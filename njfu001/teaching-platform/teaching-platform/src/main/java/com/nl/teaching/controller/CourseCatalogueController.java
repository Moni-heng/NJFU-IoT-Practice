package com.nl.teaching.controller;

import com.nl.teaching.service.ICourseCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseCatalogue")
public class CourseCatalogueController {

    @Autowired
    public ICourseCatalogueService courseCatalogueService;

}
