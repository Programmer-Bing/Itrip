package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.OrderDao;
import com.cssl.pojo.po.OrderXQ;
import com.cssl.pojo.po.Orders;
import com.cssl.pojo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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


    @Override
    public List<Orders> SelectOrderFindAll(Map<String,Object> map) {
        return orderDao.SelectOrderFindAll(map);
    }


    @Override
    public List<OrderXQ> SelectOrderProduct(String orderno) {
        return orderDao.SelectOrderProduct(orderno);
    }


    @Override
    public int SelectOrderProductCount(int userid) {
        return orderDao.SelectOrderProductCount(userid);
    }
}
