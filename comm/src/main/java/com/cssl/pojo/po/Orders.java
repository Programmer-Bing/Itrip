package com.cssl.pojo.po;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {


    private int order_id; //订单编号


    private String Submission_time;//订单提交时间

    private String stt_id;//订单支付状态

    private Integer user_id;//用户ID

    private double summoney;//产品总价格

    private Integer Product_num;//商品数量

    private double accountpaid;//已付款

    private String orderNumber;//订单编号


    private int productnumb;//总数





}
