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

    @Override
    public List<Map<String, Object>> citiesstates() {
        return productMapper.citiesstates();
    }

    @Override
    public List<Map<String, Object>> findProduct(Map<String, Object> map) {
        return productMapper.findProduct(map);
    }

    @Override
    public int productSize() {
        return productMapper.productSize();
    }

    @Override
    public int addProduct(Map<String, Object> map) {
        return productMapper.addProduct(map);
    }

    @Override
    public int addtourismproducts(Map<String, Object> map) {
        return productMapper.addtourismproducts(map);
    }

    @Override
    public Map<String, Object> selectP_id(String product_name) {
        return productMapper.selectP_id(product_name);
    }

    @Override
    public int addhotel(Map<String, Object> map) {
        return productMapper.addhotel(map);
    }

    @Override
    public int selProCount(Map<String, Object> map) {
        return productMapper.selProCount(map);
    }
}
