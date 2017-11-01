package com.cn.hnust.pojo;

import java.util.Date;

public class DailyWeather {
    private Long id;

    private String city;

    private Date time;

    private Double tmax;

    private Double ws;

    private Double tdew;

    private Double rh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getTmax() {
        return tmax;
    }

    public void setTmax(Double tmax) {
        this.tmax = tmax;
    }

    public Double getWs() {
        return ws;
    }

    public void setWs(Double ws) {
        this.ws = ws;
    }

    public Double getTdew() {
        return tdew;
    }

    public void setTdew(Double tdew) {
        this.tdew = tdew;
    }

    public Double getRh() {
        return rh;
    }

    public void setRh(Double rh) {
        this.rh = rh;
    }

	@Override
	public String toString() {
		return "DailyWeather [id=" + id + ", city=" + city + ", time=" + time + ", tmax=" + tmax + ", ws=" + ws
				+ ", tdew=" + tdew + ", rh=" + rh + "]";
	}
}