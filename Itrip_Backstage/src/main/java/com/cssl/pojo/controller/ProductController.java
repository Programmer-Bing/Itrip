package com.cssl.pojo.controller;

import com.cssl.pojo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("productType")
    public List<Map<String,Object>> productType(){
        return productService.productType();
    }
}
