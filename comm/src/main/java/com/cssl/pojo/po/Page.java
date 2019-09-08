package com.cssl.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Page<T> {

    private List<T> list; //当前页列表数据，数据库查询得到

    private int pageNumber; //当前页码，前端页面传递

    private int totalRecord; //总记录数，数据库查询得到

    private int pageSize; //每页显示条数，在Servlet中指定

    private int totalPage; //总页数，计算得到

    private int index; //当前页的起始索引，计算得到

    private String path; //用来设置Servlet访问路径及method参数

}
