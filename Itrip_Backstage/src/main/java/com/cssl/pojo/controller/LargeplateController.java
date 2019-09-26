package com.cssl.pojo.controller;

import com.cssl.pojo.po.Page;
import com.cssl.pojo.service.LargeplateService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.*;

@RestController
public class LargeplateController {

    @Autowired
    private LargeplateService largeplateService;

    @RequestMapping("Finlargeplate")
    public List<Map<String,Object>> Finlargeplate(){
        return largeplateService.Finlargeplate();
    }

    @RequestMapping("smallplate")
    public List<Map<String,Object>> smallplate(@RequestBody int lp_id){
        System.out.println("lp_id:"+lp_id);
        return largeplateService.smallplate(lp_id);
    }

    @RequestMapping("pageCitiesstates")
    public Page pageCitiesstates(@RequestBody Map<String,Object> map){
        System.out.println("服务者pageCitiesstatesMap:"+map);
        Map<String,Object> map1=new HashMap<>();
        map1.put("pageindex",null);
        map1.put("pagesize",null);
        map1.put("cs_name",map.get("cs_name"));
        map1.put("sp_id",map.get("sp_id"));
        List<Map<String,Object>> list1=largeplateService.pageCitiesstates(map1);

        int total=list1.size();   //获取总数量
        int pageSize=3;          //每页显示数量
        String pageNumber=(String)map.get("pageindex");   //获取当前页数
        int pageindex=Integer.parseInt(pageNumber);
        int pages=total%pageSize==0?total/pageSize:total/pageSize+1;  //获取总页数

        Map<String,Object> map2=new HashMap<>();
        map2.put("pageindex",(pageindex-1)*pageSize);
        map2.put("pagesize",pageSize);
        map2.put("cs_name",map.get("cs_name"));
        map2.put("sp_id",map.get("sp_id"));
        List<Map<String,Object>> list2=largeplateService.pageCitiesstates(map2);
        for (int i=0;i<list2.size();i++){
            int sb_cs=(int)list2.get(i).get("cs_id");
            List<Map<String,Object>> list3=largeplateService.sonCitiesstates(sb_cs);
            System.out.println("list3:"+list3);
            list2.get(i).put("sonCity",list3);
        }
        System.out.println("list2:"+list2);

        Page page=new Page();
        page.setList(list2);
        page.setTotalPage(pages);
        return page;
    }

    @RequestMapping("citiesstatesIsNUll")
    public List<Map<String,Object>> citiesstates(@RequestBody Map<String,Object> map){
        return largeplateService.pageCitiesstates(map);
    }

    @RequestMapping("addCitiesstates")
    public int addCitiesstates(@RequestBody Map<String,Object> map){
        System.out.println("服务者addCitiesstatesMap:"+map);
        Map<String,Object> map1=new HashMap<>();
        map1.put("cs_name",map.get("cs_name"));
        map1.put("sp_id",map.get("sp_id"));
        List<Map<String,Object>> list=largeplateService.selCityWhereNameAndsp_id(map1);
        System.out.println("服务者新增国家或地区:"+list);
        if(list.size()!=0){
            return 3;
        }else{
            return largeplateService.addCitiesstates2(map);
        }
    }

    @RequestMapping("setCitiesstates")
    public int setCitiesstates(@RequestBody Map<String,Object> map){
        return largeplateService.setCitiesstates(map);
    }

    @RequestMapping("selCitiesstatesID")
    public List<Map<String,Object>> selCitiesstatesID(@RequestBody int cs_id){
        return largeplateService.selCitiesstatesID(cs_id);
    }

    @RequestMapping("delCitiesstates")
    public int delCitiesstates(@RequestBody int cs_id){
        List<Map<String,Object>> sonCity=largeplateService.sonCitiesstates(cs_id);
        if(sonCity.size()>0){
            return 3;
        }else{
            return largeplateService.delCitiesstates(cs_id);
        }
    }
}
