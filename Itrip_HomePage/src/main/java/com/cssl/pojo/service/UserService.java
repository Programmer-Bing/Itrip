package com.cssl.pojo.service;

import com.cssl.pojo.po.User;

import java.util.List;

public interface UserService  {

    public List<User> Cs();


    /***
     *
     * 添加用户 注册
     * @return
     */
    public int addUser(String name);
}
