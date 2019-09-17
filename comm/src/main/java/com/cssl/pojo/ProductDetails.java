package com.cssl.pojo;

import java.math.BigDecimal;

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
    public Integer getTp_id() {
        return tp_id;
    }

    public void setTp_id(Integer tp_id) {
        this.tp_id = tp_id;
    }

    public String getTp_name() {
        return tp_name;
    }

    public void setTp_name(String tp_name) {
        this.tp_name = tp_name;
    }

    public String getDays_play() {
        return Days_play;
    }

    public void setDays_play(String days_play) {
        Days_play = days_play;
    }

    public Integer getPurchases_Number() {
        return purchases_Number;
    }

    public void setPurchases_Number(Integer purchases_Number) {
        this.purchases_Number = purchases_Number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getComments_Number() {
        return comments_Number;
    }

    public void setComments_Number(Integer comments_Number) {
        this.comments_Number = comments_Number;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Integer getCollectors_Number() {
        return Collectors_Number;
    }

    public void setCollectors_Number(Integer collectors_Number) {
        Collectors_Number = collectors_Number;
    }

    public String getStrategy() {
        return Strategy;
    }

    public void setStrategy(String strategy) {
        Strategy = strategy;
    }

    public String getExpensestatement() {
        return Expensestatement;
    }

    public void setExpensestatement(String expensestatement) {
        Expensestatement = expensestatement;
    }

    public String getReservationNotes() {
        return ReservationNotes;
    }

    public void setReservationNotes(String reservationNotes) {
        ReservationNotes = reservationNotes;
    }

    public Integer getItrip() {
        return itrip;
    }

    public void setItrip(Integer itrip) {
        this.itrip = itrip;
    }

    public Integer getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(Integer product_id) {
        Product_id = product_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public ProductDetails() {
        super();
    }

    public ProductDetails(Integer tp_id, String tp_name, String days_play, Integer purchases_Number, BigDecimal price, Integer comments_Number, String describes, Integer collectors_Number, String strategy, String expensestatement, String reservationNotes, Integer itrip, Integer product_id, String picture) {
        this.tp_id = tp_id;
        this.tp_name = tp_name;
        Days_play = days_play;
        this.purchases_Number = purchases_Number;
        this.price = price;
        this.comments_Number = comments_Number;
        this.describes = describes;
        Collectors_Number = collectors_Number;
        Strategy = strategy;
        Expensestatement = expensestatement;
        ReservationNotes = reservationNotes;
        this.itrip = itrip;
        Product_id = product_id;
        this.picture = picture;
    }

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
                '}';
    }
}
