package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.entity.base.BaseClass;

/**
 * <p>
  * 班级 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseClassMapper extends BaseMapper<BaseClass> {

	/**
	 * 查找班级通过老师ID
	 * @author ChenYuanRong
	 * @date 2017年7月26日 上午11:51:43
	 * @param teacherId
	 * @return
	 */
	public List<BaseClass> findClassByTeacherId(@Param("teacherId") String teacherId);
}