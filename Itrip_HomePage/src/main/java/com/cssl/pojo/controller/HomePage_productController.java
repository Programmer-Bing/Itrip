package com.cssl.pojo.controller;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.service.HomePage_productService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HomePage_productController {
    @Autowired
    private HomePage_productService homePage_productService;
    @RequestMapping("findBargains")
    public List<HomePage_product> findBargains(@RequestParam("lp_id") Integer lp_id){
        System.out.println("成功到服务者模块！！");
        System.out.println(lp_id);
        return homePage_productService.findBargains(lp_id);
    }
}
