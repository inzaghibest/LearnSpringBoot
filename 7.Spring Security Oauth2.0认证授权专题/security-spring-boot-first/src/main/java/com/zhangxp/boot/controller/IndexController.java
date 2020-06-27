package com.zhangxp.boot.controller;

import com.zhangxp.boot.entity.MyUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2020/6/25 0025.
 */
@Controller
public class IndexController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login-success")
    @ResponseBody
    public String logSuccess() {
        // 提示用户名称成功
        return getUserName() + "登录成功!";
    }


    @RequestMapping(value = "/r/r1")
    @ResponseBody
    public String r1() {
        return "访问资源r1";
    }

    @RequestMapping(value = "/r/r2")
    @ResponseBody
    public String r2() {
        return "访问资源r2";
    }


//    @RequestMapping("/")
//    public String index() {
//        return "我是根路径页面!";
//    }

    // 登录成功后，获取登录用户相关信息的方法
    private String getUserName() {
        String username = null;
       Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        // 用户身份
        Object principal = authentication.getPrincipal();
        if (principal == null)
        {
            username = "匿名";
        }else if (principal instanceof UserDetails)
        {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        }else
        {
            username = principal.toString();
        }
        return username;
    }
}
