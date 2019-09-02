package com.cssl.rule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

/*
 * 该类@Configuration这个注解是不能被@ComponetScan扫描到
 * https://segmentfault.com/a/1190000011159573
 */
@Configuration
public class MyRule {
	
	@Bean
	public IRule getMyRule() {		
		return new MyRandom();
	}

}
