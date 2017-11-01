package com.cn.hnust.service.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.DailyWeatherMapper;
import com.cn.hnust.pojo.DailyWeather;
import com.cn.hnust.service.IDailyWeather;

@Service("dailyWeatherService")
public class DailyWeatherServiceImpl implements IDailyWeather {
	@Resource
	private DailyWeatherMapper dailyWeatherMapper;

	@Override
	public int insertDailyWeather(DailyWeather dailyWeather) {
		return this.dailyWeatherMapper.insert(dailyWeather);
	}

	@Override
	public DailyWeather getDailyWeatherByTimeAndCity(Date time, String city) {
		return this.dailyWeatherMapper.selectByDateAndCity(time, city);
	}

	@Override
	public List<DailyWeather> getAllDailyWeatherByTimeAndCity(Date time, int duration, String city) {
		return this.dailyWeatherMapper.selectAllByDateAndCity(time, duration, city);
	}

	@Override
	public List<DailyWeather> getAllDailyWeatherByTime(Date time) {		
		return this.dailyWeatherMapper.selectAllByDate(time);
	}


}
