package com.zhangxp.boot;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;
/**
 * Created by Administrator on 2020/6/22 0022.
 */
@MapperScan("com.zhangxp.boot.mapper")
@SpringBootApplication
public class MybatisSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringBootApplication.class);
    }
}
