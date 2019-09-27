package com.cssl.pojo.controller;

import cn.hutool.db.sql.Order;
import com.cssl.pojo.po.OrderPage;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private HomePageClientService service;




    /***
     *
     * 查询全部订单
     * @return
     */
    @RequestMapping("/SelectFindAll")
    public OrderPage SelectFindAll(HttpSession se,String pageno){

        User user=(User) se.getAttribute(se.getId());
        if(user!=null){
            Map<String,Object> map=new HashMap<>();
            map.put("userid",user.getUser_id());
            int pagesize=2;
            map.put("state",(Integer.parseInt(pageno)-1)*pagesize);
            map.put("pagesize",pagesize);
            List<Orders> list = service.SelectOrderFindAll(map);
            System.out.println("订单总数: "+list.size());
            for (int i = 0; i <list.size() ; i++) {
                String orderno=list.get(i).getOrder_no();
                List<OrderXQ> orderXQS = service.SelectOrderProductUser(orderno);
                System.out.println("查询到的产品:  "+orderXQS.size());
                list.get(i).setOrderproduct(orderXQS);




            }
            int totalcount=service.SelectOrderProductCount(user.getUser_id());//总数据量

            int totalPage=totalcount%pagesize==0?totalcount/pagesize:totalcount/pagesize+1;//总页数
            OrderPage page=new OrderPage();

            page.setTotalCount(totalcount);
            page.setPageSize(pagesize);
            page.setPageNo(Integer.parseInt(pageno));
            page.setList(list);
            page.setTotalPage(totalPage);

            System.out.println("外面获取到的产品 分页总数据量: "+page.getTotalCount());

            return  page;

        }

        return  null;
    }

}
