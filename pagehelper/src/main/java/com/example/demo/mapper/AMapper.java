package com.example.demo.mapper;

import com.example.demo.domain.A;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface AMapper extends Mapper<A>, MySqlMapper<A> {
    void deleteUser(@Param("id") int id);
}
