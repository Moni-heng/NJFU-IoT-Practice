package com.nl.teaching.controller;

import com.nl.teaching.result.Result;
import com.nl.teaching.service.ICategoryService;
import com.nl.teaching.vo.SimpleCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    public ICategoryService categoryService;

    //获取所有的课程分类信息，只包含id,名称，课程分类关系
    @GetMapping("/all")
    public Result all() {
        List<SimpleCategoryVO> categoryVOS = categoryService.all();
        return Result.ok(categoryVOS);

    }
}