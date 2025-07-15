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
 * 虚拟实验课程老师关系表
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("vlab_course_teacher")
public class VlabCourseTeacher extends Model<VlabCourseTeacher> {

    private static final long serialVersionUID = 1L;

    /**
     * 虚拟实验课程老师关系id
     */
    @TableId("id")
    private Long id;

    /**
     * 实验课程id
     */
    @TableField("course_id")
    private Long courseId;

    /**
     * 老师id
     */
    @TableField("teacher_id")
    private Long teacherId;

    /**
     * 用户端是否展示
     */
    @TableField("is_show")
    private Integer isShow;

    /**
     * 序号
     */
    @TableField("c_index")
    private Integer cIndex;

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
