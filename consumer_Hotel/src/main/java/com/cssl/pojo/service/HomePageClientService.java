package com.cssl.pojo.service;


import org.bouncycastle.cert.ocsp.Req;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value = "microservice-hotel",fallbackFactory = FeginFactory.class)
public interface HomePageClientService {

    @RequestMapping(value = "hotel")
    public List<Map> hotel(int id);

    @RequestMapping(value = "showInfo")
    public List<Map> showInfo(int id);

    @RequestMapping(value = "showlable")
    public List<Map> showlable(int id);

    @RequestMapping(value = "showpre")
    public List<Map> showpre(int id);

    @RequestMapping(value = "addCart")
    public boolean addCart(Map<String,Object> map);

}
