package com.zhangxp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by Administrator on 2020/6/21 0021.
 */
@SpringBootApplication
public class AppSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(AppSpringBoot.class, args);
    }
//    @SpringBootApplication注解等同于@Configuration+@EnableAutoConfiguration+@ComponentScan
//    SpringBoot的启动类的扫包范围就是启动类所在包com.zhangxp.api.service
}
