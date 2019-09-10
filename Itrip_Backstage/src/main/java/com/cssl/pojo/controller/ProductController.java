package com.cssl.pojo.controller;

import com.cssl.pojo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET,value = "productType")
    public List<Map<String,Object>> productType(){
        return productService.productType();
    }

    @RequestMapping(method = RequestMethod.GET,value = "citiesstates")
    public List<Map<String,Object>> citiesstates(){
        return productService.citiesstates();
    }

    @RequestMapping(method = RequestMethod.GET,value = "findProduct")
    public List<Map<String,Object>> findProduct(@RequestBody Map<String,Object> map){
        System.out.println("map参数:"+map);
        System.out.println("服务者:"+productService.findProduct(map));
        return productService.findProduct(map);
    }
    @RequestMapping(method = RequestMethod.GET,value = "productSize")
    public int productSize(){
        return productService.productSize();
    }
}
