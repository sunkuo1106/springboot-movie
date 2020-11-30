package com.kgc.movie.service.impl;

import com.kgc.movie.dao.OrderIdMapper;
import com.kgc.movie.pojo.OrderId;
import com.kgc.movie.service.OrderIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-30 12:37
 */
@Service
public class OrderIdServiceImpl implements OrderIdService {
    @Resource
    OrderIdMapper orderIdMapper;
    @Override
    public List<OrderId> orderList() {
        return orderIdMapper.selectByExample(null);
    }
}
