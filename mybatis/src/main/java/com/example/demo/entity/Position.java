package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Position {
    private int id;
    private String name;
    private List<Teacher> teacherlist;
}
