package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.entity.base.BaseDuties;

/**
 * <p>
  * 职务表 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseDutiesMapper extends BaseMapper<BaseDuties> {

	/**
	 * 模糊查询职务
	 * @author jiangwangying
	 * @date 2017年7月30日 下午8:01:01
	 * @param page 分页
	 * @param vague 搜索词条
	 * @param schoolId 园校id
	 * @return
	 */
	List<BaseDuties> findDutiesByVague(Pagination page, @Param("vague") String vague,@Param("schoolId") String schoolId);
}