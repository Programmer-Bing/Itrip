package com.cssl.pojo.service;

import java.util.List;
import java.util.Map;

public interface ProductService {


    public List<Map<String,Object>> productType();

    public List<Map<String,Object>> citiesstates();

    public List<Map<String,Object>> findProduct(Map<String,Object> map);

    public int productSize();

    public int addProduct(Map<String,Object> map);

    public int addtourismproducts(Map<String,Object> map);

    public Map<String,Object> selectP_id(String product_name);

    public int addhotel(Map<String,Object> map);

    public int selProCount(Map<String,Object> map);
}
