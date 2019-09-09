package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService us;


    @RequestMapping("/homeproduct/cs")
    public List<User> Cs() {
        return us.Cs();
    }


    /***
     *
     * 添加 用户 注册
     * @param
     * @return
     */

    @RequestMapping(method = RequestMethod.POST, value = "/userADD")
    public int addUser(@RequestBody Map<String,Object> map) {
        System.out.println("提供者来到注册");

        return us.addUser(map);
    }


    /***
     * 用户注册
     * 判断号码
     * @param phone
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "UserRegistration")
    public List<User> JudgeUser(@RequestParam(value = "phone") String phone) {
        System.out.println("来了提供者con太肉了咯");
        return us.JudgeUser(phone);
    }

    /***
     *
     * 根据号码拿邮箱
     * @param phone
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "PhoneEmailUser")
    public Map<String,Object> PhoneEmail(@RequestParam(value = "phone") String phone){
        System.out.println("消费者来了查询邮箱");
        return  us.PhoneEmail(phone);
    }

    /***
     *
     * 修改密码
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/UpdatePhoneUser")
    public int UpdatePhone(@RequestBody  Map<String,Object> map){
        System.out.println("消费者来修改密码");
        return  us.UpdatePhone(map);
    }

    /***
     *
     * 手机密码登录
     */
    @RequestMapping(method = RequestMethod.POST,value = "/LoginPhoeUser")
    public List<User> LoginPhone(@RequestBody  Map<String,Object> map){
        System.out.println("消费者来登录");
        return us.UserLogin(map);
    }





}
