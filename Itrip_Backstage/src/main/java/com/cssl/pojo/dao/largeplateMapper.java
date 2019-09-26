package com.cssl.pojo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface largeplateMapper {

    public List<Map<String,Object>> Finlargeplate();

    public List<Map<String,Object>> smallplate(@Param("lp_id") int lp_id);

    public List<Map<String,Object>> pageCitiesstates(Map<String,Object> map);

    public List<Map<String,Object>> sonCitiesstates(@Param("sb_cs") int sb_cs);

    public int addCitiesstates1(Map<String,Object> map);

    public int addCitiesstates2(Map<String,Object> map);

    public List<Map<String,Object>> selCityWhereNameAndsp_id(Map<String,Object> map);

    public int setCitiesstates(Map<String,Object> map);

    public List<Map<String,Object>> selCitiesstatesID(@Param("cs_id") int cs_id);

    public int delCitiesstates(@Param("cs_id") int cs_id);
}
