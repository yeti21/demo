package com.example.demo.controller;

import cn.hutool.core.util.IdUtil;
import com.example.demo.domain.A;
import com.example.demo.mapper.AMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AController {

    @Autowired
    AMapper aMapper;

    @GetMapping("/a")
    public String a(){
        String salt=IdUtil.fastSimpleUUID();
        A a=A.builder().name("user_3").password("123456"+salt).salt(salt)
                .email("123456@qq.com").phoneNumber("12345678901")
                .status(1).createTime(new Date())
                .lastLoginTime(null).lastUpdateTime(new Date()).build();
        aMapper.insertUseGeneratedKeys(a);
        return "success";
    }

    @GetMapping("/b")
    public String b(){
        String salt=IdUtil.fastSimpleUUID();
        List<A> list=new ArrayList<>();
        for(int i=4;i<20;i++){
          A a=  A.builder().name("user_"+i).password("123456"+salt).salt(salt)
                    .email("123456"+i+"@qq.com").phoneNumber("12345678901"+i)
                    .status(1).createTime(new Date())
                    .lastLoginTime(null).lastUpdateTime(new Date()).build();
          list.add(a);
        }
        aMapper.insertList(list);
        return "success";
    }

    @GetMapping("/c")
    public String c(){
        aMapper.deleteByPrimaryKey(77L);
        for(int i=58;i>2;i--){
            aMapper.deleteUser(i);
        }
        return "success";
    }

    @GetMapping({"/d","/"})
    public A d(){
       A a=aMapper.selectByPrimaryKey(1L);
       return  a;
    }

    @GetMapping({"/e"})
    public List<A> e(){
        List<A> list=aMapper.selectAll();
        return  list;
    }

    /**
     * 查看表总共有几条数据
     * @return
     */
    @GetMapping("/f")
    public int f(){
      int i=  aMapper.selectCount(null);
      return i;
    }

    @GetMapping("/g")
    public void g(){
        //当前第几页
        int currentPage=2;
        //每页显示几条数据
        int pageSize=5;
        PageHelper.startPage(currentPage,pageSize);

        List<A> list=aMapper.selectAll();
        PageInfo<A> pageInfo=new PageInfo<>(list);
    }







}
