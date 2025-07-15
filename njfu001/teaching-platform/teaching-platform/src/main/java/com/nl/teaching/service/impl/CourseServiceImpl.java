package com.nl.teaching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nl.teaching.domain.po.*;
import com.nl.teaching.dto.CourseBaseInfoSaveDTO;
import com.nl.teaching.dto.PageDTO;
import com.nl.teaching.mapper.CourseMapper;
import com.nl.teaching.mapper.TeachingClassMapper;
import com.nl.teaching.query.CoursePageQuery;
import com.nl.teaching.service.ICourseContactService;
import com.nl.teaching.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nl.teaching.vo.CoursePageVO;
import com.nl.teaching.vo.StatisticalDataVo;
import com.nl.teaching.vo.TeacherPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 虚拟实验-草稿课程 服务实现类
 * </p>
 *
 * @author smy
 * @since 2025-07-10
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    private TeachingClassMapper teachingClassMapper;

    @Autowired
    private ICourseContactService courseContactService;

    @Override
    public PageDTO<CoursePageVO> queryCourseListProtal(CoursePageQuery coursePageQuery) {
        Long tagId = coursePageQuery.getTagId();
        Long cateId = coursePageQuery.getFirstCateId();
        Long total = courseMapper.queryCourseTotal(cateId, tagId);
        List<CoursePageVO> coursePageVOS = null;
        if (total > 0) {
            Integer pageSize = coursePageQuery.getPageSize();
            Integer pageNo = coursePageQuery.getPageNo();
            Integer start = (pageNo - 1) * pageSize;
            coursePageVOS = courseMapper.queryCourse(cateId, tagId, start, pageSize);
            List<Long> courseIdList = coursePageVOS.stream().map(CoursePageVO::getId).collect(Collectors.toList());
            List<CourseTag> courseTags = courseMapper.queryCourseTagsByCourseId(courseIdList);
            for (int i = 0; i < coursePageVOS.size(); i++) {
                CoursePageVO coursePageVO = coursePageVOS.get(i);
                List<CourseTag> voTags = coursePageVO.getTags();
                Long cId = coursePageVO.getId();
                for (int j = 0; j < courseTags.size(); j++) {
                    CourseTag courseTag = courseTags.get(j);
                    Long courseId = courseTag.getCourseId();
                    if (Objects.equals(cId, courseId)) {
                        voTags.add(courseTag);
                    }
                }
            }
        }

        PageDTO<CoursePageVO> coursePageDTO = new PageDTO<>();
        coursePageDTO.setList(coursePageVOS);
        coursePageDTO.setTotal(total);
        return coursePageDTO;
    }
    public CourseBaseInfoSaveDTO getCourseDetailProtal(Long courseId) {
        //1.查询课程信息
        CourseBaseInfoSaveDTO courseBaseInfoSaveDTO = courseMapper.queryCourseDetailById(courseId);
        if (courseBaseInfoSaveDTO != null) {
            //1、讲师
            List<TeacherPageVO> teacherPageVOS = courseMapper.queryTeachers(courseId);
            courseBaseInfoSaveDTO.setTeachers(teacherPageVOS);

            //2、联系人
            LambdaQueryWrapper<CourseContact> queryContactWrapper = new LambdaQueryWrapper<>();
            queryContactWrapper.eq(CourseContact::getCourseId, courseId);
            List<CourseContact> contactList = courseContactService.list(queryContactWrapper);
            List<CourseBaseInfoSaveDTO.Contacts> contactsList = contactList.stream().map(CourseBaseInfoSaveDTO.Contacts::fromCourseContactAll).collect(Collectors.toList());
            courseBaseInfoSaveDTO.setContacts(contactsList);
            //3、学员信息
            List<Student> students = courseMapper.queryStudents(courseId);
            courseBaseInfoSaveDTO.setStudents(students);
            //4、累计选课人数
            StatisticalDataVo selectionNum = courseMapper.querySelectionNum(courseId);
            courseBaseInfoSaveDTO.setSelectionNum(selectionNum.getSelectionNum());
            //5、累计互动次数
            StatisticalDataVo interactionNum = courseMapper.queryInteractionNum(courseId);
            courseBaseInfoSaveDTO.setInteractionNum(interactionNum.getInteractionNum());

            //6、查询学期列表
            List<TeachingClass> teachingClasses = teachingClassMapper.getCoursePlanByCourseId(courseId);
            courseBaseInfoSaveDTO.setTeachingClasses(teachingClasses);
        }
        return courseBaseInfoSaveDTO;
    }
}
