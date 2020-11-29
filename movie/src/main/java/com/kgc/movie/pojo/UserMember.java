package com.kgc.movie.pojo;

import java.util.Date;

public class UserMember {
    private Integer memberId;

    private String userName;

    private String type;

    private Date startingTime;

    private Date endTime;

    private Float memberMoney;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Float getMemberMoney() {
        return memberMoney;
    }

    public void setMemberMoney(Float memberMoney) {
        this.memberMoney = memberMoney;
    }

    @Override
    public String toString() {
        return "UserMember{" +
                "memberId=" + memberId +
                ", userName='" + userName + '\'' +
                ", type='" + type + '\'' +
                ", startingTime=" + startingTime +
                ", endTime=" + endTime +
                ", memberMoney=" + memberMoney +
                '}';
    }
}