package com.example.demo.dao;

import com.example.demo.entity.B;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @Mapper
* 为了不再写mapper映射文件,为了把mapper这个DAO交給Spring管理
* 这个接口中不可以定义同名的方法，因为会生成相同的id,也就是说这个接口是不支持重载的
 */

/**
 * 对于多个参数来说，每个参数之前都要加上@Param注解，要不然会找不到对应的参数进而报错
 */
@Mapper
@Repository
public interface BMapper {

@Select("select * from orm_user")
List<B> selectAllMybatis();

@Select("select * from orm_user where id=#{id}")
B selectMybatisById(@Param("id") Long  id);

 @Insert("insert into orm_user(name,password,salt,email,phone_number,status,create_time,last_login_time,last_update_time) values(#{mybatis.name},#{mybatis.password},#{mybatis.salt},#{mybatis.email},#{mybatis.phoneNumber},#{mybatis.status},#{mybatis.createTime},#{mybatis.lastLoginTime},#{mybatis.lastUpdateTime})")
 int saveMybatis(@Param("mybatis") B mybatis);



 B test1(@Param("name") String name);

 List<B> test2(@Param("name")String name);

 B test3(@Param("id")Integer id);

 B test4(@Param("name") String name);

 List<B> test5(@Param("name") String name);

 B test6(@Param("id") Integer id,@Param("name") String name);

 B test7(@Param("status") Integer status,@Param("name") String name);

 List<B> test8(@Param("status") Integer status,@Param("name") String name);

 void test9(@Param("name")String name,@Param("status") Integer status,@Param("id")Integer id);






}
