package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
@SpringBootApplication看作是
@Configuration:允许在 Spring 上下文中注册额外的 bean 或导入其他配置类
@EnableAutoConfiguration:启用 SpringBoot 的自动配置机制
@ComponentScan: 扫描被@Component (@Service,@Controller)注解的 bean，注解默认会扫描该类所在的包下所有的类
注解的集合
 */
@SpringBootApplication


public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
