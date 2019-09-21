package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class hotal implements Serializable {

    int h_id;
    String h_name;
    Product product;
    int purchases_Number;
    int Star_class;
    citiesstates citiesstate;
    String describes;
    String Specific_address;
    String picturel1;
    String picturel2;
    String picturel3;
    String picturel4;
    String picturel5;

}
