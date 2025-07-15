package com.nl.teaching.service.impl;

import com.nl.teaching.domain.po.TagItem;
import com.nl.teaching.mapper.TagItemMapper;
import com.nl.teaching.service.ITagItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagItemServiceImpl extends ServiceImpl<TagItemMapper, TagItem> implements ITagItemService {

    // ✅ 新增
    @Override
    public List<TagItem> getTagItemList() {
        return baseMapper.getTagItemList();
    }
}
