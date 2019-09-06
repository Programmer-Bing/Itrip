package com.cssl.pojo.service;

import com.cssl.pojo.po.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public List<Map<String, Object>> productType() {
                System.out.println("失败了");
                return new ArrayList<>();
            }

            @Override
            public List<Map<String,Object>> findAll() {
                System.out.println("查询失败了");
                return new ArrayList<>();
            }
        };
    }
}
