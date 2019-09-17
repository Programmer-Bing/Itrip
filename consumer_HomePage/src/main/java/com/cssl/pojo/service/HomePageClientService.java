package com.cssl.pojo.service;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.po.Orders;
import com.cssl.pojo.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//当一个服务停止了，Consumer客户端提供降级信息
/*@FeignClient("MICROSERVICE-DEPT")*/
@FeignClient(value = "MICROSERVICE-DEPT", fallbackFactory = FeginFactory.class)
public interface HomePageClientService {
    //查特价商品
    @RequestMapping(method = RequestMethod.GET, value = "findBargains")
    public List<HomePage_product> findBargains(@RequestParam("lp_id") Integer lp_id);

    //查吃喝玩乐板块
    @RequestMapping(method = RequestMethod.GET, value = "findPartyingByCity")
    public List<HomePage_product> findPartyingByCity(@RequestParam(required = false, value = "P_cid") Integer P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id);

    @RequestMapping(method = RequestMethod.GET, value = "/homeproduct/list2")
    public List<HomePage_product> list2(@RequestParam Map<String, Object> map);

    @RequestMapping(method = RequestMethod.GET, value = "/homeproduct/cs")
    public List<User> Cs();

    /***
     * 添加用户 注册
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/userADD")
    public int addUser(@RequestBody Map<String,Object> map);


    /***
     * 注册
     *  判断号码
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "UserRegistration")
    public List<User> JudgeUser(@RequestParam(value = "phone") String phone);


    /***
     * 根据号码拿邮箱
     */
    @RequestMapping(method = RequestMethod.GET,value = "PhoneEmailUser")
    public Map<String,Object> PhoneEmail(@RequestParam(value = "phone") String phone);


    /***
     * 用户修改密码
     */
    @RequestMapping(method = RequestMethod.POST,value = "/UpdatePhoneUser")
    public int UpdatePhone(@RequestBody  Map<String,Object> map);

    /***
     *
     * 手机密码登录
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/LoginPhoeUser")
    public List<User> LoginPhone(@RequestBody Map<String,Object> map);

    /***
     *
     * 邮箱登录
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/LoginEmailUser")
    public List<User> UserLoginEmail(@RequestBody  Map<String,Object> map);


    @RequestMapping(method = RequestMethod.POST,value = "/UpdateUserMsg")
    public int UpdateUser(@RequestBody User uu);


    @RequestMapping(method = RequestMethod.GET,value = "/SecectUserNamexx")
    public List<User> SelectUserName(@RequestParam(value = "name") String name);


    @RequestMapping(method = RequestMethod.POST,value = "/UpdatePhonePerson")
    public int UpdatePhonePerson(@RequestBody  Map<String, Object> map);

    @RequestMapping(method = RequestMethod.POST,value = "/UpdatePassword")
    public int UpdatePassword(@RequestBody  Map<String, Object> map);


    @RequestMapping(method = RequestMethod.POST,value = "/UpdatePicture")
    public int UpdatePicture(@RequestBody  Map<String, Object> map);


    @RequestMapping(method = RequestMethod.GET,value = "/SelectUserID")
    public List<Orders> SelectUser(@RequestParam(value = "1") int id);

}
