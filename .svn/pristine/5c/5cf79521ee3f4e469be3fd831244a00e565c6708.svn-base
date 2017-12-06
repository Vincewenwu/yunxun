package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.base.BaseEvalCrite;

/**
 * <p>
  * 宝贝在家评价 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseEvalCriteMapper extends BaseMapper<BaseEvalCrite> {
	
	/**
	 * 分页查询
	 * <p>Title: findAllParentCrite</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月19日 上午8:55:40
	 * @param page 分页参数
	 * @param baseEvalCrite 对象
	 * @return
	 */
	List<BaseEvalCrite> findAllParentCrite(Pagination page,@Param("baseEvalCrite") BaseEvalCrite baseEvalCrite);


}