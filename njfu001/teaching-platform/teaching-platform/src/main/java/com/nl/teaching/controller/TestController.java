package com.nl.teaching.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/msg")
    public String getTestMsg(@RequestParam(required = false) String message) {
        System.out.println("message->" + message);
        return "TestController-> " + message;
    }


}