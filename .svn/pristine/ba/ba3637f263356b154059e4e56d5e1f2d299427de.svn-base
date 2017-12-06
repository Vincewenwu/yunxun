package com.vision.edu.service.base.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseEvalCrite;
import com.vision.edu.mapper.base.BaseEvalCriteMapper;
import com.vision.edu.service.base.IBaseEvalCriteService;

/**
 * <p>
 * 宝贝在家评价 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseEvalCriteServiceImpl extends ServiceImpl<BaseEvalCriteMapper, BaseEvalCrite> implements IBaseEvalCriteService {

	
	/**
	 * 分页查询、根据条件分页查询
	 * <p>Title: findAllParentCrite</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月19日 上午8:50:10
	 * @param page 分页参数
	 * @param baseEvalCrite 对象
	 * @return
	 */
	@Override
	public Page<BaseEvalCrite> findAllParentCrite(Page<BaseEvalCrite> page, @Param("baseEvalCrite") BaseEvalCrite baseEvalCrite) {
		page.setRecords(super.baseMapper.findAllParentCrite(page, baseEvalCrite));
		return page;
	}
	
}
