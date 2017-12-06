package com.vision.edu.service.member.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.member.MemComment;
import com.vision.edu.mapper.member.MemCommentMapper;
import com.vision.edu.service.member.IMemCommentService;

/**
 * <p>
 * 评论记录 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemCommentServiceImpl extends ServiceImpl<MemCommentMapper, MemComment> implements IMemCommentService {
	
}
