package com.cssl.pojo.service;

import com.cssl.pojo.HomePage_product;

import java.util.List;
import java.util.Map;

public interface HomePage_productService {
    List<HomePage_product> findAll();
    List<HomePage_product> findByCPT(Map<String,Object> map); //根据地名和产品类型查找产品
}
