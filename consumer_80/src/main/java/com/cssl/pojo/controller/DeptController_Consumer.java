package com.cssl.pojo.controller;

import com.cssl.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {
	
	/**
	 * 使用restTemplate访问restful接口非常简单 (url, requestMap,ResponseBean.class)
	 * 这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	public DeptController_Consumer() {
		System.out.println("无参构造:");
	}
 
	//private static final String REST_URL_PREFIX = "http://127.0.0.1:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICE-DEPT";
	//private static final String REST_URL_PREFIX = "http://MICROSERVICE-ZUUL-GATEWAY/microservice-dept";
	

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept){
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	} 
	
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list()	{
		System.out.println("restTemplate:"+restTemplate);
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

}
