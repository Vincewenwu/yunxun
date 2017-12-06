package com.vision.edu.service.base.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseHelp;
import com.vision.edu.mapper.base.BaseHelpMapper;
import com.vision.edu.service.base.IBaseHelpService;

/**
 * <p>
 * 用于记录帮助信息，帮助说明 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseHelpServiceImpl extends ServiceImpl<BaseHelpMapper, BaseHelp> implements IBaseHelpService {
	
}
