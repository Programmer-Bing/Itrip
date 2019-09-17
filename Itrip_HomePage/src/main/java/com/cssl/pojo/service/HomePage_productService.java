package com.cssl.pojo.service;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.ProductDetails;

import java.util.List;
import java.util.Map;

public interface HomePage_productService {
    /*首页操作*/
    List<HomePage_product> findBargains(Integer id); //根据在哪个大区查特价商品（大区：一级分类例如:欧洲，东南亚）
    List<HomePage_product> findPartyingByCity(Map<String,Object>map); //根据在哪个城市及什么类型查商品
    List<HomePage_product> findPartyingByCities(Map<String,Object>map); //根据在哪些城市及什么类型查商品
    List<HomePage_product> findSellwell(); //根据在哪个大区查热销商品（大区：一级分类例如:欧洲，东南亚）
    /*商品详情页操作*/
    ProductDetails findProductDetails(Integer Product_id);//跟据商品id来查找商品的详情
}
