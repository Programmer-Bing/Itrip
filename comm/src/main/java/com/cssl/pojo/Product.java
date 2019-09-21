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
public class Product {

    int Product_id;
    String product_name;
    int pt_id;
    int P_cid;
    String img;
    double P_price;


}
