package com.zhangxp.boot.controller;

import com.zhangxp.boot.entity.AuthenticationRequest;
import com.zhangxp.boot.entity.MyUser;
import com.zhangxp.boot.service.AuthenticationService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zhangxp on 2020/6/24.
 */
@Controller
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;
    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        return "我是index控制类!";
    }

    @RequestMapping("/freemarkerIndex")
    public String freemarkerIndex() {
        return "freemarkerIndex";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@ModelAttribute AuthenticationRequest authenticationRequest, HttpSession httpSession) {
        MyUser myUser = authenticationService.authentication(authenticationRequest);
        System.out.println(myUser.getUsername());
        // 保存session
        httpSession.setAttribute(MyUser.SESSION_USER_KEY, myUser);
        return myUser.getUsername() + "登录成功!";
    }

    @RequestMapping(value = "/r/r1")
    @ResponseBody
    public String isLogin(HttpSession httpSession)
    {
        String fullname = null;
        Object object =  httpSession.getAttribute(MyUser.SESSION_USER_KEY);
        if (object == null)
        {
            fullname = "匿名";
        }else{
            MyUser myUser = (MyUser)object;
            fullname = myUser.getUsername();
        }
        return fullname + "访问资源r1";
    }

    @RequestMapping(value = "/r/r2")
    @ResponseBody
    public String isLogin1(HttpSession httpSession)
    {
        String fullname = null;
        Object object =  httpSession.getAttribute(MyUser.SESSION_USER_KEY);
        if (object == null)
        {
            fullname = "匿名";
        }else{
            MyUser myUser = (MyUser)object;
            fullname = myUser.getUsername();
        }
        return fullname + "访问资源r2";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "退出成功!";
    }

}
