package com.cssl.pojo.controller;

import com.cssl.pojo.po.Page;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class FinlargeplateController {

    @Autowired
    private UserService userService;

    @RequestMapping("Finlargeplate")
    @ResponseBody
    public List<Map<String,Object>> Finlargeplate(){
        return userService.Finlargeplate();
    }

    @RequestMapping("smallplate")
    @ResponseBody
    public List<Map<String,Object>> smallplate(int lp_id){
        return userService.smallplate(lp_id);
    }

    @RequestMapping("pageCitiesstates")
    @ResponseBody
    public Page pageCitiesstates(@RequestParam Map<String,Object> map){
        System.out.println("pageCitiesstates Map:"+map);
        return userService.pageCitiesstates(map);
    }

    @RequestMapping("citiesstatesIsNull")
    @ResponseBody
    public List<Map<String,Object>> citiesstates(int sp_id){
        System.out.println("citiesstatesIsNullSp_id:"+sp_id);
        Map<String,Object> map=new HashMap<>();
        System.out.println("citiesstatesIsNull返回结果:"+userService.citiesstates(map));
        map.put("sp_id",sp_id);
        return userService.citiesstates(map);
    }

    @RequestMapping("addCitiesstates")
    @ResponseBody
    public int addCitiesstates(@RequestParam Map<String,Object> map){
        System.out.println("消费者addCitiesstatesMap:"+map);
        return userService.addCitiesstates(map);
    }

    @RequestMapping("selCitiesstatesID")
    public ModelAndView selCitiesstatesID(@RequestParam int cs_id,ModelAndView modelAndView){
        System.out.println("cs_id:"+cs_id);
        List<Map<String,Object>> selMap=userService.selCitiesstatesID(cs_id);
        System.out.println("selCitiesstatesIDList:"+selMap);
        modelAndView.addObject("list",selMap);
        modelAndView.setViewName("modCityArea");
        return modelAndView;
    }

    @GetMapping("setCitiesstates")
    public String setCitiesstates(@RequestParam Map<String,Object> map){
        System.out.println("消费者setCitiesstatesMap:"+map);
        Map<String,Object> map1=new HashMap<>();
        map1.put("cs_name",map.get("cs_name"));
        map1.put("sb_cs",map.get("cs_id"));
        map1.put("sp_id",map.get("sp_id"));
        map1.put("cs_id",map.get("c_id"));
        map1.put("Popular",map.get("Popular"));
        int num=userService.setCitiesstates(map1);
        if(num>0){
            return "skip/cityTips";
        }else{
            return "skip/cityFailed";
        }
    }

    @RequestMapping("delCitiesstates")
    @ResponseBody
    public int delCitiesstates(@RequestParam int cs_id){
        return userService.delCitiesstates(cs_id);
    }
}
