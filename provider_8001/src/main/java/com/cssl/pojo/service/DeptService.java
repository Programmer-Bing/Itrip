package com.cssl.pojo.service;

import java.util.List;

import com.cssl.pojo.Dept;

public interface DeptService{
	
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
