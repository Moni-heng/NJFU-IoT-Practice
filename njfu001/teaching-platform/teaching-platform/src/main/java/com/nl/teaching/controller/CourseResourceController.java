package com.nl.teaching.controller;

import com.nl.teaching.service.ICourseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseResource")
public class CourseResourceController {

    @Autowired
    public ICourseResourceService courseResourceService;

}
