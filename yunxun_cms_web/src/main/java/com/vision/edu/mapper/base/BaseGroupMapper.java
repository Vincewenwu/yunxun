package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.GroupSchoolDTO;
import com.vision.edu.entity.base.BaseGroup;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
  * 会员组 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseGroupMapper extends BaseMapper<BaseGroup> {

	/**
	 * 查询分组中的园校
	 * @author jiangwangying
	 * @date 2017年7月23日 下午12:07:49
	 * @param schoolId 园校id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<GroupSchoolDTO> findSchoolGroup(@Param("schoolId")String schoolId,@Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 移除分组
	 * @author jiangwangying
	 * @date 2017年8月9日 上午9:34:45
	 * @param teacherId 教师id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	public List<BaseGroup> findRemoveGroup(@Param("teacherId")String teacherId,@Param("deleteFlag")Integer deleteFlag);
}