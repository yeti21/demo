package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private String id;
    private String name;
    private List<Teacher> list;
}
