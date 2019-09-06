package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.UserDao;
import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao ud;

    @Override
    public List<User> Cs() {
        return ud.Cs();
    }


    @Override
    public int addUser(String name) {
        return  ud.addUser(name);
    }
}