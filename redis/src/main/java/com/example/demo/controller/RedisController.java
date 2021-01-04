package com.example.demo.controller;


import com.example.demo.entity.Redis;
import com.example.demo.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
public class RedisController {

    @Resource
    private RedisUtils redisUtils;

    @GetMapping("/a")
    public void a() {
        Redis ru = new Redis(1L, "陈亮");
        redisUtils.set("myKey", ru);
        log.info("{}", redisUtils.get("myKey"));
    }


}
