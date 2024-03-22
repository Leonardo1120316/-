package com.example.usercenter.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 社团
 * @TableName club
 */
@TableName(value ="club")
@Data
public class Club implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long manageid;

    /**
     * 
     */
    private String clubname;

    /**
     * 
     */
    private String avatarUrl;

    /**
     * 社团包含的用户
     */
    private String student;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private Integer clubStatus;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer isDelete;

    /**
     * 社团介绍
     */
    private String introduce;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}