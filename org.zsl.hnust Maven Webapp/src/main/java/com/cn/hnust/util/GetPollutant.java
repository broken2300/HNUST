package com.cn.hnust.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.pojo.MonitorStation;
import com.cn.hnust.pojo.PollutantInfo;
import com.cn.hnust.service.impl.PollutantInfoServiceImpl;

 
/**
 * 
 * @author Qin
 *
 */
public class GetPollutant {
	@Resource
	private PollutantInfoServiceImpl pollutantService = null;
 
    public static final String token = "quLyz34WSw86Byb4TzYm"; 
    /**
     * @param args
     */
    
    public boolean excutable(String city) {
        String url = "http://www.pm25.in/api/querys/aqi_details.json?city="+ city +"&token="+token;
        String json = loadJSON(url);
        System.out.println(json);
        List<MonitorStation> jsonList = JSON.parseArray(json, MonitorStation.class);
        try{
        	for (MonitorStation monitorStation : jsonList) {
            	PollutantInfo info = new PollutantInfo();
            	info.setAQI(monitorStation.getAqi());
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
            	pollutantService.insertMongoInfo(info);     	       	
    			
    		}
        	return true;
        }catch (Exception e) {
			// TODO: handle exception        	
			e.printStackTrace();
			return false;
		}
        
        
        
    }
 
    public static String loadJSON (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                        yc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }
    
    
}
