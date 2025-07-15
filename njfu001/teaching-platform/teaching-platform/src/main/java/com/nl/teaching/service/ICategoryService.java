package com.nl.teaching.service;

import com.nl.teaching.domain.po.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nl.teaching.vo.SimpleCategoryVO;

import java.util.List;

/**
 * <p>
 * 课程分类 服务类
 * </p>
 *
 * @author smy
 * @since 2025-07-10
 */
public interface ICategoryService extends IService<Category> {

    List<SimpleCategoryVO> all();
}
