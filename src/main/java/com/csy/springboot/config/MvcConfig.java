package com.csy.springboot.config;

import com.csy.springboot.intereptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置类，增加自定义拦截器和解析器
 * @author ScienJus
 * @date 2015/7/30.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TokenInterceptor authorizationInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor);
    }

}
