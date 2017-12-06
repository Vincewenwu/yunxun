package com.vision.edu.service.base.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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

	
	@Override
	public List<BaseEvalProject> getEvalProjectList() 
	{
		EntityWrapper<BaseEvalProject> entityWrapper=new EntityWrapper<BaseEvalProject>();
		entityWrapper.where("delete_flag = 0");
		return selectList(entityWrapper);
	}
	
}
