package com.cssl.pojo.controller;

import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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


    //测试分布式session
    @GetMapping("/getUser")
    public String getUser(HttpServletRequest request, HttpSession session){

        String name=(String)session.getAttribute("user");
        if(name==null||name.isEmpty()){
            name="session:"+System.currentTimeMillis();
            session.setAttribute("userName",name);
        }
        System.out.println("访问的端口："+request.getServerPort()+":"+name);
        return name;
    }

    /***
     *
     * 邮箱登录
     */
    @RequestMapping(method = RequestMethod.POST,value = "/LoginEmailUser")
    public List<User> UserLoginEmail(@RequestBody Map<String,Object> map){

        System.out.println("消费者来邮箱登录");
        List<User> list = us.UserLoginEmail(map);

        return  us.UserLoginEmail(map);
    }

    /***
     *
     *
     * 修改用户信息
     */
    @RequestMapping(method = RequestMethod.POST,value = "/UpdateUserMsg")
    public int UpdateUser(@RequestBody User uu){

        System.out.println("消费者来修改用户信息");
        return  us.UpdateUser(uu);
    }

    /****
     *
     *
     * 根据昵称查询用户
     * @param name
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SecectUserNamexx")
    public List<User> SelectUserName(@RequestParam(value = "name") String name) {
        System.out.println("消费者查询姓名");
        return us.SelectUserName(name);
    }

    /***
     *
     * 修改电话
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/UpdatePhonePerson")
    public int UpdatePhonePerson(@RequestBody  Map<String, Object> map) {
        System.out.println("消费者修改电话");
        return us.UpdatePhonePerson(map);
    }

    /***
     *
     * 修改密码
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/UpdatePassword")
    public int UpdatePassword(@RequestBody  Map<String, Object> map) {
        System.out.println("消费者来修改密码");
        return us.UpdatePassword(map);
    }

    /***
     *
     * 修改图片
     *
     */
    @RequestMapping(method = RequestMethod.POST,value = "/UpdatePicture")
    public int UpdatePicture(@RequestBody  Map<String, Object> map){

        System.out.println("消费者来到修改图片");
        return  us.UpdatePicture(map);
    }


}
