package com.zhangxp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/6/21 0021.
 */
@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addUser(String name, Integer age) {
        int update = jdbcTemplate.update("insert into users values(null, ?, ?);", name, age);
        return update > 0 ? true : false;
    }
}
