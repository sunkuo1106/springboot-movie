package com.kgc.movie.service.impl;

import com.kgc.movie.dao.HarvestAddressMapper;
import com.kgc.movie.pojo.HarvestAddress;
import com.kgc.movie.pojo.HarvestAddressExample;
import com.kgc.movie.service.HarvestAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HarvestAddressServiceImpl implements HarvestAddressService {

    @Resource
    HarvestAddressMapper harvestAddressMapper;

    @Override
    public List<HarvestAddress> selectAllAddress(Integer userId) {
        HarvestAddressExample example=new HarvestAddressExample();
        HarvestAddressExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        example.setOrderByClause("add_id desc");
        List<HarvestAddress> harvestAddresses = harvestAddressMapper.selectByExample(example);
        return harvestAddresses;
    }

    @Override
    public void addAddress(HarvestAddress harvestAddress) {
        harvestAddressMapper.insertSelective(harvestAddress);
    }

    @Override
    public void delShippingAddress(Integer addId) {
        harvestAddressMapper.deleteByPrimaryKey(addId);
    }
}
