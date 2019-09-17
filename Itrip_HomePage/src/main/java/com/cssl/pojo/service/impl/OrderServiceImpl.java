package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.OrderDao;
import com.cssl.pojo.po.Orders;
import com.cssl.pojo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> SelectUser(int id) {
        return orderDao.SelectUser(id);
    }
}
