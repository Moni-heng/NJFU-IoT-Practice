package com.nl.teaching.mapper;

import com.nl.teaching.domain.po.TeachingClass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 教学班级表 Mapper 接口
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
public interface TeachingClassMapper extends BaseMapper<TeachingClass> {



    @Select("select a.id,a.name,a.lecturer,a.start_date,a.end_date,a.optional,p.param4 termName ,a.term_id," +
            " CASE" +
            "  WHEN a.release_state = 0 THEN 0 " +
            "  WHEN a.release_state = 1 and a.start_date > CURRENT_DATE THEN 1" +
            "  WHEN a.release_state = 1 and a.end_date < CURRENT_DATE  THEN 3" +
            " ELSE 2  END AS planState, a.release_state " +
            " from teaching_class a left join course c on a.course_id = c.id" +
            " left join p_code p on a.term_id = p.param1 and code_type = 3" +
            " where a.deleted = 0 and a.course_id = #{id} and a.release_state = 1 order by a.term_id")
    List<TeachingClass> getCoursePlanByCourseId(Long id);
}
