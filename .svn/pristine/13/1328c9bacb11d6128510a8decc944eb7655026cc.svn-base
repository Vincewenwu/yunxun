package com.vision.edu.service.base.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseEvalProject;
import com.vision.edu.mapper.base.BaseEvalProjectMapper;
import com.vision.edu.service.base.IBaseEvalProjectService;

/**
 * <p>
 * 评测项目 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseEvalProjectServiceImpl extends ServiceImpl<BaseEvalProjectMapper, BaseEvalProject> implements IBaseEvalProjectService {

	/**
	 * <p>Title: findAllTeacherEvalPro</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月20日 下午4:44:44
	 * @param page
	 * @param name
	 * @return
	 */
	@Override
	public Page<BaseEvalProject> findAllTeacherEvalPro(Page<BaseEvalProject> page, String name) {
		page.setRecords(super.baseMapper.findAllTeacherEvalPro(page, name));
		return page;
	}
	
}
