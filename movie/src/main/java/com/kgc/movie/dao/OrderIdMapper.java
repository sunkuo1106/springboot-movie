package com.kgc.movie.dao;

import com.kgc.movie.pojo.OrderId;
import com.kgc.movie.pojo.OrderIdExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderIdMapper {
    int countByExample(OrderIdExample example);

    int deleteByExample(OrderIdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderId record);

    int insertSelective(OrderId record);

    List<OrderId> selectByExample(OrderIdExample example);

    int updateByExampleSelective(@Param("record") OrderId record, @Param("example") OrderIdExample example);

    int updateByExample(@Param("record") OrderId record, @Param("example") OrderIdExample example);
}