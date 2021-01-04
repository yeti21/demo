package com.example.demo.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.MybatisPlusUser;
import com.example.demo.service.MybatisPlusUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class MybatisPlusUserController {

    @Autowired
   private MybatisPlusUserService mybatisPlusUserService;

    /*
    * 新增一个
    * */
    @GetMapping("mybatisplususer1")
    public int  a(MybatisPlusUser mybatisPlusUser){
        String salt= IdUtil.fastSimpleUUID();
        MybatisPlusUser mpu=mybatisPlusUser.builder()
                .name("user_5")
                .password(SecureUtil.md5("123456"+salt))
                .salt(salt)
                .email("1186939102@qq.com")
                .phoneNumber("12345678904")
                .status(1)
                .lastLoginTime(new DateTime())
                .build();
      mybatisPlusUserService.save(mpu);
      return 1;
    }

    /*
    * mybatis一级缓存和二级缓存问题？？？
    * */
    @GetMapping("mybatisplususer2")
    public void b(){

       MybatisPlusUser mpu1=  mybatisPlusUserService.getById(1L);
       MybatisPlusUser mpu2= mybatisPlusUserService.getById(1L);
       log.info("{}",mpu1==mpu2);
    }

    /*
    批量新增
    * */
    @GetMapping("mybatisplususer3")
    public int c(){
      List<MybatisPlusUser> list= new ArrayList();
        for(int i=6;i<=14;i++){
        String salt=IdUtil.fastSimpleUUID();
        MybatisPlusUser mpu=MybatisPlusUser.builder()
              .name("user_"+i)
                 .password(SecureUtil.md5("123456"+salt))
                 .salt(salt)
                 .email("user_"+i+"@qq.com")
                 .phoneNumber("1234567890"+i)
                 .status(1)
                 .lastLoginTime(new Date()).build();
        list.add(mpu);
        }
        mybatisPlusUserService.saveBatch(list);
        return 1;
    }

    /*
    * 修改
    * */
    @GetMapping("mybatisplususer4")
    public int d(){
        MybatisPlusUser mpu=mybatisPlusUserService.getById(1L);
        mpu.setName("修改数据");
        mybatisPlusUserService.updateById(mpu);
    return 1;
    }


    /*
    * 查询单个记录
    * */
    @GetMapping("mybatisplususer5")
    public MybatisPlusUser a5(){
       MybatisPlusUser mpu=mybatisPlusUserService.getById(1L);
        return mpu;
    }

    /*
 查询所有数据
 * */
    @GetMapping("mybatisplususer6")
    public List<MybatisPlusUser> a6(){
        List<MybatisPlusUser> list=mybatisPlusUserService.list();
        return  list;
    }

   /*
   * 分页查询
   * */
   @GetMapping("mybatisplususer7")
   public void a7(){
       /*
       * size每页显示多少数据
       * current 当前第几页
       * */
       IPage<MybatisPlusUser> page=new Page<MybatisPlusUser>(2,5);
       /*
       * 条件构造器 Wrapper
       * */
       QueryWrapper<MybatisPlusUser> wrapper=new QueryWrapper<>();
       IPage<MybatisPlusUser> IPage= mybatisPlusUserService.page(page,wrapper);
       log.info(" {}",IPage.getSize());
       log.info("{}",IPage.getTotal());
       log.info(" {}",IPage.getRecords());
   }

   /*
   * 测试乐观锁
   * */
    @GetMapping("/mybatisplususer8")
    public void a8(){


    }




}
