package com.cssl.pojo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cssl.pojo.HomePage_product;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  服务降级回调类
 */
@Component 
public class FeginFactory implements FallbackFactory<HomePageClientService>{
	@Override
	public HomePageClientService create(Throwable throwable){
		
		return new HomePageClientService() {
			@Override
			public List<HomePage_product> findBargains(Integer id) {
				return new ArrayList<>();
			}
		};
	}
}
