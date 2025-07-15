package com.nl.teaching.controller;

import com.nl.teaching.service.IVlabCourseContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vlabCourseContact")
public class VlabCourseContactController {

    @Autowired
    public IVlabCourseContactService vlabCourseContactService;

}
