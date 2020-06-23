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
    public String addUser(Integer id, String name, String password) {
        return userMapper.insert(1, "zhangxp", "test") > 0 ? "succes" : "failed";
    }
}
