package com.cssl.pojo.controller;


import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.service.HomePage_productService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomePage_productController {
    @Autowired
    private HomePage_productService homePage_productService;
    /*特价商品*/
    @RequestMapping("findBargains")
    public List<HomePage_product> findBargains(@RequestParam("lp_id") Integer lp_id){
        System.out.println("成功到服务者模块！！");
        System.out.println(lp_id);
        return homePage_productService.findBargains(lp_id);
    }
    /*吃喝玩乐*/
    @RequestMapping("findPartyingByCity")
    public List<HomePage_product> findPartyingByCity(@RequestParam(required = false, value = "P_cid") Integer P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id){
        System.out.println("成功到服务者模块！！");
        Map<String, Object> map = new HashMap<>();
        map.put("P_cid", P_cid);
        map.put("Pt_id", Pt_id);
        System.out.println(map);
        return homePage_productService.findPartyingByCity(map);
    }
}
