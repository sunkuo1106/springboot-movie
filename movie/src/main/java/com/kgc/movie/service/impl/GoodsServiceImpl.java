package com.kgc.movie.service.impl;

import com.kgc.movie.dao.GoodsMapper;
import com.kgc.movie.pojo.Goods;
import com.kgc.movie.pojo.GoodsExample;
import com.kgc.movie.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    @Override
    public boolean selectById(String userName, String goodsName) {
        GoodsExample example=new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsTypeEqualTo(0);
        criteria.andUserNameEqualTo(userName);
        criteria.andGoodsNameEqualTo(goodsName);
        List<Goods> goods = goodsMapper.selectByExample(example);
        if(goods.size()!=0 && goods!=null){
            return true;
        }
        return false;
    }

    @Override
    public void AddGoods(Goods goods) {
        goodsMapper.insertSelective(goods);
    }

    @Override
    public int updateGoodsNums(String userName, String goodsName) {
        GoodsExample example=new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsTypeEqualTo(0);
        criteria.andUserNameEqualTo(userName);
        criteria.andGoodsNameEqualTo(goodsName);
        List<Goods> goods = goodsMapper.selectByExample(example);
        Goods good=goods.get(goods.size()-1);
        if(good.getGoodsNums()>=10){
            return 0;
        }else{
            good.setGoodsNums(good.getGoodsNums()+1);
            goodsMapper.updateByPrimaryKeySelective(good);
        }
        return 1;
    }
}
