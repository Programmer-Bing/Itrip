package com.cssl.pojo.dao;

import com.cssl.pojo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface UserDao {


     //测试
     public List<User>  Cs();


     public  int addUSer(User uu);


}
