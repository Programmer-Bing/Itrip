package com.cssl.pojo.service;

import com.cssl.pojo.po.OrderXQ;
import com.cssl.pojo.po.Orders;

import java.util.List;
import java.util.Map;

public interface OrderService {


    public List<Orders> SelectOrderFindAll(Map<String,Object> map);


    public List<OrderXQ>  SelectOrderProduct(String orderno);


    public int SelectOrderProductCount(int userid);


    public List<Orders>  SelectOrderObligation(Map<String,Object> map);


    public int SelectOrderObligationCount(Map<String,Object> map);


}
