package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.shoppingcartDao;
import com.cssl.pojo.service.shoppingcartservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class shoppingcartserviceimpl implements shoppingcartservice{

    @Autowired
    private shoppingcartDao shoppingcartDao;

    @Override
    public boolean addCart(Map<String, Object> map) {
        if (shoppingcartDao.addCart(map)&&shoppingcartDao.addRoom(map)){
            return true;
        }
        return false;
    }
}
