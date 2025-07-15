package com.nl.teaching.service.impl;

import com.nl.teaching.domain.po.InteractionQuestion;
import com.nl.teaching.mapper.InteractionQuestionMapper;
import com.nl.teaching.service.IInteractionQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 互动提问的问题表 服务实现类
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Service
public class InteractionQuestionServiceImpl extends ServiceImpl<InteractionQuestionMapper, InteractionQuestion> implements IInteractionQuestionService {

}
