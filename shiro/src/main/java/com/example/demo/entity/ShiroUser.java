package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("shiro_user")
@Builder
public class ShiroUser {
    private Long id;
    private String username;
    private String password;
    private String salt;
    private String nickname;
    private String phone;
    private String email;
    private Long birthday;
    private Long sex;
    private Long status;
    @TableField(value = "create_time")
    private Long createtime;
    @TableField(value = "update_time")
    private Long updatetime;
    /**
     * @TableField(exist = false) 注解加载bean属性上，
     * 表示当前属性不是数据库的字段，但在项目中必须使用.
     */
    @TableField(exist = false)
    private List<ShiroRole> roleList;


}
