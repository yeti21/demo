package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*
*@TableName指定表名注解,默认下划线转驼峰 table_name   tableName
* 如果数据表和类名不对应,会报错，找不到对应表。
* */
@TableName( value = "orm_user" )
public class MybatisPlusUser implements Serializable {
    private static final long serialVersionUID =1L;


    /**
     * 主键生成策略(自增id,uuid,雪花算法，redis,zookeeper)
     * mybatisplus默认是基于雪花算法的自增id
     */
    /*
    *@TableId指定表主键名的注解，默认是叫id,
    * 如果类主键名不叫id，需要指定表主键名字，否则报错
    * */
    @TableId(value = "id",type= IdType.ASSIGN_ID)
    private Long id1;

    /**
     * 用户名
     */
    private String name;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 加密使用的盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 状态，-1：逻辑删除，0：禁用，1：启用
     */
    private Integer status;

    /**
     * 创建时间
     * 按照指定格式输出
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    /*
    * @TableField字段注解，默认表字段下划线转类属性驼峰
    * 如果两者不对应，会报错，需要用@TableField指定表字段名
    *  fill字段自动填充策略（INSERT插入时填充，UPDATE更新时填充，INSERT_UPDATE插入和更新时填充）
    * */
    @TableField(value="create_time",fill=FieldFill.INSERT)
    private Date createTime;

    /**
     * 上次登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date lastLoginTime;

    /**
     * 上次更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;

    /*
    多读的场景用乐观锁，多写用悲观锁
    * @Version乐观锁注解
    * */
    @Version
    private Integer version;


}
