package com.kgc.movie.service.impl;

import com.kgc.movie.dao.CommodityTableMapper;
import com.kgc.movie.dao.GoodsMapper;
import com.kgc.movie.pojo.CommodityTable;
import com.kgc.movie.pojo.CommodityTableExample;
import com.kgc.movie.pojo.Goods;
import com.kgc.movie.pojo.MallOrder;
import com.kgc.movie.service.CommodityStockService;
import com.kgc.movie.service.CommodityTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class CommodityTableServiceImpl implements CommodityTableService {

    @Resource
    CommodityTableMapper commodityTableMapper;

    @Resource
    CommodityStockService commodityStockService;

    @Resource
    GoodsMapper goodsMapper;


    @Override
    public CommodityTable selectByCommodity(Integer id) {
        return commodityTableMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CommodityTable> selectAllCommodity() {
        return commodityTableMapper.selectByExample(null);
    }

    @Override
    public void selectIdByPictureAndJianStockNums(String[] goodsIds,String[] stockNum) {
        //根据购物车id查询出对应的图片路径
        for (int i = 0; i < goodsIds.length; i++) {
            CommodityTableExample example=new CommodityTableExample();
            CommodityTableExample.Criteria criteria = example.createCriteria();
            Goods goods = goodsMapper.selectByPrimaryKey(Integer.parseInt(goodsIds[i]));
            criteria.andCommodityPictureEqualTo(goods.getGoodsPicture());
            System.out.println(goods.getGoodsPicture());
            List<CommodityTable> commodityTables = commodityTableMapper.selectByExample(example);
            System.out.println("mallOrders的size为"+commodityTables.size());
            Integer Id = commodityTables.get(commodityTables.size()-1).getId();
            //调用减库存方法
            commodityStockService.JianStockNums(Integer.parseInt(stockNum[i]),Id);
        }
    }
}
