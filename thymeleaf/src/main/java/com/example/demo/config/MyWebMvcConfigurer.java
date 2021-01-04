package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决无法重定向问题
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/thymeleaf/hello.html")
                .setViewName("/thymeleaf/hello.html");
    }


}
