package com.cssl.pojo.dao;

import com.cssl.pojo.po.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CollectDao {

    /***
     *
     * 查询收藏的总数
     */
    public int SelectCollectCount(Collect co);

    /***
     *
     * 添加收藏
     * @return
     */
    public int InsertCollect(Collect co);


    /***
     *
     *
     * 个人查询收藏
     */
    public List<Collect> SelectCollectUser(Map<String,Object> map);


    /****
     *
     *
     *
     * 个人查询分页收藏总数
     */
    public int SelectCollectCountUser(int userid);


    /***
     *
     *
     * 取消收藏
     */
    public int DeleteCollect(Map<String,Object> map);





}
