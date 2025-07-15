package com.nl.teaching.vo;

import com.nl.teaching.domain.po.CourseTeacher;
import com.nl.teaching.domain.po.VlabCourseTeacher;
import lombok.Data;

import java.time.LocalDateTime;

@Data
//"分页教师信息")
public class TeacherPageVO {
    //"教师id，也是用户id", example = "1")
    private Long id;
    //"教师名称", example = "罗老师")
    private String name;
    //"头像", example = "default-user-icon.jpg")
    private String icon;
    //"手机号", example = "13980019001")
    private String cellPhone;
    //"岗位", example = "讲师")
    private String job;
    //"介绍", example = "freext高级讲师")
    private String intro;
    //"负责的课程数量", example = "10")
    private Integer courseAmount;
    //"出题数量", example = "18")
    private Integer examQuestionAmount;
    //"注册时间", example = "2022-07-12")
    private LocalDateTime createTime;
    //"账户状态，0-禁用，1-正常", example = "1")
    private Integer status;
    //"形象照片地址", example = "default-user-icon.jpg")
    private String photo;

    private String tagType = "warning";

    private String title;
    private Boolean isShow = true;


    public static TeacherPageVO fromCourseTeacher(CourseTeacher teacher) {
        TeacherPageVO vo = new TeacherPageVO();
        vo.setId(teacher.getTeacherId());
        vo.setIsShow(teacher.getIsShow() == 0 ? true : false);
        return vo;
    }

    public static TeacherPageVO fromCourseTeacher(VlabCourseTeacher teacher) {
        TeacherPageVO vo = new TeacherPageVO();
        vo.setId(teacher.getTeacherId());
        vo.setIsShow(teacher.getIsShow() == 0 ? true : false);
        return vo;
    }
}
