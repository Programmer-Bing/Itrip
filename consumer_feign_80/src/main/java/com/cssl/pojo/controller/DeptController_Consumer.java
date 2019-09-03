package com.cssl.pojo.controller;

import com.cssl.pojo.Dept;
import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService service;

	@RequestMapping(value = "/consumer/dept/list")
	public List<HomePage_product> list(HttpSession session){
		System.out.println("sessionId:"+session.getId());
		return this.service.list();
	}
}
