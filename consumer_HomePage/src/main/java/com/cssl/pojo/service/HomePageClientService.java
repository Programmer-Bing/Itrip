package com.cssl.pojo.service;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.ProductDetails;
import com.cssl.pojo.Product_shopping;
import com.cssl.pojo.order.Order;
import com.cssl.pojo.po.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
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

    //查热销商品
    @RequestMapping(method = RequestMethod.GET, value = "findSellwell")
    public List<HomePage_product> findSellwell();

    //根据所属唯一城市查商品
    @RequestMapping(method = RequestMethod.GET, value = "findPartyingByCity")
    public List<HomePage_product> findPartyingByCity(@RequestParam(required = false, value = "P_cid") Integer P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id);

    //根据所属不唯一城市查商品
    @RequestMapping(method = RequestMethod.GET, value = "findPartyingByCities")
    public List<HomePage_product> findPartyingByCities(@RequestParam(required = false, value = "P_cid") String P_cid, @RequestParam(required = false, value = "Pt_id") Integer Pt_id);
    /***
     * 跟据商品id来查商品详情
     * @param Product_id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "findProductDetails")
    public ProductDetails findProductDetails(@RequestParam("Product_id") Integer Product_id);

    /***
     * 跟据商品id来查商品
     * @param Product_id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "findByP_id")
    public HomePage_product findByP_id(@RequestParam("Product_id") Integer Product_id);

    /***
     * 添加购物车
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "addShopping")
    public Integer addShopping(@RequestParam("map") String map);

    /***
     * 查找xx的购物车的商品
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "findShoppingByUid")
    public List<Product_shopping> findShoppingByUid(@RequestParam("uid") Integer uid);

    /***
     * 删除购物车的商品
     * @param psc_id 购物车中的商品的id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "delShopping")
    public Integer delShopping(@RequestParam("psc_id") Integer psc_id);

    /***
     * 添加用户 注册
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/userADD")
    public int addUser(@RequestBody Map<String, Object> map);

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

    @RequestMapping(method = RequestMethod.GET,value = "/SelectOrderProdoct")
    public List<Orders> SelectOrderProdoct(@RequestParam("1") int userid) ;


    @RequestMapping(method = RequestMethod.GET,value = "/SelectOrderNumb")
    public List<Orders> SelectOrderNumb(@RequestParam(value = "1") int userid);



    @RequestMapping(method = RequestMethod.GET,value = "/SelectOrderXQ")
    public List<OrderXQ> SelectOrderProduct(@RequestParam(value = "ordernum") String ordernum);

    /***
     *
     * 收藏查询总数
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/SelectCollectCount")
    public int SelectCollectCount(@RequestBody Collect co);

    /***
     *
     *
     * 添加收藏
     * @param co
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/InsertCollect")
    public int InsertCollect(@RequestBody Collect co) ;

    /****
     *
     *
     * 个人收藏的查询
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/SelectCollectUser")
    public List<Collect> SelectCollectUser(@RequestBody  Map<String,Object> map);


    /****
     *
     *
     * 个人收藏总数的查询
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectCollectCountUser")
    public int SelectCollectCountUser(@RequestParam(value = "11") int userid);


    /***
     *
     *
     * 取消收藏
     * @param map
     * @return
     */

    @RequestMapping(method = RequestMethod.POST,value = "/DeleteCollect")
    public int DeleteCollect(@RequestBody Map<String, Object> map);

    /**
     * 显示酒店购物车
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/showMycart")
    public List<List> showMycart();

    /**
     *删除酒店购物车
     */
    @RequestMapping(method = RequestMethod.GET,value = "/delHotel")
    public boolean delHotel(Integer sht);

    /***
     *
     *
     * 浏览记录
     */
    @RequestMapping(method = RequestMethod.POST,value = "/AddBrowsingHistory")
    public int AddBrowsingHistory(@RequestBody BrowsingHistory bb);

    /***
     *
     *
     * 浏览记录的修改
     * @param bb
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/UpdateBrowsingHistory")
    public int UpdateBrowsingHistory(@RequestBody  BrowsingHistory bb);


    /***
     *
     *
     * 浏览的记录的查询
     * @param bb
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/SelectBrowsingHistory")
    public int SelectBrowsingHistory(@RequestBody  BrowsingHistory bb);

    /***
     *
     * 个人浏览记录的查询
     * @param userid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectBrowsingHistoryUser")
    public List<BrowsingHistory> SelectBrowsingHistoryUser(@RequestParam(value = "111") int userid);
    /***
     * 查询数据库最新添加的一条数据
     * @return
     */
    @RequestMapping("findNew")
    public Product_shopping findNew();

    /***
     * 跟据id查购物车的商品
     * @return
     */
    @RequestMapping("findById")
    public Product_shopping findById(@RequestParam(value = "psc_id") Integer psc_id);

    /***
     * 新增订单
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "addOrder")
    public int addOrder(@RequestParam("map") String map);


    /***
     *添加优惠卷
     * @param dc
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/AddDiscountCoupon")
    public int AddDiscountCoupon(@RequestBody  DiscountCoupon dc);

    /****
     *
     *
     *
     * 查询当前用户是否拥有优惠卷
     * @param userid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectDiscountCouponCount")
    public int SelectDiscountCouponCount(@RequestParam(value = "1") int userid);


    /***
     *
     *
     *
     * 查询当前用户拥有优惠卷
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectDiscountCouponCount")
    public List<DiscountCoupon> SelectDiscountCouponUserShow(@RequestParam(value = "1") int userid);
}
