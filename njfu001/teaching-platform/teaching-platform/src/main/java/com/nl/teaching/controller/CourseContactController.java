package com.nl.teaching.controller;

import com.nl.teaching.service.ICourseContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseContact")
public class CourseContactController {

    @Autowired
    public ICourseContactService courseContactService;

}
