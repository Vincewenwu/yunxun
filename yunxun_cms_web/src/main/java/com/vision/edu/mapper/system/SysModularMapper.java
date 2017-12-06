package com.vision.edu.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.system.SysModular;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface SysModularMapper extends BaseMapper<SysModular> {

	/**
	 * 查询所有模块
	 * @author XieFan
	 * @date 2017年7月18日 下午2:09:31
	 * @return
	 */
	List<BaseEntity> findAllSysModule(Pagination page,@Param("map")Map<String, Object> map);
	
	/**
	 * 根据ID查询模块信息
	 * @author XieFan
	 * @date 2017年7月29日 下午5:27:26
	 * @param id
	 * @return
	 */
	SysModular findModularById(@Param("id")String id);
	
}