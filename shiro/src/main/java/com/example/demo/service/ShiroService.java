package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.ShiroUser;
import org.apache.ibatis.annotations.Param;

public interface ShiroService extends IService<ShiroUser> {
    ShiroUser selectShiroUser(String name);
}
