package com.cssl.pojo.controller;

import com.cssl.pojo.po.OrderXQ;
import com.cssl.pojo.po.Orders;
import com.cssl.pojo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService os;


    /***
     *
     *
     * 订单的全部查询
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/SelectOrderFindAll")
    public List<Orders> SelectOrderFindAll(@RequestBody  Map<String,Object> map) {
        return os.SelectOrderFindAll(map);

    }

    /***
     *
     *
     * 根据订单查询产品
     * @param orderno
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectOrderProductUser")
    public List<OrderXQ> SelectOrderProductUser(@RequestParam(value = "1") String orderno) {
        return os.SelectOrderProduct(orderno);
    }


    /***
     *
     *
     * 根据订单查询产品总数
     * @param userid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectOrderProductCount")
    public int SelectOrderProductCount(@RequestParam(value = "1") int userid) {
        return os.SelectOrderProductCount(userid);
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
