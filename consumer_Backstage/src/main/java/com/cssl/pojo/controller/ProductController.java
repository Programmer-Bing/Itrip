package com.cssl.pojo.controller;

import com.cssl.pojo.po.Page;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Page page=userService.findProduct(map);
        System.out.println("消费者page:"+page);
        return page;
    }

    @GetMapping("addProduct")
    public String addProduct(@RequestParam Map<String,Object> map,String[] picture){
        System.out.println("AddProductMap:"+map);
        System.out.println("picture:"+picture);
        Map<String,Object> map3=new HashMap<>();
        map3.put("product_name",map.get("p_name"));
        map3.put("p_cid",map.get("citiesstates"));
        int selProCount=userService.selProCount(map3);
        System.out.println("selProCount:"+selProCount);
        if(selProCount>0){
            return "failed";
        }else{
            Map<String,Object> map1=new HashMap<String,Object>();
            map1.put("product_name",map.get("p_name"));
            map1.put("pt_id",map.get("product"));
            map1.put("p_cid",map.get("citiesstates"));
            map1.put("p_imgpath",map.get("img"));
            map1.put("p_price",map.get("price"));
            int num1=userService.addProduct(map1);
            System.out.println("num1:"+num1);
            if(num1<=0){
                return "failed";
            }else{
                if(map.get("product").equals("1") || map.get("product").equals("2") || map.get("product").equals("3")){
                    Map selectMap=userService.selectP_id((String) map.get("p_name"));
                    Map<String,Object> map2=new HashMap<>();
                    map2.put("tp_name",map.get("p_name"));
                    map2.put("Days_play",map.get("Days_play"));
                    map2.put("purchases_Number",map.get("purchases_Number"));
                    map2.put("price",map.get("price"));
                    map2.put("comments_Number",map.get("comments_Number"));
                    map2.put("describes",map.get("describes"));
                    map2.put("Collectors_Number",map.get("Collectors_Number"));
                    map2.put("Strategy",map.get("Strategy"));
                    map2.put("Expensestatement",map.get("Expensestatement"));
                    map2.put("ReservationNotes",map.get("ReservationNotes"));
                    map2.put("itrip",map.get("itrip"));
                    map2.put("Product_id",selectMap.get("Product_id"));

                    String image=picture[0];
                    for (int i=1;i<picture.length;i++){
                        image=image+","+picture[i];
                    }

                    System.out.println("图片:"+image);
                    map2.put("picture",image);
                    int num2=userService.addtourismproducts(map2);
                    System.out.println("num2:"+num2);
                    if(num2>0){
                        System.out.println("新增成功！！！");
                        return "tips";
                    }
                }else if(map.get("product").equals("4")){
                    Map selectMap=userService.selectP_id((String)map.get("p_name"));
                    Map<String,Object> map2=new HashMap<>();

                    map2.put("h_name",map.get("p_name"));
                    map2.put("Product_id",selectMap.get("Product_id"));
                    map2.put("purchases_Number",map.get("purchases_Number"));
                    map2.put("Star_class",map.get("Star_class"));
                    map2.put("cs_id",map.get("citiesstates"));
                    map2.put("describes",map.get("describes"));
                    map2.put("Specific_address",map.get("Specific_address"));
                    map2.put("score",map.get("score"));
                    map2.put("Reservation_Notes",map.get("Reservation_Notes"));
                    map2.put("tips",map.get("tips"));

                    String image=picture[0];

                    for (int i=1;i<picture.length;i++){
                        image=image+","+picture[i];
                    }

                    System.out.println("图片:"+image);
                    map2.put("picture1",image);
                    int num2=userService.addhotel(map2);
                    System.out.println("num2:"+num2);
                    if(num2>0){
                        System.out.println("新增成功！！！");
                        return "tips";
                    }
                }
            }
        }
        return "failed";
    }
}
