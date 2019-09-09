package com.cssl.pojo.service;

import com.cssl.pojo.po.User;

import java.util.List;
import java.util.Map;

public interface UserService  {

    public List<User> Cs();


    /***
     *
     * 添加用户 注册
     * @return
     */
    public int addUser(Map<String,Object> map);


    /***
     *
     * 注册 判断重复账号
     * @param phone
     * @return
     */
    public  List<User> JudgeUser(String phone);

    public String Cs2(String name);


    public Map<String,Object> PhoneEmail(String phone);


    public int UpdatePhone(Map<String,Object> map);

    public  List<User> UserLogin(Map<String,Object> map);

}
