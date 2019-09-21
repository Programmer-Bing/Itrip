package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class shoppingcart {
    double sht_id;
    int Product_id;
    int user_id;
    double Original_price;
    double Settlement_price;
    String Travle_date;
    String Leavingshop_date;
    int sm_id;
    int Adult_num;
    int children_num;
    int baby_num;
    int Passenger_num;
    String room;

}
