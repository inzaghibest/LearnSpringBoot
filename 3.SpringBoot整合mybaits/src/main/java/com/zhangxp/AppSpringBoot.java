package com.zhangxp;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2020/6/21 0021.
 */
@SpringBootApplication
@MapperScan("com.zhangxp.mapper")
public class AppSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(AppSpringBoot.class);
    }
}
