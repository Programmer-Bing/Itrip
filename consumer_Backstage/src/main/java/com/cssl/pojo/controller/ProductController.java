package com.cssl.pojo.controller;

import com.cssl.pojo.po.Page;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private UserService userService;

    @RequestMapping("productType")
    @ResponseBody
    public List<Map<String, Object>> productType(){
        return userService.productType();
    }

    @RequestMapping("citiesstates")
    @ResponseBody
    public List<Map<String,Object>> citiesstates(){
        return userService.citiesstates();
    }

    @RequestMapping("findProduct")
    @ResponseBody
    public Page findProduct(@RequestParam Map<String,Object> map){
        System.out.println("分页map:"+map);

        String pageNumber=(String)map.get("pageNumber");
        Map<String,Object> map1=new HashMap<>();

        int pageIndex=Integer.parseInt(pageNumber);  //当前页数
        int pageSize=3;   //每页显示数量
        List list=userService.findProduct(null);

        map1.put("index",(pageIndex-1)*pageSize);
        map1.put("size",pageSize);
        map1.put("pt_id",(String)map.get("pt_id"));
        map1.put("p_cid",(String)map.get("p_cid"));
        int total=list.size(); //获取总数据量

        System.out.println("total:"+total);
        int pages=total%pageSize==0?total/pageSize:total/pageSize+1;  //获取总页数
        List list2=userService.findProduct(map1);
        System.out.println("list2:"+list2);

        Page page=new Page();
        page.setPageNumber(pageIndex);
        page.setList(list2);
        page.setTotalRecord(total);
        page.setPageSize(pageSize);
        page.setTotalPage(pages);

        return page;
    }
}
