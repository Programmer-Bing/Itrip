package com.cssl.pojo.service;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//当一个服务停止了，Consumer客户端提供降级信息
//@FeignClient("MICROSERVICE-DEPT")
@FeignClient(value = "MICROSERVICE-DEPT",fallbackFactory= FeginFactory.class)
public interface HomePageClientService {
    @RequestMapping(method = RequestMethod.GET,value="findBargains")
    public List<HomePage_product> findBargains(@RequestParam("lp_id") Integer lp_id);


    @RequestMapping(method = RequestMethod.GET,value="/homeproduct/list2")
    public List<HomePage_product> list2(@RequestParam Map<String,Object> map);
    @RequestMapping(method = RequestMethod.GET,value="/homeproduct/cs")
    public  List<User> Cs();




    /***
     * 添加用户 注册
     * @param name
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/homeproduct/add")
    public int  addUser(@RequestParam(value = "空",required = true) String name);
}
