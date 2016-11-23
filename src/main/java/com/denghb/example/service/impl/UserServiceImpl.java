package com.denghb.example.service.impl;

import com.denghb.dbhelper.DbHelper;
import com.denghb.example.model.User;
import com.denghb.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ppd on 16/11/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DbHelper db;

    @Override
    public User queryByName(String name) {
        return db.queryForObject("select * from user where name=? limit 0,1",User.class,name);
    }
}
