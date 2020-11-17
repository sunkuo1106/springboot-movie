package com.kgc.movie.service.impl;

import com.kgc.movie.dao.MovieTicketMapper;
import com.kgc.movie.pojo.MovieTicket;
import com.kgc.movie.pojo.MovieTicketExample;
import com.kgc.movie.service.MovieTicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MovieTicketServiceImpl implements MovieTicketService {
    @Resource
    MovieTicketMapper movieTicketMapper;

    @Override
    public void addMovieTicket(MovieTicket movieTicket) {
        movieTicketMapper.insertSelective(movieTicket);
    }

    @Override
    public List<MovieTicket> ceshiList(String yingpianname, Integer yingyuanid, Date datetime) {
        MovieTicketExample ceShiExample=new MovieTicketExample();
        MovieTicketExample.Criteria criteria = ceShiExample.createCriteria();
        if(yingpianname!=null&&yingpianname.isEmpty()==false){
            criteria.andMovieNameEqualTo(yingpianname);
        }
        if(yingyuanid!=null&&yingyuanid!=0) {
            criteria.andMovieYingchengidEqualTo(yingyuanid);
        }
        if(datetime!=null){
            criteria.andMovieDateEqualTo(datetime);
        }
        return movieTicketMapper.selectByExample(ceShiExample);
    }

    @Override
    public int movieById() {
        List<MovieTicket> movieTickets = movieTicketMapper.selectByExample(null);
        int i=movieTickets.get(movieTickets.size()-1).getMovieId()+1;
        return i;
    }

}
