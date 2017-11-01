package org.zsl.testmybatis;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.cn.hnust.util.NonlinearRegressionWithSA;


public class Test {
	
	public static void main(String[] args) {
		BufferedReader br_x = null;
		BufferedReader br_y = null;
		double[][] Ax =new double[365][4];
		double[][] Ay =new double[365][1];
		String s= null;
		String s_pm = null;
		int k=0;
		Object[] result = null;
		try {
			 br_x=new BufferedReader(new FileReader("E:\\x.txt"));
			 br_y=new BufferedReader(new FileReader("E:\\y.txt"));
			 while((s = br_x.readLine())!=null&&(s_pm = br_y.readLine())!=null) {
				 String[] temp = s.split(" ");
				 for(int i=0;i<4;i++) {
					 Ax[k][i] = Double.parseDouble(temp[i]);
				 }
				 Ay[k][0] = Double.parseDouble(s_pm);
				 k++;
			 }
			 
			 double[][] future_weather = {{36, 24, 65, 11,0},
						{36, 25, 72, 11,0},
						{35, 25, 76, 8,0},
						{34, 26, 76, 9, 0},
						{34, 25, 75, 8, 0},
						{34, 25, 74, 7, 0},
						{34, 25, 74, 7, 0}};
			 long startTime=System.currentTimeMillis();
			double[] calYY = NonlinearRegressionWithSA.forcast(Ax, Ay, future_weather);
			long endTime=System.currentTimeMillis();
			System.out.println("total time : "+ (endTime-startTime)/1000);
			for(Double zz:calYY) {
				System.out.println(zz);
			}
			 
			/* long startTime=System.currentTimeMillis(); 
			//result = NonlinearRegressionWithSA.getCoefficient(Ax, Ay);
			long endTime=System.currentTimeMillis();
			System.out.println("total time : "+ (endTime-startTime)/1000);
			System.out.println("coefficients : \n"+result[0]);
			System.out.println("RSS : "+result[1]);
			System.out.println("NAME : "+result[4]);
			
			String[] coefficient = result[0].toString().split("\n");
			for(String x:coefficient) {
				System.out.println(x);
			}*/
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
