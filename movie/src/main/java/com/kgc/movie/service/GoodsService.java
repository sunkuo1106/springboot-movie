package com.kgc.movie.service;

import com.kgc.movie.pojo.Goods;

import java.util.List;

public interface GoodsService {
    //添加前判断是否存在
    boolean selectById(String userName,String goodsName);
    //添加
    void AddGoods(Goods goods);
    //修改购物车数量
    int updateGoodsNums(String userName,String goodsName);

    //查询用户购物车
    List<Goods>selectAllGoods(String userName);
}
