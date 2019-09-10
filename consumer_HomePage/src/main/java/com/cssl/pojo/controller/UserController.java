package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.service.HomePageClientService;
import com.cssl.pojo.util.DunXing;
import com.cssl.pojo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private HomePageClientService service;

    private  RedisUtil ru=new RedisUtil();

    @RequestMapping(value = "/consumer/homeproduct/cs")
    public List<User> Cs(HttpSession session){
        System.out.println("测试类");
        return this.service.Cs();
    }



    @RequestMapping(value ="/usercode")
    public String Usercode(@RequestParam String phone) throws Exception{
        System.out.println("手机号码: "+phone);
        DunXing dd=new DunXing();


        //int dx = dd.DX(phone);

        String dx="123456";
        ru.SetKey("code",dx);
        System.out.println("短信验证码"+dx);


        return "0";

    }



    @RequestMapping(value = "/UserRegistration")
    public List<User> JudgeUser(@RequestParam String phone){
        System.out.println("注册判断: "+phone);
        System.out.println("长度: "+service.JudgeUser(phone).size());
        return  service.JudgeUser(phone);
    }

    /***
     *
     * 注册 判断验证码 跳转
     * @param phone
     * @param code
     * @return
     */
    @RequestMapping(value = "/addUser")
    public int addUser(@RequestParam String phone,@RequestParam String code){
        System.out.println("添加:");
        String coderedis = ru.getKey("code");
        System.out.println("redis取出来的验证码: "+coderedis);
        if(code.equals(coderedis)){
            System.out.println("验证码输入正确");
            return 1;
        }
        else{
            System.out.println("验证码输入错误");
            return  0;
        }


    }

    /***
     *
     *用户注册添加
     * @return
     */
    @RequestMapping(value = "/UserAddZc")
    public int UertAdd(@RequestParam String phone,@RequestParam String username,@RequestParam String rePhonePwd,@RequestParam String password){
        System.out.println("前台注册添加");
        System.out.println("mm1: "+password);
        System.out.println("mm2: "+rePhonePwd);
        if(password.equals(rePhonePwd)){
            System.out.println("密码输入一致");
            HashMap<String,Object> map=new HashMap<String, Object>();
            map.put("phone",phone);
            map.put("password",password);
            map.put("username",username);
            map.put("account",phone);
            return  service.addUser(map);

        }
        else{
            System.out.println("密码输入不一致");
            return 0;
        }


    }






}
