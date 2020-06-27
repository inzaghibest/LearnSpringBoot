package com.zhangxp.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by Administrator on 2020/6/25 0025.
 */
@SpringBootApplication
@MapperScan("com.zhangxp.boot.mapper")
public class SecuritySpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecuritySpringApplication.class, args);
    }
}
