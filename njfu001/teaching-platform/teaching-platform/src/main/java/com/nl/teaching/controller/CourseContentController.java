package com.nl.teaching.controller;

import com.nl.teaching.service.ICourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    public ICourseContentService courseContentService;

}
