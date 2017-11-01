package com.cn.hunust.tmr.Panel;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.util.AlternativeJdkIdGenerator;

public class AutoRun implements ServletContextListener {
	
	private Timer timer = null;

	/**
	 * 服务器关闭触发函数
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		timer.cancel();

	}

	/**
	 * 服务器启动触发函数
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		timer=new Timer(true);  

        timer.schedule(new DisplayDate(),0,3 * 60 * 60 * 1000);//延迟0秒，每3小时执行一次神经网络算法          
        timer.schedule(new CrawlerDailyWeather(),5 * 1000,1 * 24 * 60 * 60 * 1000);//延迟5秒，每1天执行一次天气抓取
        timer.schedule(new CrawlerPollutant(),0,1 * 60 * 60 * 1000);//延迟0秒，每小时执行一次污染物抓取
        timer.schedule(new AlgorithmRSA(),0,7 * 24 * 60 * 60 * 1000);//延迟0秒，每7天执行一次预测


	}

}
