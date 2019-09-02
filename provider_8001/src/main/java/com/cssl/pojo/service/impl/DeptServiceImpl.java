package com.cssl.pojo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cssl.pojo.Dept;
import com.cssl.pojo.dao.DeptDao;
import com.cssl.pojo.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptDao dao;
	
	@Override
	public boolean add(Dept dept){
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id){
		return dao.findById(id);
	}

	@Override
	public List<Dept> list(){
		return dao.findAll();
	}

}
