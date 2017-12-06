package com.vision.edu.mapper.base;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.BaseSchoolDTO;
import com.vision.edu.dto.BaseSchoolMsgDTO;
import com.vision.edu.entity.base.BaseSchool;

/**
 * <p>
  * 园校，记录的是园校的基本信息 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseSchoolMapper extends BaseMapper<BaseSchool> {

	/**这是查询园校对应的所属地区
	*@author:zyml
	*@date:2017年7月5日下午9:10:04
	*/
	List<BaseSchoolDTO> findSchoolList();

	/**
	*模糊查询院校信息
	*@author:zyml
	*@date:2017年7月6日上午8:42:38
	*@param strSchoolName 学校名称
	*/
	List<String> findSchool(@Param("name") String strSchoolName);

	/**
	*查询学校的院所信息
	*@author:zyml
	*@date:2017年7月6日下午2:29:40
	*@param strSchoolName 学校名称
	*/
	BaseSchoolMsgDTO findSchoolMsg(@Param("name") String strSchoolName);

	/**
	*根据学校的id查询园所介绍的基本信息
	*@author:zyml
	*@date:2017年7月10日下午2:17:33
	*@param strSchoolId 学校id
	*@return
	*/
	BaseEntity findSchoolMsgBase(@Param("id") String strSchoolId);

	/**
	*根据学校的id查询园所介绍的详细信息
	*@author:zyml
	*@date:2017年7月16日下午3:50:27
	*@param strSchool 学校id
	*/
	BaseEntity findSchoolMsgDetail(@Param("id") String strSchoolId);

	/**
	*这是查询园校对应的所属地区
	*@author:zyml
	*@date:2017年7月5日下午8:40:04
	*/
	List<BaseEntity> findSchoolListOnly();

}