package com.cn.hnust.service.impl;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.Pm25ForecastMapper;
import com.cn.hnust.pojo.DailyWeather;
import com.cn.hnust.pojo.Pm25Forecast;
import com.cn.hnust.service.IForecastDailyPM2_5;
import com.cn.hnust.util.NonlinearRegressionWithSA;

@Service("forecastDailyPM2_5Service")
public class ForecastDailyPM2_5Impl implements IForecastDailyPM2_5{

	@Resource
	private Pm25ForecastMapper pm25ForecastMapper;
	
	@Override
	public double[] forecast(double[][] weather, double[][] pm25, double[][] future_weather) {
		return NonlinearRegressionWithSA.forcast(weather, pm25, future_weather);
	}

	@Override
	public Pm25Forecast getPm25ForecastByTimeAndCity(Date time, String city) {		
		return pm25ForecastMapper.selectByDateAndCity(time, city);
	}

}
