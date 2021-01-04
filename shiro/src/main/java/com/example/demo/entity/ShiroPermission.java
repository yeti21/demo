package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("shiro_permission")
@Builder
public class ShiroPermission {
    private Long id;
    private String name;
    private String url;
    private Integer type;
    private String permission;
    private String method;
    private Integer sort;
    @TableField("parent_id")
    private Long parentId;

}
