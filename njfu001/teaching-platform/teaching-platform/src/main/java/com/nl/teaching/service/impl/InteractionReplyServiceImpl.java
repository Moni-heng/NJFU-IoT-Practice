package com.nl.teaching.service.impl;

import com.nl.teaching.domain.po.InteractionReply;
import com.nl.teaching.mapper.InteractionReplyMapper;
import com.nl.teaching.service.IInteractionReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 互动问题的回答或评论 服务实现类
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Service
public class InteractionReplyServiceImpl extends ServiceImpl<InteractionReplyMapper, InteractionReply> implements IInteractionReplyService {

}
