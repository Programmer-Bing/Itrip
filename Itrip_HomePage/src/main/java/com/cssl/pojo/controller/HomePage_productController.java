package com.cssl.pojo.controller;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.service.HomePage_productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HomePage_productController {
    @Autowired
    private HomePage_productService homePage_productService;
    @GetMapping("/homeproduct/list")
    public List<HomePage_product> list(){
        System.out.println("成功到服务者模块！！");
        return homePage_productService.findAll();
    }
    @GetMapping("/homeproduct/list2")
    public List<HomePage_product> list2(Map<String,Object> map){
        System.out.println("成功到服务者模块！！");
        System.out.println(map);
        return homePage_productService.findByCPT(map);
    }
}
