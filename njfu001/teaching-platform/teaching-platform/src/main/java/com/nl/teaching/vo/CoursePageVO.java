package com.nl.teaching.vo;

import com.nl.teaching.domain.po.CourseTag;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
//课程信息
public class CoursePageVO {
    private Long id; //课程id
    private String name; // 课程名称
    private String coverUrl; //课程封面地址
    private String categories; // 课程分类，三级分类，以/隔开
    private Integer sections; //课程章节数量
    private Integer sold; // 课程报名人数（销量）
    private Integer score; // 课程评价得分，45代表4.5星
    private Integer status; // 课程状态，1：待上架，2：已上架，3：已下架，4：已完结
    private String updaterName; //更新人名字
    private LocalDateTime updateTime; //更新时间
    private LocalDateTime publishTime; //课程发布时间

    private BigDecimal credit; //学分

    private List<CourseTag> tags = new ArrayList<>(); //课程标签

    private Integer classhourNum; //课时数
    public static final String[] EXCLUDE_FIELDS =
            {"free", "type", "teacher","duration","publishTime"};
}
