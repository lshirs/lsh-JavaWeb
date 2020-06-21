package com.lsh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lsh
 * @since 2020-06-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String filmName;

    private String filmPic;

    private String actor;

    private String dirctor;

    private String nation;

    /**
     * 类别
     */
    private String type;

    private String language;

    private String summary;

    /**
     * 上映时间
     */
    private String releaseTime;

    /**
     * 逻辑删除表示位
     */
    private Integer delFlag;


}
