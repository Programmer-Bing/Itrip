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
@Accessors(chain = true)
//2. chain 一个布尔值。如果为真，产生的setter返回的this而不是void。
// 默认是假。如果fluent=true，那么chain默认为真。
public class Touristinfo {
    Integer ot_id;
    String name;
    String namepinyyin;
    String email;
    String vx;
    String tel;
    String sparetel;
    String order_id;

    @Override
    public String toString() {
        return "Touristinfo{" +
                "ot_id=" + ot_id +
                ", name='" + name + '\'' +
                ", namepinyyin='" + namepinyyin + '\'' +
                ", email='" + email + '\'' +
                ", vx='" + vx + '\'' +
                ", tel='" + tel + '\'' +
                ", sparetel='" + sparetel + '\'' +
                ", order_id='" + order_id + '\'' +
                '}';
    }
}
