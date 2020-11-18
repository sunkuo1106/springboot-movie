package com.kgc.movie.service.impl;

import com.kgc.movie.dao.CommodityTypeMapper;
import com.kgc.movie.pojo.CommodityType;
import com.kgc.movie.service.CommodityTypeService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-17 10:02
 */
@Service
public class CommodityTypeServiceImpl implements CommodityTypeService{
    @Resource
    CommodityTypeMapper commodityTypeMapper;

    @Override
    public List<CommodityType> selectAll() {
        List<CommodityType> commodityTypes = commodityTypeMapper.selectByExample(null);
        return commodityTypes;
    }
}
