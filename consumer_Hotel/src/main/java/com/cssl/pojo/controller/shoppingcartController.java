package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.roomtype;
import com.cssl.pojo.service.HomePageClientService;
import com.cssl.pojo.shoppingcart;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class shoppingcartController {

    @Autowired
    private HomePageClientService service;

    //加入购物车
    @RequestMapping(value = "addCart/{cart}" , method = RequestMethod.GET )
    public String addCart(@PathVariable("cart") Object cart, HttpSession session){
        User attribute = (User)session.getAttribute(session.getId());
        Object attribute1 = session.getAttribute(session.getId() + "123");
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
        if(attribute!=null){
            map.put("userid",attribute.getUser_id());
        }else{
            map.put("userid",1);
        }
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
        return "1";
    }


    @RequestMapping(value = "addHorder/{c}" , method = RequestMethod.GET)
    public ModelAndView AddhOrder(@PathVariable("c") Object c,HttpSession session,ModelAndView model){
        String ro = c.toString().substring(1);
        String[] split1 = ro.split("'");
        List list1 = new ArrayList();
        String[] split = split1[0].split(":");
        Object user = session.getAttribute(session.getId());
        Object hol = session.getAttribute("hol");
        List<Map> home = (List<Map>) session.getAttribute("home");
        for (String s : split) {
            list1.add(s.substring(0,1));
            list1.add(s.substring(2,3));
        }
        List<Map> list = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if(i%2==0){
                for (int j = 0; j < home.size(); j++) {
                    if(list1.get(i).equals(home.get(j).get("rif_id").toString())){
                        list.add(home.get(j));
                    }
                }
            }
        }
        model.addObject("user",user);
        model.addObject("hotel",hol);
        model.addObject("room",list);
        model.addObject("sp1",split1[1]);
        model.addObject("sp2",split1[2]);
        model.addObject("sp3",split1[3]);
        model.setViewName("OrderHotel");
        return model;
    }


}
