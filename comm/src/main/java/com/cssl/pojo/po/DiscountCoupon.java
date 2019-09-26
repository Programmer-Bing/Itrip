package com.cssl.pojo.po;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DiscountCoupon {

    private  int did; //优惠券id

    private int userid;//用户id

    private Integer dprice;//优惠券金额

    private String dstatetime;//用户开始时间

    private Integer meet;//满足金额

    private  String  dmrtime;//到期时间

    private String dname; //优惠卷名称

    private int dstate;//优惠卷状态
}
