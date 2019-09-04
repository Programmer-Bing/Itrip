package com.cssl.pojo.serviceimpl;


import com.cssl.pojo.dao.UserDao;
import com.cssl.pojo.po.User;
import com.cssl.pojo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

        @Autowired
        private UserDao ud;


    @Override
    public List<User> Cs() {
        return ud.Cs();
    }
}
