package com.vision.edu.service.base.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.mapper.base.BaseBabyMapper;
import com.vision.edu.service.base.IBaseBabyService;

/**
 * <p>
 * 宝贝 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseBabyServiceImpl extends ServiceImpl<BaseBabyMapper, BaseBaby> implements IBaseBabyService {

	/**
	 * <p>Title: getBabyByClassID</p>
	 * <p>Description: </p>
	 * @param classID
	 * @return=
	 */
	@Override
	public List<BaseBaby> getBabyByClassId(String classId) {
		EntityWrapper<BaseBaby> entityWrapper = new EntityWrapper<BaseBaby>();
		entityWrapper.where("class_id = {0} and delete_flag = 0",classId);
		return selectList(entityWrapper);
	}
	
}
