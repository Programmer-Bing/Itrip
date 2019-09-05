package com.cssl.pojo.service;

import com.cssl.pojo.HomePage_product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//当一个服务停止了，Consumer客户端提供降级信息
//@FeignClient("MICROSERVICE-DEPT")
@FeignClient(value = "MICROSERVICE-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface HomePageClientService {
    @RequestMapping(method = RequestMethod.GET,value="/homeproduct/list")
	public List<HomePage_product> list();
    @RequestMapping(method = RequestMethod.GET,value="/homeproduct/list2")
    public List<HomePage_product> list2(@RequestParam Map<String,Object> map);

}
