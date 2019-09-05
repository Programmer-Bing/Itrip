package com.cssl.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User {


    private int userid; //用户编号


    private String username;//用户姓名


    private String ChineseName; //用户中文姓名

    private  String EnglishName;  //用户的英文姓名


    private String Gender; //用户的性别


    private Date Birthday; //用户的生日


    private String Phonenumber; //用户的电话


    private String email; //用户邮箱

    private String Accountnumber; //用户账号

    private String Password; //用户密码

    private  int Administration; //用户权限

    private  String  Column_13; //空字段


    private String Head_portrait;//用户的图片

}
