package com.kgc.movie.dao;

import com.kgc.movie.pojo.Seats;
import com.kgc.movie.pojo.SeatsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeatsMapper {
    int countByExample(SeatsExample example);

    int deleteByExample(SeatsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Seats record);

    int insertSelective(Seats record);

    List<Seats> selectByExample(SeatsExample example);

    Seats selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Seats record, @Param("example") SeatsExample example);

    int updateByExample(@Param("record") Seats record, @Param("example") SeatsExample example);

    int updateByPrimaryKeySelective(Seats record);

    int updateByPrimaryKey(Seats record);
}