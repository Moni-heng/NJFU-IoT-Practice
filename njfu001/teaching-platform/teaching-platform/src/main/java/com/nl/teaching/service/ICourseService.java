package com.nl.teaching.service;

import com.nl.teaching.domain.po.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nl.teaching.dto.CourseBaseInfoSaveDTO;
import com.nl.teaching.dto.PageDTO;
import com.nl.teaching.query.CoursePageQuery;
import com.nl.teaching.vo.CoursePageVO;

/**
 * <p>
 * 虚拟实验-草稿课程 服务类
 * </p>
 *
 * @author smy
 * @since 2025-07-10
 */
public interface ICourseService extends IService<Course> {
   // public PageDTO<CoursePageVO> queryCourseListProtal(CoursePageQuery coursePageQuery) {}
   PageDTO<CoursePageVO> queryCourseListProtal(CoursePageQuery coursePageQuery);

   CourseBaseInfoSaveDTO getCourseDetailProtal(Long id);

//   CourseBaseInfoSaveDTO getCourseDetailProtal(Long id);
}
