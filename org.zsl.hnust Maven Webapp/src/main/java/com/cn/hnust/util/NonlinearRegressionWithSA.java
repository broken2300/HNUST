package com.cn.hnust.util;
import com.mathworks.toolbox.javabuilder.*;

import NLR_SA.*;

public class NonlinearRegressionWithSA {
	
	/**
	 * 
	 * @param weather : [][0] -> Tmax  [][1] -> Tdp  [][2] ->RH  [][3] -> WS
	 * @param pm25 :  a  n * 1 array, and the row vector stands for pm2.5 data 
	 * @param future_weather 
	 * @return
	 */
	public static double[] forcast(double[][] weather,double[][] pm25,double[][] future_weather) {
		double[] yy=new double[future_weather.length];
		double[] b =new double[10];
		double[] x = new double[5];
		x[0]=b[0]=0;
		Object[] result = NonlinearRegressionWithSA.getCoefficient(weather, pm25);
		String[] coefficient = result[0].toString().split("\n");
		for(int i=0;i<coefficient.length;i++) {
			b[i+1] = Double.parseDouble(coefficient[i]);
		}
		for(int i=0;i<yy.length;i++) {
			x[1]=future_weather[i][0];
			x[2]=future_weather[i][1];
			x[3]=future_weather[i][2];
			x[4]=future_weather[i][3];
			yy[i]=b[1]+b[2]*b[3]+b[2]*(b[4]*x[1]+b[5]*Math.pow(x[1], 2))*Math.exp(b[6]*x[4])+b[7]*x[3]+b[8]*x[2]+b[9]*x[1];
		}
		return yy;
	}

	/**
	 * 
	 * @param weather
	 * @param pm25
	 * @return Object[0] regression coefficients
	 *  	   Object[1] RSS
	 *  
	 *  xCurrent,Resnorm,EXITFLAG,FVAL,NAME,calY,OUTPUT,LAMBDA,JACOB
	 */
	public static Object[] getCoefficient(double[][] weather,double[][] pm25) {
		MWNumericArray a = null; // 用于保存矩阵
		Object[] result = null; // 用于保存计算结果
		NLRwithSA nlr_sa = null;
		MWNumericArray x = null; // 用于保存矩阵
		MWNumericArray y = null; // 用于保存矩阵
		try {
			nlr_sa = new NLRwithSA();
			x = new MWNumericArray(weather, MWClassID.DOUBLE);
			y = new MWNumericArray(pm25, MWClassID.DOUBLE);
			double best = Double.MAX_VALUE;
			Object[] bestResult = result;
			for(int i=0;i<10;i++) {
				result = nlr_sa.NLR_SA(9,x,y);
				double temp = Double.parseDouble(result[1].toString());
				if(temp<best) {
					best = temp;
					bestResult = result;
				}
			}
			result = bestResult;
		} catch (MWException e) {
			e.printStackTrace();
		} finally {
			MWArray.disposeArray(a);
			MWArray.disposeArray(x);
			MWArray.disposeArray(y);
			//MWArray.disposeArray(result);
			nlr_sa.dispose();
		}
		
		return result;
	}
}
