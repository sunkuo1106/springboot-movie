package com.kgc.movie.service.impl;

import com.kgc.movie.dao.GoodsMapper;
import com.kgc.movie.dao.MallOrderMapper;
import com.kgc.movie.pojo.Goods;
import com.kgc.movie.pojo.MallOrder;
import com.kgc.movie.pojo.MallOrderExample;
import com.kgc.movie.service.CommodityStockService;
import com.kgc.movie.service.MallOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MallOrderServiceImpl implements MallOrderService {

    @Resource
    MallOrderMapper mallOrderMapper;

    @Resource
    GoodsMapper goodsMapper;

    @Resource
    CommodityStockService commodityStockService;

    @Override
    public void addMallOrder(String[] goodsIds, Integer addId, String userName) {
        for (int i = 0; i < goodsIds.length; i++) {
            Goods goods = goodsMapper.selectByPrimaryKey(Integer.parseInt(goodsIds[i]));
            MallOrder mallOrder=new MallOrder();
            mallOrder.setUserName(userName);
            mallOrder.setAddId(addId);
            mallOrder.setMallOrderName(goods.getGoodsName());
            mallOrder.setMallOrderNums(goods.getGoodsNums());
            mallOrder.setMallOrderPicture(goods.getGoodsPicture());
            mallOrder.setMallOrderPrice(goods.getGoodsPrice());
            mallOrderMapper.insertSelective(mallOrder);
        }
    }

    @Override
    public List<MallOrder> selectAllMallOrderByUserName(String uname) {
        MallOrderExample example=new MallOrderExample();
        MallOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(uname);
        List<MallOrder> mallOrders = mallOrderMapper.selectByExample(example);
        return mallOrders;
    }
}
