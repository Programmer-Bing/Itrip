package com.cssl.pojo.controller;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.service.HomePageClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class constroller {
    @Autowired
    private HomePageClientService service;

    @RequestMapping(value = "/consumer/homeproduct/list2")
    public List<HomePage_product> list(HttpSession session){
        System.out.println("sessionId:"+session.getId());
        Map<String,Object>map = new HashMap<String, Object>();
        map.put("Countrt_name","法意瑞");
        map.put("ProductType_name","当地跟游");
        return this.service.list2(map);
    }
}
