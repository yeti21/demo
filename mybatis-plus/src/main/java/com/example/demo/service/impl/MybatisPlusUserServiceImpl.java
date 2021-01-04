package com.example.demo.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.MybatisPlusUser;
import com.example.demo.dao.MybatisPlusUserMapper;
import com.example.demo.service.MybatisPlusUserService;
import org.springframework.stereotype.Service;

@Service
public class MybatisPlusUserServiceImpl extends ServiceImpl<MybatisPlusUserMapper, MybatisPlusUser> implements MybatisPlusUserService {


}
