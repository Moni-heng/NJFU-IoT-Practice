package com.nl.teaching.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 教师详情表
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_detail")
public class UserDetail extends Model<UserDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 关联用户id
     */
    @TableId("id")
    private Long id;

    /**
     * 用户类型：1-员工, 2-普通学员，3-老师
     */
    @TableField("type")
    private Integer type;

    /**
     * 名字
     */
    @TableField("name")
    private String name;

    /**
     * 性别：0-男性，1-女性
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 头像地址
     */
    @TableField("icon")
    private String icon;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * QQ号码
     */
    @TableField("qq")
    private String qq;

    /**
     * 生日
     */
    @TableField("birthday")
    private LocalDate birthday;

    /**
     * 职位
     */
    @TableField("job")
    private String job;

    /**
     * 省
     */
    @TableField("province")
    private String province;

    /**
     * 市
     */
    @TableField("city")
    private String city;

    /**
     * 区
     */
    @TableField("district")
    private String district;

    /**
     * 个人介绍
     */
    @TableField("intro")
    private String intro;

    /**
     * 形象照地址
     */
    @TableField("photo")
    private String photo;

    /**
     * 角色id
     */
    @TableField("role_id")
    private Long roleId;

    /**
     * 购买课程数量，学生才有该字段信息
     */
    @TableField("course_amount")
    private Integer courseAmount;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 创建者id
     */
    @TableField("creater")
    private Long creater;

    /**
     * 更新者id
     */
    @TableField("updater")
    private Long updater;

    /**
     * 部门id
     */
    @TableField("dep_id")
    private Long depId;

    /**
     * 职称
     */
    @TableField("title")
    private String title;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
