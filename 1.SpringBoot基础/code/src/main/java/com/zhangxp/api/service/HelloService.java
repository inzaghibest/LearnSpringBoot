package com.zhangxp.api.service;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/6/21 0021.
 */
@RestController
// @EnableAutoConfiguration注解实际上启动SpringMvc
// 这个注解扫包的范围为当前这个类
//@EnableAutoConfiguration
// @RestController注解:表示当前所定义的方法统一返回json,原理就是通过@Controller,@ResponseBody组合
//@ComponentScan("com.zhangxp.api.service")
public class HelloService {
    @RequestMapping("/hello")
    public String Hello(){
        return "张晓平第一次学习Srping Boot课程";
    }

//    public static void main(String[] args) {
//        SpringApplication.run(HelloService.class, args);
//    }
}
