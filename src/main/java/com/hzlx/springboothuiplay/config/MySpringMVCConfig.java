package com.hzlx.springboothuiplay.config;

import com.hzlx.springboothuiplay.interceptors.SessionInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot-hui-play
 * 2023/5/18 11:44
 * 星期四
 */
@Configuration
public class MySpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptors sessionInterceptors ;

    /**
     * 添加过滤器的
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptors).addPathPatterns("/jump/**");
    }
}
