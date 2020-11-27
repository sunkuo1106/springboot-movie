package com.kgc.movie.service;

import com.kgc.movie.pojo.CommodityFront;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-24 15:21
 */
public interface CommodityFrontService {
    CommodityFront frontById(Integer enterId);
    void addFront(CommodityFront commodityFront);
}
