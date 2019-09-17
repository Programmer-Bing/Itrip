package com.cssl.pojo.service.impl;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.ProductDetails;
import com.cssl.pojo.dao.HomePage_productDao;
import com.cssl.pojo.service.HomePage_productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HomePage_productServiceImpl implements HomePage_productService {

    @Autowired
    public HomePage_productDao hpdao;

    @Override
    public List<HomePage_product> findBargains(Integer id) {
        return hpdao.findBargains(id);
    }

    @Override
    public List<HomePage_product> findPartyingByCity(Map<String, Object> map) {
        return hpdao.findPartyingByCity(map);
    }

    @Override
    public List<HomePage_product> findPartyingByCities(Map<String, Object> map) {
        return hpdao.findPartyingByCities(map);
    }

    @Override
    public List<HomePage_product> findSellwell() {
        return hpdao.findSellwell();
    }

    @Override
    public ProductDetails findProductDetails(Integer Product_id) {
        return hpdao.findProductDetails(Product_id);
    }
}
