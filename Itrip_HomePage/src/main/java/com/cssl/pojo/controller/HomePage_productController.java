package com.cssl.pojo.controller;


import com.alibaba.fastjson.JSON;
import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.ProductDetails;
import com.cssl.pojo.Product_shopping;
import com.cssl.pojo.order.OProduct;
import com.cssl.pojo.order.Order;
import com.cssl.pojo.service.HomePage_productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

import static com.cssl.pojo.method.Method.getOrderIdByTime;
import static com.cssl.pojo.method.Method.json2map;

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
    public List<Map> showregion() {
        return homePage_productService.showregion();
    }


    /*显示购物车*/
    @RequestMapping("showMycart")
    @ResponseBody
    public List<List> showMycart() {
        return homePage_productService.showMycart();
    }

    /*删除酒店购物车*/
    @RequestMapping("delHotel")
    @ResponseBody
    public boolean delHotel(Integer sht) {
        return homePage_productService.delHotel(sht);
    }

    /* 查询数据库最新添加的一条数据*/
    @RequestMapping("findNew")
    @ResponseBody
    public Product_shopping findNew() {
        return homePage_productService.findNew();
    }

    /* 跟据id查购物车的商品*/
    @RequestMapping("findById")
    @ResponseBody
    public Product_shopping findById(Integer psc_id) {
        return homePage_productService.findById(psc_id);
    }

    /* 添加订单*/
    @RequestMapping("addOrder")
    @ResponseBody
    public Map addOrder(@RequestParam(value = "map", required = false) String map) {
        Map<String, Object> map2 = json2map(map);
        Order o = new Order();
        String orderno = getOrderIdByTime();
        o.setMoney(BigDecimal.valueOf(Double.valueOf((String) map2.get("Allmoney"))));
        o.setUid(Integer.parseInt((String) map2.get("uid")));
        o.setOrder_no(orderno);
        int num1 = 0;
        num1 = homePage_productService.addOrder(o);
        List<String> strings = (List<String>) map2.get("pscids");
        for (String string : strings) {
            Product_shopping ps = homePage_productService.findById(Integer.valueOf(string));
            OProduct op = new OProduct();
            op.setP_id(ps.getP_id());
            op.setP_img(ps.getP_imgpath());
            op.setP_name(ps.getP_title());
            op.setTraveltime(ps.getTravel_date());
            op.setMoney(ps.getSettlement_price());
            op.setOrder_no(orderno);
            num1 = homePage_productService.addOrderProduct(op);
        }
        Map<String, Object> omap = new HashMap<>();
        omap.put("orderNo", orderno);
        omap.put("orderMoney", (String) map2.get("Allmoney"));
        omap.put("num", num1);
        return omap;
    }

    @RequestMapping("updOrder")
    @ResponseBody
    public int updOrder(@RequestParam(value = "order_no", required = false) String order_no) {
        int num = 0;
        num = homePage_productService.updOrderState(order_no);
        System.out.println(order_no+"ij"+num);
        num = homePage_productService.updOrderProductState(order_no);
        System.out.println(num);
        return num;
    }
}
