package com.zhangxp.controller;

import com.zhangxp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/6/21 0021.
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/addUser")
    public String addUser(String name, Integer age) {
        return userMapper.insert(name, age) > 0 ? "succes" : "failed";
    }
}
