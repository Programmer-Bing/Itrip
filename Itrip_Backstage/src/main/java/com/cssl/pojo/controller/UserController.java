package com.cssl.pojo.controller;

import com.cssl.pojo.po.Page;
import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public Page findAll(@RequestBody Map<String,Object> map){
        System.out.println("服务者UserMap:"+map);
        Map<String,Object> map1=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();
        Page page=new Page();

        map1.put("index",null);
        map1.put("size",null);
        map1.put("chinese_name",(String)map.get("Chinese_Name"));
        map1.put("english_name",(String)map.get("English_Name"));
        List list=userService.findAll(map1);
        int totle=list.size();  //查询总数据量
        String pageNumber=(String)map.get("pageNumber");  //当前页数
        int pageIndex=Integer.parseInt(pageNumber);
        int pageSize=1;  //每页显示数量
        int pages=totle%pageSize==0?totle/pageSize:totle/pageSize+1;  //获取总页数

        map2.put("index",(pageIndex-1)*pageSize);
        map2.put("size",pageSize);
        map2.put("chinese_name",(String)map.get("Chinese_Name"));
        map2.put("english_name",(String)map.get("English_Name"));
        List list1=userService.findAll(map2);
        System.out.println("服务者:"+list1);

        page.setList(list1);
        page.setTotalPage(pages);

        return page;
    }
}
