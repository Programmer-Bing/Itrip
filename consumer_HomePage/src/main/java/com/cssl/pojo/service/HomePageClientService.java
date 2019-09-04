package com.cssl.pojo.service;

import com.cssl.pojo.HomePage_product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//当一个服务停止了，Consumer客户端提供降级信息
@FeignClient(value = "microservice-dept",fallbackFactory= HomePageClientServiceFallbackFactory.class)
public interface HomePageClientService {
	@GetMapping("/homeproduct/list")
	public List<HomePage_product> list();

}
