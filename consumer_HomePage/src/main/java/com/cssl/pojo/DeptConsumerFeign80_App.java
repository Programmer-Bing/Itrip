package com.cssl.pojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.RedisFlushMode;

@SpringBootApplication
@EnableEurekaClient()
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3000,redisFlushMode = RedisFlushMode.IMMEDIATE)
//开启Feign支持
@EnableFeignClients
/*@ServletComponentScan("com.cssl.pojo.filter")//过滤器*/
public class DeptConsumerFeign80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerFeign80_App.class, args);
	}
}
