package com.vision.edu.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseEvalContent;
import com.vision.edu.entity.base.BaseEvalProject;
import com.vision.edu.entity.base.BaseGrade;
import com.vision.edu.mapper.base.BaseEvalContentMapper;
import com.vision.edu.mapper.base.BaseEvalProjectMapper;
import com.vision.edu.mapper.base.BaseGradeMapper;
import com.vision.edu.service.base.IBaseEvalContentService;

/**
 * <p>
 * 评测内容 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseEvalContentServiceImpl extends ServiceImpl<BaseEvalContentMapper, BaseEvalContent> implements IBaseEvalContentService {

	/**
	 * 年级
	 */
	@Autowired
	private BaseGradeMapper baseGradeMapper;
	/**
	 * 教师评测项目
	 */
	@Autowired
	private BaseEvalProjectMapper baseEvalProjectMapper;
	/**
	 * 教师评测内容
	 */
	@Autowired
	private BaseEvalContentMapper baseEvalContentMapper;
	
	/**
	 * 查询所有有效的年级
	 * <p>Title: findGrades</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 上午9:33:22
	 * @return
	 */
	@Override
	public List<BaseGrade> findGrades() {
		EntityWrapper<BaseGrade> baseGrade = new EntityWrapper<BaseGrade>();
		baseGrade.where("delete_flag = 0");
		return baseGradeMapper.selectList(baseGrade);
	}

	/**
	 * 查询所有有效的老师评价项目
	 * <p>Title: findPros</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 上午9:41:16
	 * @return
	 */
	@Override
	public List<BaseEvalProject> findPros() {
		EntityWrapper<BaseEvalProject> baseEvalProject = new EntityWrapper<BaseEvalProject>();
		baseEvalProject.where("delete_flag = 0 ");
		return baseEvalProjectMapper.selectList(baseEvalProject);
	}

	/**
	 * 分页查询老师评价信息
	 * <p>Title: findAllTeacherEvalContent</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 下午2:13:07
	 * @param page
	 * @param baseEvalContent
	 * @return
	 */
	@Override
	public Page<BaseEvalContent> findAllTeacherEvalContent(Page<BaseEvalContent> page, BaseEvalContent baseEvalContent) {
		page.setRecords(super.baseMapper.findAllTeacherEvalContent(page, baseEvalContent));
		return page;
	}
	
	/**
	 * 绑定教师评价内容信息
	 * <p>Title: findTeacherEvalContentInfo</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 下午3:26:28
	 * @param gradeName 参数 年级名称
	 * @return
	 */
	@Override
	public List<BaseEvalContent> findTeacherEvalContentInfo(String gradeName) {
		List<BaseEvalContent> baseEvalContents= this.baseEvalContentMapper.findTeacherEvalContentInfo(gradeName);
		return baseEvalContents;
	}
	
}
