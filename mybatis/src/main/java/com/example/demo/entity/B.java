package com.example.demo.entity;

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
/*
 *对象的创建工作更提供Builder方法,对外保持private setter,而对属性的赋值采用Builder的方式,
 * 不对外公开属性的写操作.
 * @Builder声明实体，表示可以进行Builder方式初始化
 *
 *@Builder注解赋值新对象
 * mybatisUser mu=mybatis.builder().name("zzl").password("345").build();
 * @Builder注解修改原对象的属性值
 * mu=mybatis.toBuilder().name("zzl").password("123").build();
 * */
@Builder
/*
序列化定义： 把原本在内存中的对象状态变成可存储或传输的过程称之为序列化。
           序列化之后，就可以把序列化后的内容写入磁盘，或者通过网络传输到别的机器上，
           或者保存到数据库（持久化对象）。
序列化前的对象和反序列化后得到的对象，内容是一样的(且对象中包含的引用也相同)，但两个对象的地址不同。
换句话说，序列化操作可以实现对任何可Serializable对象的”深度复制（deep copy）"。

* 什么情况下需要序列化:
1.当你想把的内存中的对象状态保存到一个文件中或者数据库中，以便可以在以后重新创建精确的副本
2.当你想用套接字在网络上传送对象的时候(从一个应用程序域发送到另一个应用程序域中)
3.当你想通过RMI传输对象的时候

序列化策略：一个设为固定的 1L，另一个是随机生成一个不重复的 long 类型数据（实际上是使用 JDK 工具生成）
一般如果没有特殊需求，用默认的 1L 就可以，这样可以确保反序列化成功，
因为不同的序列化id之间不能进行序列化和反序列化。
* */
public class B implements Serializable {
    private static final long serialVersionUID = -7953761300041643974L;

    /**
     * 主键
     */
    private Long id;

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
     * 状态码
     * -1：逻辑删除，0：禁用，1：启用
     */
    private Integer status;

    /**
     * 创建时间
     * 按照指定格式输出
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date createTime;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 上次更新时间
     */
    private Date lastUpdateTime;



}
