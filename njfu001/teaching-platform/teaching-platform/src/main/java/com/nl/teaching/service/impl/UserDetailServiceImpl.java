package com.nl.teaching.service.impl;

import com.nl.teaching.domain.po.UserDetail;
import com.nl.teaching.mapper.UserDetailMapper;
import com.nl.teaching.service.IUserDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 教师详情表 服务实现类
 * </p>
 *
 * @author sunjunqiang 
 * @since 2025-07-14
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements IUserDetailService {

}
