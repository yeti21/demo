package com.example.demo.controller;

import com.example.demo.entity.Position;
import com.example.demo.entity.Teacher;
import com.example.demo.dao.AMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AController {
    /*
    @Autowired默认按照类型匹配注入bean
    如果有多个实现类，搭配@Qualifier(“实现类名称”)表明注入的是哪一个实现类的bean
     */
    @Autowired
    AMapper aMapper;

    @GetMapping("/a")
    public Teacher a(){
       return aMapper.selectTeacherAndPositionByName("风清扬");
    }

    @GetMapping("/b")
    public List<Teacher> b(){
        List<Teacher> list= aMapper.selectTeacherAndPosition();
        return list;
    }

    @GetMapping("/c")
     public Position c(){
     Position position=   aMapper.selectPositionTeacherByName("教授");
        return position;
     }

     @GetMapping("/d")
     public List<Position> d(){
      List<Position> list= aMapper.selectPositionTeacher();
        return  list;
     }

     @GetMapping("/e")
     public Position e(){
     Position p=   aMapper.selectStudents("教授");
        return p;
     }






}
