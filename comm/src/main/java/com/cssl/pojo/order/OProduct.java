package com.cssl.pojo.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
//2. chain 一个布尔值。如果为真，产生的setter返回的this而不是void。
// 默认是假。如果fluent=true，那么chain默认为真。
public class OProduct {
    Integer p_id;
    String p_img;
    String p_name;
    String Traveltime;
    String Startingtime;
    Integer p_state;
    String order_no;
    BigDecimal money;

    @Override
    public String toString() {
        return "OProduct{" +
                "p_id=" + p_id +
                ", p_img='" + p_img + '\'' +
                ", p_name='" + p_name + '\'' +
                ", Traveltime='" + Traveltime + '\'' +
                ", Startingtime='" + Startingtime + '\'' +
                ", p_state=" + p_state +
                ", order_no='" + order_no + '\'' +
                ", money=" + money +
                '}';
    }
}
