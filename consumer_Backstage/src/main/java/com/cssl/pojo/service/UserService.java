package com.cssl.pojo.service;

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
    public List<Map<String,Object>> findAll(Map<String,Object> map);
    @RequestMapping(method = RequestMethod.GET,value = "citiesstates")
    public List<Map<String,Object>> citiesstates();
    @RequestMapping(method = RequestMethod.GET,value = "findProduct")
    public List<Map<String,Object>> findProduct(Map<String,Object> map);
    @RequestMapping(method = RequestMethod.GET,value = "productSize")
    public int productSize();
}
