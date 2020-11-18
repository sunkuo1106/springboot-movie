package com.kgc.movie.pojo;

import java.util.Date;

public class Commodity {
    private Integer id;

    private String name;

    private String marketValue;

    private String membershipPrice;

    private Integer num;

    private Integer type;

    private String picture;

    private Integer sale;

    private String safedate;

    private Date producedate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue == null ? null : marketValue.trim();
    }

    public String getMembershipPrice() {
        return membershipPrice;
    }

    public void setMembershipPrice(String membershipPrice) {
        this.membershipPrice = membershipPrice == null ? null : membershipPrice.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getSafedate() {
        return safedate;
    }

    public void setSafedate(String safedate) {
        this.safedate = safedate == null ? null : safedate.trim();
    }

    public Date getProducedate() {
        return producedate;
    }

    public void setProducedate(Date producedate) {
        this.producedate = producedate;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marketValue='" + marketValue + '\'' +
                ", membershipPrice='" + membershipPrice + '\'' +
                ", num=" + num +
                ", type=" + type +
                ", picture='" + picture + '\'' +
                ", sale=" + sale +
                ", safedate='" + safedate + '\'' +
                ", producedate=" + producedate +
                '}';
    }
}