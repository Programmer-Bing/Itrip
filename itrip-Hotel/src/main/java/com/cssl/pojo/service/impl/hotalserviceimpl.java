package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.hotalDao;
import com.cssl.pojo.hotal;
import com.cssl.pojo.service.hotalservice;
import com.netflix.discovery.converters.Auto;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class hotalserviceimpl implements hotalservice {

    @Autowired
    private hotalDao hotaldao;

    @Override
    public List<Map> hotel(int id) {
        return hotaldao.hotel(id);
    }

    @Override
    public List<Map> showInfo(int id) {
        return hotaldao.showInfo(id);
    }

    @Override
    public List<Map> showlable(int id) {
        return hotaldao.showlable(id);
    }

    @Override
    public List<Map> showAll(int id) {
        return null;
    }

    @Override
    public List<Map> showpre(int id) {
        return hotaldao.showpre(id);
    }
}
