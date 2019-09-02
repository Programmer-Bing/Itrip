package com.cssl.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 *   自定义负载均衡策略
 *
 *
 */
public class MyRandom extends AbstractLoadBalancerRule {
		
	public Server choose(ILoadBalancer lb, Object key)	{	
			
		return null;
	}

	@Override
	public Server choose(Object key){
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig){
		
	}

}