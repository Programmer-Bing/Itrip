package com.cssl.pojo.controller;

import cn.hutool.core.img.Img;
import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.cssl.pojo.po.Page;
import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public Page findAll(@RequestBody Map<String,Object> map){
        System.out.println("服务者UserMap:"+map);
        Map<String,Object> map1=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();
        Page page=new Page();

        map1.put("index",null);
        map1.put("size",null);
        map1.put("chinese_name",(String)map.get("Chinese_Name"));
        map1.put("english_name",(String)map.get("English_Name"));
        List list=userService.findAll(map1);
        int totle=list.size();  //查询总数据量
        String pageNumber=(String)map.get("pageNumber");  //当前页数
        int pageIndex=Integer.parseInt(pageNumber);
        int pageSize=3;  //每页显示数量
        int pages=totle%pageSize==0?totle/pageSize:totle/pageSize+1;  //获取总页数

        map2.put("index",(pageIndex-1)*pageSize);
        map2.put("size",pageSize);
        map2.put("chinese_name",(String)map.get("Chinese_Name"));
        map2.put("english_name",(String)map.get("English_Name"));
        List list1=userService.findAll(map2);
        System.out.println("服务者:"+list1);

        page.setList(list1);
        page.setTotalPage(pages);

        return page;
    }

    @RequestMapping("addUser")
    public int addUser(@RequestBody Map<String,Object> map){
        System.out.println("addUserMap:"+map);
        Map<String,Object> map1=new HashMap<>();
        map1.put("user_name",map.get("user_name"));
        map1.put("Chinese_Name",map.get("Chinese_Name"));
        map1.put("English_Name",map.get("English_Name"));
        map1.put("Gender",map.get("sex"));
        map1.put("Birthday",map.get("Birthday"));
        map1.put("Phone_number",map.get("Phone_number"));
        map1.put("email",map.get("email"));
        map1.put("Account_number",map.get("Account_number"));
        map1.put("Password",map.get("pass"));
        String imag="http://39.107.103.69/images/user/"+map.get("Head_portrait");
        map1.put("Head_portrait", imag);
        map1.put("Administration",map.get("admin"));


        return userService.addUser(map1);
    }

    @RequestMapping("deluser")
    public int deluser(@RequestBody int u_id){
        System.out.println("服务者u_id:"+u_id);
        Map<String,Object> map=userService.whereuid(u_id);
        if(!map.get("Administration").equals("1")){
            int num=userService.deluser(u_id);
            if(num>0) {
                return 1;
            }
        }
        return 0;
    }

    @RequestMapping("whereuid")
    public Map<String,Object> whereuid(@RequestBody int uid){
        return userService.whereuid(uid);
    }

    @RequestMapping("modUser")
    public int modUser(@RequestBody Map<String,Object> map){
        System.out.println("服务者modUserMap:"+map);
        Map<String,Object> map1=new HashMap<>();
        Session session= JschUtil.getSession("39.107.103.69",22,"root","ailvxing@123");
        Sftp stfp=JschUtil.createSftp(session);
        map1.put("user_name",map.get("user_name"));
        map1.put("Chinese_Name",map.get("Chinese_Name"));
        map1.put("English_Name",map.get("English_Name"));
        map1.put("Gender",map.get("sex"));
        map1.put("Birthday",map.get("Birthday"));
        map1.put("Phone_number",map.get("Phone_number"));
        map1.put("email",map.get("email"));
        String img="http://39.107.103.69/images/user/"+map.get("Head_portrait");
        Sftp put=stfp.put("C:\\Users\\Lenovo\\Desktop\\itrip项目\\图片\\"+map.get("Head_portrait"),"/home/ftpuser/www/images/user");
        map1.put("Head_portrait",img);
        map1.put("newpass",map.get("newpass"));
        map1.put("admin",map.get("admin"));
        map1.put("user_id",map.get("user_id"));
        int num=userService.modUser(map1);
        return num;
    }

    @RequestMapping("selUserAdmin")
    public Map<String,Object> selUserAdmin(@RequestBody Map<String,Object> map){
        return userService.selUserAdmin(map);
    }
}
