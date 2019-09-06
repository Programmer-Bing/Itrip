package com.cssl.pojo.service;

import com.cssl.pojo.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="backstage-dept",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface UserService {

    @RequestMapping(method = RequestMethod.GET,value = "findALL")
    public List<User> findAll();
}
