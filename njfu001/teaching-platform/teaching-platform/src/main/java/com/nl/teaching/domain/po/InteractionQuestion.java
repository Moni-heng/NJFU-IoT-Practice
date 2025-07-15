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
 * 互动提问的问题表
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("interaction_question")
public class InteractionQuestion extends Model<InteractionQuestion> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，互动问题的id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 互动问题的标题
     */
    @TableField("title")
    private String title;

    /**
     * 问题描述信息
     */
    @TableField("description")
    private String description;

    /**
     * 所属课程id
     */
    @TableField("course_id")
    private Long courseId;

    /**
     * 所属课程章id
     */
    @TableField("chapter_id")
    private Long chapterId;

    /**
     * 所属课程节id
     */
    @TableField("section_id")
    private Long sectionId;

    /**
     * 提问学员id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 最新的一个回答的id
     */
    @TableField("latest_answer_id")
    private Long latestAnswerId;

    /**
     * 问题下的回答数量
     */
    @TableField("answer_times")
    private Integer answerTimes;

    /**
     * 是否匿名，默认false
     */
    @TableField("anonymity")
    private Boolean anonymity;

    /**
     * 是否被隐藏，默认false
     */
    @TableField("hidden")
    private Boolean hidden;

    /**
     * 管理端问题状态：0-未查看，1-已查看
     */
    @TableField("status")
    private Integer status;

    /**
     * 提问时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 课程所在学期
     */
    @TableField("term_id")
    private Integer termId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
