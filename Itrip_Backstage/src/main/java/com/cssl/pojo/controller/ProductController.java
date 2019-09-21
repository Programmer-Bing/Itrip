package com.cssl.pojo.controller;

import com.cssl.pojo.po.Page;
import com.cssl.pojo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET,value = "productType")
    public List<Map<String,Object>> productType(){
        return productService.productType();
    }

    @RequestMapping(method = RequestMethod.GET,value = "citiesstates")
    public List<Map<String,Object>> citiesstates(){
        return productService.citiesstates();
    }


    @RequestMapping("findProduct")
    public Page findProduct(@RequestBody Map<String,Object> map){
        System.out.println("map参数:"+map);
        System.out.println("服务者:"+productService.findProduct(map));
        String pageNumber=(String)map.get("pageNumber");
        Map<String,Object> map1=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();
        map2.put("index",null);
        map2.put("size",null);
        map2.put("title",(String)map.get("title"));
        map2.put("pt_id",(String)map.get("pt_id"));
        map2.put("p_cid",(String)map.get("p_cid"));

        int pageIndex=Integer.parseInt(pageNumber);  //当前页数
        int pageSize=3;   //每页显示数量
        List list=productService.findProduct(map2);
        int total=list.size();  //获取总数据量

        map1.put("index",(pageIndex-1)*pageSize);
        map1.put("size",pageSize);
        map1.put("title",(String)map.get("title"));
        map1.put("pt_id",(String)map.get("pt_id"));
        map1.put("p_cid",(String)map.get("p_cid"));
        System.out.println("total:"+total);

        int pages=total%pageSize==0?total/pageSize:total/pageSize+1;  //获取总页数
        List list2=productService.findProduct(map1);
        //System.out.println("list2:"+list2);

        Page page=new Page();
        page.setPageNumber(pageIndex);
        page.setList(list2);
        page.setTotalRecord(total);
        page.setPageSize(pageSize);
        page.setTotalPage(pages);
        System.out.println("提供者page:"+page);
        return page;
    }


    @RequestMapping(method = RequestMethod.GET,value = "productSize")
    public int productSize(){
        return productService.productSize();
    }

    @RequestMapping("addProduct")
    public int addProduct(@RequestBody Map<String,Object> map){
        return productService.addProduct(map);
    }

    @RequestMapping("addtourismproducts")
    public int addtourismproducts(@RequestBody Map<String,Object> map){
        System.out.println("addtourismproductsMap:"+map);
        return productService.addtourismproducts(map);
    }

    @RequestMapping("selectP_id")
    public Map<String,Object> selectP_id(@RequestBody String product_name){
        return productService.selectP_id(product_name);
    }

    @RequestMapping("addhotel")
    public int addhotel(@RequestBody Map<String,Object> map){
        return productService.addhotel(map);
    }

    @RequestMapping("selProCount")
    public int selProCount(@RequestBody Map<String,Object> map){
        System.out.println("selProCount Map:"+map);
        return productService.selProCount(map);
    }
}