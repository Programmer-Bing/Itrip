package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.OrderDao;
import com.cssl.pojo.po.OrderXQ;
import com.cssl.pojo.po.Orders;
import com.cssl.pojo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> SelectUser(int id) {
        return orderDao.SelectUser(id);
    }


    @Override
    public List<Orders> SelectOrderProdoct(int userid) {
        return orderDao.SelectOrderProdoct(userid);
    }

    @Override
    public List<Orders> SelectOrderNumb(int userid) {
        return orderDao.SelectOrderNumb(userid);
    }


    @Override
    public List<OrderXQ> SelectOrderProduct(String ordernum) {
        return orderDao.SelectOrderProduct(ordernum);
    }
}
