package com.kgc.movie.service;

import com.kgc.movie.pojo.MovieComment;
import com.kgc.movie.pojo.MovieTicket;

import java.util.Date;
import java.util.List;

public interface PersonalCenterService {
    //查询出该用户观影场次
    List<MovieTicket>selectAllTicket(String userName);
    //查询出所发表的评论次数
    List<MovieComment>selectAllComment(String userName);
    //查询总消费金额

    //查询会员等级  没有就是普通会员

    //如果是会员查询该会员的到期时间
    Date selectByUserMemberEndTime(String userName);
}
