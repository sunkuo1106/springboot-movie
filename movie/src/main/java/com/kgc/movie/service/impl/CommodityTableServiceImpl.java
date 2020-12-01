package com.kgc.movie.service.impl;

import com.kgc.movie.dao.CommodityTableMapper;
import com.kgc.movie.pojo.CommodityTable;
import com.kgc.movie.service.CommodityTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CommodityTableServiceImpl implements CommodityTableService {

    @Resource
    CommodityTableMapper commodityTableMapper;


    @Override
    public CommodityTable selectByCommodity(Integer id) {
        return commodityTableMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CommodityTable> selectAllCommodity() {
        return commodityTableMapper.selectByExample(null);
    }
}
