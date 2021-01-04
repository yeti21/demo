package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
* 实体要序列化一定要实现Serializable接口
* */
public class Redis implements Serializable {
    private static final long serialVersionUID = 1L;

    private  Long id;
    private  String name;
}
