package com.nl.teaching.service.impl;

import com.nl.teaching.domain.po.Student;
import com.nl.teaching.mapper.StudentMapper;
import com.nl.teaching.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学员表 服务实现类
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
