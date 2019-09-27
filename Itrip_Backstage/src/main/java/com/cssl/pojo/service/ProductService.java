package com.cssl.pojo.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductService {


    public List<Map<String,Object>> productType();

    public List<Map<String,Object>> citiesstatesLs();

    public List<Map<String,Object>> findProduct(Map<String, Object> map);

    public int productSize();

    public int addProduct(Map<String, Object> map);

    public int addtourismproducts(Map<String, Object> map);

    public Map<String,Object> selectP_id(String product_name);

    public int addhotel(Map<String, Object> map);

    public int selProCount(Map<String, Object> map);

    public int delproduct(int p_id);

    public int deltourism(int p_id);

    public int delhotel(int p_id);

    public int addcost_description(Map<String, Object> map);

    public Map<String,Object> tourismproductsP_id(int p_id);

    public Map<String,Object> productP_id(int p_id);

    public Map<String,Object> cost_descriptionC_id(int cd_id);

    public Map<String,Object> cost_descriptionOrder();

    public Map<String,Object> hotelP_id(int p_id);

    public int setProduct(Map<String, Object> map);

    public int setProduct1(Map<String, Object> map);

    public int setTourism(Map<String, Object> map);

    public int setTourism1(Map<String, Object> map);

    public int setDescription(Map<String, Object> map);

    public int setHotel(Map<String, Object> map);

    public int setHotel1(Map<String, Object> map);

    public List<Map<String,Object>> roominformation(Map<String, Object> map);

    public List<Map<String,Object>> productName(String name);

    public List<Map<String,Object>> hotel();

    public int addroom(Map<String, Object> map);

    public int setRoom(Map<String, Object> map);

    public Map<String,Object> selsetRoom(int id);

    public int setRoom1(Map<String, Object> map);

    public int delRoom(int id);
}
