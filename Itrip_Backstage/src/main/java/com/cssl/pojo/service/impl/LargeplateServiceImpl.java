package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.largeplateMapper;
import com.cssl.pojo.service.LargeplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class LargeplateServiceImpl implements LargeplateService {

    @Autowired
    private largeplateMapper largeplateMapper;

    @Override
    public List<Map<String, Object>> Finlargeplate() {
        return largeplateMapper.Finlargeplate();
    }

    @Override
    public List<Map<String, Object>> smallplate(int lp_id) {
        return largeplateMapper.smallplate(lp_id);
    }

    @Override
    public List<Map<String, Object>> pageCitiesstates(Map<String, Object> map) {
        return largeplateMapper.pageCitiesstates(map);
    }

    @Override
    public List<Map<String, Object>> sonCitiesstates(int sb_cs) {
        return largeplateMapper.sonCitiesstates(sb_cs);
    }

    @Override
    public int addCitiesstates1(Map<String, Object> map) {
        return largeplateMapper.addCitiesstates1(map);
    }

    @Override
    public int addCitiesstates2(Map<String, Object> map) {
        return largeplateMapper.addCitiesstates2(map);
    }

    @Override
    public List<Map<String, Object>> selCityWhereNameAndsp_id(Map<String, Object> map) {
        return largeplateMapper.selCityWhereNameAndsp_id(map);
    }

    @Override
    public int setCitiesstates(Map<String, Object> map) {
        return largeplateMapper.setCitiesstates(map);
    }

    @Override
    public List<Map<String, Object>> selCitiesstatesID(int cs_id) {
        return largeplateMapper.selCitiesstatesID(cs_id);
    }

    @Override
    public int delCitiesstates(int cs_id) {
        return largeplateMapper.delCitiesstates(cs_id);
    }
}
