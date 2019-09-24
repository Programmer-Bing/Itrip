package com.cssl.pojo.service.impl;

import com.cssl.pojo.dao.CollectDao;
import com.cssl.pojo.po.Collect;
import com.cssl.pojo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao cd;


     @Override
    public int SelectCollectCount(Collect co) {
        return cd.SelectCollectCount(co);
    }


    @Override
    public int InsertCollect(Collect co) {
        return cd.InsertCollect(co);
    }

    @Override
    public List<Collect> SelectCollectUser(Map<String,Object> map) {
        return cd.SelectCollectUser(map);
    }


    @Override
    public int SelectCollectCountUser(int userid) {
        return cd.SelectCollectCountUser(userid);
    }

    @Override
    public int DeleteCollect(Map<String, Object> map) {
        return cd.DeleteCollect(map);
    }


}


