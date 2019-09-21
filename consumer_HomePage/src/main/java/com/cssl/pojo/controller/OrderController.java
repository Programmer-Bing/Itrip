package com.cssl.pojo.controller;

import com.cssl.pojo.service.HomePageClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private HomePageClientService service;


}
