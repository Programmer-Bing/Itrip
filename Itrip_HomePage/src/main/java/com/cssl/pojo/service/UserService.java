package com.cssl.pojo.service;

import com.cssl.pojo.po.User;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<User> UserLoginEmail(Map<String,Object> map);

    public int UpdateUser(User uu);

    public List<User> SelectUserName( String name);

    public int UpdatePhonePerson(Map<String,Object> map);



}
