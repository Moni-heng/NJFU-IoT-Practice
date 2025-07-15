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
 * 互动问题的回答或评论
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("interaction_reply")
public class InteractionReply extends Model<InteractionReply> {

    private static final long serialVersionUID = 1L;

    /**
     * 互动问题的回答id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 互动问题问题id
     */
    @TableField("question_id")
    private Long questionId;

    /**
     * 回复的上级回答id
     */
    @TableField("answer_id")
    private Long answerId;

    /**
     * 回答者id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 回答内容
     */
    @TableField("content")
    private String content;

    /**
     * 回复的目标用户id
     */
    @TableField("target_user_id")
    private Long targetUserId;

    /**
     * 回复的目标回复id
     */
    @TableField("target_reply_id")
    private Long targetReplyId;

    /**
     * 评论数量
     */
    @TableField("reply_times")
    private Integer replyTimes;

    /**
     * 点赞数量
     */
    @TableField("liked_times")
    private Integer likedTimes;

    /**
     * 是否被隐藏，默认false
     */
    @TableField("hidden")
    private Boolean hidden;

    /**
     * 是否匿名，默认false
     */
    @TableField("anonymity")
    private Boolean anonymity;

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
     * 课程所在学期
     */
    @TableField("term_id")
    private Integer termId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
