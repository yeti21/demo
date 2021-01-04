package com.example.demo.dao;

import com.example.demo.entity.Position;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AMapper {

  Teacher  selectTeacherAndPositionByName(@Param("name")String name );
  List<Teacher>  selectTeacherAndPosition();

  Position selectPositionTeacherByName(@Param("name")String name);
    List<Position> selectPositionTeacher();

   Position selectStudents(@Param("name") String name);

}
