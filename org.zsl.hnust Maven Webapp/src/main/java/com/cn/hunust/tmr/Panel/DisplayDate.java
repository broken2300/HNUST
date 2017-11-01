package com.cn.hunust.tmr.Panel;

import java.util.TimerTask;
import java.util.Date;

public class DisplayDate extends TimerTask {
	
	/**
	 * 定时器控制函数
	 */
	@Override
	public void run(){
		try {
			System.out.println(new Date());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
