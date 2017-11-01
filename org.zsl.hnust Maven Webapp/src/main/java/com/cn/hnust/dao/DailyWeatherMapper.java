package com.cn.hnust.dao;

import java.sql.Date;
import java.util.List;

import com.cn.hnust.pojo.DailyWeather;

public interface DailyWeatherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DailyWeather record);

    int insertSelective(DailyWeather record);

    DailyWeather selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DailyWeather record);

    int updateByPrimaryKey(DailyWeather record);
    
    DailyWeather selectByDateAndCity(Date date, String city);
    
    List<DailyWeather> selectAllByDate(Date date);
    
    List<DailyWeather> selectAllByDateAndCity(Date date,int duration,String city);

}