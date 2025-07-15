package com.nl.teaching.controller;

import com.nl.teaching.service.ICourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseTeacher")
public class CourseTeacherController {

    @Autowired
    public ICourseTeacherService courseTeacherService;

}
