package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.ShiroMapper;
import com.example.demo.entity.ShiroUser;
import com.example.demo.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroServiceImpl extends ServiceImpl<ShiroMapper, ShiroUser> implements ShiroService {

    @Autowired
    ShiroMapper shiroMapper;
    @Override
    public ShiroUser selectShiroUser(String name) {
       ShiroUser shiroUser=shiroMapper.selectShiroUser(name);
        return shiroUser;
    }
}
