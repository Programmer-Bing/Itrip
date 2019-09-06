package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public List<Map<String,Object>> findALL(){
        System.out.println("进入消费者Controller");
        System.out.println("输出:"+userService.findAll());
        return this.userService.findAll();
    }
}
