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
 * 在线课程
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("course_catalogue")
public class CourseCatalogue extends Model<CourseCatalogue> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程目录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 目录名称
     */
    @TableField("name")
    private String name;

    /**
     * 是否支持试看
     */
    @TableField("trailer")
    private Integer trailer;

    /**
     * 课程id
     */
    @TableField("course_id")
    private Long courseId;

    /**
     * 目录类型1：章，2：节，3：测试
     */
    @TableField("type")
    private Integer type;

    /**
     * 所属章id，只有小节和测试有该值，章没有，章默认为0
     */
    @TableField("parent_catalogue_id")
    private Long parentCatalogueId;

    /**
     * 媒资id
     */
    @TableField("media_id")
    private Long mediaId;

    /**
     * 视频id
     */
    @TableField("video_id")
    private Long videoId;

    /**
     * 视频名称
     */
    @TableField("video_name")
    private String videoName;

    /**
     * 直播开始时间
     */
    @TableField("living_start_time")
    private LocalDateTime livingStartTime;

    /**
     * 直播结束时间
     */
    @TableField("living_end_time")
    private LocalDateTime livingEndTime;

    /**
     * 是否支持回放
     */
    @TableField("play_back")
    private Integer playBack;

    /**
     * 视频时长，以秒为单位
     */
    @TableField("video_duration")
    private Integer videoDuration;

    /**
     * 用于章节排序
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

    /**
     * 视频url
     */
    @TableField("video_url")
    private String videoUrl;

    /**
     * 视频大小，单位是字节
     */
    @TableField("video_size")
    private Integer videoSize;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
