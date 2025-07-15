package com.nl.teaching.controller;

import com.nl.teaching.service.IVlabCourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vlabCourseTeacher")
public class VlabCourseTeacherController {

    @Autowired
    public IVlabCourseTeacherService vlabCourseTeacherService;

}
