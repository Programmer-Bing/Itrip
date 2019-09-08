package com.cssl.pojo.controller;

import com.cssl.pojo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("citiesstates")
    public List<Map<String,Object>> citiesstates(){
        return productService.citiesstates();
    }

    @RequestMapping("findProduct")
    public List<Map<String,Object>> findProduct(@RequestBody Map<String,Object> map){
        System.out.println("map参数:"+map);
        System.out.println("服务者:"+productService.findProduct(map));
        return productService.findProduct(map);

    }
}
