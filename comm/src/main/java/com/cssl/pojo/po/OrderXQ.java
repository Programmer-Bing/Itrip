package com.cssl.pojo.po;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderXQ {

        private  int p_id;//产品编号

        private String p_img; //产品图片

        private  String p_name;//产品名字

        private String Traveltime;//产品出行时间

        private  String Startingtime;//保险时间

        private String p_state;//产品状态

        private String order_no;//订单号

        private double money;//价格




}
