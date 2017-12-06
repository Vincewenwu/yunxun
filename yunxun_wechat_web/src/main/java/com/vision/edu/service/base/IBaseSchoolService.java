package com.vision.edu.service.base;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.BaseSchoolDTO;
import com.vision.edu.dto.BaseSchoolMsgDTO;
import com.vision.edu.entity.base.BaseSchool;

/**
 * <p>
 * 园校，记录的是园校的基本信息 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseSchoolService extends IService<BaseSchool> {
	

	/**
	*这是查询园校对应的所属地区
	*@author:zyml
	*@date:2017年7月5日下午8:59:51
	*/
	List<BaseSchoolDTO> findSchoolList();

	/**
	*模糊查询院校信息
	*@author:zyml
	*@date:2017年7月6日上午9:06:18
	*@param strSchoolName 学校名称
	*/
	List<String> findSchool(String strSchoolName);

	/**
	*查询学校的院所信息
	*@author:zyml
	*@date:2017年7月6日上午11:30:34
	*@param strSchoolName 学校名称
	*/
	BaseSchoolMsgDTO findSchoolMsg(String strSchoolName);

	/**
	*根据学校的id查询园所介绍的基本信息
	*@author:zyml
	*@date:2017年7月10日下午2:15:07
	*@param strSchoolId 学校id
	*@return
	*/
	BaseEntity findSchoolMsgBase(String strSchoolId);

	/**
	*根据学校的id查询园所介绍的详细信息
	*@author:zyml
	*@date:2017年7月16日下午3:50:27
	*@param strSchool 学校id
	*/
	BaseEntity findSchoolMsgDetail(String strSchoolId);

	/**
	*这是查询园校对应的所属地区
	*@author:zyml
	*@date:2017年7月5日下午8:40:04
	*/
	List<BaseEntity> findSchoolListOnly();
}
