package com.cssl.pojo.dao;

import com.cssl.pojo.po.ProductType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProductMapper {

    public List<Map<String,Object>> productType();

    public int addProduct(Map<String,Object> map);

    public List<Map<String,Object>> findProduct(Map<String,Object> map);

    public List<Map<String,Object>> citiesstates();
}
