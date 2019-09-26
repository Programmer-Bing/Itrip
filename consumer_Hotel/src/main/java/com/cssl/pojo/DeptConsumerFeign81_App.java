package com.cssl.pojo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DeptConsumerFeign81_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign81_App.class,args);
    }

}
