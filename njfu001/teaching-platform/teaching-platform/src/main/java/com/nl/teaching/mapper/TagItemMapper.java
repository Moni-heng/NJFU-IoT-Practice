package com.nl.teaching.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nl.teaching.domain.po.TagItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // ✅ 确保加上这个注解
public interface TagItemMapper extends BaseMapper<TagItem> {

    // ✅ 新增：标签与分组联合查询
    @Select("SELECT a.*, b.type FROM tag_item a, tag_group b WHERE a.group_id = b.id AND a.deleted = 0")
    List<TagItem> getTagItemList();
}
