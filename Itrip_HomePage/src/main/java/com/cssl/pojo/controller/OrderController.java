package com.cssl.pojo.controller;

import com.cssl.pojo.po.Orders;
import com.cssl.pojo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService os;

    /***
     *
     * 根据用户查询订单
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectUserID")
    public List<Orders> SelectUser(@RequestParam(value = "1") int id) {
        return os.SelectUser(id);
    }
}
