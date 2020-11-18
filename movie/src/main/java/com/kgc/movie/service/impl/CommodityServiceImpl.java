package com.kgc.movie.service.impl;

import com.kgc.movie.dao.CommodityMapper;
import com.kgc.movie.pojo.Commodity;
import com.kgc.movie.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-17 10:02
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    CommodityMapper commodityMapper;

    @Override
    public List<Commodity> selectAll() {
        List<Commodity> commodities = commodityMapper.selectByExample(null);
        return commodities;
    }
}
