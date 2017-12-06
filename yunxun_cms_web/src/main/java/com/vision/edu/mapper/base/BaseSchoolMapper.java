package com.vision.edu.mapper.base;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.entity.base.BaseSchool;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * <p>
  * 园校，记录的是园校的基本信息 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseSchoolMapper extends BaseMapper<BaseSchool> {

	/**
	 * 动态模糊查询园校
	 * @author jiangwangying
	 * @date 2017年7月11日 上午9:05:24
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param schoolName 园校名称
	 * @param deleteFlag 删除标记
	 * @return=List 园校list集合
	 */
	List<BaseSchool> findSchoolByDynamic(Pagination page,@Param("schoolId") String schoolId,@Param("schoolName") String schoolName,@Param("deleteFlag") Integer deleteFlag);

}