package com.kgc.movie.service;

import com.kgc.movie.pojo.MallOrder;

import java.util.List;

public interface MallOrderService {
    //循环添加商品订单
    void addMallOrder(String[]goodsIds,Integer addId,String userName);

    List<MallOrder> selectAllMallOrderByUserName(String uname);
}
