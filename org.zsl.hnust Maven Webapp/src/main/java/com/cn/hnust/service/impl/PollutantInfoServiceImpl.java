package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.cn.hnust.mongo.PollutantInfoMapper;
import com.cn.hnust.pojo.PollutantInfo;
import com.cn.hnust.service.IPollutantInfo;

@Service("pollutantInfoService")
public class PollutantInfoServiceImpl implements IPollutantInfo {
	@Resource
	private PollutantInfoMapper pollutantInfoMapper;
	

	@Override
	public int insertMongoInfo(PollutantInfo info) {
		pollutantInfoMapper.insert(info);
		return 1;
	}


	@Override
	public PollutantInfo getPollutantInfoById(ObjectId id) {
		return pollutantInfoMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<PollutantInfo> getPollutantInfoByDateAndCity(String date, String city) {
		
		return pollutantInfoMapper.selectByDateAndCity(date, city);
	}


	@Override
	public List<PollutantInfo> selectAllByDateAndCity(String startdate, String enddate, String city) {
		return pollutantInfoMapper.selectAllByDateAndCity(startdate, enddate, city);
	}


	@Override
	public List<PollutantInfo> getAllCityPollutantInfo(String date) {
		return pollutantInfoMapper.getAllCityPollutantInfo(date);
	}


	@Override
	public List<PollutantInfo> selectAllByDateAndCityToAnalyze(String startdate, String enddate, String city) {
		return pollutantInfoMapper.selectAllByDateAndCityToAnalyze(startdate, enddate, city);
	}
	
	

}
