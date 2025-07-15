package com.nl.teaching.controller;

import com.nl.teaching.dto.CourseBaseInfoSaveDTO;
import com.nl.teaching.dto.PageDTO;

import com.nl.teaching.query.CoursePageQuery;
import com.nl.teaching.result.Result;
import com.nl.teaching.service.ICourseService;
import com.nl.teaching.vo.CoursePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    // ✅ 已实现：支持分页参数（分类ID + 标签ID + 页码等）查询课程列表
    @GetMapping("/list")
    public Result queryCourseListProtal(CoursePageQuery coursePageQuery) {
        PageDTO<CoursePageVO> pageDTO = courseService.queryCourseListProtal(coursePageQuery);
        return Result.ok(pageDTO);
    }
    @GetMapping("/baseInfo/{id}")
    public Result baseInfoProtal(@PathVariable("id") Long id) {
        log.info("CourseController.baseInfo: [{}]", id);
        CourseBaseInfoSaveDTO courseBaseInfo = courseService.getCourseDetailProtal(id);
        return Result.ok(courseBaseInfo);
    }
    // 新增：根据课程ID查询课程详情接口
//    @GetMapping("/baseInfo/{id}")
//    public Result baseInfoProtal(@PathVariable("id") Long id) {
//        log.info("CourseController.baseInfo: [{}]", id);
//        CourseBaseInfoSaveDTO courseBaseInfo = courseService.getCourseDetailProtal(id);
//        return Result.ok(courseBaseInfo);
//    }
}
