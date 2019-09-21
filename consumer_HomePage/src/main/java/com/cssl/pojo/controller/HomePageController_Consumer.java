package com.cssl.pojo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.ProductDetails;
import com.cssl.pojo.service.HomePageClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomePageController_Consumer {

    @Autowired
    private HomePageClientService service;

    /*,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE*/
    /*特价商品查询*/
    @RequestMapping(value = "/findBargains", method = RequestMethod.GET)
    @ResponseBody
    public List<HomePage_product> findBargains(HttpSession session, @RequestParam(required = false, value = "lp_id") Integer lp_id) {
        System.out.println("sessionId:" + session.getId());
        System.out.println("大区编号：" + lp_id);
        return this.service.findBargains(lp_id);
    }

    /*热销商品查询*/
    @RequestMapping(value = "/findSellwell", method = RequestMethod.GET)
    @ResponseBody
    public List<HomePage_product> findSellwell(HttpSession session) {
        System.out.println("sessionId:" + session.getId());
        return this.service.findSellwell();
    }

    /*唯一城市商品查询*/
    @RequestMapping(value = "/findPartyingByCity", method = RequestMethod.GET)
    @ResponseBody
    public List<HomePage_product> findPartyingByCity(HttpSession session, @RequestParam(required = false, value = "P_cid") Integer P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id) {
        System.out.println("sessionId:" + session.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("P_cid", P_cid);
        map.put("Pt_id", Pt_id);
        System.out.println("map:" + map);
        return this.service.findPartyingByCity(P_cid, Pt_id);
    }

    /*多城市商品查询*/
    @RequestMapping(value = "/findPartyingByCities", method = RequestMethod.GET)
    @ResponseBody
    public List<HomePage_product> findPartyingByCities(HttpSession session, @RequestParam(required = false, value = "P_cid") String P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id) {
        System.out.println("城市不唯一");
        System.out.println("sessionId:" + session.getId());
        System.out.println(P_cid);
        Map<String, Object> map = new HashMap<>();
        map.put("P_cid", P_cid);
        map.put("Pt_id", Pt_id);
        System.out.println("map:" + map);
        return this.service.findPartyingByCities(P_cid, Pt_id);
    }

    /*跟据商品id来查找商品详情*/
    @RequestMapping(value = "/findProductDetails")
    public String findProductDetails(HttpSession session, @RequestParam(required = false, value = "Product_id") Integer Product_id) {
        System.out.println("sessionId:" + session.getId());
        System.out.println("商品编号：" + Product_id);
        return this.service.findProductDetails(Product_id);
    }
}
