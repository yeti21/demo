package com.example.demo.handler;

import com.example.demo.exception.JsonException;
import com.example.demo.exception.PageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 */

/**
 * @ControllerAdvice
 * 表示这是一个控制器增强类，当控制器发生异常且符合类中定义的拦截异常类，将会被拦截。
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     *@ExceptionHandler统一处理某一类异常
     */
    @ExceptionHandler(value=PageException.class)
    public ModelAndView a(PageException pageException){
        System.out.println("统一页面异常处理");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("message",pageException.getMessage());
        modelAndView.addObject("code",pageException.getCode());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public String b(JsonException jsonException){
        System.out.println("统一JSON异常处理");
        return jsonException.getMessage();
    }

}
