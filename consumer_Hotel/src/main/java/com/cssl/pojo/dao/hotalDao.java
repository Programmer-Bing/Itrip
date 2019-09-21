package com.cssl.pojo.dao;

import com.cssl.pojo.hotal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
@Component(value = "hotaldao")
public interface hotalDao {

    List<Map> hotel(@Param("id") int id);

    List<Map> showInfo(@Param("id") int id);

    List<Map> showlable(@Param("id") int id);

    List<Map> showpre(@Param("id") int id);

}
