package com.nl.teaching.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nl.teaching.domain.po.TagItem;

import java.util.List;

public interface ITagItemService extends IService<TagItem> {
    // ✅ 新增
    List<TagItem> getTagItemList();
}
