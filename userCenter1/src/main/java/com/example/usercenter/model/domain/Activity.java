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
 * @TableName activity
 */
@TableName(value ="activity")
@Data
public class Activity implements Serializable {
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
    private String activityname;

    /**
     * 
     */
    private String avatarUrl;

    /**
     * 参加活动的用户
     */
    private String student;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private Integer activityStatus;

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
     * 活动介绍
     */
    private String introduce;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}