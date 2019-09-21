package com.cssl.pojo.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//服务降级回掉类
@Component
public class FeginFactory implements FallbackFactory {

    @Override
    public Object create(Throwable cause) {
        return new HomePageClientService() {
            @Override
            public List<Map> hotel(int id) {
                return new ArrayList<>();
            }

            @Override
            public List<Map> showInfo(int id) {
                return new ArrayList<>();
            }

            @Override
            public List<Map> showlable(int id) {
                return new ArrayList<>();
            }

            @Override
            public List<Map> showpre(int id) {
                return new ArrayList<>();
            }

            @Override
            public boolean addCart(Map<String, Object> map) {
                return false;
            }
        };

    }
}
