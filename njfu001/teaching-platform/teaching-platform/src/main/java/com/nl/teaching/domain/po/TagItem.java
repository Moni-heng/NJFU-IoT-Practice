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
 * 标签项
 * </p>
 *
 * @author smy
 * @since 2025-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tag_item")
public class TagItem extends Model<TagItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所属标签组
     */
    @TableField("group_id")
    private Long groupId;

    /**
     * 标签名称
     */
    @TableField("name")
    private String name;

    /**
     * 标签状态，1：正常，2：禁用
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
    @TableField(exist = false) // ✅ 新增：手动映射关联字段
    private String type;
}
