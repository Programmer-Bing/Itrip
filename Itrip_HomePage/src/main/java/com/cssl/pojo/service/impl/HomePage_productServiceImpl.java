package com.cssl.pojo.service.impl;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.dao.HomePage_productDao;
import com.cssl.pojo.service.HomePage_productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class HomePage_productServiceImpl implements HomePage_productService {

    @Autowired
    public HomePage_productDao hpdao;

    @Override
    public List<HomePage_product> findAll() {
        return hpdao.findAll();
    }
}
