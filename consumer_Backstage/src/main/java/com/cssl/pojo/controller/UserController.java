package com.cssl.pojo.controller;

import com.cssl.pojo.po.Page;
import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    @ResponseBody
    public Page findALL(@RequestParam Map<String,Object> map){
        System.out.println("userMap:"+map);
        Page page=userService.findAll(map);
        System.out.println("服务者UserList:"+page.getList());
        return page;
    }



}
