package com.atguigu.schoolspringboot.config;

import com.atguigu.schoolspringboot.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //设置文件虚拟路径映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:C:\\IdeaProjects\\springboot学习\\schoolspringboot\\src\\main\\resources\\static\\upload\\");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/file/**", "/announcement/**",
                        "/dataStatistics/", "/message/**", "/teacher/**",
                        "/grade/**", "/sysClass/**", "/student/**", "/", "#//page/**");
    }


}
