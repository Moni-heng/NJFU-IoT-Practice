package com.nl.teaching.service.impl;

import com.nl.teaching.domain.po.CourseContent;
import com.nl.teaching.mapper.CourseContentMapper;
import com.nl.teaching.service.ICourseContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程内容，主要是一些大文本 服务实现类
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Service
public class CourseContentServiceImpl extends ServiceImpl<CourseContentMapper, CourseContent> implements ICourseContentService {

}
