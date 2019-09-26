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

    public List<Map<String,Object>> findAll(Map<String, Object> map);

    public int addUser(Map<String, Object> map);

    public int deluser(int u_id);

    public Map<String,Object> whereuid(int u_id);

    public int modUser(Map<String, Object> map);

    public Map<String,Object> selUserAdmin(Map<String, Object> map);
}
