package com.cssl.pojo.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.Method.Method;
import com.cssl.pojo.ProductDetails;
import com.cssl.pojo.Product_shopping;
import com.cssl.pojo.service.HomePage_productService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

import static com.cssl.pojo.Method.Method.json2map;

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
    @RequestMapping("findProductDetails")
    @ResponseBody
    public ProductDetails findProductDetails(@RequestParam("Product_id") Integer Product_id) {
        System.out.println("ByProduct_idfind成功到服务者模块！！");
        System.out.println(Product_id);
        return homePage_productService.findProductDetails(Product_id);
    }

    /*跟据商品id来查找商品*/
    @RequestMapping("findByP_id")
    @ResponseBody
    public HomePage_product findByP_id(@RequestParam("Product_id") Integer Product_id) {
        System.out.println("ByP_idfind成功到服务者模块！！");
        System.out.println(Product_id);
        return homePage_productService.findByP_id(Product_id);
    }

    /*向购物车里添加商品*/
    @RequestMapping("addShopping")
    @ResponseBody
    public Integer addShopping(@RequestParam(value = "map", required = false) String map) {
        System.out.println("AddShopping成功到服务者模块！！");
        Product_shopping product_shopping = new Product_shopping();
        Map<String, Object> map2 = json2map(map);
        System.out.println(map2);
        HomePage_product hp = homePage_productService.findByP_id(Integer.valueOf((String) map2.get("p_id")));
        product_shopping.setP_id(Integer.valueOf((String) map2.get("p_id")));
        product_shopping.setTravel_date((String) map2.get("Travel_date"));
        product_shopping.setSettlement_price(BigDecimal.valueOf((Double) map2.get("Settlement_price")));
        product_shopping.setProduct_specification((String) map2.get("Product_specification"));
        product_shopping.setAdult_num(Integer.parseInt((String) map2.get("Adult_num")));
        product_shopping.setChildren_num(Integer.parseInt((String) map2.get("children_num")));
        product_shopping.setBaby_num(Integer.parseInt((String) map2.get("baby_num")));
        product_shopping.setDiscount(BigDecimal.valueOf((Double) map2.get("Discount")));
        product_shopping.setUid(Integer.parseInt((String) map2.get("uid")));
        product_shopping.setP_imgpath(hp.getProduct_imgPath());
        product_shopping.setP_title(hp.getProduct_name());
        System.out.println(product_shopping);
        return homePage_productService.addShopping(product_shopping);
    }

    /*查找xx的购物车所有商品*/
    @RequestMapping("findShoppingByUid")
    @ResponseBody
    public List<Product_shopping> findShoppingByUid(@RequestParam(value = "uid", required = false) Integer uid) {
        System.out.println("findShopping成功到服务者模块！！");
        System.out.println(uid);
        return homePage_productService.findShoppingByUid(uid);
    }
    /*删除购物车里的商品*/
    @RequestMapping("delShopping")
    @ResponseBody
    public Integer delShopping(@RequestParam(value = "psc_id", required = false) Integer psc_id) {
        System.out.println("DelShopping成功到服务者模块！！");
        return homePage_productService.delShopping(psc_id);
    }

    /*地区显示*/
    @RequestMapping("showregion")
    public List<Map> showregion(){
        return homePage_productService.showregion();
    }


    /*显示购物车*/
    @RequestMapping("showMycart")
    @ResponseBody
    public List<List> showMycart(){
        return homePage_productService.showMycart();
    }

    /*删除酒店购物车*/
    @RequestMapping("delHotel")
    @ResponseBody
    public boolean delHotel(Integer sht){
        return  homePage_productService.delHotel(sht);
    }


}
