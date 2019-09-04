package com.cssl.pojo;

import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
//2. chain 一个布尔值。如果为真，产生的setter返回的this而不是void。
// 默认是假。如果fluent=true，那么chain默认为真。
//新增注释
public class Dept {

    private Long deptno;
    private String dname;
    private String db;


    private int ss;

}
