package com.cssl.pojo.dao;

import com.cssl.pojo.Dept;
import com.cssl.pojo.HomePage_product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface HomePage_productDao {
    List<HomePage_product> findAll();
}
