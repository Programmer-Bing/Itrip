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
}
