package com.lsh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SysRole {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String remark;
   // private String icon;
    private Integer createBy;
    private Date createDate;
    private Integer updateBy;
    private Date updateDate;
    @TableLogic
    private String delFlag;

    @TableField(exist = false)
    private List<SysMenu> menus;
}
