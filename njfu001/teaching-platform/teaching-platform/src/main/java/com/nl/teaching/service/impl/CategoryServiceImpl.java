package com.nl.teaching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.nl.teaching.domain.po.Category;
import com.nl.teaching.mapper.CategoryMapper;
import com.nl.teaching.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nl.teaching.utils.CategoryDataWrapper;
import com.nl.teaching.utils.TreeDataUtils;
import com.nl.teaching.vo.SimpleCategoryVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程分类 服务实现类
 * </p>
 *
 * @author smy
 * @since 2025-07-10
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Override
    public List<SimpleCategoryVO> all() {
        // 1.查询有课程的课程分类id列表……
        // 2.升序查询所有未禁用的课程分类
        LambdaQueryWrapper<Category> queryWrapper = Wrappers.lambdaQuery(Category.class)
                .eq(Category::getDeleted, 0)
                .orderByAsc(Category::getPriority)
                .orderByAsc(Category::getId);
        List<Category> categories = baseMapper.selectList(queryWrapper);

        // 3.将课程分类转换成树状结构
        List<SimpleCategoryVO> simpleCategoryVOS = TreeDataUtils.parseToTree(categories,
                SimpleCategoryVO.class, new CategoryDataWrapper());
        // 4.过滤掉没有三级子课程分类的课程分类……
        return simpleCategoryVOS;
    }
}
