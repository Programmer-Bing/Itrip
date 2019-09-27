package com.cssl.pojo;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptProvider8001_App {
	/**
	 * NONE:不记录任何信息，默认值
	 * BASIC:记录请求方法、请求 URL、状态码和用时
	 * HEADERS:在 BASIC 基础上再记录一些常用信息
	 * FULL:记录请求和相应的所有信息
	 * @return
	 */
	@Bean
	public Logger.Level getLogger(){
		return Logger.Level.DEBUG;
	}
	public static void main(String[] args)	{
		SpringApplication.run(DeptProvider8001_App.class, args);
	}
}
