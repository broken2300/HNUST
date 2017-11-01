package com.cn.hnust.service;

import java.sql.Date;

import com.cn.hnust.pojo.Pm25Forecast;


public interface IForecastDailyPM2_5 {

	double[] forecast(double[][] weather,double[][] pm25,double[][] future_weather);
	Pm25Forecast getPm25ForecastByTimeAndCity(Date time,String city);
}
