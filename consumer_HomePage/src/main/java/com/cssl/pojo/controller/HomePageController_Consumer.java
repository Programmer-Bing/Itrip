package com.cssl.pojo.controller;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.service.HomePageClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomePageController_Consumer {
	
	@Autowired
	private HomePageClientService service;
/*,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE*/
	@RequestMapping(value = "/findBargains",method = RequestMethod.GET)
	public List<HomePage_product> findBargains(HttpSession session,@RequestParam(required = false,value = "lp_id") Integer lp_id){
		System.out.println("sessionId:"+session.getId());
		System.out.println("大区编号："+ lp_id);
		return this.service.findBargains(lp_id);
}
}
