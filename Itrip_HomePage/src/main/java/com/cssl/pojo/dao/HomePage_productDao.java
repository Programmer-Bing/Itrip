package com.cssl.pojo.dao;

import com.cssl.pojo.HomePage_product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HomePage_productDao {
    List<HomePage_product> findAll();
    List<HomePage_product> findByCPT(Map<String,Object> map); //根据地名和产品类型查找产品
}
