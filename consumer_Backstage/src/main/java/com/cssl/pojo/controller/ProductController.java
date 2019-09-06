package com.cssl.pojo.controller;

import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private UserService userService;

    @RequestMapping("productType")
    @ResponseBody
    public List<Map<String, Object>> productType(){
        return userService.productType();
    }
}
