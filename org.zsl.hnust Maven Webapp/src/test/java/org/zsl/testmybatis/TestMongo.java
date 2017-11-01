package org.zsl.testmybatis;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.pojo.DailyWeather;
import com.cn.hnust.pojo.PollutantInfo;
import com.cn.hnust.service.IDailyWeather;
import com.cn.hnust.service.IPollutantInfo;

@RunWith(SpringJUnit4ClassRunner.class)		
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMongo {
	private static Logger logger = Logger.getLogger(TestMongo.class);
	@Resource
	private IPollutantInfo mongoInfoService = null;
	@Resource
	IDailyWeather dailyWeatherService = null;
	/*@Test
	public void test(){
//		PollutantInfo info = new PollutantInfo();
//		info.setAQI(100);
//		info.setTime("1993/01/03");
//		info.setCity("厦门1");
//		info.setMonitor("");
//		mongoInfoService.insertMongoInfo(info);
		
		String date = "2015-09-10 00:00:00";
		String city = "厦门";
		String startdate = "2015-09-08 00:00:00";
		List<PollutantInfo> infos1 =mongoInfoService.selectAllByDateAndCity(startdate, date, city);
		List<PollutantInfo> infos = mongoInfoService.getPollutantInfoByDateAndCity(date, city);

		
		System.out.println("size of : "+infos1.size());
		System.out.println("size of : "+infos.size());
		for(PollutantInfo x:infos) {
			System.out.println("infos : "+x);
		}
		
		System.out.println("---------------");
		for(PollutantInfo x:infos1) {
			System.out.println("infos1 : "+x);
		}
		//System.out.println(infos.size());
		
	}*/
	@Test
	public void name() {
		String date = "2015-09-15 00:00:00";
		String city = "北京";
		String startdate = "2015-09-01 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		List<PollutantInfo> infos1 =mongoInfoService.selectAllByDateAndCityToAnalyze(startdate, date, city);
		//List<DailyWeather> weather = dailyWeatherService.getAllDailyWeatherByTimeAndCity(Date.valueOf("2015-09-01"),181, city);
		for(PollutantInfo x:infos1) {
			System.out.println(x);
		}
		/*
		for(DailyWeather x:weather) {
			System.out.println(x);
		}*/
	}
	
}
