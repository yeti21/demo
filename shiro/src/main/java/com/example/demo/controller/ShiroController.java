package com.example.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ShiroController {

    @GetMapping({"/index","/"})
    public String a(Model model){
        model.addAttribute("message","欢迎光临");
        return "index";
    }

    @GetMapping("/user/add")
    public  String  b(){
        return  "user/add";
    }

    @GetMapping("/user/update")
    public  String  c(){
        return  "user/update";
    }

    @GetMapping("/login")
    public  String  d(){
        return  "login";
    }

    @GetMapping("/toLogin")
    public  String  e(String username,String password,Model model){
     Subject subject=SecurityUtils.getSubject();
     //封装用户数据
     UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
     try{
         //执行登录方法
         subject.login(usernamePasswordToken);
         return "index";//登录成功返回首页
     }catch (UnknownAccountException e){//用户不存在异常
         model.addAttribute("message","用户不存在");
         return "login";
     }catch (IncorrectCredentialsException e){
         model.addAttribute("message","密码错误");
         return "login";
     }
    }

    @GetMapping("/unauthorized")
    @ResponseBody
    public String f(){
        return "没有权限访问该页面";
    }

}
