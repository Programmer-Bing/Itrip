package com.cssl.pojo.controller;

import com.cssl.pojo.DeptConsumerFeign80_App;
import com.cssl.pojo.service.HomePageClientService;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class hotalControoler_Consumer {

    @Autowired
    private HomePageClientService homePageClientService;

    //酒店的显示
    @RequestMapping(value = "hotel",method = RequestMethod.GET)
    public List<Map> hotel(){
        List<Map> list = homePageClientService.hotel(0);
        for (Map map : list) {
            System.out.println(map);
        }
        return list;
    }

    //酒店详情
    @RequestMapping(value = "showInfo/{id}",method = RequestMethod.GET)
    public ModelAndView showInfo(@PathVariable("id") int id,ModelAndView model){
        List<Map> hotel = homePageClientService.hotel(id);
        model.addObject("hotel",hotel);
        for (Map map : hotel) {
            System.out.println(map);
        }
        model.addObject("lable",homePageClientService.showlable(id));
        model.addObject("home",homePageClientService.showInfo(id));
        model.addObject("pre",homePageClientService.showpre(id));
        model.setViewName("details");
        return model;
    }

}




