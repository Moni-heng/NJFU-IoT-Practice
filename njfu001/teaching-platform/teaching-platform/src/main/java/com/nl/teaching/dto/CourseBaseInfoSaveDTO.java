package com.nl.teaching.dto;

import com.nl.teaching.domain.po.CourseContact;
import com.nl.teaching.domain.po.Student;
import com.nl.teaching.domain.po.TeachingClass;
import com.nl.teaching.domain.po.VlabCourseContact;
import com.nl.teaching.vo.TeacherPageVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程基本信息
 *
 * @author wusongsong
 * @version 1.0.0
 * @ClassName CourseBaseInfoSaveDTO
 * @since 2022/7/11 11:39
 **/

@Data
public class CourseBaseInfoSaveDTO {
    //"课程id，新课程该值不能传，老课程必填")
    private Long id;
    //"课程名称")
    private String name;
    //"课程1级分类id", example = "1")
    private Long firstCateId;
    //"课程2级分类id", example = "2")
    private Long secondCateId;
    //"课程3级分类id", example = "3")
    private Long thirdCateId;

    //"封面链接url")
    private String coverUrl;
    //"课程介绍")
    private String introduce;
    private List<Long> tags;
    private List<TeacherPageVO> teachers;

    private List<Contacts> contacts;

    private List<Student> students;
    private String introductionUrl;
    private String guideUrl;

    private String introductionName;
    private String guideName;


    //"课程分类，三级分类，以/隔开")
    private String categories;

    //"学分")
    private BigDecimal credit;

    //"课时数")
    private Integer classhourNum;

    private Integer currentTerm; //当前学期

    private String collegeName; //学校名称

    private Integer selectionNum; //累计选课人数

    private Integer interactionNum; //累计互动次数

    private Integer vlabTotalNum;//累计实验次数
    private Integer vlabResultNum;//累计提交结果次数

    private String templateUrl = ""; //实验路径

    List<TeachingClass> teachingClasses = new ArrayList<>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Contacts {
        public Contacts(String name, String email, String phone) {
            this.name = name;
            this.email = email;
            this.phone = phone;
        }

        private Long id;
        private String name;//联系人姓名
        private String email; //联系人邮箱
        private String phone; //联系人电话

        public static Contacts fromCourseContact(CourseContact courseContact) {
            Contacts contacts1 = new Contacts(courseContact.getName(), courseContact.getEmail(), courseContact.getPhone());
            return contacts1;
        }

        public static Contacts fromCourseContact(VlabCourseContact courseContact) {
            Contacts contacts1 = new Contacts(courseContact.getName(), courseContact.getEmail(), courseContact.getPhone());
            return contacts1;
        }

        public static Contacts fromCourseContactAll(CourseContact courseContact) {
            Contacts contacts2 = new Contacts(courseContact.getId(), courseContact.getName(), courseContact.getEmail(), courseContact.getPhone());
            return contacts2;
        }

        public static Contacts fromCourseContactAll(VlabCourseContact courseContact) {
            Contacts contacts2 = new Contacts(courseContact.getId(), courseContact.getName(), courseContact.getEmail(), courseContact.getPhone());
            return contacts2;
        }
    }

}
