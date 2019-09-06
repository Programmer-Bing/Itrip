package com.cssl.pojo.service;

import com.cssl.pojo.HomePage_product;
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
    @RequestMapping(method = RequestMethod.GET,value="findPartyingByCity")
    public List<HomePage_product> findPartyingByCity( @RequestParam(required = false, value = "P_cid") Integer P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id);
}
