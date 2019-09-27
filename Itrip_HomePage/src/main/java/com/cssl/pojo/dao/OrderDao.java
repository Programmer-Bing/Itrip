package com.cssl.pojo.dao;

import com.cssl.pojo.po.OrderXQ;
import com.cssl.pojo.po.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderDao {

    /***
     *
     * 查询全部的订单
     * @return
     */
    public List<Orders> SelectOrderFindAll(Map<String,Object> map);


    /***
     *
     *
     * 查询订单下面的产品
     */
    public List<OrderXQ>  SelectOrderProduct(String orderno);


    /****
     *
     *
     * 查询订单下面的产品总数
     */
    public int SelectOrderProductCount(int userid);


    /***
     *
     *
     * 查询 其它状态的订单
     * @param map
     * @return
     */
    public List<Orders>  SelectOrderObligation(Map<String,Object> map);


    /***
     *
     *
     * 查询其它状态的订单总数
     */
    public int SelectOrderObligationCount(Map<String,Object> map);
}