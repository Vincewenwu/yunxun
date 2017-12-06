package com.vision.edu.mapper.base;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.entity.base.BaseSign;

/**
 * <p>
  * 签到表，宝贝排班的时候就要添加到签到表，每天定时更新这表的状态。签到，签离时候更新这签到状态，同时同步新增一条签到记录到 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseSignMapper extends BaseMapper<BaseSign> {

}