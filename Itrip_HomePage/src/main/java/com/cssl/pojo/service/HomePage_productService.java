package com.cssl.pojo.service;

import com.cssl.pojo.HomePage_product;

import java.util.List;
import java.util.Map;

public interface HomePage_productService {
    /*List<HomePage_product> findAll();
    List<HomePage_product> findByCPT(Map<String,Object> map); //根据地名和产品类型查找产品*/
    List<HomePage_product> findBargains(Integer id); //根据在哪个大区查特价商品（大区：一级分类例如:欧洲，东南亚）
}
