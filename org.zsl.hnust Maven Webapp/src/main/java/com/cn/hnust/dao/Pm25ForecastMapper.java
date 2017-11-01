package com.cn.hnust.dao;

import java.sql.Date;

import com.cn.hnust.pojo.Pm25Forecast;

public interface Pm25ForecastMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Pm25Forecast record);

    int insertSelective(Pm25Forecast record);

    Pm25Forecast selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Pm25Forecast record);

    int updateByPrimaryKey(Pm25Forecast record);
    
    Pm25Forecast selectByDateAndCity(Date date, String city);
}