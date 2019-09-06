package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.service.HomePageClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserConstroller {
    @Autowired
    private HomePageClientService service;
    @RequestMapping(value = "/UserRegistration")
    public List<User> JudgeUser(@RequestParam String phone){
        System.out.println("注册判断");
        System.out.println(phone);
        return  service.JudgeUser(phone);
    }
}
