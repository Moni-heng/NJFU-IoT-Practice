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
 * 虚拟实验课程标签
 * </p>
 *
 * @author smy
 * @since 2025-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("course_tag")
public class CourseTag extends Model<CourseTag> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程标签关系id
     */
    @TableId("id")
    private Long id;

    /**
     * 课程id
     */
    @TableField("course_id")
    private Long courseId;

    /**
     * 标签id
     */
    @TableField("tag_id")
    private Long tagId;

    /**
     * 序号
     */
    @TableField("c_index")
    private Integer cIndex;

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
