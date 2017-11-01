package com.cn.hnust.pojo;

import java.sql.Date;

import org.bson.types.ObjectId;

public class PollutantInfo {

	private ObjectId _id;
	private String time;
	private String type;
	private String city;
	private String monitor;
	private double AQI;
	private String qLevel;
	private String level;
	private double pm2_5;
	private double pm2_5_24h;
	private double pm10;
	private double pm10_24h;
	private double CO;
	private double CO_24h;
	private double NO2;
	private double NO2_24h;
	private double O3;
	private double O3_24h;
	private double O3_8h;
	private double O3_8h_24h;
	private double SO2;
	private double SO2_24h;
	private Double Real_AQI;
	private String province;
	private String index;
	private int city_code;
	private String pollutions;
	private String station_code;
	
	
	
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public double getAQI() {
		return AQI;
	}
	public void setAQI(double aQI) {
		AQI = aQI;
	}
	public String getqLevel() {
		return qLevel;
	}
	public void setqLevel(String qLevel) {
		this.qLevel = qLevel;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public double getPm2_5() {
		return pm2_5;
	}
	public void setPm2_5(double pm2_5) {
		this.pm2_5 = pm2_5;
	}
	public double getPm2_5_24h() {
		return pm2_5_24h;
	}
	public void setPm2_5_24h(double pm2_5_24h) {
		this.pm2_5_24h = pm2_5_24h;
	}
	public double getPm10() {
		return pm10;
	}
	public void setPm10(double pm10) {
		this.pm10 = pm10;
	}
	public double getPm10_24h() {
		return pm10_24h;
	}
	public void setPm10_24h(double pm10_24h) {
		this.pm10_24h = pm10_24h;
	}
	public double getCO() {
		return CO;
	}
	public void setCO(double cO) {
		CO = cO;
	}
	public double getCO_24h() {
		return CO_24h;
	}
	public void setCO_24h(double cO_24h) {
		CO_24h = cO_24h;
	}
	public double getNO2() {
		return NO2;
	}
	public void setNO2(double nO2) {
		NO2 = nO2;
	}
	public double getNO2_24h() {
		return NO2_24h;
	}
	public void setNO2_24h(double nO2_24h) {
		NO2_24h = nO2_24h;
	}
	public double getO3() {
		return O3;
	}
	public void setO3(double o3) {
		O3 = o3;
	}
	public double getO3_24h() {
		return O3_24h;
	}
	public void setO3_24h(double o3_24h) {
		O3_24h = o3_24h;
	}
	public double getO3_8h() {
		return O3_8h;
	}
	public void setO3_8h(double o3_8h) {
		O3_8h = o3_8h;
	}
	public double getO3_8h_24h() {
		return O3_8h_24h;
	}
	public void setO3_8h_24h(double o3_8h_24h) {
		O3_8h_24h = o3_8h_24h;
	}
	public double getSO2() {
		return SO2;
	}
	public void setSO2(double sO2) {
		SO2 = sO2;
	}
	public double getSO2_24h() {
		return SO2_24h;
	}
	public void setSO2_24h(double sO2_24h) {
		SO2_24h = sO2_24h;
	}
	public Double getReal_AQI() {
		return Real_AQI;
	}
	public void setReal_AQI(Double real_AQI) {
		Real_AQI = real_AQI;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public int getCity_code() {
		return city_code;
	}
	public void setCity_code(int city_code) {
		this.city_code = city_code;
	}
	public String getPollutions() {
		return pollutions;
	}
	public void setPollutions(String pollutions) {
		this.pollutions = pollutions;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	@Override	
	public String toString() {
		return "PollutantInfo [_id=" + _id + ", time=" + time + ", type=" + type + ", city=" + city + ", monitor="
				+ monitor + ", AQI=" + AQI + ", qLevel=" + qLevel + ", level=" + level + ", pm2_5=" + pm2_5
				+ ", pm2_5_24h=" + pm2_5_24h + ", pm10=" + pm10 + ", pm10_24h=" + pm10_24h + ", CO=" + CO + ", CO_24h="
				+ CO_24h + ", NO2=" + NO2 + ", NO2_24h=" + NO2_24h + ", O3=" + O3 + ", O3_24h=" + O3_24h
				+ ", O3_8h_24h=" + O3_8h_24h + ", SO2=" + SO2 + ", SO2_24h=" + SO2_24h + ", Real_AQI=" + Real_AQI
				+ ", province=" + province + ", index=" + index + ", city_code=" + city_code + ", pollutions="
				+ pollutions + ", station_code=" + station_code + "]";
	}
	
	
	
}
