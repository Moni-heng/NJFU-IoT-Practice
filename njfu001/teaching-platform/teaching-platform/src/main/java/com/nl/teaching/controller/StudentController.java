package com.nl.teaching.controller;

import com.nl.teaching.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public IStudentService studentService;

}
