package com.vision.edu.service.base;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseEvalProject;

/**
 * <p>
 * 评测项目 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseEvalProjectService extends IService<BaseEvalProject> {

	/**
	 * 分页查询、根据条件分页查询老师评价项目
	 * <p>Title: findAllTeacherEvalPro</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月20日 下午4:43:30
	 * @param page 参数
	 * @param name 项目名称
	 * @return
	 */
	Page<BaseEvalProject> findAllTeacherEvalPro(Page<BaseEvalProject> page, String name);
	
}
