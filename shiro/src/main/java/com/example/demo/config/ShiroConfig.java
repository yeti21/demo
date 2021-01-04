package com.example.demo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean a(@Qualifier("b") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /**
        shiro内置过滤器
        anon:无需认证就能访问
        authc：必须认证才能访问
        user：必须有记住我才能用
        perms:拥有对某个资源的权限才能访问
        role:拥有某个角色权限才能访问
         */
        Map<String,String> map=new LinkedHashMap<>();
        /**
         *授权
         *未授权跳转到未授权页面
         */
        map.put("/user/add","perms[user:add]");
        /**
         *拦截
         */
        map.put("/user/*","authc");




        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        /**
         *没有登陆认证跳转的页面
         */
        shiroFilterFactoryBean.setLoginUrl("/login");
        /**
         * 未授权页面
         */
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        return shiroFilterFactoryBean;
    }


    @Bean
    public  DefaultWebSecurityManager  b(@Qualifier("c") Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return  defaultWebSecurityManager;
    }

    /**
    使用@Bean 注解表明方法需要交给Spring进行管理,bean的名称默认采用的是 "方法名首字母小写"的配置方式
    方法Spring只会调用一次
     */
    @Bean
    public Realm c(){
        Realm realm=new Realm();
        return realm;
    }

}
