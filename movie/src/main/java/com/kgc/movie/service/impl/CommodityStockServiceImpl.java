package com.kgc.movie.service.impl;

import com.kgc.movie.dao.CommodityStockMapper;
import com.kgc.movie.pojo.Commodity;
import com.kgc.movie.pojo.CommodityStock;
import com.kgc.movie.pojo.CommodityStockExample;
import com.kgc.movie.service.CommodityStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityStockServiceImpl implements CommodityStockService {

    @Resource
    CommodityStockMapper commodityStockMapper;

    @Override
    public void JianStockNums(Integer stockNums, Integer commodityid) {
        CommodityStockExample example=new CommodityStockExample();
        CommodityStockExample.Criteria criteria = example.createCriteria();
        criteria.andCommodityidEqualTo(commodityid);
        //查询出当前的库存
        CommodityStockExample example1=new CommodityStockExample();
        CommodityStockExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andCommodityidEqualTo(commodityid);
        List<CommodityStock> commodityStocks = commodityStockMapper.selectByExample(example1);
        Integer nums=commodityStocks.get(commodityStocks.size()-1).getStockNums();//当前库存
        CommodityStock commodityStock=new CommodityStock();
        commodityStock.setStockNums(nums-stockNums);
        commodityStockMapper.updateByExampleSelective(commodityStock,example);
    }
}
