package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@TableName("orm_role")
@EqualsAndHashCode(callSuper = false)
/*
@Accessors用于配置getter和setter方法的生成结果
* */
@Accessors(chain = true)
public class MybatisPlusRole extends Model<MybatisPlusRole> {
  private Long  id;
  private  String name;

  /**
   * 主键值，ActiveRecord 模式这个必须有，否则 xxById 的方法都将失效！
   * 即使使用 ActiveRecord 不会用到 RoleMapper，RoleMapper 这个接口也必须创建
   */
  protected Serializable pkVal() {
    return this.id;
  }

}
