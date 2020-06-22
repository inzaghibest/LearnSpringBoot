package com.zhangxp.boot.controller;

import com.zhangxp.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/6/22 0022.
 */
@RestController
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    private UserService userService;

    @RequestMapping(value = "/c", method = RequestMethod.GET)
    public String create () {
        return "Hello SpringBoot MyBatis";
    }
}
