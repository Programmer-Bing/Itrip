package com.cssl.pojo.po;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 *
 *
 * 浏览记录
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BrowsingHistory {

      private int bid; //浏览记录id

      private String btime; //浏览记录时间

      private int productid;//浏览记录产品


      private int userid;//用户id

      private Product pp;//产品
}
