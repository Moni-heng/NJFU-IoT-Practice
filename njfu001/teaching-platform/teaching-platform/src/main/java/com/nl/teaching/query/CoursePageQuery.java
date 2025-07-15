package com.nl.teaching.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class CoursePageQuery extends PageQuery {

    private String keyword; //搜索关键字
    private Long firstCateId; //课程1级分类id
    private Long secondCateId; //课程2级分类id
    private Long thirdCateId; //课程3级分类id
    private Long tagId; //标签id
}
