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

    /***
     * 根据用户查询订单
     * @param se
     * @return
     */
    @RequestMapping("/SelectOrder")
    public List<Orders> SelectOrder(HttpSession se, String pageno){
        System.out.println("来查询订单");
        User user =(User) se.getAttribute(se.getId());
        int user_id = user.getUser_id();
        System.out.println("用户:"+user_id);
       /* Page<Object> page= PageHelper.startPage(Integer.parseInt(pageno),1);
        List<Map<String, Object>> list = service.SelectPageUser(user_id);
        OrderPage pa=new OrderPage();
        pa.setList(list);
        pa.setPageNo(page.getPageNum());
        pa.setPageSize(page.getPageSize());
        pa.setTotalPage(page.getPages());*/

        /*pa.setTotalCount((int)page.getTotal());*/
        List<Orders> orders = service.SelectOrderNumb(user_id);
        System.out.println("订单长度: "+orders.size()+"总数:  ");

        return  orders;

    }


    /***
     *
     *
     * 查询订单商品
     */
    @RequestMapping("/SelectOrderProduct")
    public List<OrderXQ> SelectOrderProduct(String ordernum, HttpSession se){
        System.out.println("前台传过来的数据: "+ordernum);


        List<OrderXQ> orderXQS = service.SelectOrderProduct(ordernum);

        System.out.println("大小:  "+orderXQS.size());

        return  orderXQS;
    }


}
