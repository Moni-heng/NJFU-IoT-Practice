package com.nl.teaching.vo;

import lombok.Data;

@Data
public class StatisticalDataVo {

    private Long  id;
    private Integer selectionNum; //累计选课人数

    private Integer interactionNum; //累计互动次数

    private Integer vlabTotalNum;//累计实验次数
    private Integer vlabResultNum;//累计提交结果次数

}
