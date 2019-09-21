package com.cssl.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
//2. chain 一个布尔值。如果为真，产生的setter返回的this而不是void。
// 默认是假。如果fluent=true，那么chain默认为真。
public class ProductDetails {
    /*商品详情id*/
    Integer tp_id;
    /*商品详情标题*/
    String tp_name;
    /*商品详情游玩天数*/
    String Days_play;
    /*商品详情购买人数*/
    Integer purchases_Number;
    BigDecimal price;
    /*评论数*/
    Integer comments_Number;
    /*商品描述*/
    String describes;
    /*收藏数*/
    Integer Collectors_Number;
    /*游玩策略*/
    String Strategy;
    /*费用说明*/
    String Expensestatement;
    /*预定须知*/
    String ReservationNotes;
    /*itrip评分*/
    Integer itrip;
    /*商品ID*/
    Integer Product_id;
    /*图片描述*/
    String picture;
    String cd_includes;
    String cd_excluded;
    String cd_description;

    @Override
    public String toString() {
        return "ProductDetails{" +
                "tp_id=" + tp_id +
                ", tp_name='" + tp_name + '\'' +
                ", Days_play='" + Days_play + '\'' +
                ", purchases_Number=" + purchases_Number +
                ", price=" + price +
                ", comments_Number=" + comments_Number +
                ", describes='" + describes + '\'' +
                ", Collectors_Number=" + Collectors_Number +
                ", Strategy='" + Strategy + '\'' +
                ", Expensestatement='" + Expensestatement + '\'' +
                ", ReservationNotes='" + ReservationNotes + '\'' +
                ", itrip=" + itrip +
                ", Product_id=" + Product_id +
                ", picture='" + picture + '\'' +
                ", cd_includes='" + cd_includes + '\'' +
                ", cd_excluded='" + cd_excluded + '\'' +
                ", cd_description='" + cd_description + '\'' +
                '}';
    }
}
