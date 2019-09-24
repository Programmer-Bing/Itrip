package com.cssl.pojo.service;

import com.cssl.pojo.po.Collect;

import java.util.List;
import java.util.Map;

public interface CollectService {


    public int SelectCollectCount(Collect co);


    public int InsertCollect(Collect co);

    public List<Collect> SelectCollectUser(Map<String,Object> map);

    public int SelectCollectCountUser(int userid);

    public int DeleteCollect(Map<String,Object> map);

}
