package com.cssl.pojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//在调用微服务的时候就能去加载我们的自定义Ribbon负载策略类
//@RibbonClient(name="microservice-dept",configuration= MyRule.class)
//消费者--暂时理解为客户端
public class DeptConsumer80_App {
	public static void main(String[] args) {

		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
