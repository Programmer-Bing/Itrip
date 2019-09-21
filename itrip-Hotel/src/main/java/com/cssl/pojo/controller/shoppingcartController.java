package com.cssl.pojo.controller;

import com.cssl.pojo.service.impl.shoppingcartserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class shoppingcartController {

    @Autowired
    private shoppingcartserviceimpl scc;

    @RequestMapping(value = "addCart")
    public boolean addCart(@RequestBody Map<String,Object> map){
        return scc.addCart(map);
    }


}


























