package com.cssl.pojo.service;

import com.cssl.pojo.po.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<Map<String,Object>> findAll(Map<String, Object> map);

    public int addUser(Map<String, Object> map);

    public int deluser(int u_id);

    public Map<String,Object> whereuid(int u_id);

    public int modUser(Map<String, Object> map);

    public Map<String,Object> selUserAdmin(Map<String, Object> map);
}
