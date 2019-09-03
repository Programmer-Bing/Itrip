package com.cssl.pojo.service;

import java.util.ArrayList;
import java.util.List;

import com.cssl.pojo.HomePage_product;
import org.springframework.stereotype.Component;

import com.cssl.pojo.Dept;

import feign.hystrix.FallbackFactory;

/*
 *  服务降级回调类
 */
@Component 
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{
	@Override
	public DeptClientService create(Throwable throwable){
		
		return new DeptClientService() {
			
			@Override
			public Dept get(long id){
				return new Dept().setDeptno(id).setDname("Consumer客户端提供的降级信息,此刻服务Provider已经关闭").setDb("no database");

			}

			@Override
			public List<HomePage_product> list(){
				return new ArrayList<>();
			}

			@Override
			public boolean add(Dept dept){
				return false;
			}
		};
	}
}
