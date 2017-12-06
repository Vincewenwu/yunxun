package com.vision.edu.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.mapper.base.BaseClassMapper;
import com.vision.edu.service.base.IBaseClassService;

/**
 * <p>
 * 班级 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseClassServiceImpl extends ServiceImpl<BaseClassMapper, BaseClass> implements IBaseClassService {

	@Autowired
    private BaseClassMapper baseClassMapper;

	public BaseClassMapper getBaseClassMapper() {
		return baseClassMapper;
	}

	public void setBaseClassMapper(BaseClassMapper baseClassMapper) {
		this.baseClassMapper = baseClassMapper;
	}

	/**
	 * <p>Title: findClassByTeacherId</p>
	 * <p>Description: </p>
	 * @param teacherId
	 * @return=
	 */
	@Override
	public List<BaseClass> findClassByTeacherId(String teacherId) 
	{
		List<BaseClass> list = baseClassMapper.findClassByTeacherId(teacherId);
		return list;
	}
	
}
