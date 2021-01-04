package com.example.demo.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.demo.entity.B;
import com.example.demo.dao.BMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

//java单行注释具体内容

/*
java多行注释的具体内容
 */

/**
 * java文档注释
 */

/**
 * @Slf4j相当于private final Logger log = LoggerFactory.getLogger(当前类名.class)
 */
@Slf4j
public class BController {


    @Autowired
    BMapper bMapper;

    @GetMapping("/aa")
    public List<B> a(){
     List<B> list=  bMapper.selectAllMybatis();
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return list;
    }


    @GetMapping("/bb")
   public B b(){
       B mu= bMapper.selectMybatisById(1L);
       log.info("mu={}",mu);
        return mu;
   }

   @GetMapping("/cc")
   public int  c(B b){
        String salt=IdUtil.fastSimpleUUID();
         b= b.builder()
               .name("user_3")
               .password(SecureUtil.md5("123456")+salt)
               .salt(salt)
               .email("1186939107@qq.com")
               .phoneNumber("12345678902")
               .status(1)
               .createTime(new DateTime())
                .lastLoginTime(null).lastUpdateTime(new DateTime()).build() ;
       bMapper.saveMybatis(b);
        return 1;
   }




   @GetMapping("/dd")
   public B d(){
      B b=  bMapper.test1("user_2");
        return b;
   }

   @GetMapping("/ee")
   public List<B> e(){
       List<B> list= bMapper.test2("1111");
       return list;
   }

   @GetMapping("/ff")
   public B test3(){
       B b= bMapper.test3(1);
       return b;
   }

    @GetMapping("/gg")
    public B test4(){
        B b= bMapper.test4(null);
        return b;
    }

    @GetMapping("/hh")
    public List<B> test5(){
        List<B> list= bMapper.test5(null);
        return list;
    }

    @GetMapping("/ii")
    public B test6(){
       B b=bMapper.test6(null,null);
       return b;
    }

    @GetMapping("/jj")
    public B test7(){
       B b=bMapper.test7(null,"user_1");
       return b;
    }

    @GetMapping("/kk")
    public List<B> test8(){
        List<B> list=bMapper.test8(null,null);
        return list;
    }

    @GetMapping("/ll")
    public void test9(){
        bMapper.test9(null,1,3);
    }

}
