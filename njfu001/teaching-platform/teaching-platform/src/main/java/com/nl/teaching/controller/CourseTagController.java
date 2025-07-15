package com.nl.teaching.controller;

import com.nl.teaching.service.ICourseTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseTag")
public class CourseTagController {

    @Autowired
    public ICourseTagService courseTagService;

}
