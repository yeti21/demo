package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//全参构造方法
@AllArgsConstructor
//无参构造方法
@NoArgsConstructor
public class Thymeleaf {
    private String name;
    private Integer age;
}
