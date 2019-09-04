package com.cssl.pojo.controller;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.service.HomePageClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class HomePageController_Consumer {
	
	@Autowired
	private HomePageClientService service;

	@RequestMapping(value = "/consumer/homeproduct/list")
	public List<HomePage_product> list(HttpSession session){
		System.out.println("sessionId:"+session.getId());
		return this.service.list();
	}
}
