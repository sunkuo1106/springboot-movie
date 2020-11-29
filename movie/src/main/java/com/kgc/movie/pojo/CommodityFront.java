package com.kgc.movie.pojo;

import java.util.Date;

public class CommodityFront {
    private Integer enterId;

    private String commodityName;

    private Date commodityDate;

    private Float commodityTotalprice;

    private String userName;

    public Integer getEnterId() {
        return enterId;
    }

    public void setEnterId(Integer enterId) {
        this.enterId = enterId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public Date getCommodityDate() {
        return commodityDate;
    }

    public void setCommodityDate(Date commodityDate) {
        this.commodityDate = commodityDate;
    }

    public Float getCommodityTotalprice() {
        return commodityTotalprice;
    }

    public void setCommodityTotalprice(Float commodityTotalprice) {
        this.commodityTotalprice = commodityTotalprice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}