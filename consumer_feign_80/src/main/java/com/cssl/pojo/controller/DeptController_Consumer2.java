package com.cssl.pojo.controller;

import com.cssl.pojo.Dept;
import com.cssl.pojo.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DeptController_Consumer2 {
	
	@Autowired
	private DeptClientService service;

	@RequestMapping(value = "/list")
	public String list(Model model){
		System.out.println("/list");
		List<Dept> list = service.list();
		System.out.println("list:"+list);
		model.addAttribute("list",list);
		model.addAttribute("user","admin");
		//return "forward:/success.html";
		return "success";
	}


}
