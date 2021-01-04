package com.example.demo.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.ShiroUser;
import com.example.demo.service.ShiroService;
import com.example.demo.service.impl.ShiroServiceImpl;
import lombok.SneakyThrows;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

/*
* info信息
* Authentication 认证/登录
* AuthenticationInfo 验证信息
* AuthorizationInfo 授权信息
*
* */
public class Realm  extends AuthorizingRealm {

    @Autowired
    ShiroService shiroService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权执行");

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission("user:add");
        //拿到当前登录认证成功的对象
        Subject subject= SecurityUtils.getSubject();
        ShiroUser  shiroUser= (ShiroUser) subject.getPrincipal();
        return simpleAuthorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       System.out.println("认证执行");
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        //获得数据库的密码
//        QueryWrapper<ShiroUser> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("username",usernamePasswordToken.getUsername());
//        ShiroUser shiroUser=shiroService.getOne(queryWrapper);
        ShiroUser shiroUser= shiroService.selectShiroUser(usernamePasswordToken.getUsername());
        if(shiroUser==null){
            return null;//抛出异常，UnknownAccountException
        }
        //密码认证，shiro做,加密了
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(shiroUser,shiroUser.getPassword(),"");
        return simpleAuthenticationInfo;
    }
}
