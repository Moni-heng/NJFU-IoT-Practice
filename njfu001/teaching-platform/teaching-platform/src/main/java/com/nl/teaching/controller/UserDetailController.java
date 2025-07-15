package com.nl.teaching.controller;

import com.nl.teaching.service.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userDetail")
public class UserDetailController {

    @Autowired
    public IUserDetailService userDetailService;

}
