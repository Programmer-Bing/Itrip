package com.cssl.pojo.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
//2. chain 一个布尔值。如果为真，产生的setter返回的this而不是void。
// 默认是假。如果fluent=true，那么chain默认为真。
public class Order {
    String order_no;
    String brontime;
    int state;
    int money;
    int uid;

    @Override
    public String toString() {
        return "OProduct{" +
                "order_no='" + order_no + '\'' +
                ", brontime='" + brontime + '\'' +
                ", state=" + state +
                ", money=" + money +
                ", uid=" + uid +
                '}';
    }
}
