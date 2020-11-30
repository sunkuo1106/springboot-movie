package com.kgc.movie.service;

import com.kgc.movie.pojo.Commodity;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-17 10:02
 */
public interface CommodityService {
    List<Commodity> selectAll();
    List<Commodity> selectByNameList(String name);
    void updCom(Commodity commodity);
}
