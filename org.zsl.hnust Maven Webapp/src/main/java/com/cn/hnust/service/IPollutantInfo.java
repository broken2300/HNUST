package com.cn.hnust.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.cn.hnust.pojo.PollutantInfo;

public interface IPollutantInfo {
	
	int insertMongoInfo(PollutantInfo info);
	
	PollutantInfo getPollutantInfoById(ObjectId id);

	List<PollutantInfo> getPollutantInfoByDateAndCity(String date,String city);
	
	List<PollutantInfo> selectAllByDateAndCity(String startdate, String enddate, String city);
	
	List<PollutantInfo> getAllCityPollutantInfo(String date);
	
	List<PollutantInfo> selectAllByDateAndCityToAnalyze(String startdate, String enddate, String city);
}
