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

    //购物车减商品
    void jianGoodsNums(String userName,Integer GoodsId);

    //购物车加商品
    void jiaGoodsNums(String userName,Integer GoodsId);

    //购物车手动输入商品数量
    void ShuRuGoodsNums(String userName, Integer GoodsId,Integer GoodsNums);

    //单删购物车
    void deleteDanShan(Integer id);

    //循环修改goods表选购买的type
    void XunHuanUpdateGoodsType(String[] goodsIds);
}
