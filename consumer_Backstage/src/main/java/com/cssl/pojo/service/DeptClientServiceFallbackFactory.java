package com.cssl.pojo.service;

import com.cssl.pojo.po.Page;
import com.cssl.pojo.po.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
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
            public Page findAll(Map<String, Object> map) {
                return new Page();
            }

            @Override
            public List<Map<String, Object>> citiesstates() {
                return new ArrayList<>();
            }

            @Override
            public Page findProduct(Map<String, Object> map) {
                return new Page();
            }

            @Override
            public int productSize() {
                return 0;
            }

            @Override
            public int addProduct(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int addtourismproducts(Map<String, Object> map) {
                return 0;
            }

            @Override
            public Map<String, Object> selectP_id(String product_Name) {
                return new HashMap<>();
            }

            @Override
            public int addhotel(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int selProCount(Map<String, Object> map) {
                return 0;
            }
        };
    }
}
