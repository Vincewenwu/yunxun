package com.vision.edu.service.system.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.system.SysOperateLog;
import com.vision.edu.mapper.system.SysOperateLogMapper;
import com.vision.edu.service.system.ISysOperateLogService;

/**
 * <p>
 * 客户操作日志 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class SysOperateLogServiceImpl extends ServiceImpl<SysOperateLogMapper, SysOperateLog> implements ISysOperateLogService {
	
}
