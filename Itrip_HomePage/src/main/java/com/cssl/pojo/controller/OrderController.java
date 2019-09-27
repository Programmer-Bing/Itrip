package com.cssl.pojo.controller;

import com.cssl.pojo.po.OrderXQ;
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

    /***
     *
     * 查询商品和订单
     * @param userid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectOrderProdoct")
    public List<Orders> SelectOrderProdoct(@RequestParam(value = "1") int userid) {
        System.out.println("消费者根据用户查询订单");
        return os.SelectOrderProdoct(userid);


    }


    /****
     *
     * 订单查询
     * @param userid
     * @return
     */

    @RequestMapping(method = RequestMethod.GET,value = "/SelectOrderNumb")
    public List<Orders> SelectOrderNumb(@RequestParam(value = "1") int userid) {
        System.out.println("ss");
        return os.SelectOrderNumb(userid);


    }

    /***
     *
     * 根据编号订单查询产品
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectOrderXQ")
    public List<OrderXQ> SelectOrderProduct(@RequestParam(value = "ordernum") String ordernum) {
        return os.SelectOrderProduct(ordernum);
    }

    /****
     *
     *
     * 查询其他状态订单
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/SelectOrderObligation")
    public List<Orders> SelectOrderObligation(@RequestBody  Map<String, Object> map) {
        return os.SelectOrderObligation(map);
    }

    /****
     *
     *
     * 查询其他状态订单总数
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/SelectOrderObligationCount")
    public int SelectOrderObligationCount(@RequestBody  Map<String, Object> map) {
        return os.SelectOrderObligationCount(map);

    }
}
