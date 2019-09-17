package com.cssl.pojo.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    private  Jedis js=new Jedis("127.0.0.1",6379);

    public Jedis SetKey(String key,String value){

        js.set(key,value);
        js.expire(key,300);

        return  js;
    }


    public String getKey(String key){

        js.get(key);
        js.expire(key,300);
        return  js.get(key);
    }


    public void aa(){

    }

}
