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

    @RequestMapping(method = RequestMethod.GET,value = "citiesstatesLs")
    public List<Map<String,Object>> citiesstatesLs();

    @RequestMapping("findProduct")
    public Page findProduct(Map<String,Object> map);

    @RequestMapping(method = RequestMethod.GET,value = "productSize")
    public int productSize();

    @RequestMapping("addProduct")
    public int addProduct(Map<String,Object> map);

    @RequestMapping("addUser")
    public int addUser(Map<String,Object> map);

    @RequestMapping("delproduct")
    public int delproduct(Map<String,Object> map);

    @RequestMapping("deluser")
    public int deluser(int u_id);

    @RequestMapping("whereuid")
    public Map<String,Object> whereuid(int uid);

    @RequestMapping("modUser")
    public int modUser(Map<String,Object> map);

    @RequestMapping("Finlargeplate")
    public List<Map<String,Object>> Finlargeplate();

    @RequestMapping("smallplate")
    public List<Map<String,Object>> smallplate(int lp_id);

    @RequestMapping("pageCitiesstates")
    public Page pageCitiesstates(Map<String,Object> map);

    @RequestMapping("citiesstatesIsNUll")
    public List<Map<String,Object>> citiesstates(Map<String,Object> map);

    @RequestMapping("addCitiesstates")
    public int addCitiesstates(Map<String,Object> map);

    @RequestMapping("selCitiesstatesID")
    public List<Map<String,Object>> selCitiesstatesID(int cs_id);

    @RequestMapping("tourismproductsP_id")
    public Map<String,Object> tourismproductsP_id(int p_id);

    @RequestMapping("setCitiesstates")
    public int setCitiesstates(Map<String,Object> map);

    @RequestMapping("delCitiesstates")
    public int delCitiesstates(int cs_id);

    @RequestMapping("productP_id")
    public Map<String,Object> productP_id(int p_id);

    @RequestMapping("cost_descriptionC_id")
    public Map<String,Object> cost_descriptionC_id(int cd_id);

    @RequestMapping("hotelP_id")
    public Map<String,Object> hotelP_id(int p_id);

    @RequestMapping("setProduct")
    public int setProduct(Map<String,Object> map);

    @RequestMapping("roominformation")
    public Page roominformation(Map<String,Object> map);

    @RequestMapping("hotel")
    public List<Map<String,Object>> hotel();

    @RequestMapping("addroom")
    public int addroom(Map<String,Object> map);

    @RequestMapping("selsetRoom")
    public Map<String,Object> selsetRoom(int id);

    @RequestMapping("setRoom")
    public int setRoom(Map<String,Object> map);

    @RequestMapping("delRoom")
    public int delRoom(int id);

    @RequestMapping("selUserAdmin")
    public Map<String,Object> selUserAdmin(Map<String,Object> map);

    @RequestMapping("order_no")
    public Page order_no(Map<String,Object> map);

    @RequestMapping("delOrder")
    public int delOrder(String no);

    @RequestMapping("userIsTwo")
    public List<Map<String,Object>> userIsTwo();

    @RequestMapping("setState")
    public int setState(Map<String,Object> map);

    @RequestMapping("setProState")
    public int setProState(Map<String,Object> map);

    @RequestMapping("setblock")
    public int setblock(Map<String,Object> map);

}