package com.zhangxp.controller;

import com.zhangxp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/6/21 0021.
 */
@RestController
public class MyBaseController {
    @Autowired
    public UserService userService;

    @RequestMapping("/addUser")
    public String addUser(String name, Integer age) {
        return userService.addUser("zhangxp", 13) ? "success": "falied";
    }

}
