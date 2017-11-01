package com.cn.hnust.dao;

import com.cn.hnust.pojo.HourlyWeather;

public interface HourlyWeatherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HourlyWeather record);

    int insertSelective(HourlyWeather record);

    HourlyWeather selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HourlyWeather record);

    int updateByPrimaryKey(HourlyWeather record);
}