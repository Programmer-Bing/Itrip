package com.cssl.pojo.dao;

import com.cssl.pojo.po.OrderXQ;
import com.cssl.pojo.po.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderDao {

    /***
     *
     * 查询订单用户
     * @param id
     * @return
     */
      public List<Orders> SelectUser(int id);

    /***
     *
     *
     * 订单加产品
     * @param userid
     * @return
     */
    public List<Orders> SelectOrderProdoct(int userid);




    /***
     *
     * 查询订单编号
     * @return
     */
    public List<Orders> SelectOrderNumb(int userid);

    /***
     *
     *
     * @param ordernum
     * @return
     */
    public List<OrderXQ> SelectOrderProduct(String ordernum);



}
