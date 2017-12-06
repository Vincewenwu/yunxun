package com.vision.edu.service.base.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.GradeClassDTO;
import com.vision.edu.entity.base.BaseGrade;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.mapper.base.BaseGradeMapper;
import com.vision.edu.service.base.IBaseGradeService;

/**
 * <p>
 * 年级表 服务实现类
 * </p>s
 *
 * @author XieFan
 * @since 2017-07-17
 */
@Service
public class BaseGradeServiceImpl extends ServiceImpl<BaseGradeMapper, BaseGrade> implements IBaseGradeService {

	/**
	 * 分页查找年级信息
	 * <p>Title: findAllGrade</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 下午5:00:52
	 * @param page 分页
	 * @param gradeName 年级名称
	 * @return
	 */
	@Override
	public Page<BaseGrade> findAllGrade(Page<BaseGrade> page, String gradeName) {
		page.setRecords(super.baseMapper.findAllGrade(page, gradeName));
		return page;
	}

	@Override
	public List<BaseGrade> findGradeBySchoolId(BaseSchool baseSchool) {
		return baseMapper.findGradeBySchoolId(baseSchool);
	}
	
	/**
	 * 查询年级
	 * @author jiangwangying
	 * @date 2017年8月2日 下午2:50:40
	 * @param deleteFlag 删除标记
	 * @return
	 */
	public List<GradeClassDTO> findGrade(Integer deleteFlag){
		
		return baseMapper.findGrade(deleteFlag);
	}

}
