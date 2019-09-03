package com.cssl.pojo;

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
public class HomePage_product {
    int product_id;
    String product_name;
    String product_imgPath;
    double product_price;

    @Override
    public String toString() {
        return "HomePage_product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_imgPath='" + product_imgPath + '\'' +
                ", product_price=" + product_price +
                '}';
    }
}
