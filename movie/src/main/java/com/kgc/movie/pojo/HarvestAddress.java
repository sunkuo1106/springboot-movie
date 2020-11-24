package com.kgc.movie.pojo;

public class HarvestAddress {
    private Integer addId;

    private String addName;

    private String addGender;

    private String addAddress;

    private String addPostcode;

    private String addPhone;

    private Integer userId;

    @Override
    public String toString() {
        return "HarvestAddress{" +
                "addId=" + addId +
                ", addName='" + addName + '\'' +
                ", addGender='" + addGender + '\'' +
                ", addAddress='" + addAddress + '\'' +
                ", addPostcode='" + addPostcode + '\'' +
                ", addPhone='" + addPhone + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName == null ? null : addName.trim();
    }

    public String getAddGender() {
        return addGender;
    }

    public void setAddGender(String addGender) {
        this.addGender = addGender == null ? null : addGender.trim();
    }

    public String getAddAddress() {
        return addAddress;
    }

    public void setAddAddress(String addAddress) {
        this.addAddress = addAddress == null ? null : addAddress.trim();
    }

    public String getAddPostcode() {
        return addPostcode;
    }

    public void setAddPostcode(String addPostcode) {
        this.addPostcode = addPostcode == null ? null : addPostcode.trim();
    }

    public String getAddPhone() {
        return addPhone;
    }

    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone == null ? null : addPhone.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}