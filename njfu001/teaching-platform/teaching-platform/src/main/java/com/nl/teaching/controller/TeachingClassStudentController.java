package com.nl.teaching.controller;

import com.nl.teaching.service.ITeachingClassStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachingClassStudent")
public class TeachingClassStudentController {

    @Autowired
    public ITeachingClassStudentService teachingClassStudentService;

}
