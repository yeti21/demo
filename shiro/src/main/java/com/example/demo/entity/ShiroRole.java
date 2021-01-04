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
@TableName("shiro_role")
@Builder
public class ShiroRole {
    private Long id;
    private String name;
    private String description;
    @TableField(value = "create_time")
    private Long createTime;
    @TableField(value = "update_time")
    private Long updateTime;
    private List<ShiroPermission> permissionList;

}
