package com.cn.hunust.tmr.Panel;

import java.sql.Date;
import java.util.TimerTask;

import com.cn.hnust.pojo.DailyWeather;
import com.cn.hnust.pojo.PinYinTrans;
import com.cn.hnust.util.GetFromNMC;


public class CrawlerDailyWeather extends TimerTask {
	/**
	 * 定时器控制函数
	 */
	@Override
	public void run(){
		GetFromNMC getFromNMC = new GetFromNMC();
		PinYinTrans trans = new PinYinTrans();
		try {
			for(String city:PinYinTrans.forestCities){
				Date time = new Date(new java.util.Date().getTime() + 1 * 24 * 60 * 60 * 1000);
				
				double[][] info = getFromNMC.excutable(trans.pinyin.get(city));
				DailyWeather dailyWeather = new DailyWeather();
				dailyWeather.setCity(city);
				dailyWeather.setTime(time);
				dailyWeather.setTmax(info[0][0]);
				dailyWeather.setTdew(info[0][1]);
				dailyWeather.setWs(info[0][2]);
				dailyWeather.setRh(info[0][3]);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("CrawlerDW failed");
			e.printStackTrace();
		}
	}
}
