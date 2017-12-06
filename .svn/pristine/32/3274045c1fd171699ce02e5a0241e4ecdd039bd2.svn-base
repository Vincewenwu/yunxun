package com.vision.edu.service.base.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.GroupSchoolDTO;
import com.vision.edu.entity.base.BaseGroup;
import com.vision.edu.mapper.base.BaseGroupMapper;
import com.vision.edu.service.base.IBaseGroupService;

/**
 * <p>
 * 会员组 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseGroupServiceImpl extends ServiceImpl<BaseGroupMapper, BaseGroup> implements IBaseGroupService {
	
	@Autowired
	private BaseGroupMapper baseGroupMapper;
	
	/**
	 * 查询分组中的园校
	 * @author jiangwangying
	 * @date 2017年7月23日 下午12:07:49
	 * @param schoolId 园校id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	public List<GroupSchoolDTO> findSchoolGroup(String schoolId,Integer deleteFlag){
		return baseGroupMapper.findSchoolGroup(schoolId, deleteFlag);
	}
	
	/**
	 * 移除分组
	 * @author jiangwangying
	 * @date 2017年8月9日 上午9:34:45
	 * @param teacherId 教师id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	public List<BaseGroup> findRemoveGroup(String teacherId, Integer deleteFlag) {
		
		return baseGroupMapper.findRemoveGroup(teacherId, deleteFlag);
	}
}
