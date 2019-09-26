package com.cssl.pojo.service;

import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface LargeplateService {

    public List<Map<String,Object>> Finlargeplate();

    public List<Map<String,Object>> smallplate(int lp_id);

    public List<Map<String,Object>> pageCitiesstates(Map<String, Object> map);

    public List<Map<String,Object>> sonCitiesstates(int sb_cs);

    public int addCitiesstates1(Map<String, Object> map);

    public int addCitiesstates2(Map<String, Object> map);

    public List<Map<String,Object>> selCityWhereNameAndsp_id(Map<String, Object> map);

    public int setCitiesstates(Map<String, Object> map);

    public List<Map<String,Object>> selCitiesstatesID(int cs_id);

    public int delCitiesstates(int cs_id);
}
