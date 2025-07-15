package com.nl.teaching.domain.po;

import java.math.BigDecimal;
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
 * 虚拟实验-草稿课程
 * </p>
 *
 * @author smy
 * @since 2025-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("course")
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程草稿id，对应正式草稿id
     */
    @TableId("id")
    private Long id;

    /**
     * 课程名称
     */
    @TableField("name")
    private String name;

    /**
     * 课程类型，1：直播课，2：录播课
     */
    @TableField("course_type")
    private Integer courseType;

    /**
     * 封面链接
     */
    @TableField("cover_url")
    private String coverUrl;

    /**
     * 一级课程分类id
     */
    @TableField("first_cate_id")
    private Long firstCateId;

    /**
     * 二级课程分类id
     */
    @TableField("second_cate_id")
    private Long secondCateId;

    /**
     * 三级课程分类id
     */
    @TableField("third_cate_id")
    private Long thirdCateId;

    /**
     * 售卖方式:0付费;1免费
     */
    @TableField("free")
    private Integer free;

    /**
     * 课程价格，单位为分
     */
    @TableField("price")
    private Integer price;

    /**
     * 模板类型，1：固定模板，2：自定义模板
     */
    @TableField("template_type")
    private Integer templateType;

    /**
     * 自定义模板的连接
     */
    @TableField("template_url")
    private String templateUrl;

    /**
     * 课程状态，1：待上架(待开始)，2：已上架（已开始），3：下架（已停止），4：已完结
     */
    @TableField("status")
    private Integer status;

    /**
     * 课程购买有效期开始时间
     */
    @TableField("purchase_start_time")
    private LocalDateTime purchaseStartTime;

    /**
     * 课程购买有效期结束时间
     */
    @TableField("purchase_end_time")
    private LocalDateTime purchaseEndTime;

    /**
     * 信息填写进度
     */
    @TableField("step")
    private Integer step;

    /**
     * 课程评价得分，45代表4.5星
     */
    @TableField("score")
    private Integer score;

    /**
     * 课程总时长
     */
    @TableField("media_duration")
    private Integer mediaDuration;

    /**
     * 课程有效期，单位月，0代表长期有效
     */
    @TableField("valid_duration")
    private Integer validDuration;

    /**
     * 课程总节数，包括练习
     */
    @TableField("section_num")
    private Integer sectionNum;

    /**
     * 部门id
     */
    @TableField("dep_id")
    private Long depId;

    /**
     * 发布次数
     */
    @TableField("publish_times")
    private Integer publishTimes;

    /**
     * 最近一次发布时间
     */
    @TableField("publish_time")
    private LocalDateTime publishTime;

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
     * 逻辑删除:0正常；1删除
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 学分
     */
    @TableField("credit")
    private BigDecimal credit;

    /**
     * 课时
     */
    @TableField("classhour_num")
    private Integer classhourNum;

    /**
     * 简介视频
     */
    @TableField("introduction_url")
    private String introductionUrl;

    /**
     * 引导视频
     */
    @TableField("guide_url")
    private String guideUrl;

    /**
     * 简介视频名称
     */
    @TableField("introduction_name")
    private String introductionName;

    /**
     * 引导视频名称
     */
    @TableField("guide_name")
    private String guideName;

    /**
     * 学校
     */
    @TableField("college_name")
    private String collegeName;

    /**
     * 课程当前学期
     */
    @TableField("current_term")
    private Integer currentTerm;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
