package com.cn.hnust.pojo;

import java.util.Date;

public class HourlyWeather {
    private Long id;

    private String station;

    private Date time;

    private Double temperature;

    private Double ws;

    private Double rh;

    private Double tdew;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWs() {
        return ws;
    }

    public void setWs(Double ws) {
        this.ws = ws;
    }

    public Double getRh() {
        return rh;
    }

    public void setRh(Double rh) {
        this.rh = rh;
    }

    public Double getTdew() {
        return tdew;
    }

    public void setTdew(Double tdew) {
        this.tdew = tdew;
    }
}