package com.cn.hnust.dao;

import java.sql.Date;

import com.cn.hnust.pojo.Pm25Accuracy;

public interface Pm25AccuracyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Pm25Accuracy record);

    int insertSelective(Pm25Accuracy record);

    Pm25Accuracy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Pm25Accuracy record);

    int updateByPrimaryKey(Pm25Accuracy record);
    
    Pm25Accuracy selectByDateAndCity(Date date, String city);
}