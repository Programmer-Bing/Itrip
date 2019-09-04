package com.cssl.pojo.service;

import java.util.ArrayList;
import java.util.List;

import com.cssl.pojo.HomePage_product;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

/*
 *  服务降级回调类
 */
@Component 
public class HomePageClientServiceFallbackFactory implements FallbackFactory<HomePageClientService>{
	@Override
	public HomePageClientService create(Throwable throwable){
		
		return new HomePageClientService() {

			@Override
			public List<HomePage_product> list(){
				return new ArrayList<>();
			}


		};
	}
}
