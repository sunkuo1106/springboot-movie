package com.kgc.movie.service;

public interface CommodityStockService {
    //减少库存的操作
    void JianStockNums(Integer stockNums,Integer commodityid);
}
