package com.cssl.pojo.dao;

import com.cssl.pojo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDao {
    /***
     *
     * 测试
     * @return
     */
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

    /***
     * 根据号码查邮箱
     * @param
     * @return
     */
    public Map<String,Object> PhoneEmail(String phone);


    /***
     *
     * 修改密码
     */
    public int UpdatePhone(Map<String,Object> map);

    /***
     * 手机密码登录
     *
     */
    public List<User> UserLogin(Map<String,Object> map);

    /***
     * 邮箱登录
     * @param map
     * @return
     */
    public List<User> UserLoginEmail(Map<String,Object> map);

    /***
     *
     *
     *修改用户信息
     * @return
     */
    public int UpdateUser(User uu);


    /***
     *
     * 根据用户昵称查询用户
     */
    public List<User> SelectUserName(@PathVariable  String name);


    /***
     *
     *
     * 修改电话
     */
    public int UpdatePhonePerson(Map<String,Object> map);








}
