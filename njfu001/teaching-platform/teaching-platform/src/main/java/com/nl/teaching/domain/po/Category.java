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
 * 课程分类
 * </p>
 *
 * @author smy
 * @since 2025-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("category")
public class Category extends Model<Category> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程分类id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类名称
     */
    @TableField("name")
    private String name;

    /**
     * 父分类id，一级分类父id为0
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 分类级别，1,2,3：代表一级分类，二级分类，三级分类
     */
    @TableField("level")
    private Integer level;

    /**
     * 同级目录优先级，数字越小优先级越高，可以重复
     */
    @TableField("priority")
    private Integer priority;

    /**
     * 课程分类状态，1：正常，2：禁用
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
