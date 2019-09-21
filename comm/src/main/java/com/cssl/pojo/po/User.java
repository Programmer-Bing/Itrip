package com.cssl.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {


    private int user_id; //用户编号


    private String user_name;//用户姓名


    private String Chinese_Name; //用户中文姓名

    private  String English_Name;  //用户的英文姓名


    private String Gender; //用户的性别


    private String Birthday; //用户的生日


    private String Phone_number; //用户的电话


    private String email; //用户邮箱

    private String Account_number; //用户账号

    private String Password; //用户密码

    private  int Administration; //用户权限

    private  String  Column_13; //空字段


    private String Head_portrait;//用户的图片

}
