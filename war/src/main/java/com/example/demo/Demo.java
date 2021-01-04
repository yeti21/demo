package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class Demo extends SpringBootServletInitializer {
    /**
     *需要打包成war包，需要继承{@link SpringBootServletInitializer}类，重写configure方法。
     *和项目的启动类在一个包下
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        /**
         * application的类名
         */
        return builder.sources(WarApplication.class);
    }
}
