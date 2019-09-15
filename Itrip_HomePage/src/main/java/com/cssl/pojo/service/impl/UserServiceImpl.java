package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.UserDao;
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
    private UserDao ud;

    @Override
    public List<User> Cs() {
        return ud.Cs();
    }


    @Override
    public int addUser(Map<String,Object> map) {
        return  ud.addUser(map);
    }


    @Override
    public List<User> JudgeUser(String phone) {
        return ud.JudgeUser(phone);
    }

    @Override
    public String Cs2(String name) {
        return ud.Cs2(name);
    }

    @Override
    public Map<String,Object> PhoneEmail(String phone) {

        return  ud.PhoneEmail(phone);
    }

    @Override
    public int UpdatePhone(Map<String, Object> map) {
        return ud.UpdatePhone(map);
    }

    @Override
    public List<User> UserLogin(Map<String, Object> map) {
        return ud.UserLogin(map);
    }


    public List<User> UserLoginEmail(Map<String,Object> map){
        return ud.UserLoginEmail(map);
    }

    @Override
    public int UpdateUser(User uu) {
        return ud.UpdateUser(uu);
    }

    @Override
    public List<User> SelectUserName(String name) {
        return ud.SelectUserName(name);
    }

    @Override
    public int UpdatePhonePerson(Map<String, Object> map) {
        return ud.UpdatePhonePerson(map);
    }
}