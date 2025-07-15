package com.nl.teaching.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 课程内容，主要是一些大文本
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("course_content")
public class CourseContent extends Model<CourseContent> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程内容id
     */
    @TableId("id")
    private Long id;

    /**
     * 课程介绍
     */
    @TableField("course_introduce")
    private String courseIntroduce;

    /**
     * 课程详情
     */
    @TableField("course_detail")
    private String courseDetail;

    /**
     * 部门id
     */
    @TableField("dep_id")
    private Long depId;

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
     * 创建人
     */
    @TableField("creater")
    private Long creater;

    /**
     * 更新人
     */
    @TableField("updater")
    private Long updater;

    /**
     * 逻辑删除
     */
    @TableField("deleted")
    private Integer deleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
