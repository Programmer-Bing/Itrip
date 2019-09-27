package com.cssl.pojo.po;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {


   private String order_no; //订单编号

   private String brontime; //订单提交时间

   private int state;//订单状态

   private double money;//订单总金额

   private int uid;//用户id

   private int psum;//订单商品总数

   private List<OrderXQ> orderproduct; //订单号下的产品






}
