package com.kgc.movie.dao;

import com.kgc.movie.pojo.HarvestAddress;
import com.kgc.movie.pojo.HarvestAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HarvestAddressMapper {
    int countByExample(HarvestAddressExample example);

    int deleteByExample(HarvestAddressExample example);

    int deleteByPrimaryKey(Integer addId);

    int insert(HarvestAddress record);

    int insertSelective(HarvestAddress record);

    List<HarvestAddress> selectByExample(HarvestAddressExample example);

    HarvestAddress selectByPrimaryKey(Integer addId);

    int updateByExampleSelective(@Param("record") HarvestAddress record, @Param("example") HarvestAddressExample example);

    int updateByExample(@Param("record") HarvestAddress record, @Param("example") HarvestAddressExample example);

    int updateByPrimaryKeySelective(HarvestAddress record);

    int updateByPrimaryKey(HarvestAddress record);
}