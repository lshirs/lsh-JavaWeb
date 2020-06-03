package com.lsh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SysUser {
    @TableId(type = IdType.AUTO) //主键自动增加
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String mobile;
    private Integer status;
    //private String userType;
    private Integer createBy;
    private Date createDate;
    private Integer updateBy;
    private Date updateDate;
    //@TableLogic 设置逻辑字段
    @TableLogic
    private String delFlag;


    //mybatis 忽略属性的数据库关系
    @TableField(exist = false)
    private List<SysRole> roles;
}
