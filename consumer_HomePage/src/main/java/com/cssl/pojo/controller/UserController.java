package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.service.HomePageClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private HomePageClientService service;
    @RequestMapping(value = "/consumer/homeproduct/cs")
    public List<User> Cs(HttpSession session){
        return this.service.Cs();
    }



    @RequestMapping(value ="/consumer/homeproduct/add")
    public int addUser(@RequestParam String name){

        return  0;

    }

    @RequestMapping(value = "/consumer/homeproduct/JudageUser")
    public List<User> JudgeUser(@RequestParam String phone){
        System.out.println("注册判断");
        System.out.println(phone);
        return  service.JudgeUser(phone);
    }



}
