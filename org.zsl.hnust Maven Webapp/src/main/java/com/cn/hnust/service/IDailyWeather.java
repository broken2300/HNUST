package com.cn.hnust.service;

import java.sql.Date;
import java.util.List;

import com.cn.hnust.pojo.DailyWeather;

public interface IDailyWeather {
	
	public DailyWeather getDailyWeatherByTimeAndCity(Date time,String city);
	
	public int insertDailyWeather(DailyWeather dailyWeather);
	
	public List<DailyWeather> getAllDailyWeatherByTimeAndCity(Date time,int duration, String city);
	
	public List<DailyWeather> getAllDailyWeatherByTime(Date time);
	


}
