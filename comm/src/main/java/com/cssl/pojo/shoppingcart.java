package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class shoppingcart implements Serializable {
    Long sht_id;
    int Product_id;
    int user_id;
    double Original_price;
    double Settlement_price;
    Date Travel_date;
    Date Leavingshop_date;
    List<roomtype> rt;


}
