package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private int id;
    private String no;
    private String name;
    private List<Student> studentList;
    private Position position;
}
