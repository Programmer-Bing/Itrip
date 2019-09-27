package com.cssl.pojo.controller;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.cssl.pojo.po.User;
import com.cssl.pojo.service.HomePageClientService;
import com.cssl.pojo.util.DunXing;
import com.cssl.pojo.util.RedisUtil;
import com.jcraft.jsch.Session;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.PrintWriter;
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
        return null;
    }



    @RequestMapping(value ="/usercode")
    public String Usercode(@RequestParam String phone) throws Exception{
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

        if(list.size()>0){
            User user=list.get(0);
            System.out.println("中文名字: "+user.getChinese_Name());
            se.setAttribute(se.getId(),user);
            se.setAttribute(se.getId()+"123",user.getPhone_number());
            System.out.println("sessionid: "+se.getId());
            User uu = (User) se.getAttribute(se.getId());
            se.setAttribute("name",user.getChinese_Name());
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
        String phone = (String)se.getAttribute(se.getId() + "123");
        System.out.println("显示主界面的名字: "+phone);
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

    /***
     * 个人中心显示信息
     * @param se
     * @return
     */
    @RequestMapping("/SelectUser")
    public List<User> PersonCenterSelect(HttpSession se){
        System.out.println("来到个人显示中心");
        String phone = (String) se.getAttribute(se.getId() + "123");

        List<User> list = service.JudgeUser(phone);

        return  list;
    }

    /***
     * 修改用户信息
     *
     * @return
     */
    @RequestMapping("/UpdateUser")
    public User UpdateUser(String nameZh,String givenNameEn,String familyNameEn,String nickName,int sex,String birthDay,HttpSession se){
        System.out.println("来到修改用户信息");
        String EnglishName=givenNameEn+" "+familyNameEn;
        User user=new User();
        user.setEnglish_Name(EnglishName);
        user.setChinese_Name(nameZh);
        user.setUser_name(nickName);
        if(sex==0){
            user.setGender("男");
        }
        else{
            user.setGender("女");
        }

        user.setBirthday(birthDay);
        String phone=(String)se.getAttribute(se.getId()+"123");
        System.out.println("从session获取的电话号码: "+phone+" sessionID: "+se.getId());
        user.setPhone_number(phone);
        int i = service.UpdateUser(user);
        System.out.println("修改长度: "+i);


        return  user;

    }

    /***
     *
     *
     * 显示手机号等信息
     * @param se
     * @return
     */
    @RequestMapping("/xsphone")
    public User XsPhone(HttpSession se){
        System.out.println("显示手机号等信息");
        String phone = (String) se.getAttribute(se.getId()+"123");

        User user=new User();
        user.setPhone_number(phone);

        List<User> list = service.JudgeUser(phone);

        String email = list.get(0).getEmail();
        String hedr=list.get(0).getHead_portrait();

        System.out.println("session里面的邮箱: "+email);
        System.out.println("session图片地址: "+hedr);
        user.setEmail(email);
        user.setHead_portrait(hedr);

        return  user;
    }

    /***
     *
     * 修改手机
     *
     */
    @RequestMapping("/UpdatePhone")
    public int UpdatePhoneNumber(String phone,String ophone,String smsCode,HttpSession se){

        System.out.println("来到修改手机号码");
        String code = ru.getKey(phone);
        if(smsCode.equals(code)){
            //验证码输入正确
            Map<String,Object> map=new HashMap<>();
            map.put("newPhone",phone);
            map.put("oPhone",ophone);
            int i = service.UpdatePhonePerson(map);
            System.out.println("修改手机号码的sessionID:  "+se.getId());
            if(i>0){
                se.setAttribute(se.getId()+"123",phone);
                return  i;
            }
            else{
                return 0;
            }
        }
        else{

            //验证码输入错误

            return  0;
        }

    }


    /***
     *
     * 修改密码
     * @return
     */
    @RequestMapping("/UpdatePassWord")
    public int UpdatePassWord(HttpSession se,String repwd,String password,String newpwd){
        String phone = (String) se.getAttribute(se.getId()+"123");
        List<User> list = service.JudgeUser(phone);
        String sepwd=list.get(0).getPassword();
        System.out.println("session集合的密码: "+sepwd);
        if(sepwd.equals(password)){
            System.out.println("数据密码输入正确");
            if(newpwd.equals(repwd)){
                System.out.println("两次密码输入一致");
                Map<String,Object> map=new HashMap<>();
                map.put("newpwd",newpwd);
                map.put("phone",phone);
                int i = service.UpdatePassword(map);
                return i;
            }
            else{
                System.out.println("两次密码输不一致");
                return  -2;
            }
        }
        else{
            System.out.println("数据密码输入不正确");
            return -1;
        }

    }

    /***
     *
     *
     * 根据号码查询邮想
     * @param se
     * @return
     */
    @RequestMapping("/SelectEmail")
    public int SelectEmail(HttpSession se){
        String phone = (String)se.getAttribute(se.getId() + "123");

        List<User> list = service.JudgeUser(phone);

        String email = list.get(0).getEmail();

        System.out.println("session里面的邮箱: "+email);
        return 0;

    }

    /***
     *
     *
     * 传输图片
     *
     */
    @RequestMapping("/DisplayImg")
    public int DisplayImg(String tp){

        Session se = JschUtil.getSession("39.107.103.69", 22, "root", "ailvxing@123");
        Sftp sftp = JschUtil.createSftp(se);
        sftp.put("E:\\img\\aa.jpg","/home/ftpuser/www/images/user");

        return  0;
    }

    /***
     *
     *
     * 修改图片
     * @param map
     * @param tp
     * @return
     */
    @RequestMapping("/UpdatePicture")
    public int UpdatePicture(Map<String,Object> map,String tp,HttpSession se){
        String site="http://39.107.103.69/images/user/"+tp;
        System.out.println("修改图片的地址:  "+site);
        map.put("picture",site);
        String phone = (String)se.getAttribute(se.getId() + "123");
        map.put("phone",phone);
        int i = service.UpdatePicture(map);


        return  i;

    }







}
