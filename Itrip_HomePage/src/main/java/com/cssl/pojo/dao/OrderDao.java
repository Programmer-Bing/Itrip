package com.cssl.pojo.dao;

import com.cssl.pojo.po.Orders;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface OrderDao {

    /***
     *
     * 查询订单用户
     * @param id
     * @return
     */
      public List<Orders> SelectUser(int id);
}
