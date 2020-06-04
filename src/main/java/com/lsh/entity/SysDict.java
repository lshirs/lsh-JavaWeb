package com.lsh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author lsh
 * @since 2020-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型
     */
    private String typeCode;

    /**
     * 字典名
     */
    private String value;

    /**
     * 字典值
     */
    private String label;

    private String description;

    private LocalDateTime createDate;

    private Integer createBy;

    private LocalDateTime updateDate;

    private Integer updateBy;

    @TableField(exist = false)
    private String delFlag;


}
