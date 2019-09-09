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
}
