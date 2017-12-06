package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.entity.base.BaseEvalContent;

/**
 * <p>
  * 评测内容 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseEvalContentMapper extends BaseMapper<BaseEvalContent> {
	
	/**
	 * 分页查询老师评价内容信息
	 * <p>Title: findAllTeacherEvalContent</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 下午2:21:22
	 * @param page 分页参数
	 * @param baseEvalContent 实体
	 * @return
	 */
	List<BaseEvalContent> findAllTeacherEvalContent(Pagination page, @Param("baseEvalContent") BaseEvalContent baseEvalContent);
	/**
	 * 绑定教师评价内容信息
	 * <p>Title: findTeacherEvalContentInfo</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 下午3:13:54
	 * @return
	 */
	List<BaseEvalContent> findTeacherEvalContentInfo(@Param("gradeName") String gradeName);

}