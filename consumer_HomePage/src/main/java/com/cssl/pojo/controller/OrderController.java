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
import org.springframework.web.bind.annotation.ResponseBody;
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
    public OrderPage SelectFindAll(HttpSession se, String pageno) {

        User user = (User) se.getAttribute(se.getId());
        if (user != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("userid", user.getUser_id());
            int pagesize = 2;
            map.put("state", (Integer.parseInt(pageno) - 1) * pagesize);
            map.put("pagesize", pagesize);
            List<Orders> list = service.SelectOrderFindAll(map);

            for (int i = 0; i < list.size(); i++) {
                String orderno = list.get(i).getOrder_no();
                List<OrderXQ> orderXQS = service.SelectOrderProductUser(orderno);

                list.get(i).setOrderproduct(orderXQS);


            }
            int totalcount = service.SelectOrderProductCount(user.getUser_id());//总数据量

            int totalPage = totalcount % pagesize == 0 ? totalcount / pagesize : totalcount / pagesize + 1;//总页数
            OrderPage page = new OrderPage();

            page.setTotalCount(totalcount);
            page.setPageSize(pagesize);
            page.setPageNo(Integer.parseInt(pageno));
            page.setList(list);
            page.setTotalPage(totalPage);


            return page;

        }

        return null;
    }

    /***
     *
     * 查询其它状态的订单
     * @param se
     * @param pageno
     * @param state
     * @return
     */
    @RequestMapping("/SelectOrderObligation")
    public OrderPage SelectOrderObligation(HttpSession se, String pageno, String state) {

        User user = (User) se.getAttribute(se.getId());
        System.out.println("外面获取到的产品: "+pageno);
        if (user != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("userid",user.getUser_id());
            map.put("ks",state);
            int pagesize=2;
            map.put("pageno",(Integer.parseInt(pageno)-1)*pagesize);
            map.put("pagesize",pagesize);
            List<Orders> orders = service.SelectOrderObligation(map);
            System.out.println("查询其它状态的订单: 大小"+orders.size());
            for (int i = 0; i < orders.size(); i++) {
                String orderno = orders.get(i).getOrder_no();
                List<OrderXQ> orderXQS = service.SelectOrderProductUser(orderno);
                System.out.println("查询其它状态的订单:  " + orderXQS.size());
                orders.get(i).setOrderproduct(orderXQS);
            }
            Map<String,Object> map1=new HashMap<>();
            map1.put("uid",user.getUser_id());
            map1.put("state",state);
            int totalcount = service.SelectOrderObligationCount(map1);//总数据量
            System.out.println("外面获取到的产品 总数居量: "+totalcount);
            int totalPage = totalcount % pagesize == 0 ? totalcount / pagesize : totalcount / pagesize + 1;//总页数

            OrderPage page = new OrderPage();
            page.setList(orders);
            page.setPageSize(pagesize);
            page.setTotalPage(totalPage);
            page.setTotalCount(totalcount);
            page.setPageNo(Integer.parseInt(pageno));


            System.out.println("外面获取到的产品 分页总数据量: " + page.getTotalCount());


            return  page;

        }
        return null;
    }

    /***
     *
     *
     * 显示其它状态的总数量
     * @return
     */
    @RequestMapping("/ShowStateOrder")
    @ResponseBody
    public List<Integer> ShowStateOrder(HttpSession se){
        User user = (User)se.getAttribute(se.getId());
        Map<String,Object> map=new HashMap<>();
        map.put("uid",user.getUser_id());
        map.put("state",1);
        int dfk = service.SelectOrderObligationCount(map);//待付款
        List<Integer> list=new ArrayList<>();
        list.add(dfk);
        Map<String,Object> map1=new HashMap<>();
        map1.put("uid",user.getUser_id());
        map1.put("state",2);
        int dcx = service.SelectOrderObligationCount(map1);//待出行
        list.add(dcx);
        Map<String,Object> map2=new HashMap<>();
        map2.put("uid",user.getUser_id());
        map2.put("state",3);
        int dpl = service.SelectOrderObligationCount(map2);//待出行
        list.add(dpl);
        return  list;
    }

    /***
     *
     *单独显示总数据量
     * @return
     */
    @RequestMapping("/ShowOrderSum")
    public int ShowOrderSum(HttpSession se){
        User user = (User)se.getAttribute(se.getId());
        System.out.println("单独显示总数据量:  "+ service.SelectOrderProductCount(user.getUser_id()));
        return  service.SelectOrderProductCount(user.getUser_id());
    }


}