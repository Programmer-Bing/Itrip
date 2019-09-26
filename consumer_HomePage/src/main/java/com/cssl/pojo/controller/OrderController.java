package com.cssl.pojo.controller;

import cn.hutool.db.sql.Order;
import com.cssl.pojo.po.OrderXQ;
import com.cssl.pojo.po.Orders;
import com.cssl.pojo.po.User;
import com.cssl.pojo.service.HomePageClientService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private HomePageClientService service;

}
