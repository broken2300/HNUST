/**
 * @author Qin 
 * @function get meteorological data ,including the max temperature, the average wind speed,
 * the dew point temperature and the relative humidity.
 * 
 * 
 * **/


package com.cn.hnust.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetFromNMC {

	private final static int FORECAST_DAY = 6;
	private final static int INPUT_FACTORS = 4;
	
	public double[][] excutable(String city) {
	
		GetFromNMC gf = new GetFromNMC();
		String url = "http://www.nmc.cn/publish/forecast/AFJ/"+ city+".html";
		double[][] result = gf.getByURL(url);
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<4;j++) 
				System.out.print(result[i][j]+"\t");
			System.out.println("");
		}
		
		return result;
	}
	
	public GetFromNMC(){
		
	}
	
	public double[][] getByURL(String url) {
		// the result consists of four factors, which are the max temperature, the average wind speed,
		// the dew point temperature and the relative humidity.
		double[][] res = new double[FORECAST_DAY][INPUT_FACTORS];
		
		try {
			Document doc = Jsoup.connect(url).timeout(30000).get();
			Element hour3=doc.getElementById("hour3");// the forecasting time interval is per 3 hours
			Element[] days = new Element[7]; // 7 days ,but only 6 complete days' data
			//4 time : 2:00 8:00 14:00 20:00
			String[][] FTime = new String[FORECAST_DAY][4]; //The Forecasting Time
			double[][] Tem = new double[FORECAST_DAY][4]; // The Temperature
			double[][] WS =  new double[FORECAST_DAY][4]; // wind speed
			double[][] Tdew = new double[FORECAST_DAY][4]; // Dew Point Temperature
			double[][] RH = new double[FORECAST_DAY][4]; //Relative humidity
			for(int i=0;i<days.length;i++) {
				days[i] =  hour3.getElementById("day"+i);
			}
			for(int i=0;i<days.length;i++) {
				Element x= days[i];
				Elements first = x.getElementsByClass("first"); //get the forecasting time
				String[] strs = first.text().split(" ");
				
				Elements wd = x.getElementsByClass("wd"); //get temperature
				String[] strs_wd =wd.text().split(" ");
				
				Elements winds = x.getElementsByClass("winds"); //get wind speed
				String[] strs_winds = winds.text().split(" ");
				
				Elements xdsd = x.getElementsByClass("xdsd"); //get relative humidity
				String[] strs_xdsd = xdsd.text().split(" ");
				
				if(i==0) { //the first day is special
					for(int j=1;j<strs.length;j++) {
						if(strs[j].contains("02:00")) {
							Tem[0][0] = Double.parseDouble(strs_wd[j].replace("℃",""));
							WS[0][0] = Double.parseDouble(strs_winds[j].replace("米/秒",""));
							RH[0][0] = Double.parseDouble(strs_xdsd[j].replace("%",""))/100;
							Tdew[0][0] = getDewPoint(Tem[0][0],RH[0][0]);
						}
					}
				} else { //from the second day on, the format is in the same form
					double[] temArrs = new double[5];
					for(int n=0;n<5;n++) {
						temArrs[n] = Double.parseDouble(strs_wd[n+1].replace("℃", ""));
					}
					res[i-1][0] = getMax(temArrs); // get the max temperature
					for(int k=1;k<strs.length-3;k++) {
						Tem[i-1][(k+1)/2] = Double.parseDouble(strs_wd[k].replace("℃",""));
						WS[i-1][(k+1)/2] = Double.parseDouble(strs_winds[k].replace("米/秒",""));
						RH[i-1][(k+1)/2] = Double.parseDouble(strs_xdsd[k].replace("%",""))/100;
						Tdew[i-1][(k+1)/2] = getDewPoint(Tem[i-1][(k+1)/2],RH[i-1][(k+1)/2]);
					}
					if(i<6) {
						Tem[i][0] = Double.parseDouble(strs_wd[7].replace("℃",""));
						WS[i][0] = Double.parseDouble(strs_winds[7].replace("米/秒",""));
						RH[i][0] = Double.parseDouble(strs_xdsd[7].replace("%",""))/100;
						Tdew[i][0] = getDewPoint(Tem[i][0],RH[i][0]);
					}
				}
			}
			
			for(int i=0;i<FORECAST_DAY;i++) {
				res[i][1] = getAverage(WS[i]); 
				res[i][2] = getAverage(Tdew[i]);
				res[i][3] = getAverage(RH[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<FORECAST_DAY;i++) {
			for(int j=1;j<INPUT_FACTORS;j++) {
				if(j==1||j==2)
					res[i][j] = new BigDecimal(res[i][j]).
					setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
				if(j==3)
					res[i][j] = new BigDecimal(res[i][j]).
					setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
			}
		}
		return res;//"success";
	}
	
	/**
	 * 
	 * 计算公式参考自 《对露点温度计算的经验式的修正》 布文峰，王世洪
	 * @param t  the temperature
	 * @param RH relative humidity
	 * @return
	 */
	
	public double getDewPoint(double t,double RH) {
		double T=t+273.15;
		double[] C= new double[14];
		double dew = -273.15;
		C[0] = 0;
		C[1] = -5674.5359;
		C[2] = 6.395247;
		C[3] = -0.009677843;
		C[4] = 0.62215701e-6;
		C[5] = 0.20747825e-18;
		C[6] = -0.9484024e-12;
		C[7] = 4.1635019;
		C[8] = -5800.2206;
		C[9] = 1.3914993;
		C[10] = -0.04860239;
		C[11] = 0.41764768e-4;
		C[12] = -0.14452093e-7;
		C[13] = 6.5459673;
		double LnPqb = 0;
		if(t>=-100&&t<=0) {
		    LnPqb =C[1]/T+C[2]+C[3]*T+C[4]*Math.pow(T,2)+
				C[5]*Math.pow(T,3)+C[6]*Math.pow(T, 4)+C[7]*Math.log(T);	
		} 
		else if(t>0&&t<=200) {
			LnPqb = C[8]/T+C[9]+C[10]*T+C[11]*Math.pow(T,2)
					+C[12]*Math.pow(T,3)+C[13]*Math.log(T);
		} else {
			return dew;
		}
		double LnPq = Math.log(RH)+LnPqb;
		if(t>=-60&&t<=0) {
			dew = -60.23484+7.03841*LnPq+0.37359*Math.pow(LnPq,2);
		}
		if(t>=0&&t<=70) {
			dew = -35.28896-2.03222*LnPq+1.17025*Math.pow(LnPq,2);
		}
		return dew;
	}
	
	public double getMax(double[] x) {
		double max = x[0];
		for(Double m:x) {
			if(m>max) max = m;
		}
		return max;
	}
	
	public double getAverage(double[] x) {
		double sum = 0;
		if(x.length==0) return 0;
		for(Double m:x) {
			sum+=m;
		}
		return sum/x.length;
	}
}
