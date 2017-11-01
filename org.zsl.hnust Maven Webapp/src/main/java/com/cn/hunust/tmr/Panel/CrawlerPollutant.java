package com.cn.hunust.tmr.Panel;

import java.util.Date;
import java.util.TimerTask;

import org.springframework.data.convert.ThreeTenBackPortConverters;

import com.cn.hnust.pojo.CityList;
import com.cn.hnust.util.GetPollutant;

public class CrawlerPollutant extends TimerTask {
	/**
	 * 定时器控制函数
	 */
	@Override
	public void run(){
//		Thread thread = new Thread();
		GetPollutant getPollutant = new GetPollutant();
		try {
			for(String x:CityList.cities) {
	        	 System.out.println(x + "pollutant crawler!");
	        	 if(getPollutant.excutable(x.replace("市", "")) == true){
	        		 System.out.println("insert "+ x + " pollutant");;
	        	 }
	        	 else{
	        		 System.out.println("insert "+ x + " pollutant failed");
	        	 }
	        	 //抓完休眠1S
//	        	 thread.sleep(1* 1000);
	         }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("CrawlerPo failed");

			e.printStackTrace();
		}
	}
}
