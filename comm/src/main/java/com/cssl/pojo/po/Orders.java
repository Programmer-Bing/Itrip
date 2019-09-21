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

    private String stt_id;//订单状态

    private int user_id;//用户ID

    private double Amount_money;//商品价格

    private int Product_num;//商品数量

    private int Column_7;//多余字段


}
