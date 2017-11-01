package com.cn.hunust.tmr.Panel;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cn.hnust.dao.DailyWeatherMapper;
import com.cn.hnust.pojo.DailyWeather;

import java.io.BufferedInputStream;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileInputStream;

import java.io.InputStreamReader;

import java.io.Reader;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Repository
public class InsertData  {
	@Resource
	private DailyWeatherMapper mapper;
	
	public void readTxtFile(String filePath){

        try {

                String encoding="GBK";

                File file=new File(filePath);

                if(file.isFile() && file.exists()){ //判断文件是否存在

                    InputStreamReader read = new InputStreamReader(

                    new FileInputStream(file),encoding);//考虑到编码格式

                    BufferedReader bufferedReader = new BufferedReader(read);

                    String lineTxt = null;


                	Date dateBase = new Date(2015-1900,9,1);
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	DailyWeather dWeather = new DailyWeather();
                    	dWeather.setCity("福州");
                    	dWeather.setTime(dateBase);
                    	System.out.println(dateBase);
                    	
                    	String[] figure = lineTxt.split(" ");

                    	dWeather.setTmax(Double.parseDouble(figure[0]));
                    	dWeather.setTdew(Double.parseDouble(figure[1]));
                    	dWeather.setRh(Double.parseDouble(figure[2])/100);
                    	dWeather.setWs(Double.parseDouble(figure[3]));

                    	dateBase.setDate(dateBase.getDate()+1);
                    	
                    	mapper.insert(dWeather);

                        System.out.println(dWeather.getTdew());

                    }

                    read.close();

        }else{

            System.out.println("找不到指定的文件");

        }

        } catch (Exception e) {

            System.out.println("读取文件内容出错");

            e.printStackTrace();

        }

     

    }

    
    public static void main(String argv[]){

        String filePath = "C:\\Users\\Gino543\\Desktop\\fuzhou201510-20163.txt";
        InsertData insertData = new InsertData();
//      "res/";

        insertData.readTxtFile(filePath);

    }
}
