package com.vision.edu.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.BaseSchoolDTO;
import com.vision.edu.dto.BaseSchoolMsgDTO;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.mapper.base.BaseSchoolMapper;
import com.vision.edu.service.base.IBaseSchoolService;

/**
 * <p>
 * 园校，记录的是园校的基本信息 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseSchoolServiceImpl extends ServiceImpl<BaseSchoolMapper, BaseSchool> implements IBaseSchoolService {
	
	@Autowired
	private BaseSchoolMapper baseSchoolMapper;   //注入BaseSchoolMapper
	
	
	/**
	 * 这是查询园校对应的所属地区
	 */
	@Override
	public List<BaseSchoolDTO> findSchoolList() {
		List<BaseSchoolDTO> list=baseSchoolMapper.findSchoolList();
		return list;
	}

	/**
	 *模糊查询院校信息
	 *@param strSchoolName 学校名称
	 */
	@Override
	public List<String> findSchool(String strSchoolName) {
		List<String> listSchool=baseSchoolMapper.findSchool(strSchoolName);
		return listSchool;
	}

	/**
	 *查询学校的院所信息
	 *@param strSchoolName 学校名称
	 */
	@Override
	public BaseSchoolMsgDTO findSchoolMsg(String strSchoolName) {
		return  baseSchoolMapper.findSchoolMsg(strSchoolName);
	}

	/**
	 *根据学校的id查询园所介绍的基本信息
	 *@param strSchoolId 学校id
	 */
	@Override
	public BaseEntity findSchoolMsgBase(String strSchoolId) {
		BaseEntity baseSchoolMsgPo=baseSchoolMapper.findSchoolMsgBase(strSchoolId);
		return baseSchoolMsgPo;
	}

	/**
	*根据学校的id查询园所介绍的详细信息
	*@author:zyml
	*@date:2017年7月16日下午3:50:27
	*@param strSchool 学校id
	*/
	@Override
	public BaseEntity findSchoolMsgDetail(String strSchoolId) {
		BaseEntity baseSchoolMsgDTO=baseSchoolMapper.findSchoolMsgDetail(strSchoolId);
		return baseSchoolMsgDTO;
	}

	/**
	*这是查询园校对应的所属地区
	*@author:zyml
	*@date:2017年7月5日下午8:40:04
	*/
	@Override
	public List<BaseEntity> findSchoolListOnly() {
		List<BaseEntity> list=baseSchoolMapper.findSchoolListOnly();
		return list;
	}

}
