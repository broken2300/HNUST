package com.cn.hnust.mongo;

import java.sql.Date;
import java.util.List;

import javax.ejb.Init;

import org.bson.types.*;
import org.springframework.data.mongodb.core.query.Update;

import com.cn.hnust.pojo.PollutantInfo;

public interface PollutantInfoMapper {
	
	int deleteByPrimaryKey(ObjectId id);

    void insert(PollutantInfo info);

    PollutantInfo selectByPrimaryKey(ObjectId id);

    int updateByPrimaryKey(PollutantInfo info,Update update);
    
    List<PollutantInfo> selectByDateAndCity(String date, String city);
    
    List<PollutantInfo> selectAllByDateAndCity(String startdate, String enddate, String city);
    
    List<PollutantInfo> getAllCityPollutantInfo(String date);
    
    List<PollutantInfo> selectAllByDateAndCityToAnalyze(String startdate, String enddate, String city);
    
    List<PollutantInfo> selectAllByDateAndMonitorToAnalyze(String startdate, String enddate, String monitor);

    
	

}
