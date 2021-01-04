package com.example.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.MybatisPlusUser;
import org.springframework.stereotype.Repository;


@Repository
public interface MybatisPlusUserMapper  extends BaseMapper<MybatisPlusUser> {

}
