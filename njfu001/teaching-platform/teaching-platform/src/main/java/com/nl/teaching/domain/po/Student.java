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
 * 学员表
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("student")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 学号
     */
    @TableField("no")
    private String no;

    /**
     * 性别
     */
    @TableField("sex")
    private String sex;

    /**
     * 联系电话
     */
    @TableField("telephone")
    private String telephone;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 身份证号
     */
    @TableField("card_id")
    private String cardId;

    /**
     * 家庭住址
     */
    @TableField("addr")
    private String addr;

    /**
     * 紧急电话
     */
    @TableField("urgent_phone")
    private String urgentPhone;

    /**
     * 学校
     */
    @TableField("college_name")
    private String collegeName;

    @TableField("college_id")
    private Integer collegeId;

    /**
     * 年级
     */
    @TableField("grade")
    private String grade;

    /**
     * 专业
     */
    @TableField("major_name")
    private String majorName;

    @TableField("major_id")
    private Integer majorId;

    /**
     * 所属班级标识
     */
    @TableField("class_id")
    private Integer classId;

    /**
     * 所属班级名称
     */
    @TableField("class_name")
    private String className;

    /**
     * 班号
     */
    @TableField("class_no")
    private Integer classNo;

    /**
     * 电子照片
     */
    @TableField("photo")
    private String photo;

    /**
     * 学生状态：学习中 准备考研 准备就业 考研上岸  已就业  已退学
     */
    @TableField("student_state")
    private String studentState;

    /**
     * 数据状态0：正常，1删除
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 数据来源：0录入：1表格导入
     */
    @TableField("data_from")
    private Integer dataFrom;

    /**
     * 创建时间
     */
    @TableField("CREATE_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("UPDATE_time")
    private LocalDateTime updateTime;

    /**
     * 导入批次,同一批导入的数据批次号相同
     */
    @TableField("import_batch")
    private String importBatch;

    /**
     * 头像地址
     */
    @TableField("icon")
    private String icon;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
