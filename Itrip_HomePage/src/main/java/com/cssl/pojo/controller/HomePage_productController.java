package com.cssl.pojo.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.ProductDetails;
import com.cssl.pojo.service.HomePage_productService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HomePage_productController {
    @Autowired
    private HomePage_productService homePage_productService;

    /*特价商品*/
    @RequestMapping("findBargains")
    @ResponseBody
    public List<HomePage_product> findBargains(@RequestParam("lp_id") Integer lp_id) {
        System.out.println("特价成功到服务者模块！！");
        System.out.println(lp_id);
        return homePage_productService.findBargains(lp_id);
    }

    /*热销商品*/
    @RequestMapping("findSellwell")
    @ResponseBody
    public List<HomePage_product> findSellwell() {
        System.out.println("热销成功到服务者模块！！");
        return homePage_productService.findSellwell();
    }

    /*根据城市查商品*/
    @RequestMapping("findPartyingByCity")
    @ResponseBody
    public List<HomePage_product> findPartyingByCity(@RequestParam(required = false, value = "P_cid") Integer P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id) {
        System.out.println("唯一成功到服务者模块！！");
        Map<String, Object> map = new HashMap<>();
        map.put("P_cid", P_cid);
        map.put("Pt_id", Pt_id);
        System.out.println(map);
        return homePage_productService.findPartyingByCity(map);
    }

    /*根据多城市查商品*/
    @RequestMapping("findPartyingByCities")
    @ResponseBody
    public List<HomePage_product> findPartyingByCities(@RequestParam(required = false, value = "P_cid") String P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id) {
        System.out.println("多成功到服务者模块！！");
        List<String> list = JSON.parseArray(P_cid, String.class);
        Map<String, Object> map = new HashMap<>();
        map.put("P_cid", list);
        map.put("Pt_id", Pt_id);
        System.out.println(map);
        return homePage_productService.findPartyingByCities(map);
    }

    /*跟据商品id来查找商品详情*/
    @RequestMapping("/findProductDetails")
    public String findProductDetails(@RequestParam("Product_id") Integer Product_id, Model model) {
        System.out.println("ByProduct_idfind成功到服务者模块！！");
        System.out.println(Product_id);
        ProductDetails pd = homePage_productService.findProductDetails(Product_id);
        model.addAttribute("ProductDetails", pd);
        return "HomePage/ProductDetails";
    }

}
