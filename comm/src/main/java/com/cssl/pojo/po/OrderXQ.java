package com.cssl.pojo.po;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderXQ {


    private int oid; //订单详情id

    private  int orderid; //订单id

    private  int productid; //产品id

    private int productnumb; //产品数量

    private int userid; //用户id

    private Product pp;  //产品

    private Orders oo;  //订单

    private String traveltime; //出行时间


    private int state;//待处理
}
