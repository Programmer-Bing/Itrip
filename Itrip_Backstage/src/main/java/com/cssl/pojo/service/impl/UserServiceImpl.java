package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.UserMapper;
import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String,Object>> findAll(Map<String,Object> map) {
        return userMapper.findAll(map);
    }

    @Override
    public int addUser(Map<String, Object> map) {
        return userMapper.addUser(map);
    }

    @Override
    public int deluser(int u_id) {
        return userMapper.deluser(u_id);
    }

    @Override
    public Map<String, Object> whereuid(int u_id) {
        return userMapper.whereuid(u_id);
    }

    @Override
    public int modUser(Map<String, Object> map) {
        return userMapper.modUser(map);
    }

    @Override
    public Map<String, Object> selUserAdmin(Map<String, Object> map) {
        return userMapper.selUserAdmin(map);
    }


}
