package com.cssl.pojo.service;

import com.cssl.pojo.po.Page;
import com.cssl.pojo.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value="BACKSTAGE-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface UserService {

    @RequestMapping(method = RequestMethod.GET,value = "productType")
    public List<Map<String,Object>> productType();

    @RequestMapping("findAll")
    public Page findAll(Map<String,Object> map);

    @RequestMapping(method = RequestMethod.GET,value = "citiesstates")
    public List<Map<String,Object>> citiesstates();

    @RequestMapping("findProduct")
    public Page findProduct(Map<String,Object> map);

    @RequestMapping(method = RequestMethod.GET,value = "productSize")
    public int productSize();

    @RequestMapping("addProduct")
    public int addProduct(Map<String,Object> map);

    @RequestMapping("addtourismproducts")
    public int addtourismproducts(Map<String,Object> map);

    @RequestMapping("selectP_id")
    public Map<String,Object> selectP_id(String product_Name);

    @RequestMapping("addhotel")
    public int addhotel(Map<String,Object> map);

    @RequestMapping("selProCount")
    public int selProCount(Map<String,Object> map);
}
