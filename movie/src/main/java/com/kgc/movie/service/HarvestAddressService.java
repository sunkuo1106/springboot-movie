package com.kgc.movie.service;

import com.kgc.movie.pojo.HarvestAddress;

import java.util.List;

public interface HarvestAddressService {
    //查询所有收货地址
    List<HarvestAddress>selectAllAddress(Integer userId);

    void addAddress(HarvestAddress harvestAddress);

    void delShippingAddress(Integer addId);

    HarvestAddress selectById(Integer addId);
}
