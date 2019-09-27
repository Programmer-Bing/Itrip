package com.cssl.pojo.dao;

import com.cssl.pojo.po.BrowsingHistory;
import com.cssl.pojo.po.Collect;
import com.cssl.pojo.po.DiscountCoupon;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CollectDao {

    /***
     *
     * 查询收藏的总数
     */
    public int SelectCollectCount(Collect co);

    /***
     *
     * 添加收藏
     * @return
     */
    public int InsertCollect(Collect co);


    /***
     *
     *
     * 个人查询收藏
     */
    public List<Collect> SelectCollectUser(Map<String,Object> map);


    /****
     *
     *
     *
     * 个人查询分页收藏总数
     */
    public int SelectCollectCountUser(int userid);


    /***
     *
     *
     * 取消收藏
     */
    public int DeleteCollect(Map<String,Object> map);


    /***
     *
     * 浏览记录添加
     */
    public int AddBrowsingHistory(BrowsingHistory  bb);

    /***
     *
     *
     * 浏览记录的查询
     */
    public int  SelectBrowsingHistory(BrowsingHistory  bb);


    /***
     *
     *
     * 浏览记录的查询到了修改
     */
    public int  UpdateBrowsingHistory(BrowsingHistory  bb);


    /****
     *
     *
     *
     * 个人浏览记录的查询
     */
     public List<BrowsingHistory> SelectBrowsingHistoryUser(int userid);


    /***
     *
     *
     * 领取优惠卷
     *
     */
     public int AddDiscountCoupon(DiscountCoupon dc);


    /***
     *
     *
     * 查询当前用户是否有优惠券总数
     */
     public int SelectDiscountCouponCount(int userid);


    /***
     *
     *
     * 查询用户的优惠卷
     */
    public List<DiscountCoupon> SelectDiscountCouponCountUser(int userid);




}
