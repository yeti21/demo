package com.example.demo.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;
    public MyAuthenticationSuccessHandler(String url) {
        this.url=url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        User user= (User) authentication.getPrincipal();
        System.out.println(user.getUsername());
        //直接输出null
        System.out.println(user.getPassword());
        //权限
        System.out.println(user.getAuthorities());
        httpServletResponse.sendRedirect(url);

    }
}
