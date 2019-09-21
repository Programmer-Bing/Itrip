package com.cssl.pojo.dao;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    public List<Map<String,Object>> findAll(Map<String,Object> map);
}
