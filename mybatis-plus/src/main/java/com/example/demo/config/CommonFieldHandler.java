package com.example.demo.config;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
* MybatisPLus通用字段填充处理
* */
@Component
public class CommonFieldHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
     this.setFieldValByName("createTime",new Date(),metaObject);
     this.setFieldValByName("lastUpdateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
         this.setFieldValByName("lastUpdateTime",new Date(),metaObject);
    }
}
