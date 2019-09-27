package com.cssl.pojo.controller;

import com.cssl.pojo.po.BrowsingHistory;
import com.cssl.pojo.po.Collect;
import com.cssl.pojo.po.DiscountCoupon;
import com.cssl.pojo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CollectController {

    @Autowired
    private CollectService cs;

    /***
     *
     * 查询收藏总数
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/SelectCollectCount")
    public int SelectCollectCount(@RequestBody Collect co) {
        System.out.println("查询收藏总数");
        return cs.SelectCollectCount(co);
    }

    /***
     *
     *添加收藏
     * @param co
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/InsertCollect")
    public int InsertCollect(@RequestBody  Collect co) {
        System.out.println("添加收藏");
        return cs.InsertCollect(co);
    }

    /***
     *
     * 个人收藏的查询
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/SelectCollectUser")
    public List<Collect> SelectCollectUser(@RequestBody  Map<String,Object> map) {
        return cs.SelectCollectUser(map);

    }

    /***
     *
     *
     *个人收藏总数
     * @param userid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectCollectCountUser")
    public int SelectCollectCountUser(@RequestParam(value = "11") int userid) {
        return cs.SelectCollectCountUser(userid);


    }

    /***
     *
     *
     * 取消收藏
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/DeleteCollect")
    public int DeleteCollect(@RequestBody Map<String, Object> map) {
        return cs.DeleteCollect(map);
    }


    /***
     *
     *
     * 浏览记录
     */
    @RequestMapping(method = RequestMethod.POST,value = "/AddBrowsingHistory")
    public int AddBrowsingHistory(@RequestBody BrowsingHistory bb) {
        return cs.AddBrowsingHistory(bb);

    }

    /***
     *
     * 浏览记录的查询
     * @param bb
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/SelectBrowsingHistory")
    public int SelectBrowsingHistory(@RequestBody  BrowsingHistory bb) {
        return cs.SelectBrowsingHistory(bb);


    }

    /***
     *
     *
     * 浏览记录的修改
     * @param bb
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/UpdateBrowsingHistory")
    public int UpdateBrowsingHistory(@RequestBody  BrowsingHistory bb) {
        return cs.UpdateBrowsingHistory(bb);
    }

    /****
     *
     *
     * 浏览记录用户查询
     * @param userid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectBrowsingHistoryUser")
    public List<BrowsingHistory> SelectBrowsingHistoryUser(@RequestParam(value = "111") int userid) {
        return cs.SelectBrowsingHistoryUser(userid);

    }

    /***
     *
     * 添加优惠卷
     * @param dc
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/AddDiscountCoupon")
    public int AddDiscountCoupon(@RequestBody  DiscountCoupon dc) {
        return cs.AddDiscountCoupon(dc);

    }

    /***
     *
     *
     * 查询当前用户是否拥有优惠卷
     */
    @RequestMapping(method = RequestMethod.GET,value = "/SelectDiscountCouponCount")
    public int SelectDiscountCouponCount(@RequestParam(value = "1") int userid) {
        return cs.SelectDiscountCouponCount(userid);
    }

}
