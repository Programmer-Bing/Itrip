package com.cssl.pojo.dao;

import com.cssl.pojo.po.ProductType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProductMapper {

    public List<Map<String,Object>> productType();

    public List<Map<String,Object>> findProduct(Map<String,Object> map);

    public List<Map<String,Object>> citiesstates();

    public int productSize();

    public int addProduct(Map<String,Object> map);

    public int addtourismproducts(Map<String,Object> map);

    public Map<String,Object> selectP_id(String product_name);

    public int addhotel(Map<String,Object> map);

    public int selProCount(Map<String,Object> map);
}
