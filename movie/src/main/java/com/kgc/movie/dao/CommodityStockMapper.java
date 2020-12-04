package com.kgc.movie.dao;

import com.kgc.movie.pojo.CommodityStock;
import com.kgc.movie.pojo.CommodityStockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityStockMapper {
    int countByExample(CommodityStockExample example);

    int deleteByExample(CommodityStockExample example);

    int deleteByPrimaryKey(Integer stockId);

    int insert(CommodityStock record);

    int insertSelective(CommodityStock record);

    List<CommodityStock> selectByExample(CommodityStockExample example);

    CommodityStock selectByPrimaryKey(Integer stockId);

    int updateByExampleSelective(@Param("record") CommodityStock record, @Param("example") CommodityStockExample example);

    int updateByExample(@Param("record") CommodityStock record, @Param("example") CommodityStockExample example);

    int updateByPrimaryKeySelective(CommodityStock record);

    int updateByPrimaryKey(CommodityStock record);
}