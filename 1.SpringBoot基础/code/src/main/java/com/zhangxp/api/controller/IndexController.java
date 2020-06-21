package com.zhangxp.api.controller;

/**
 * Created by Administrator on 2020/6/21 0021.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        return "我是index控制类!";
    }
}
