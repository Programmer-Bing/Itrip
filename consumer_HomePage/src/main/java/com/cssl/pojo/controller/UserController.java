package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.service.HomePageClientService;
import com.cssl.pojo.util.DunXing;
import com.cssl.pojo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
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

    /***
     * 判断号码和邮箱
     * @return
     */
    @RequestMapping(value = "/Determinethenumber")
    public List<User> SelectPhoneEmail(@RequestParam  String phone){
        System.out.println("来了判断号码");
        List<User> list = service.JudgeUser(phone);
        System.out.println(list.size());
        return  list;
    }


    @RequestMapping(value = "/PhoneEmailUser")
    public Map<String,Object> PhoneEmail(String phone){
        System.out.println("来了拿邮箱:"+service.PhoneEmail(phone).get("email"));

        return service.PhoneEmail(phone);
    }

    /***
     *
     *
     * 修改密码
     * @param pwd
     * @param rePwd
     * @param phone
     * @return
     */
    @RequestMapping(value = "/UpdatePwd")
    public  int UpdatePhone(String pwd,String rePwd,String phone){
        System.out.println("来了修改密码");
        if(pwd.equals(rePwd)){
            System.out.println("两次密码输入一致");
            HashMap<String,Object> map=new HashMap();
            map.put("phone",phone);
            map.put("pwd",pwd);
            return  service.UpdatePhone(map);

        }
        else{
            System.out.println("密码输入不一致");
            return  0;
        }

    }


    /***
     *
     * 手机密码登录
     * @param phone
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/loginUser")
    public int loginUser(String phone,String pwd,HttpSession se){
        System.out.println("来了登录");
        //md5对密码加密
        /*String password = DigestUtils.md5DigestAsHex(pwd.getBytes());
        System.out.println("加密后的密码:"+password);*/
        Map<String,Object> map=new HashMap<>();
        map.put("phone",phone);
        map.put("password",pwd);
        List<User> list = service.LoginPhone(map);

        if(list.size()>0){
            User user=list.get(0);
            System.out.println("中文名字: "+user.getChinese_Name());
            se.setAttribute(se.getId(),user);
            System.out.println("sessionid: "+se.getId());
            User uu = (User) se.getAttribute(se.getId());
            System.out.println("redis取出来的数据: "+uu.getChinese_Name());
            int administration = list.get(0).getAdministration();
            if(administration==1){
                return  1;
            }
            else{
                return  2;
            }

        }
        else{
            System.out.println("密码输入错误");
            return 0;
        }

    }

    /***
     *
     * 邮箱登录
     * @return
     */
    @RequestMapping("/loginEmail")
    public int UserLoginEmail(String email,String password,HttpSession se){

        System.out.println("来了邮箱登录: "+email+"邮箱密码: "+password);
        Map<String,Object>  map=new HashMap<>();
        map.put("email",email);
        map.put("password",password);
        List<User> list = service.UserLoginEmail(map);
        if(list.size()>0){
            User user=list.get(0);
            System.out.println("邮箱登录成功");
            se.setAttribute(se.getId(),user);
            int administration = list.get(0).getAdministration();
            if(administration==1){
                return 1;
            }
            else{
                return 2;
            }
        }
        else{
            System.out.println("邮箱登录失败");
            return 0;
        }


    }



}
