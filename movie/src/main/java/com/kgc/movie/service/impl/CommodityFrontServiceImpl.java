package com.kgc.movie.service.impl;

import com.kgc.movie.dao.CommodityFrontMapper;
import com.kgc.movie.pojo.CommodityFront;
import com.kgc.movie.service.CommodityFrontService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shkstart
 * @create 2020-11-24 15:22
 */
@Service
public class CommodityFrontServiceImpl implements CommodityFrontService {
    @Resource
    CommodityFrontMapper commodityFrontMapper;
    @Override
    public CommodityFront frontById(Integer enterId) {
        return commodityFrontMapper.selectByPrimaryKey(enterId);
    }

    @Override
    public void addFront(CommodityFront commodityFront) {
        commodityFrontMapper.insertSelective(commodityFront);
    }
}
