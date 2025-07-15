package com.nl.teaching.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 所有课程分类数据
 *
 * @author wusongsong
 * @version 1.0.0
 * @since 2022/7/14 18:15
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//所有课程分类数据
public class SimpleCategoryVO {
    private Long id;
    private String name;
    private List<SimpleCategoryVO> children;
    private Integer level;
    private Long parentId;
}
