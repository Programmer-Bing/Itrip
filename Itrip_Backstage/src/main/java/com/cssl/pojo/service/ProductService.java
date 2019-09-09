package com.cssl.pojo.service;

import java.util.List;
import java.util.Map;

public interface ProductService {


    public List<Map<String,Object>> productType();

    public List<Map<String,Object>> citiesstates();

    public List<Map<String,Object>> findProduct(Map<String,Object> map);

    public int productSize();
}
