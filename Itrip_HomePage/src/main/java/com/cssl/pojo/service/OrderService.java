package com.cssl.pojo.service;

import com.cssl.pojo.po.OrderXQ;
import com.cssl.pojo.po.Orders;

import java.util.List;

public interface OrderService {


    public List<Orders> SelectUser(int id);

    public List<Orders> SelectOrderProdoct(int userid);

    public List<Orders> SelectOrderNumb(int userid);



    public List<OrderXQ> SelectOrderProduct(String ordernum);


    public List<Orders>  SelectOrderObligation(Map<String,Object> map);


    public int SelectOrderObligationCount(Map<String,Object> map);


}
