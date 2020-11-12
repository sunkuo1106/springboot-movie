package com.kgc.movie.dao;

import com.kgc.movie.pojo.MovieTicket;
import com.kgc.movie.pojo.MovieTicketExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieTicketMapper {
    int countByExample(MovieTicketExample example);

    int deleteByExample(MovieTicketExample example);

    int deleteByPrimaryKey(Integer movieId);

    int insert(MovieTicket record);

    int insertSelective(MovieTicket record);

    List<MovieTicket> selectByExample(MovieTicketExample example);

    MovieTicket selectByPrimaryKey(Integer movieId);

    int updateByExampleSelective(@Param("record") MovieTicket record, @Param("example") MovieTicketExample example);

    int updateByExample(@Param("record") MovieTicket record, @Param("example") MovieTicketExample example);

    int updateByPrimaryKeySelective(MovieTicket record);

    int updateByPrimaryKey(MovieTicket record);
}