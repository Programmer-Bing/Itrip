package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.ProductMapper;
import com.cssl.pojo.service.ProductService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Map<String, Object>> productType() {
        return productMapper.productType();
    }

    @Override
    public List<Map<String, Object>> citiesstatesLs() {
        return productMapper.citiesstatesLs();
    }

    @Override
    public List<Map<String, Object>> findProduct(Map<String, Object> map) {
        return productMapper.findProduct(map);
    }

    @Override
    public int productSize() {
        return productMapper.productSize();
    }

    @Override
    public int addProduct(Map<String, Object> map) {
        return productMapper.addProduct(map);
    }

    @Override
    public int addtourismproducts(Map<String, Object> map) {
        return productMapper.addtourismproducts(map);
    }

    @Override
    public Map<String, Object> selectP_id(String product_name) {
        return productMapper.selectP_id(product_name);
    }

    @Override
    public int addhotel(Map<String, Object> map) {
        return productMapper.addhotel(map);
    }

    @Override
    public int selProCount(Map<String, Object> map) {
        return productMapper.selProCount(map);
    }

    @Override
    public int delproduct(int p_id) {
        return productMapper.delproduct(p_id);
    }

    @Override
    public int deltourism(int p_id) {
        return productMapper.deltourism(p_id);
    }

    @Override
    public int delhotel(int p_id) {
        return productMapper.delhotel(p_id);
    }

    @Override
    public int addcost_description(Map<String, Object> map) {
        return productMapper.addcost_description(map);
    }

    @Override
    public Map<String, Object> tourismproductsP_id(int p_id) {
        return productMapper.tourismproductsP_id(p_id);
    }

    @Override
    public Map<String, Object> productP_id(int p_id) {
        return productMapper.productP_id(p_id);
    }

    @Override
    public Map<String, Object> cost_descriptionC_id(int cd_id) {
        return productMapper.cost_descriptionC_id(cd_id);
    }

    @Override
    public Map<String, Object> cost_descriptionOrder() {
        return productMapper.cost_descriptionOrder();
    }

    @Override
    public Map<String, Object> hotelP_id(int p_id) {
        return productMapper.hotelP_id(p_id);
    }

    @Override
    public int setProduct(Map<String, Object> map) {
        return productMapper.setProduct(map);
    }

    @Override
    public int setProduct1(Map<String, Object> map) {
        return productMapper.setProduct1(map);
    }

    @Override
    public int setTourism(Map<String, Object> map) {
        return productMapper.setTourism(map);
    }

    @Override
    public int setTourism1(Map<String, Object> map) {
        return productMapper.setTourism1(map);
    }

    @Override
    public int setDescription(Map<String, Object> map) {
        return productMapper.setDescription(map);
    }

    @Override
    public int setHotel(Map<String, Object> map) {
        return productMapper.setHotel(map);
    }

    @Override
    public int setHotel1(Map<String, Object> map) {
        return productMapper.setHotel1(map);
    }

    @Override
    public List<Map<String, Object>> roominformation(Map<String, Object> map) {
        return productMapper.roominformation(map);
    }

    @Override
    public List<Map<String, Object>> productName(String name) {
        return productMapper.productName(name);
    }

    @Override
    public List<Map<String, Object>> hotel() {
        return productMapper.hotel();
    }

    @Override
    public int addroom(Map<String, Object> map) {
        return productMapper.addroom(map);
    }

    @Override
    public int setRoom(Map<String, Object> map) {
        return productMapper.setRoom(map);
    }

    @Override
    public Map<String, Object> selsetRoom(int id) {
        return productMapper.selsetRoom(id);
    }

    @Override
    public int setRoom1(Map<String, Object> map) {
        return productMapper.setRoom1(map);
    }

    @Override
    public int delRoom(int id) {
        return productMapper.delRoom(id);
    }


}
