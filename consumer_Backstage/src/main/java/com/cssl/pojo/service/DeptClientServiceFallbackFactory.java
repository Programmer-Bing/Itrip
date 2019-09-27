package com.cssl.pojo.service;

import com.cssl.pojo.po.Page;
import com.cssl.pojo.po.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public List<Map<String, Object>> productType() {
                System.out.println("失败了");
                return new ArrayList<>();
            }

            @Override
            public Page findAll(Map<String, Object> map) {
                return new Page();
            }

            @Override
            public List<Map<String, Object>> citiesstatesLs() {
                return new ArrayList<>();
            }

            @Override
            public Page findProduct(Map<String, Object> map) {
                return new Page();
            }

            @Override
            public int productSize() {
                return 0;
            }

            @Override
            public int addProduct(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int addUser(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int delproduct(Map<String,Object> map) {
                return 0;
            }

            @Override
            public int deluser(int u_id) {
                return 0;
            }

            @Override
            public Map<String, Object> whereuid(int uid) {
                return null;
            }

            @Override
            public int modUser(Map<String, Object> map) {
                return 0;
            }

            @Override
            public List<Map<String, Object>> Finlargeplate() {
                return null;
            }

            @Override
            public List<Map<String, Object>> smallplate(int lp_id) {
                return null;
            }

            @Override
            public Page pageCitiesstates(Map<String, Object> map) {
                return new Page();
            }

            @Override
            public List<Map<String, Object>> citiesstates(Map<String, Object> map) {
                return null;
            }

            @Override
            public int addCitiesstates(Map<String, Object> map) {
                return 0;
            }

            @Override
            public List<Map<String, Object>> selCitiesstatesID(int cs_id) {
                return null;
            }

            @Override
            public Map<String, Object> tourismproductsP_id(int p_id) {
                return null;
            }

            @Override
            public int setCitiesstates(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int delCitiesstates(int cs_id) {
                return 0;
            }

            @Override
            public Map<String, Object> productP_id(int p_id) {
                return null;
            }

            @Override
            public Map<String, Object> cost_descriptionC_id(int cd_id) {
                return null;
            }

            @Override
            public Map<String, Object> hotelP_id(int p_id) {
                return null;
            }

            @Override
            public int setProduct(Map<String, Object> map) {
                return 0;
            }

            @Override
            public Page roominformation(Map<String, Object> map) {
                return new Page();
            }

            @Override
            public List<Map<String, Object>> hotel() {
                return null;
            }

            @Override
            public int addroom(Map<String, Object> map) {
                return 0;
            }

            @Override
            public Map<String, Object> selsetRoom(int id) {
                return null;
            }

            @Override
            public int setRoom(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int delRoom(int id) {
                return 0;
            }

            @Override
            public Map<String, Object> selUserAdmin(Map<String, Object> map) {
                return null;
            }

            @Override
            public Page order_no(Map<String, Object> map) {
                return new Page();
            }

            @Override
            public int delOrder(String no) {
                return 0;
            }

            @Override
            public List<Map<String, Object>> userIsTwo() {
                return null;
            }

            @Override
            public int setState(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int setProState(Map<String, Object> map) {
                return 0;
            }

            @Override
            public int setblock(Map<String, Object> map) {
                return 0;
            }
        };
    }
}
