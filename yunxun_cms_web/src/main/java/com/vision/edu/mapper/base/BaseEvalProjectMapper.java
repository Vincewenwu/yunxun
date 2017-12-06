package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.entity.base.BaseEvalProject;

/**
 * <p>
  * 评测项目 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseEvalProjectMapper extends BaseMapper<BaseEvalProject> {
	
	/**
	 * 分页查询老师评价项目
	 * <p>Title: findAllTeacherEvalPro</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月20日 下午4:51:09
	 * @param page 分页参数
	 * @param name 项目名称
	 * @return
	 */
	List<BaseEvalProject> findAllTeacherEvalPro(Pagination page,@Param("name") String name);

}