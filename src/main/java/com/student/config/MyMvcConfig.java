package com.student.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //设置页面的跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("auth-login");
        registry.addViewController("/auth-login").setViewName("auth-login");
        registry.addViewController("/index").setViewName("index");
    }

    //设置拦截的目录，以及要排除的目录
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/auth-login", "/manager/login", "/css/**", "/fonts/**", "/img/**", "/js/**");
    }
}
