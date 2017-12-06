package com.vision.edu.service.member.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.member.MemCollection;
import com.vision.edu.mapper.member.MemCollectionMapper;
import com.vision.edu.service.member.IMemCollectionService;

/**
 * <p>
 * 收藏记录 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemCollectionServiceImpl extends ServiceImpl<MemCollectionMapper, MemCollection> implements IMemCollectionService {
	
}
