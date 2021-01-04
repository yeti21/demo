package com.example.demo.controller;

import com.example.demo.constant.Status;
import com.example.demo.exception.JsonException;
import com.example.demo.exception.PageException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AController {

    //@GetMapping("/{path}")
    /**
     * @PathVariable,接收请求路径中占位符的值。
     * 通过 @PathVariable
     * 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
     */
    public void a(@PathVariable("path")String path){
           if(!"index".equals(path)){
               throw new PageException(500,"服务器错误");
           }

    }

    @GetMapping("/{path}")
    @ResponseBody
    public void  b(@PathVariable("path")String path) {
        if (!"index".equals(path)) {
            throw new JsonException(Status.UNKNOWN_ERROR);
        }

    }





}
