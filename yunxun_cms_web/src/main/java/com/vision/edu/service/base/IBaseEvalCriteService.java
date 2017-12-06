package com.vision.edu.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseEvalCrite;

/**
 * <p>
 * 宝贝在家评价 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseEvalCriteService extends IService<BaseEvalCrite> {
	
	/**
	 * 分页查询、根据条件分页查询
	 * <p>Title: findAllParentCrite</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月19日 上午8:49:00
	 * @param page 分页参数
	 * @param name 项目名称
	 * @return
	 */
	Page<BaseEvalCrite> findAllParentCrite(Page<BaseEvalCrite> page,BaseEvalCrite baseEvalCrite);
}
