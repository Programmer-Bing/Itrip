package com.cssl.pojo.controller;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.Product_shopping;
import com.cssl.pojo.service.HomePageClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cssl.pojo.method.Method.json2map;

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
    @RequestMapping(value = "/findProductDetails", method = RequestMethod.GET)
    public ModelAndView findProductDetails(HttpSession session, @RequestParam(required = false, value = "Product_id") Integer Product_id, ModelAndView model) {
        System.out.println("sessionId:" + session.getId());
        System.out.println("商品编号：" + Product_id);
        model.addObject("ProductDetails", this.service.findProductDetails(Product_id));
        model.setViewName("HomePage/ProductDetails");
        return model;
    }

    /*添加购物车*/
    @RequestMapping(value = "/addShopping", method = RequestMethod.GET)
    @ResponseBody
    public Integer addShopping(HttpSession session, @RequestParam(value = "map", required = false) String map) {
        System.out.println("sessionId:" + session.getId());
        System.out.println(map);
        Integer num = this.service.addShopping(map);
        System.out.println("num:" + num);
        return num;
    }
    /*立即预定*/
    @RequestMapping("/Reservation")
    public ModelAndView Reservation(HttpSession session, @RequestParam(value = "map", required = false) String map,ModelAndView model, Model model2) {
        System.out.println("sessionId:" + session.getId());
        System.out.println("进入立即结算");
        Integer num = this.service.addShopping(map);
        Map<String, Object> map2 = json2map(map);
        Product_shopping product_shopping = new Product_shopping();
        HomePage_product hp = this.service.findByP_id(Integer.valueOf((String) map2.get("p_id")));
        product_shopping.setP_id(Integer.valueOf((String) map2.get("p_id")));
        product_shopping.setTravel_date((String) map2.get("Travel_date"));
        product_shopping.setSettlement_price(BigDecimal.valueOf((Double) map2.get("Settlement_price")));
        product_shopping.setProduct_specification((String) map2.get("Product_specification"));
        product_shopping.setAdult_num(Integer.parseInt((String) map2.get("Adult_num")));
        product_shopping.setChildren_num(Integer.parseInt((String) map2.get("children_num")));
        product_shopping.setBaby_num(Integer.parseInt((String) map2.get("baby_num")));
        product_shopping.setDiscount(BigDecimal.valueOf((Double) map2.get("Discount")));
        product_shopping.setUid(Integer.parseInt((String) map2.get("uid")));
        product_shopping.setP_title(hp.getProduct_name());
        List<Product_shopping> list1 = new ArrayList<>();
        List<Product_shopping> list2 = new ArrayList<>();
        list1.add(product_shopping);
        System.out.println(list1);
        model.addObject("Pshopping", list1);
        model2.addAttribute("Hshopping", list2);
        model.setViewName("HomePage/Order_now");
        return model;
    }
    /*xx的购物车的显示*/
    @RequestMapping("/findShoppingByUid")
    public ModelAndView findShoppingByUid(HttpSession session, ModelAndView model, Model model2, @RequestParam(value = "uid", required = false) Integer uid) {
        System.out.println("findShopping成功到消费者模块！！");
        List<List> maps = service.showMycart();
        System.out.println(uid);
        model2.addAttribute("ShoppingC", this.service.findShoppingByUid(uid));
        model2.addAttribute("ShoppingH", maps);
        System.out.println("--------------------");
        model.setViewName("HomePage/ShoppingCart");
        return model;
    }

    /*删除购物车中的商品*/
    @RequestMapping(value = "/delShopping", method = RequestMethod.GET)
    @ResponseBody
    public Integer delShopping(HttpSession session, @RequestParam(value = "psc_id", required = false) Integer psc_id) {
        System.out.println("sessionId:" + session.getId());
        System.out.println(psc_id);
        Integer num = this.service.delShopping(psc_id);
        System.out.println("num:" + num);
        return num;
    }



    /**
     * 删除酒店购物车
     */
    @RequestMapping(value = "/delHotel" , method = RequestMethod.GET)
    public ModelAndView delHotel(ModelAndView model,@RequestParam(value = "sht", required = false) Integer sht){
        service.delHotel(sht);
        model.setViewName("Europe");
        return model;
    }

}
