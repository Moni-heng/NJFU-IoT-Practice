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
 * 标签分组
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tag_group")
public class TagGroup extends Model<TagGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签分组id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分组名称
     */
    @TableField("name")
    private String name;

    /**
     * 标签主题
     */
    @TableField("effect")
    private String effect;

    /**
     * 标签类型
     */
    @TableField("type")
    private String type;

    /**
     * 标签分类状态，1：正常，2：禁用
     */
    @TableField("status")
    private Integer status;

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
     * 创建者
     */
    @TableField("creater")
    private Long creater;

    /**
     * 更新者
     */
    @TableField("updater")
    private Long updater;

    @TableField("deleted")
    private Integer deleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
