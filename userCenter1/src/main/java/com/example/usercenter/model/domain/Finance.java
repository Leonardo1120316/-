package com.example.usercenter.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动
 * @TableName finance
 */
@TableName(value ="finance")
@Data
public class Finance implements Serializable {
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
    private String financename;

    /**
     * 
     */
    private String avatarUrl;

    /**
     * 财务负责人
     */
    private String manage;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private Integer financeStatus;

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
     * 财务详情介绍
     */
    private String introduce;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}