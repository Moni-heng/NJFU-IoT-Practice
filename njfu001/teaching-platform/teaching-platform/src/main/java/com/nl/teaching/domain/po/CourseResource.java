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
 * 课程资料
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("course_resource")
public class CourseResource extends Model<CourseResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程目录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 资料名称
     */
    @TableField("name")
    private String name;

    /**
     * 课程id
     */
    @TableField("course_id")
    private Long courseId;

    /**
     * 文件id
     */
    @TableField("file_id")
    private Long fileId;

    /**
     * 文件名称
     */
    @TableField("file_name")
    private String fileName;

    /**
     * 文件url
     */
    @TableField("file_url")
    private String fileUrl;

    /**
     * 文件大小，单位是字节
     */
    @TableField("file_size")
    private Integer fileSize;

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
