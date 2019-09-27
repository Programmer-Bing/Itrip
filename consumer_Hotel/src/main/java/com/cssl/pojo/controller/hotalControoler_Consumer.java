package com.cssl.pojo.controller;

import com.cssl.pojo.DeptConsumerFeign81_App;
import com.cssl.pojo.po.User;
import com.cssl.pojo.service.HomePageClientService;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class hotalControoler_Consumer {

    @Autowired
    private HomePageClientService homePageClientService;

    //酒店的显示
    @RequestMapping(value = "hotel",method = RequestMethod.GET)
    public List<Map> hotel(HttpSession session){
        User attribute = (User) session.getAttribute(session.getId());
        Map map = new HashMap();
        if(attribute!=null){
            map.put("name",attribute.getChinese_Name());
        }
        List<Map> list = homePageClientService.hotel(0);
        list.add(map);
        for (Map maps : list) {
            System.out.println(maps);
        }
        System.out.println("--------------------");
        System.out.println(session.getId());
        System.out.println("--------------------");
        return list;
    }

    //酒店详情
    @RequestMapping(value = "showInfo/{id}",method = RequestMethod.GET)
    public ModelAndView showInfo(@PathVariable("id") int id,ModelAndView model,HttpSession session){
        List<Map> hotel = homePageClientService.hotel(id);
        List<Map> maps = homePageClientService.showInfo(id);
        User user = (User) session.getAttribute(session.getId());
        if(user==null){
            User user1 = new User();
            user1.setUser_id(0);
            user = user1;
        }
        model.addObject("hotel",hotel);
        model.addObject("lable",homePageClientService.showlable(id));
        model.addObject("home",maps);
        model.addObject("pre",homePageClientService.showpre(id));
        model.addObject("user",user);
        model.setViewName("details");
        session.setAttribute("hol",hotel);
        session.setAttribute("home",maps);
        return model;
    }

    @RequestMapping("/GetSession")
    public User GetSession(HttpSession se){
        System.out.println("来了查询sessionid");
        System.out.println("sessionID: "+se.getId());
        User user =(User) se.getAttribute(se.getId());
        String phone = (String)se.getAttribute(se.getId() + "123");
        System.out.println("显示主界面的名字: "+phone);
        if(user!=null){
            System.out.println("用户姓名: "+user.getChinese_Name());
            return  user;
        }
        else{
            return  null;
        }


    }


    /***
     *
     * 退出登录
     */
    @RequestMapping(value = "/logout")
    public int LogOut(HttpSession se){

        se.invalidate();
        return  0;

    }

    /**
     * 添加酒店订单
     */
    public ModelAndView HotelOrder(){
        return null;
    }

}




