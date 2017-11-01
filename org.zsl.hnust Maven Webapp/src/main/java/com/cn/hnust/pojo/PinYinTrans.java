package com.cn.hnust.pojo;

import java.util.Hashtable;


public class PinYinTrans {
	public static final String[] forestCities = {"福州","厦门","莆田","泉州","漳州","宁德","三明",
			"龙岩","南平"};
	
	public Hashtable<String,String> pinyin = new Hashtable<String,String>();
	
	public PinYinTrans() {
		pinyin.put("福州", "fuzhou");
		pinyin.put("厦门", "shamen");
		pinyin.put("莆田", "putian");
		pinyin.put("泉州", "quanzhou");
		pinyin.put("漳州", "zhangzhou");
		pinyin.put("宁德", "ningde");
		pinyin.put("三明", "sanming");
		pinyin.put("龙岩", "longyan");
		pinyin.put("南平", "nanping");
	}

}
