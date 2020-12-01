package com.kgc.movie.service;

import com.kgc.movie.pojo.CommodityTable;

import java.util.List;

public interface CommodityTableService {
    CommodityTable selectByCommodity(Integer id);
    List<CommodityTable>selectAllCommodity();
}
