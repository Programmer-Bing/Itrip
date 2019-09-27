package com.cssl.pojo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;

import com.cssl.pojo.po.*;
import com.cssl.pojo.service.HomePageClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CollectController {

     @Autowired
     private HomePageClientService service;



     /***
      *
      * 查询收藏总数
      * @param productnum
      * @return
      */
     @RequestMapping("/SelectCollect")
     @ResponseBody
     public int SelectCollectCount(int productnum,HttpSession se){


         Collect co=new Collect();
         User user = (User) se.getAttribute(se.getId());
         if(user!=null){
             co.setProductid(productnum);
             co.setUserid(user.getUser_id());
             System.out.println("查询收藏总数: "+user.getUser_id()+"商品id: "+productnum);
         }


         int i = service.SelectCollectCount(co);


         return i;

     }

    /***
     *
     * 判断点击收藏登录
     * @return
     */
    @RequestMapping("/SelectCollectUser")
    @ResponseBody
    public int SelectCollectUser(HttpSession se){
        System.out.println("收藏判断登录");
        User user = (User) se.getAttribute(se.getId());
        if(user!=null){
            return 1;
        }
        return 0;
    }

    /***
     *
     *
     *添加收藏
     * @param
     * @return
     */
    @RequestMapping("/InsertCollect")
    @ResponseBody
    public int InsertCollect(int productnum,HttpSession se) {
        User user=(User) se.getAttribute(se.getId());
        System.out.println("添加收藏: "+user.getUser_id()+"商品id: "+productnum);
        Collect co=new Collect();
        co.setProductid(productnum);
        co.setUserid(user.getUser_id());

        int i = service.InsertCollect(co);
        return i;
    }

    /***
     *
     * 个人收藏的查询
     * @param se
     * @return
     */
    @RequestMapping("/SelectCollectUsercx")
    @ResponseBody
    public OrderPage SelectCollectUsercx(HttpSession se,String pageno){

        User user=(User) se.getAttribute(se.getId());
        Map<String,Object> map=new HashMap<>();
        map.put("userid",user.getUser_id());
        int pageSize=2;//每页显示数量
        map.put("size",pageSize);
        System.out.println("当前页码:  "+(Integer.parseInt(pageno)-1)*pageSize);
        map.put("state",(Integer.parseInt(pageno)-1)*pageSize);
        List<Collect> list = service.SelectCollectUser(map);
        int totle = service.SelectCollectCountUser(user.getUser_id());//总数据量
        int pages=totle%pageSize==0?totle/pageSize:totle/pageSize+1;  //获取总页数

        OrderPage pa=new OrderPage();
        pa.setPageSize(pageSize);
        pa.setList(list);
        pa.setTotalCount(totle);
        pa.setPageNo(Integer.parseInt(pageno));
        pa.setTotalPage(pages);
        System.out.println("个人收藏的查询来了:  "+list.size()+": 图片: ");


        return  pa;

    }

    /**
     *
     * 取消收藏
     * @param pid
     * @return
     */
    @RequestMapping("/DeleteCollect")
    public String DeleteCollect(String pid,HttpSession se){
        System.out.println("查询的商品: "+pid);
        User user = (User) se.getAttribute(se.getId());
        Map<String,Object> map=new HashMap<>();
        map.put("cid",pid);
        map.put("userid",user.getUser_id());
        int i = service.DeleteCollect(map);
        if(i>0){
            return  "个人中心我的收藏.html";
        }
        return  "个人中心我的收藏.html";
    }


    /***
     *
     * 浏览记录
     * @return
     */
    @RequestMapping("/AddBrowsingHistory")
    @ResponseBody
    public int AddBrowsingHistory(String pid,HttpSession se){
        User user = (User) se.getAttribute(se.getId());
        BrowsingHistory bb=new BrowsingHistory();
        if(user!=null){
            bb.setProductid(Integer.parseInt(pid));
            bb.setUserid(user.getUser_id());
        }


        int count = service.SelectBrowsingHistory(bb);
        if(count>0){
            System.out.println("用户浏览记录中存在");
            int i = service.UpdateBrowsingHistory(bb);
            if(i>0){
                System.out.println("修改成功");
            }
        }
        else{
            System.out.println("用户浏览记录中不存在:  "+pid);
            if(user!=null){
                int i = service.AddBrowsingHistory(bb);
                System.out.println("数字:  "+i);
            }


        }

        return 0;
    }

    /***
     *
     *
     * 个人的浏览记录的查询
     * @return
     */
    @RequestMapping("/SelectBrowsingHistoryUser")
    @ResponseBody
    public List<BrowsingHistory> SelectBrowsingHistoryUser(HttpSession se){
        User user = (User) se.getAttribute(se.getId());
        List<BrowsingHistory> browsingHistories = service.SelectBrowsingHistoryUser(user.getUser_id());
        if (browsingHistories!=null){
            System.out.println("个人的浏览记录的查询:  "+browsingHistories.size()+"产品: "+browsingHistories.get(0).getPp().getP_imgpath());
        }
        return  browsingHistories;
    }

    /***
     *
     *
     * 爱旅行主界面显示
     * @return
     */
    @RequestMapping("/EuropeShowCollect")
    @ResponseBody
    public List<Integer> EuropeShowCollect(HttpSession se){

        User user = (User)se.getAttribute(se.getId());
        if(user!=null){
            int totle = service.SelectCollectCountUser(user.getUser_id());
            List<Integer> list=new ArrayList<>();
            list.add(totle);
            return  list;
        }

        return  null;
    }

    /***
     *
     * 添加优惠卷
     * @param time1
     * @param time2
     * @param yhjmony
     * @param se
     * @return
     */
    @RequestMapping("/AddDiscountCoupon")
    @ResponseBody
    public int AddDiscountCoupon(String time1,String time2,int yhjmony,HttpSession se,String dname){
        User user =(User) se.getAttribute(se.getId());
        if(user==null){
            return -1;
        }
        else {
            DiscountCoupon ds = new DiscountCoupon();
            ds.setUserid(user.getUser_id());
            ds.setDstatetime(time1);
            ds.setDmrtime(time2);
            ds.setDprice(yhjmony);
            int mz = yhjmony + 1;
            ds.setMeet(mz);
            ds.setDname(dname);
            int i = service.AddDiscountCoupon(ds);
            System.out.println("添加优惠卷:  " + i);

            return 0;
        }
    }

    /***
     *
     * 查询当前用户是否拥有优惠卷
     * @param se
     * @return
     */
    @RequestMapping("/SelectDiscountCouponCount")
    @ResponseBody
    public int SelectDiscountCouponCount(HttpSession se){
        User user =(User) se.getAttribute(se.getId());
        int i = service.SelectDiscountCouponCount(user.getUser_id());
        System.out.println("查询当前用户是否拥有优惠卷:  "+i);

        return i;
    }


    /***
     *
     * 当前用户查询优惠卷
     */
    @RequestMapping("/SelectDiscountCouponUserShow")
    @ResponseBody
    public List<DiscountCoupon> SelectDiscountCouponUserShow(HttpSession se){
        User user = (User)se.getAttribute(se.getId());

        List<DiscountCoupon> discountCoupons = service.SelectDiscountCouponCountUser(user.getUser_id());


        return  discountCoupons;
    }



}
