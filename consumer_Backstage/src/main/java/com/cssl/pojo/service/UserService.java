package com.cssl.pojo.service;

import com.cssl.pojo.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value="backstage-dept",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface UserService {

    @RequestMapping("findAll")
    public List<Map<String,Object>> findAll();
}
