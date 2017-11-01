package com.cn.hnust.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.service.IDailyWeather;
import com.cn.hnust.service.IForecastDailyPM2_5;
import com.cn.hnust.service.IPollutantInfo;
import com.cn.hnust.service.impl.ForecastDailyPM2_5Impl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cn.hnust.pojo.DailyWeather;
import com.cn.hnust.pojo.JsonInfo;
import com.cn.hnust.pojo.JsonListInfo;
import com.cn.hnust.pojo.Pm25Forecast;
import com.cn.hnust.pojo.PollutantInfo;

@Controller
@RequestMapping("/test")
public class HnustController {
	@Resource
	private IDailyWeather dailyWeatherService;
	@Resource
	private IPollutantInfo pollutantInfoService;
	@Resource
	private IForecastDailyPM2_5 forecastDailyPM2_5Service;

	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request, Model model) {
		return "index";
	}

	@RequestMapping("/pollution")
	public String toPollution() {
		return "pollution";
	}

	@RequestMapping("/CT")
	public String toCT(HttpServletRequest request) {
		return "CT";
	}

	@RequestMapping("/AQI")
	public String toAQI() {
		return "AQI";
	}

	@RequestMapping("/introduce")
	public String tointroduce() {
		return "introduce";
	}

	@RequestMapping("/PCMSs")
	public String toPCMSs() {
		return "PCMSs";
	}

	@ResponseBody
	@RequestMapping(value = "/getWeatherDataJson", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Object> getWeatherDataJson() {
		JsonInfo model = new JsonInfo();

		java.util.Date utilDate = new java.util.Date();
		Date date = new Date(utilDate.getTime());

		List list = new ArrayList<Object>();
		List<PollutantInfo> Plist = pollutantInfoService.getAllCityPollutantInfo("2016-04-26 13:00:00");
		for (PollutantInfo x : Plist) {
			Object json = JSON.toJSON(x);
//			System.out.println(json);
			list.add(json);
		}

		return list;
	}

	/**
	 * 图表数据返回
	 * @param request
	 * @return 缺少适合的类型声明（返回List<Json>或List<JsonList>）
	 */
	@ResponseBody
	@RequestMapping("/testCT")
	public List<Object> testCT(HttpServletRequest request) {
		if (request.getParameter("city").isEmpty()) {
			String city = "厦门";
		}
		String type = request.getParameter("type");
		String city = request.getParameter("city");
		
		System.out.println(city);

		Date date = new Date(System.currentTimeMillis());

		// 最近15天
		if (type.equals("recent15")) {

			List<JsonListInfo> list = new ArrayList<JsonListInfo>();
			String date15end = "";
			date15end = "2015-09-15 00:00:00";
//			date15end = date15end + (date.getYear() + 1900) + "-" + ((date.getMonth() + 1)<10?("0"+(date.getMonth() + 1)):(date.getMonth() + 1)) + 
//					"-" + (date.getDate()<10?("0"+date.getDate()):date.getDate()) + " 00:00:00";

			date = new Date(date.getTime() - 15 * 24 * 60 * 60 * 1000);
			String date15 = "";
			date15 = "2015-09-01 00:00:00";
//			date15 = date15 + (date.getYear() + 1900) + "-" + ((date.getMonth() + 1)<10?("0"+(date.getMonth() + 1)):(date.getMonth() + 1)) + 
//					"-" + (date.getDate()<10?("0"+date.getDate()):date.getDate()) + " 00:00:00";
			
			List info = new ArrayList<Object>();
			// 获得list
			List<PollutantInfo> Plist = pollutantInfoService.selectAllByDateAndCityToAnalyze(date15, date15end, city);
			for (PollutantInfo pollutantInfo : Plist) {			
				
				List valueList = new ArrayList<Object>();
				// value数组顺序：AQI,pm2.5,PM10,SO2,NO2,CO,O3
				valueList.add(pollutantInfo.getAQI());
				valueList.add(pollutantInfo.getPm2_5_24h());
				valueList.add(pollutantInfo.getPm10_24h());
				valueList.add(pollutantInfo.getSO2_24h());
				valueList.add(pollutantInfo.getNO2_24h());
				valueList.add(pollutantInfo.getCO_24h());
				valueList.add(pollutantInfo.getO3_24h());
				
				info.add(valueList);

			}
//			System.out.println(info);
			return info;
		}
		if (type.equals("recent7")) {
			List<JsonListInfo> list = new ArrayList<JsonListInfo>();
			String date7end = "";
			date7end = date7end + (date.getYear() + 1900) + "/" + (date.getMonth() + 1) + "/" + date.getDate()
					+ " 00:00:00";

			date = new Date(date.getTime() - 7 * 24 * 60 * 60 * 1000);
			String date7 = "";
			date7 = date7 + (date.getYear() + 1900) + "/" + (date.getMonth() + 1) + "/" + date.getDate() + " 00:00:00";

			List info = new ArrayList<Object>();
			// 获得list
			List<PollutantInfo> Plist = pollutantInfoService.selectAllByDateAndCityToAnalyze(date7, date7end, city);
			for (PollutantInfo pollutantInfo : Plist) {
				List valueList = new ArrayList<Object>();
				// value数组顺序：AQI,pm2.5,PM10,SO2,NO2,CO,O3
				valueList.add(pollutantInfo.getReal_AQI());
				valueList.add(pollutantInfo.getPm2_5_24h());
				valueList.add(pollutantInfo.getPm10_24h());
				valueList.add(pollutantInfo.getSO2_24h());
				valueList.add(pollutantInfo.getNO2_24h());
				valueList.add(pollutantInfo.getCO_24h());
				valueList.add(pollutantInfo.getO3_24h());
				
				info.add(valueList);
			}
			return info;
		}
		if(type.equals("futureWeek")){
			System.out.println("futureWeek");
			date = new Date(new java.util.Date().getTime());
			//未来预测7天
			List info = new ArrayList<Object>();			
			System.out.println("date "+ date);
			Pm25Forecast inForecast = forecastDailyPM2_5Service.getPm25ForecastByTimeAndCity(date, city);
			System.out.println("MODEL "+ inForecast.getCity());
				info.add(inForecast.getOne());
				info.add(inForecast.getTwo());
				info.add(inForecast.getThree());
				info.add(inForecast.getFour());
				info.add(inForecast.getFive());
				info.add(inForecast.getSix());
				info.add(inForecast.getSeven());				

				System.out.println(info);
			return info;
		}
		return null;
	}
}

// java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml
// -overwrite