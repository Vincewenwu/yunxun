package com.vision.edu.service.base.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseIps;
import com.vision.edu.mapper.base.BaseIpsMapper;
import com.vision.edu.service.base.IBaseIpsService;

/**
 * <p>
 * 设备ip池 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-26
 */
@Service
public class BaseIpsServiceImpl extends ServiceImpl<BaseIpsMapper, BaseIps> implements IBaseIpsService {

}
