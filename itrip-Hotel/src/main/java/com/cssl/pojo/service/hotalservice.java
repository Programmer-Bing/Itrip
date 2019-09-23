package com.cssl.pojo.service;

import com.cssl.pojo.hotal;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface hotalservice {

    List<Map> hotel(int id);

    List<Map> showInfo(int id);

    List<Map> showlable(int id);

    List<Map> showAll(int id);

    List<Map> showpre(int id);

}
