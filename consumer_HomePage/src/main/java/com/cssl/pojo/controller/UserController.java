package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.service.HomePageClientService;
import com.cssl.pojo.util.DunXing;
import com.cssl.pojo.util.RedisUtil;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String Usercode(@RequestParam String phone,HttpSession se) throws Exception{
        System.out.println("手机号码: "+phone);
        DunXing dd=new DunXing();


        //int dx = dd.DX(phone);

        String dx="123456";
        ru.SetKey(phone,dx);
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
        String coderedis = ru.getKey(phone);
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


    /***
     * 邮箱
     * @param phone
     * @return
     */

    @RequestMapping(value = "/PhoneEmailUser")
    public Map<String,Object> PhoneEmail(String phone){
        System.out.println("来了拿邮箱:"+service.PhoneEmail(phone).get("email"));

        return service.PhoneEmail(phone);
    }

    /****
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
        System.out.println("长度:  "+list.size());
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

    /****
     *
     * 主页面显示
     * @param se
     * @return
     */
    @RequestMapping("/GetSession")
    public User GetSession(HttpSession se){
        System.out.println("来了查询sessionid");
        System.out.println("sessionID: "+se.getId());
        User user =(User) se.getAttribute(se.getId());
        if(user!=null){
            System.out.println("用户姓名: "+user.getChinese_Name());
            return  user;
        }
        else{
            return  null;
        }


    }


    /***
     *
     * 退出登录
     */
    @RequestMapping(value = "/logout")
    public int LogOut(HttpSession se){

        se.invalidate();
        return  0;

    }



    /****
     *
     *
     * 个人中心个人信息展示
     */
    @RequestMapping("/PersonCenterSelect")
    public User PersonCenterSelect(HttpSession se) throws  Exception{

        User user =(User)se.getAttribute(se.getId());

        if(user!=null){
            System.out.println("拿到数据: 生日:"+user.getBirthday());
        }


        return  user;
    }

    /***
     *
     * 个人修改用户数据
     * @param
     * @return
     */
    @RequestMapping("/UpdateUser")
    public User UpdateUser(String nameZh,String givenNameEn,String familyNameEn,String nickName,int sex,String birthDay,HttpSession se){
        String EnglishName=givenNameEn+" "+familyNameEn;
        System.out.println("来了修改用户信息:  "+sex);
        User uu=new User();
        uu.setBirthday(birthDay);
        uu.setChinese_Name(nameZh);
        uu.setEnglish_Name(EnglishName);
        uu.setUser_name(nickName);

        if(sex==0){
            uu.setGender("男");
        }
        else if(sex==1){
            uu.setGender("女");
        }
        User user =(User) se.getAttribute(se.getId());
        uu.setPhone_number(user.getPhone_number());
        service.UpdateUser(uu);
        return  uu;
    }


    /**
     *
     * 个人中心个人信息显示信息
     */
    @RequestMapping("/SelectUser")
    public List<User> SelectUser(HttpSession se){

        User user = (User) se.getAttribute(se.getId());
        String phone=user.getPhone_number();
        List<User> list = service.JudgeUser(phone);

        return  list;
    }


    /***
     *
     * 账号与密码手机号显示
     */
    @RequestMapping("/xsphone")
    public User ShowPersonxx(HttpSession se){
        System.out.println("显示账号密码: "+se.getId());

        User user =(User) se.getAttribute(se.getId());

        String phone = ru.getKey(user.getUser_name());
        if(phone==null){
            return  user;
        }
        else{
            User uu=new User();
            uu.setPhone_number(phone);
            return  uu;
        }

    }

    /***
     *
     * 个人中心修改手机号
     * @return
     */
    @RequestMapping("/UpdatePhone")
    public int  UpdatePhonexx(String phone,String smsCode,String ophone,HttpSession se){
        System.out.println("打字: "+phone);
        String cede=ru.getKey(phone);
        if(cede.equals(smsCode)){
            //验证码输入正确
            Map<String,Object> map=new HashMap<>();
            map.put("newPhone",phone);
            map.put("oPhone",ophone);

            int i = service.UpdatePhonePerson(map);
            if(i>=0){
                //修改成功
                System.out.println("返回的数: "+i);
                String code=se.getId();
                ru.SetKey(code,phone);
                return  i;
            }
            else{
                return  0;
            }
        }
        else{
            System.out.println("验证码有误");
            return  0;
        }

    }


}
