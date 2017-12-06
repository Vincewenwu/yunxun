package com.vision.edu.service.base.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseEvalContent;
import com.vision.edu.mapper.base.BaseEvalContentMapper;
import com.vision.edu.service.base.IBaseEvalContentService;

/**
 * <p>
 * 评测内容 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseEvalContentServiceImpl extends ServiceImpl<BaseEvalContentMapper, BaseEvalContent> implements IBaseEvalContentService {

	/**
	 * <p>Title: getEvalContentList</p>
	 * <p>Description: </p>
	 * @return=
	 */
	@Override
	public List<BaseEvalContent> getEvalContentList(String evalProjectId ) 
	{
		EntityWrapper<BaseEvalContent> entityWrapper=new EntityWrapper<BaseEvalContent>();
		entityWrapper.where("eval_project_id = {0} and  delete_flag = 0",evalProjectId);
		return selectList(entityWrapper);
	}
	
}
