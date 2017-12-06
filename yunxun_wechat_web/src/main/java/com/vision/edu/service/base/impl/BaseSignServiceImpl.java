package com.vision.edu.service.base.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseSign;
import com.vision.edu.mapper.base.BaseSignMapper;
import com.vision.edu.service.base.IBaseSignService;

/**
 * <p>
 * 签到表，宝贝排班的时候就要添加到签到表，每天定时更新这表的状态。签到，签离时候更新这签到状态，同时同步新增一条签到记录到 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseSignServiceImpl extends ServiceImpl<BaseSignMapper, BaseSign> implements IBaseSignService {
	
}
