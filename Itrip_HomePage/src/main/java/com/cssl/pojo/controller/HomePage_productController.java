package com.cssl.pojo.controller;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.service.HomePage_productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomePage_productController {
    @Autowired
    private HomePage_productService homePage_productService;
    @GetMapping("/homeproduct/list")
    public List<HomePage_product> list(){
        return homePage_productService.findAll();
    }
}
