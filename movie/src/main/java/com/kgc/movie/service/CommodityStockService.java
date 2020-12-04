package com.kgc.movie.service;

import com.kgc.movie.pojo.CommodityStock;

import java.util.List;

public interface CommodityStockService {
    //减少库存的操作
    void JianStockNums(Integer stockNums,Integer commodityid);
    List<CommodityStock> stockNums(Integer commodityid);
}
