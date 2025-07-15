package com.nl.teaching.service.impl;

import com.nl.teaching.domain.po.TeachingClassStudent;
import com.nl.teaching.mapper.TeachingClassStudentMapper;
import com.nl.teaching.service.ITeachingClassStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 选课学生表 服务实现类
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Service
public class TeachingClassStudentServiceImpl extends ServiceImpl<TeachingClassStudentMapper, TeachingClassStudent> implements ITeachingClassStudentService {

}
