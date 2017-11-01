package org.zsl.testmybatis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IDailyWeather;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.impl.DailyWeatherServiceImpl;
import com.cn.hunust.tmr.Panel.InsertData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	// private ApplicationContext ac = null;
	@Resource
	private IUserService userService = null;
	@Resource
	IDailyWeather DailyWeatherService = null;

	public void readTxtFile(String filePath) {

		try {

			String encoding = "GBK";

			File file = new File(filePath);

			if (file.isFile() && file.exists()) { // 判断文件是否存在

				InputStreamReader read = new InputStreamReader(

						new FileInputStream(file), encoding);// 考虑到编码格式

				BufferedReader bufferedReader = new BufferedReader(read);

				String lineTxt = null;

				Date dateBase = new Date(2015 - 1900, 9, 0);
				while ((lineTxt = bufferedReader.readLine()) != null) {
					DailyWeather dWeather = new DailyWeather();
					dWeather.setCity("厦门");
					dWeather.setTime(dateBase);
					System.out.println(dateBase);

					String[] figure = lineTxt.split(" ");

					dWeather.setTmax(Double.parseDouble(figure[0]));
					dWeather.setTdew(Double.parseDouble(figure[1]));
					dWeather.setRh(Double.parseDouble(figure[2]) / 100);
					dWeather.setWs(Double.parseDouble(figure[3]));

					dateBase.setDate(dateBase.getDate() + 1);

					DailyWeatherService.insertDailyWeather(dWeather);

					System.out.println(dWeather.getTdew());

				}

				read.close();

			} else {

				System.out.println("找不到指定的文件");

			}

		} catch (Exception e) {

			System.out.println("读取文件内容出错");

			e.printStackTrace();

		}

	}


	@Test
	public void test1() {
//		User user = userService.getUserById(1);
//		Date time = new Date(2016 - 1900, 3, 14);
//		System.out.println(time);
//		String city = "厦门";
//		// DailyWeather dailyWeather =
//		// DailyWeatherService.getDailyWeatherByTime(time, city);
//		List<DailyWeather> dailyWeather = DailyWeatherService.getAllDailyWeatherByTime(time, 2, city);
//		// logger.info(JSON.toJSONString(dailyWeather));
//		for (DailyWeather dw : dailyWeather) {
//			logger.info(dw.toString());
//		}
		
		String filePath = "C:\\Users\\Gino543\\Desktop\\xiamen201510-20163.txt";
		// "res/";

		readTxtFile(filePath);
		
	}
}
