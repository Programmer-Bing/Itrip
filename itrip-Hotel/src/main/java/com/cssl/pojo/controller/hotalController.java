package com.cssl.pojo.controller;

import com.cssl.pojo.hotal;
import com.cssl.pojo.service.hotalservice;
import com.cssl.pojo.service.impl.hotalserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class hotalController {

    @Autowired
    public hotalservice hotalservices;

    @RequestMapping(value = "hotel")
    public List<Map> hotel(@RequestBody int id){
        List<Map> maps = hotalservices.hotel(id);
        for (Map map : maps) {
            System.out.println(map);
        }
        return maps;
    }

    @RequestMapping(value = "showInfo")
    public List<Map> showInfo(@RequestBody int id){
        return hotalservices.showInfo(id);
    }

    @RequestMapping(value = "showlable")
    public List<Map> showlable(@RequestBody int id){
        return  hotalservices.showlable(id);
    }

    @RequestMapping(value = "showpre")
    public List<Map> showpre(@RequestBody int id){
        return hotalservices.showpre(id);
    }

}
