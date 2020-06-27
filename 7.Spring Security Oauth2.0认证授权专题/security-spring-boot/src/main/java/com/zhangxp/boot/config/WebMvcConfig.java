package com.zhangxp.boot.config;

import com.zhangxp.boot.interceptor.SimpleAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by Administrator on 2020/6/25 0025.
 * 配置使用拦截器
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{
    @Autowired
    private SimpleAuthInterceptor simpleAuthInterceptor;


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleAuthInterceptor)
                .addPathPatterns("/r/*")//拦截的访问路径，拦截所有
                .excludePathPatterns("/freemarkerIndex");//排除登录路径
        super.addInterceptors(registry);
    }
    
}
