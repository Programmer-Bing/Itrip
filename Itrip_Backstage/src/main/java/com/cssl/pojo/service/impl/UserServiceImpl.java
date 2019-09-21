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

}
