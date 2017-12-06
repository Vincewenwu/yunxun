package com.vision.edu.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseEvalContent;
import com.vision.edu.entity.base.BaseEvalProject;
import com.vision.edu.entity.base.BaseGrade;

/**
 * <p>
 * 评测内容 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseEvalContentService extends IService<BaseEvalContent> {

	/**
	 * 查询所有有效的年级
	 * <p>Title: findGrades</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 上午9:32:30
	 * @return
	 */
	List<BaseGrade> findGrades();

	/**
	 * 查询所有有效的老师评价项目
	 * <p>Title: findPros</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 上午9:40:42
	 * @return
	 */
	List<BaseEvalProject> findPros();

	/**
	 * 分页查询老师评价内容信息
	 * <p>Title: findAllTeacherEvalContent</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 下午2:10:06
	 * @param page
	 * @param baseEvalContent
	 * @return
	 */
	Page<BaseEvalContent> findAllTeacherEvalContent(Page<BaseEvalContent> page, BaseEvalContent baseEvalContent);

	/**
	 * 绑定教师评价内容信息
	 * <p>Title: findTeacherEvalContentInfo</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 下午3:25:04
	 * @param gradeName 参数 年级名称
	 * @return
	 */
	List<BaseEvalContent> findTeacherEvalContentInfo(String gradeName);
	
}
