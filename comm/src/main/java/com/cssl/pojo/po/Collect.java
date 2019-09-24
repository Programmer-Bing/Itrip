package com.cssl.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Collect {


    private int cid; //收藏id

    private int productid; //收藏产品id

    private int userid;  //用户id


    private Product pp;//产品

}
