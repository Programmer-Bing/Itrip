package com.cssl.pojo.controller;

import com.cssl.pojo.Dept;
import com.cssl.pojo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController{
	
	@Autowired
	private DeptService service;

	@PostMapping("/dept/add")
	public boolean add(@RequestBody Dept dept){
		System.out.println("8001 add:"+dept.getDname());
		dept.setDb("mydb");
		return service.add(dept);
	}

	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return service.get(id);
	}

	@GetMapping("/dept/list")
	public List<Dept> list(){
		System.out.println("8001");
		return service.list();
	}

	
}
