package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.entity.base.BaseCombo;

/**
 * <p>
  * 套餐 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseComboMapper extends BaseMapper<BaseCombo> {
 
	/**
	 * 
	 * @author ChenWenWu
	 * @date 2017年7月28日 下午3:54:51
	 * @param page
	 * @param baseCombo 套餐实体
	 * @return
	 */
	 List<BaseCombo> findBaseCombopage(Pagination page,@Param("baseCombo")BaseCombo baseCombo);

}