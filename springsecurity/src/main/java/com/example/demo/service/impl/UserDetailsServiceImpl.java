package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 自定义登录逻辑
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    /**
     * 密码加密
     * PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * (String s)前端的用户名
     * @param
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("执行自定义登录逻辑");
        /**
         * 去数据库查询数据admin
         */
        if(!"root".equals(s)){
            throw new UsernameNotFoundException("用户不存在");
        }
        System.out.println("用户存在");
        /**
         *数据库密码123456
         */
       String password=passwordEncoder.encode("123456");
        return new User(s,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
