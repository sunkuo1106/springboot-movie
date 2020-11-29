package com.kgc.movie.service;

import com.kgc.movie.pojo.CommodityFront;
import com.kgc.movie.pojo.MovieComment;
import com.kgc.movie.pojo.MovieTicket;
import com.kgc.movie.pojo.UserMember;

import java.util.Date;
import java.util.List;

public interface PersonalCenterService {
    //查询出该用户观影场次
    List<MovieTicket>selectAllTicket(String userName);
    //查询出所发表的评论次数
    List<MovieComment>selectAllComment(String userName);
    //查询总消费金额    (电影票价格+食品价格+商城价格+会员充值价格)
    List<MovieTicket>selectTicketMoneyByUserName(String userName);   //电影票价格
    List<CommodityFront>selectCommodityFrontMoneyByUserName(String userName);  //食品价格
    //待完成--商城价格

    //查询会员等级  没有就是普通会员
    List<UserMember>selectMemberByUserName(String userName);  //会员充值价格
    //如果是会员查询该会员的到期时间
    Date selectByUserMemberEndTime(String userName);
}
