package com.example.day07SessionPrac;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor())
                .addPathPatterns("/admin");


        // TestInterceptor 등록하기
        registry.addInterceptor(new TestInterceptor())
                .addPathPatterns("/test");

        registry.addInterceptor(new LoggingInterceptor())
                .addPathPatterns("/signup");


    }
}
