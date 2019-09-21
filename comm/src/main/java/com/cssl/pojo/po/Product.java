package com.cssl.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {



    private int Product_id; //产品ID

    private String Product_Name; //产品的名称

    private int Pt_id;

    private int P_cid;

    private String P_imgpath;  //产品图片

    private double price; //产品金额

    private String ProductNumber; //产品的编号
}
