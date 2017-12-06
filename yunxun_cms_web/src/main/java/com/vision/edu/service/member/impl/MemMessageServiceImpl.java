package com.vision.edu.service.member.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.member.MemMessage;
import com.vision.edu.mapper.member.MemMessageMapper;
import com.vision.edu.service.member.IMemMessageService;

/**
 * <p>
 * 提醒信息 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemMessageServiceImpl extends ServiceImpl<MemMessageMapper, MemMessage> implements IMemMessageService {
	
}
