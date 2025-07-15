package com.nl.teaching.mapper;

import com.nl.teaching.domain.po.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nl.teaching.domain.po.CourseTag;
import com.nl.teaching.domain.po.Student;
import com.nl.teaching.dto.CourseBaseInfoSaveDTO;
import com.nl.teaching.vo.CoursePageVO;
import com.nl.teaching.vo.StatisticalDataVo;
import com.nl.teaching.vo.TeacherPageVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 虚拟实验-草稿课程 Mapper 接口
 * </p>
 *
 * @author smy
 * @since 2025-07-10
 */
public interface CourseMapper extends BaseMapper<Course> {
    @Select(" <script> select count(a.id) from course a where a.deleted = 0 " +
            " <if test='cateId != null'> and a.first_cate_id = #{cateId} </if>" +
            " <if test='tagId != null'> and a.id in (select t.course_id from course_tag  t where t.tag_id = #{tagId}) </if> </script>")
    Long queryCourseTotal(Long cateId, Long tagId);
    @Select(" <script> select cate.name categories,a.* from course a left join category cate on a.first_cate_id = cate.id where a.deleted = 0 " +
            " <if test='cateId != null'> and a.first_cate_id = #{cateId} </if>" +
            " <if test='tagId != null'> and a.id in (select t.course_id from course_tag  t where t.tag_id = #{tagId}) </if>" +
            " order by update_time desc limit #{start}, #{size} </script>")
    List<CoursePageVO> queryCourse(Long cateId, Long tagId, Integer start, Integer size);

    @Select("<script>" +
            "select a.id courseId,b.tag_id,c.name tagName,b.c_index from course a " +
            "left join course_tag b on a.id = b.course_id " +
            "left join tag_item c on b.tag_id = c.id " +
            "where a.id in " +
            "<foreach item='item' collection='courseId' open='(' separator=',' close=')'>" +
            "#{item}" +
            "</foreach> " +
            " order by a.id,b.c_index" +
            "</script>")
    List<CourseTag> queryCourseTagsByCourseId(List<Long> courseId);



    @Select(" SELECT c.NAME categories, a.first_cate_id, a.id, a.NAME, a.cover_url, b.course_introduce introduce, a.introduction_url, a.introduction_name, a.guide_url, a.guide_name, a.credit, a.classhour_num, a.college_name,a.current_term  " +
            " FROM course a LEFT JOIN category c ON a.first_cate_id = c.id, course_content b  WHERE a.id = #{id}  AND a.id = b.id")
    CourseBaseInfoSaveDTO queryCourseDetailById(Long id);
    @Select("SELECT u.id,u.name ,u.icon,u.job,u.intro,u.title FROM course_teacher a, user_detail u  WHERE a.course_id = #{courseId}  AND a.deleted = 0  AND a.teacher_id = u.id")
    List<TeacherPageVO> queryTeachers(Long courseId);
    @Select(" select s.id, s.name,s.icon from teaching_class a, teaching_class_student b,student s where a.course_id = #{courseId}" +
            " and a.deleted = 0 and b.deleted = 0 and a.release_state = 1" +
            " and a.id = b.teaching_id and b.student_id = s.id order by a.update_time desc, b.id desc limit 9")
    List<Student> queryStudents(Long courseId);
    @Select("select count(b.student_id) selectionNum, course_id  " +
            " from teaching_class a,teaching_class_student b " +
            " where a.course_id = #{id} and a.id = b.teaching_id and b.deleted = 0 and a.deleted = 0")
    StatisticalDataVo querySelectionNum(Long id);
    @Select("select count(b.id) + count(distinct a.id) interactionNum,course_id " +
            " from interaction_question a left join interaction_reply b on a.id = b.question_id " +
            " where a.course_id = #{id}")
    StatisticalDataVo queryInteractionNum(Long id);
}
