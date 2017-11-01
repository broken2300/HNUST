package org.zsl.testmybatis;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.pojo.DailyWeather;
import com.cn.hnust.pojo.MonitorStation;
import com.cn.hnust.pojo.PollutantInfo;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IDailyWeather;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.impl.DailyWeatherServiceImpl;
import com.cn.hnust.util.GetPollutant;

public class TestDailyWeather {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DailyWeather dailyWeather = new DailyWeather();
		String url = "http://www.pm25.in/api/querys/aqi_details.json?city=xiamen&token="+"quLyz34WSw86Byb4TzYm";
        String json = GetPollutant.loadJSON(url);
        
        List<MonitorStation> jsonList = JSON.parseArray(json, MonitorStation.class);
        for (MonitorStation monitorStation : jsonList) {
        	PollutantInfo info = new PollutantInfo();
        	info.setAQI(monitorStation.getAqi());
        	//todo: 这地方依次set下去，需要转换格式的转格式
        	info.setCity(monitorStation.getArea());
        	info.setCO((double)monitorStation.getCo());
        	info.setCO_24h((double)monitorStation.getCo_24h());
        	info.setNO2((double)monitorStation.getNo2());
        	info.setNO2_24h((double)monitorStation.getNo2_24h());
        	info.setO3((double)monitorStation.getO3());
        	info.setO3_24h((double)monitorStation.getO3_24h());
        	info.setO3_8h((double)monitorStation.getO3_8h());
        	info.setO3_8h_24h((double)monitorStation.getO3_8h_24h());
        	info.setMonitor(monitorStation.getPosition_name());
        	info.setLevel(monitorStation.getQuality());
        	info.setPm10((double)monitorStation.getPm10());
        	info.setPm10_24h((double)monitorStation.getPm10_24h());
        	info.setPm2_5((double)monitorStation.getPm2_5());
        	info.setPm2_5_24h((double)monitorStation.getPm2_5_24h());
        	info.setStation_code(monitorStation.getStation_code());
        	info.setPollutions(monitorStation.getPrimary_pollutant());
        	info.setSO2((double)monitorStation.getSo2());
        	info.setSO2_24h((double)monitorStation.getSo2_24h());
        	info.setTime(monitorStation.getTime_point().replaceAll("[A-Za-z]", " "));
        	
        	   System.out.println(info);
        }
	}

}
