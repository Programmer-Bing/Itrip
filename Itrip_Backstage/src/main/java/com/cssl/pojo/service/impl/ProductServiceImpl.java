package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.ProductMapper;
import com.cssl.pojo.service.ProductService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Map<String, Object>> productType() {
        return productMapper.productType();
    }
}
