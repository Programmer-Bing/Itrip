package com.cssl.pojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
//开启Feign支持
@EnableFeignClients
public class DeptConsumerFeign80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerFeign80_App.class, args);
	}
}
