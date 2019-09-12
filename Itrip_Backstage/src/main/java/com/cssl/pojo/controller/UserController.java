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
    private UserService userService;

    @RequestMapping("findAll")
    public List<Map<String,Object>> findAll(@RequestBody Map<String,Object> map){
        System.out.println("服务者UserMap:"+map);
        System.out.println("服务者User:"+userService.findAll(map));
        return userService.findAll(map);
    }
}
