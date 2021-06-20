package com.dutu.admin.config;

import com.dutu.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dutu
 * @date 2021-03-04 20:34
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")   //所有请求都被拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/query");
    }
}
