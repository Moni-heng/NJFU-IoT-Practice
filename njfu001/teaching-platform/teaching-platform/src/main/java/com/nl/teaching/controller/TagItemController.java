package com.nl.teaching.controller;

import com.nl.teaching.domain.po.TagItem;
import com.nl.teaching.result.Result;
import com.nl.teaching.service.ITagItemService;
import lombok.extern.slf4j.Slf4j; // ✅ 新增
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // ✅ 新增
@RestController
@RequestMapping("/tagItem")
public class TagItemController {

    @Autowired
    public ITagItemService tagItemService;

    // ✅ 新增：查询所有标签项
    @GetMapping("/list")
    public Result getTagItemList() {
        List<TagItem> list = tagItemService.getTagItemList();
        log.info("TagItemController.getTagItemList: [{}]", list);
        return Result.ok(list);
    }
}
