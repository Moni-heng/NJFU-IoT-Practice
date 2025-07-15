package com.nl.teaching.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nl.teaching.domain.po.PCode;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunjunqiang
 * @since 2025-07-08
 */
public interface IPCodeService extends IService<PCode> {

    List<PCode> findPcodeListByCodyType(Integer codeType);

}

