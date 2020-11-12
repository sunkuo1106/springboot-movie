package com.kgc.movie.service.impl;

import com.kgc.movie.dao.MovieTicketMapper;
import com.kgc.movie.pojo.MovieTicket;
import com.kgc.movie.pojo.MovieTicketExample;
import com.kgc.movie.service.UserOderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserOderServiceImpl implements UserOderService {
    @Resource
    MovieTicketMapper movieTicketMapper;
    @Override
    public List<MovieTicket> selectAllOrder(String userName) {
        MovieTicketExample example=new MovieTicketExample();
        MovieTicketExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<MovieTicket> movieTickets = movieTicketMapper.selectByExample(example);
        return movieTickets;
    }
}
