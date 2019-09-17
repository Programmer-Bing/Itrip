package com.cssl.pojo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.po.Orders;
import com.cssl.pojo.po.User;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  服务降级回调类
 */
@Component 
public class FeginFactory implements FallbackFactory<HomePageClientService>{
	@Override
	public HomePageClientService create(Throwable throwable){
		
		return new HomePageClientService() {
			@Override
			public List<HomePage_product> findBargains(Integer id) {
				return new ArrayList<>();
			}

			@Override
			public List<HomePage_product> findPartyingByCity(Integer P_cid, Integer Pt_id) {
				return null;
			}

			@Override
			public List<HomePage_product> list2(Map<String, Object> map) {
				return new ArrayList<>();
			}

			@Override
			public List<User> Cs() {
				return new ArrayList<>();
			}




			@Override
			public List<User> JudgeUser(String phone) {
				return new ArrayList<>();
			}


			@Override
			public int addUser(Map<String,Object> map) {
				return 0;
			}


			@Override
			public Map<String,Object> PhoneEmail(String phone) {
				return null;
			}

			@Override
			public int UpdatePhone(Map<String, Object> map) {
				return 0;
			}


			@Override
			public List<User> LoginPhone(Map<String, Object> map) {
				return null;
			}

			@Override
			public List<User> UserLoginEmail(Map<String, Object> map) {
				return null;
			}

			@Override
			public int UpdateUser(User uu) {
				return 0;
			}

			@Override
			public List<User> SelectUserName(String name) {
				return null;
			}

			@Override
			public int UpdatePhonePerson(Map<String, Object> map) {
				return 0;
			}

			@Override
			public int UpdatePassword(Map<String, Object> map) {
				return 0;
			}

			@Override
			public int UpdatePicture(Map<String, Object> map) {
				return 0;
			}


			@Override
			public List<Orders> SelectUser(int id) {
				return null;
			}
		};
	}
}
