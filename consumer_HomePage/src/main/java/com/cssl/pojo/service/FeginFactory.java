package com.cssl.pojo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cssl.pojo.HomePage_product;
import com.cssl.pojo.ProductDetails;
import com.cssl.pojo.Product_shopping;
import com.cssl.pojo.po.Collect;
import com.cssl.pojo.po.OrderXQ;
import com.cssl.pojo.po.Orders;
import com.cssl.pojo.po.User;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  服务降级回调类
 */
@Component
public class FeginFactory implements FallbackFactory<HomePageClientService> {
    @Override
    public HomePageClientService create(Throwable throwable) {

        return new HomePageClientService() {
            @Override
            public List<HomePage_product> findBargains(Integer id) {
                return new ArrayList<>();
            }

            @Override
            public List<HomePage_product> findSellwell() { return null; }

            @Override
            public List<HomePage_product> findPartyingByCity(Integer P_cid, Integer Pt_id) {
                return null;
            }

            @Override
            public List<HomePage_product> findPartyingByCities(String P_cid, Integer Pt_id) {
                return null;
            }

            @Override
            public List<User> JudgeUser(String phone) {
                return new ArrayList<>();
            }

            @Override
            public ProductDetails findProductDetails(Integer Product_id) { return null; }

            @Override
            public HomePage_product findByP_id(Integer Product_id) {
                return null;
            }

            @Override
            public Integer addShopping(String map) {
                return null;
            }

            @Override
            public List<Product_shopping> findShoppingByUid(Integer uid) {
                return null;
            }

            @Override
            public Integer delShopping(Integer psc_id) {
                return null;
            }

            @Override
            public Map<String, Object> PhoneEmail(String phone) {
                return null;
            }

            @Override
            public int UpdatePhone(Map<String, Object> map) {
                return 0;
            }

            @Override
            public List<User> LoginPhone(Map<String, Object> map) {
                return null;
            }

            @Override
            public List<User> UserLoginEmail(Map<String, Object> map) {
                return null;
            }

            @Override
            public int UpdateUser(User uu) {
                return 0;
            }

            @Override
            public List<User> SelectUserName(String name) {
                return null;
            }

            @Override
            public int UpdatePhonePerson(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int UpdatePassword(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int UpdatePicture(Map<String, Object> map) {
                return 0;
            }

            @Override
            public List<Orders> SelectUser(int id) {
                return null;
            }

            @Override
            public List<Orders> SelectOrderProdoct(int userid) {
                return null;
            }

            @Override
            public List<Orders> SelectOrderNumb(int userid) {
                return null;
            }

            @Override
            public List<OrderXQ> SelectOrderProduct(String ordernum) {
                return null;
            }

            @Override
            public int addUser(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int SelectCollectCount(Collect co) {
                return 0;
            }

            @Override
            public int InsertCollect(Collect co) {
                return 0;
            }

            @Override
            public List<Collect> SelectCollectUser(Map<String, Object> map) {
                return null;
            }

            @Override
            public int SelectCollectCountUser(int userid) {
                return 0;
            }

            @Override
            public int DeleteCollect(Map<String, Object> map) {
                return 0;
            }

            @Override
            public List<List> showMycart() {
                return  null;
            }

            @Override
            public boolean delHotel(Integer sht) {
                return false;
            }
        };
    }
}
