package com.kgc.movie.pojo;

public class MallOrder {
    private Integer mallOrderId;

    private String mallOrderName;

    private Float mallOrderPrice;

    private Integer mallOrderNums;

    private String mallOrderPicture;

    private String userName;

    private Integer addId;

    public Integer getMallOrderId() {
        return mallOrderId;
    }

    public void setMallOrderId(Integer mallOrderId) {
        this.mallOrderId = mallOrderId;
    }

    public String getMallOrderName() {
        return mallOrderName;
    }

    public void setMallOrderName(String mallOrderName) {
        this.mallOrderName = mallOrderName == null ? null : mallOrderName.trim();
    }

    public Float getMallOrderPrice() {
        return mallOrderPrice;
    }

    public void setMallOrderPrice(Float mallOrderPrice) {
        this.mallOrderPrice = mallOrderPrice;
    }

    public Integer getMallOrderNums() {
        return mallOrderNums;
    }

    public void setMallOrderNums(Integer mallOrderNums) {
        this.mallOrderNums = mallOrderNums;
    }

    public String getMallOrderPicture() {
        return mallOrderPicture;
    }

    public void setMallOrderPicture(String mallOrderPicture) {
        this.mallOrderPicture = mallOrderPicture == null ? null : mallOrderPicture.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }
}