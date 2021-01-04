package com.example.demo.config;

import com.example.demo.handler.MyAuthenticationFailureHandler;
import com.example.demo.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 授权规则
         */
        http.authorizeRequests()
                /**
                 * 放行，无需认证
                 */
                .antMatchers("/" , "/views/login", "/views/error.html").permitAll()
                /**
                 * 需要认证才能访问
                 */
                .anyRequest().authenticated()
                .and()
                /**
                 * 需要认证的跳转到自定义登录页面
                 * security默认登录界面（默认用户名user,密码自动生成）
                 *
                 */
                .formLogin().loginPage("/views/login")
                /**
                 * 走{@link UsernamePasswordAuthenticationFilter} 这个类
                 * 自定义登录表单参数
                 */
                .usernameParameter("name")
                .passwordParameter("pw")
                /**
                 *必须和表单action一样，执行认证。
                 *
                 */
                .loginProcessingUrl("/toLogin")
                /**
                 * 成功登录的页面,必须是post请求 @PostMapping()
                 * 默认是转发
                 * 自己自定义
                 */
                //.successForwardUrl("/views/success")
                .successHandler(new MyAuthenticationSuccessHandler("/demo/views/success.html"))
                /**
                 * 登录失败，post请求
                 */
                //.failureForwardUrl("/views/error");
                .failureHandler(new MyAuthenticationFailureHandler("/demo/views/error.html"))
                .and()
                .logout();
        /**
         * 关闭csrf防护，不然没法和数据库进行验证。
         */
        http.csrf().disable();
    }

    @Bean
    PasswordEncoder a(){
        return new BCryptPasswordEncoder();
    }

}
