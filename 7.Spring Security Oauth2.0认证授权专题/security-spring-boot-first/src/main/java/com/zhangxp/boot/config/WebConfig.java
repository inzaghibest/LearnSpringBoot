package com.zhangxp.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Administrator on 2020/6/25 0025.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    // 默认URL路径跳转到/login,此url为spring security提供
    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addViewController("/").setViewName("redirect:/login-view");
        viewControllerRegistry.addViewController("/login-view").setViewName("redirect:/login");

    }
}
