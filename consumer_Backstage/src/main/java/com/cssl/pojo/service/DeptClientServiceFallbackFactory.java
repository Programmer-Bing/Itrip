package com.cssl.pojo.service;

import com.cssl.pojo.po.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public List<User> findAll() {
                System.out.println("查询失败了");
                return new ArrayList<>();
            }
        };
    }
}
