package com.nl.teaching.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CataVO
 * @Author wusongsong
 * @Date 2022/7/11 16:42
 * @Version
 **/
@Data
//"课程目录")
public class CataVO {
    //"章、节id")
    private Long id;
    //"章节练习名称")
    private String name;

    private Long courseId; //课程Id

    //"目录类型1：章，2：节，3：测试")
    private Integer type;

    private Long parentCatalogueId; //所属章id

    //"视频id")
    private Long videoId;
    private String videoName;

    private String videoUrl;  //视屏url

    //"序号")
    private Integer cIndex;

    private Integer vedioDuration; //视频时长，以秒为单位
    private Integer videoSize; //视频大小
    //"是否可以修改,默认不能修改")
    private Boolean canUpdate = false;
    //"该章的所有小节和练习")
    private List<CataVO> sections = new ArrayList<>();

    private Integer moment = 0; //视频的当前观看时长，单位秒
    private Boolean finished; //是否完成学习，默认false
}
