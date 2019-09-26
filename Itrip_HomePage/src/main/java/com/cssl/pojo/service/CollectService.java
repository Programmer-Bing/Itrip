package com.cssl.pojo.service;

import com.cssl.pojo.po.BrowsingHistory;
import com.cssl.pojo.po.Collect;
import com.cssl.pojo.po.DiscountCoupon;

import java.util.List;
import java.util.Map;

public interface CollectService {


    public int SelectCollectCount(Collect co);


    public int InsertCollect(Collect co);

    public List<Collect> SelectCollectUser(Map<String,Object> map);

    public int SelectCollectCountUser(int userid);

    public int DeleteCollect(Map<String,Object> map);

    public int AddBrowsingHistory(BrowsingHistory bb);

    public int  SelectBrowsingHistory(BrowsingHistory  bb);


    public int  UpdateBrowsingHistory(BrowsingHistory  bb);

    public List<BrowsingHistory> SelectBrowsingHistoryUser(int userid);

    public int AddDiscountCoupon(DiscountCoupon dc);

    public int SelectDiscountCouponCount(int userid);


}
