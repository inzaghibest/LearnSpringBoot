package com.zhangxp.boot.controller;

import com.zhangxp.boot.entity.User;
import com.zhangxp.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by Administrator on 2020/6/22 0022.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/c", method = RequestMethod.GET)
    public String create () {
        for (int i = 0; i<100; i++)
        {
            User user = new User();
            String temp = "user" + i;
            user.setUsername(temp);
            Random random = new Random();
            int pass = random.nextInt(10);
            user.setPassword("332323" + pass);
            userService.createUser(user);
        }
        return "success!";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id) {
        User user = new User();
        System.out.println(id);
        user.setId(id);
        user.setUsername("update" + id);
        user.setPassword("update" + id);
        userService.updateUser(user);
        return "update suceess!";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String selectUser() {
        System.out.println("-----------------------------");
         userService.findUser();
         return "select success!";
    }
    public String test() {
        return "test";
    }
}
