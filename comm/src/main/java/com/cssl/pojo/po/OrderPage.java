package com.cssl.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPage<T> {

    private int  PageNo; //当前页码

    private int  PageSize; //页码数据量

    private int   totalCount;//总数据量

    private int totalPage;//总页数

    private List<T> list;
}
