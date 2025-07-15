package com.nl.teaching.controller;

import com.nl.teaching.service.ITeachingClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachingClass")
public class TeachingClassController {

    @Autowired
    public ITeachingClassService teachingClassService;

}
