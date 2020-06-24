package com.zhangxp.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zhangxp on 2020/6/24.
 */
@Controller
public class AuthController {
    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        return "我是index控制类!";
    }

    @RequestMapping("/freemarkerIndex")
    public String freemarkerIndex() {
        return "freemarkerIndex";
    }
}
