package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService us;


    @RequestMapping("/homeproduct/cs")
    public List<User> Cs() {
        return us.Cs();
    }


    /***
     *
     * 添加 用户 注册
     * @param name
     * @return
     */

    @RequestMapping("/homeproduct/add")
    public int addUser(@RequestParam String name) {


        return us.addUser(name);
    }


    /***
     * 用户注册
     * 判断号码
     * @param phone
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "UserRegistration")
    public List<User> JudgeUser(@RequestParam(value = "phone",required = false) String phone) {
        System.out.println("来了提供者con太肉了咯");
        return us.JudgeUser(phone);
    }


}
