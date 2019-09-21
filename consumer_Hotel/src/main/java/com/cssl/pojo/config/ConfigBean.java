package com.cssl.pojo.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigBean {

    @Bean
    public IRule getRule(){
        return new RoundRobinRule();
    }

}
