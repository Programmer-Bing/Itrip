package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
     * @param
     * @return
     */

    @RequestMapping(method = RequestMethod.POST, value = "/userADD")
    public int addUser(@RequestBody Map<String,Object> map) {
        System.out.println("提供者来到注册");

        return us.addUser(map);
    }


    /***
     * 用户注册
     * 判断号码
     * @param phone
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "UserRegistration")
    public List<User> JudgeUser(@RequestParam(value = "phone") String phone) {
        System.out.println("来了提供者con太肉了咯");
        return us.JudgeUser(phone);
    }




}
