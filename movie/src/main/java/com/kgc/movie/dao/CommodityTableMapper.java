package com.kgc.movie.dao;

import com.kgc.movie.pojo.CommodityTable;
import com.kgc.movie.pojo.CommodityTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityTableMapper {
    int countByExample(CommodityTableExample example);

    int deleteByExample(CommodityTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommodityTable record);

    int insertSelective(CommodityTable record);

    List<CommodityTable> selectByExample(CommodityTableExample example);

    CommodityTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommodityTable record, @Param("example") CommodityTableExample example);

    int updateByExample(@Param("record") CommodityTable record, @Param("example") CommodityTableExample example);

    int updateByPrimaryKeySelective(CommodityTable record);

    int updateByPrimaryKey(CommodityTable record);
}