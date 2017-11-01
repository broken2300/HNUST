package com.cn.hnust.pojo;

import java.util.Date;

public class Pm25Accuracy {
    private Long id;

    private String city;

    private Date time;

    private Double observed;

    private Double forecasted;

    private Double accuracyRate;

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

    public Double getObserved() {
        return observed;
    }

    public void setObserved(Double observed) {
        this.observed = observed;
    }

    public Double getForecasted() {
        return forecasted;
    }

    public void setForecasted(Double forecasted) {
        this.forecasted = forecasted;
    }

    public Double getAccuracyRate() {
        return accuracyRate;
    }

    public void setAccuracyRate(Double accuracyRate) {
        this.accuracyRate = accuracyRate;
    }
}