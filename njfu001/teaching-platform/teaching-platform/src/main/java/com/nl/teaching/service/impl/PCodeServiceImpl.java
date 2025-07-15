package com.nl.teaching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nl.teaching.domain.po.PCode;
import com.nl.teaching.mapper.PCodeMapper;
import com.nl.teaching.service.IPCodeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PCodeServiceImpl extends ServiceImpl<PCodeMapper, PCode> implements IPCodeService {

    @Override
    public List<PCode> findPcodeListByCodyType(Integer codeType) {
        LambdaQueryWrapper<PCode> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PCode::getCodeType, codeType);
        return list(queryWrapper);
    }
}
