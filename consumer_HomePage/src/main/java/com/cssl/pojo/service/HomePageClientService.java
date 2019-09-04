package com.cssl.pojo.service;

import com.cssl.pojo.HomePage_product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient("MICROSERVICE-DEPT")
//当一个服务停止了，Consumer客户端提供降级信息
@FeignClient(value = "microservice-dept",fallbackFactory= HomePageClientServiceFallbackFactory.class)
//通过网关服务访问
//@FeignClient(value = "microservice-zuul-gateway",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface HomePageClientService {
	@GetMapping("/dept/list")
	//网关取的服务别名mydept
	//@GetMapping("/cssl/mydept/dept/list")
	public List<HomePage_product> list();

}
