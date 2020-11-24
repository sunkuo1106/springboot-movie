package com.kgc.movie.controller;

import com.kgc.movie.pojo.CommodityFront;
import com.kgc.movie.pojo.CommodityFrontExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityFrontMapper {
    int countByExample(CommodityFrontExample example);

    int deleteByExample(CommodityFrontExample example);

    int deleteByPrimaryKey(Integer enterId);

    int insert(CommodityFront record);

    int insertSelective(CommodityFront record);

    List<CommodityFront> selectByExample(CommodityFrontExample example);

    CommodityFront selectByPrimaryKey(Integer enterId);

    int updateByExampleSelective(@Param("record") CommodityFront record, @Param("example") CommodityFrontExample example);

    int updateByExample(@Param("record") CommodityFront record, @Param("example") CommodityFrontExample example);

    int updateByPrimaryKeySelective(CommodityFront record);

    int updateByPrimaryKey(CommodityFront record);
}