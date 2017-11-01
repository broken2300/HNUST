package com.cn.hunust.tmr.Panel;

import java.sql.Date;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;

import com.cn.hnust.dao.Pm25AccuracyMapper;
import com.cn.hnust.dao.Pm25ForecastMapper;
import com.cn.hnust.pojo.CityList;
import com.cn.hnust.pojo.DailyWeather;
import com.cn.hnust.pojo.PinYinTrans;
import com.cn.hnust.pojo.Pm25Forecast;
import com.cn.hnust.pojo.PollutantInfo;
import com.cn.hnust.service.impl.DailyWeatherServiceImpl;
import com.cn.hnust.service.impl.PollutantInfoServiceImpl;
import com.cn.hnust.util.GetFromNMC;
import com.cn.hnust.util.NonlinearRegressionWithSA;

public class AlgorithmRSA extends TimerTask {
	@Resource
	DailyWeatherServiceImpl dailyWeatherService = null;
	@Resource
	PollutantInfoServiceImpl pollutantInfoService = null;
	@Resource
	Pm25ForecastMapper pm25ForecastMapper = null;
	@Resource
	Pm25AccuracyMapper pm25AccuracyMapper = null;

	/**
	 * 定时器控制函数
	 */
	@Override
	public void run() {
		NonlinearRegressionWithSA nonlinearRegressionWithSA = new NonlinearRegressionWithSA();
		GetFromNMC getFromNMC = new GetFromNMC();
		PinYinTrans trans = new PinYinTrans();
		try {

			// TODO： 获取城市String
			for (String city : PinYinTrans.forestCities) {// 获取算法参数矩阵
				// @param weather : [][0] -> Tmax [][1] -> Tdp [][2] ->RH [][3]
				// -> WS

				double[][] weather = new double[180][4];
				Date time = new Date(new java.util.Date().getTime() - 180 * 24 * 60 * 60 * 1000);
				int duration = 180;
				List<DailyWeather> dailyWeathers = dailyWeatherService.getAllDailyWeatherByTimeAndCity(time, duration,
						city);

				int i = 0;
				for (DailyWeather dailyWeather : dailyWeathers) {
					weather[i][0] = dailyWeather.getTmax();
					weather[i][1] = dailyWeather.getTdew();
					weather[i][2] = dailyWeather.getRh();
					weather[i][3] = dailyWeather.getWs();
					i++;
				}
				// @param pm25 : a n * 1 array, and the row vector stands for
				// pm2.5 data
				double[][] pm25 = new double[180][1];
				// 时间拼接
				java.util.Date date180end = new Date(System.currentTimeMillis());
				String enddate = "";
				enddate = enddate + (date180end.getYear() + 1900) + "-"
						+ ((date180end.getMonth() + 1) < 10 ? ("0" + (date180end.getMonth() + 1))
								: (date180end.getMonth() + 1))
						+ "-" + (date180end.getDate() < 10 ? ("0" + date180end.getDate()) : date180end.getDate())
						+ " 00:00:00";
				java.util.Date date180 = new java.util.Date(date180end.getTime() - 180 * 24 * 60 * 60 * 1000);
				String startdate = "";
				startdate = startdate + (date180.getYear() + 1900) + "-"
						+ ((date180.getMonth() + 1) < 10 ? ("0" + (date180.getMonth() + 1)) : (date180.getMonth() + 1))
						+ "-" + (date180.getDate() < 10 ? ("0" + date180.getDate()) : date180.getDate()) + " 00:00:00";
				List<PollutantInfo> pollutantInfos = pollutantInfoService.selectAllByDateAndCityToAnalyze(startdate,
						enddate, city);
				i = 0;
				for (PollutantInfo pollutantInfo : pollutantInfos) {
					pm25[i][0] = pollutantInfo.getPm2_5();
					i++;
				}
				// @param future_weather
				double[][] future_weather = getFromNMC.excutable(trans.pinyin.get(city));

				// 获得预测
				double[] forestResult = nonlinearRegressionWithSA.forcast(weather, pm25, future_weather);

				// 预测数据入库
				Pm25Forecast pm25Forecast = new Pm25Forecast();
				pm25Forecast.setCity(city);
				pm25Forecast.setOne(forestResult[0]);
				pm25Forecast.setTwo(forestResult[1]);
				pm25Forecast.setThree(forestResult[2]);
				pm25Forecast.setFour(forestResult[3]);
				pm25Forecast.setFive(forestResult[4]);
				pm25Forecast.setSix(forestResult[5]);
				pm25Forecast.setSeven(forestResult[6]);

				if (pm25ForecastMapper.insert(pm25Forecast) >= 0) {
					System.out.println("insert " + city + "forecast");
				} else {
					System.out.println("insert " + city + "forecast failed");
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
