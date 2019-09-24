package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
//2. chain 一个布尔值。如果为真，产生的setter返回的this而不是void。
// 默认是假。如果fluent=true，那么chain默认为真。
public class Product_shopping {
    Integer psc_id;
    Integer p_id;
    Integer uid;
    String p_imgpath;
    String p_title;
    String Travel_date;
    String Product_specification; //产品规格
    Integer Adult_num;
    Integer children_num;
    Integer baby_num;
    BigDecimal Discount;
    BigDecimal Settlement_price; //结算价
    Date departure_date;
    List<roomtype> rt;

    @Override
    public String toString() {
        return "Product_shopping{" +
                "psc_id=" + psc_id +
                ", p_id=" + p_id +
                ", uid=" + uid +
                ", p_imgpath='" + p_imgpath + '\'' +
                ", p_title='" + p_title + '\'' +
                ", Travel_date='" + Travel_date + '\'' +
                ", Product_specification='" + Product_specification + '\'' +
                ", Adult_num=" + Adult_num +
                ", children_num=" + children_num +
                ", baby_num=" + baby_num +
                ", Discount=" + Discount +
                ", Settlement_price=" + Settlement_price +
                '}';
    }
}
