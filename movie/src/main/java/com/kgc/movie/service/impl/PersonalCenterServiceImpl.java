package com.kgc.movie.service.impl;

import com.kgc.movie.dao.CommodityFrontMapper;
import com.kgc.movie.dao.MovieCommentMapper;
import com.kgc.movie.dao.MovieTicketMapper;
import com.kgc.movie.dao.UserMemberMapper;
import com.kgc.movie.pojo.*;
import com.kgc.movie.service.PersonalCenterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class PersonalCenterServiceImpl implements PersonalCenterService {
    @Resource
    MovieCommentMapper movieCommentMapper;

    @Resource
    MovieTicketMapper movieTicketMapper;

    @Resource
    UserMemberMapper userMemberMapper;

    @Resource
    CommodityFrontMapper commodityFrontMapper;

    @Override
    public List<MovieTicket> selectAllTicket(String userName) {
        MovieTicketExample example=new MovieTicketExample();
        MovieTicketExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<MovieTicket> movieTickets = movieTicketMapper.selectByExample(example);
        return movieTickets;
    }

    @Override
    public List<MovieComment> selectAllComment(String userName) {
        MovieCommentExample example=new MovieCommentExample();
        MovieCommentExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<MovieComment> movieComments = movieCommentMapper.selectByExample(example);
        return movieComments;
    }

    @Override
    public List<MovieTicket> selectTicketMoneyByUserName(String userName) {
        MovieTicketExample example=new MovieTicketExample();
        MovieTicketExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<MovieTicket> movieTickets = movieTicketMapper.selectByExample(example);
        return movieTickets;
    }

    @Override
    public List<CommodityFront> selectCommodityFrontMoneyByUserName(String userName) {
        CommodityFrontExample example=new CommodityFrontExample();
        CommodityFrontExample.Criteria criteria = example.createCriteria();
        criteria.andCommodityNameEqualTo(userName);
        List<CommodityFront> commodityFronts = commodityFrontMapper.selectByExample(example);
        return commodityFronts;
    }

    @Override
    public List<UserMember> selectMemberByUserName(String userName) {
        UserMemberExample example=new UserMemberExample();
        UserMemberExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<UserMember> userMembers = userMemberMapper.selectByExample(example);
        return userMembers;
    }

    @Override
    public Date selectByUserMemberEndTime(String userName) {
        UserMemberExample example=new UserMemberExample();
        UserMemberExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<UserMember> userMembers = userMemberMapper.selectByExample(example);
        if(userMembers.size()!=0 && userMembers!=null){
            return userMembers.get(userMembers.size()-1).getEndTime();
        }
        return null;
    }
}
