package com.cssl.pojo.controller;

import com.cssl.pojo.roomtype;
import com.cssl.pojo.service.HomePageClientService;
import com.cssl.pojo.shoppingcart;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import lombok.Data;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class shoppingcartController {

    @Autowired
    private HomePageClientService service;

    //加入购物车
    @RequestMapping(value = "addCart/{cart}" , method = RequestMethod.GET )
    public String addCart(@PathVariable("cart") Object cart){
        JSONObject jsonObject = JSONObject.fromObject(cart);
        shoppingcart scart = new shoppingcart();
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime());
        int math = (int)((Math.random()*9+1)*1000);
        String id = timestamp+math;
        Object room = jsonObject.get("room");
        String[] split = room.toString().split("\\|");
        Map map = new HashMap();
        List<roomtype> list = new ArrayList<>();
        for (String s : split) {
            roomtype rt = new roomtype();
            rt.setId(id);
            rt.setRif_id(Integer.parseInt(s.substring(0,1)));
            rt.setRif_num(Integer.parseInt(s.substring(1,2)));
            list.add(rt);
        }
        map.put("sht_id",id);
        map.put("Product_id",Integer.parseInt(jsonObject.get("Product_id").toString()));
        map.put("Original_price",Double.parseDouble(jsonObject.get("Original_price").toString()));
        map.put("Travle_date",jsonObject.get("Travle_date").toString());
        map.put("Leavingshop_date",jsonObject.get("Leavingshop_date").toString());
        List<roomtype> list1 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getRif_num()!=0){
                roomtype roomt = new roomtype();
                roomt.setRif_id(list.get(i).getRif_id());
                roomt.setRif_num(list.get(i).getRif_num());
                list1.add(roomt);
            }
        }
        map.put("rooms",list1);
        service.addCart(map);
        return "牛逼";
    }



}
