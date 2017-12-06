package com.vision.edu.service.base;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseBaby;

/**
 * <p>
 * 宝贝 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseBabyService extends IService<BaseBaby> {
	
	/**
	 * 获取宝贝信息通过班级ID
	 * @author ChenYuanRong
	 * @date 2017年7月26日 下午3:09:21
	 * @param classID
	 * @return
	 */
	public List<BaseBaby> getBabyByClassId(String classId);
	
}
