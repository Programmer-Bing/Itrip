package com.cssl.pojo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Map;

@Mapper
@Repository
@Component(value = "shoppingcartDao")
public interface shoppingcartDao {

    boolean addCart(@Param("cart") Map<String,Object> map);

    boolean addRoom(@Param("room") Map<String,Object> map);

}


















