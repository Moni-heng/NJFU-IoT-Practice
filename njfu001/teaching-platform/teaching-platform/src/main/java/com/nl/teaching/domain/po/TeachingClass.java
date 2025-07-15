package com.nl.teaching.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 教学班级表
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("teaching_class")
public class TeachingClass extends Model<TeachingClass> {

    private static final long serialVersionUID = 1L;

    /**
     * 教学班id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 教学班名称
     */
    @TableField("name")
    private String name;

    /**
     * 任课老师
     */
    @TableField("lecturer")
    private String lecturer;

    /**
     * 开课时间
     */
    @TableField("start_date")
    private LocalDateTime startDate;

    /**
     * 结课时间
     */
    @TableField("end_date")
    private LocalDateTime endDate;

    /**
     * 教学班学期
     */
    @TableField("term_id")
    private Integer termId;

    /**
     * 课程id
     */
    @TableField("course_id")
    private Long courseId;

    /**
     * 课程计划发布状态：0未发布；1已发布，结合开始日期,结束日期，可区分为，新建，选课中，进行中，已结束
     */
    @TableField("release_state")
    private Integer releaseState;

    /**
     * 0:不可选，1：可选
     */
    @TableField("optional")
    private Integer optional;

    /**
     * 0正常；1删除
     */
    @TableField("deleted")
    private Integer deleted;

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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    @TableField(exist = false)
    private String courseName; //课程名称
    @TableField(exist = false)
    private String termName;//学期名称
    @TableField(exist = false)
    private String currentTerm;//当前学期
}
