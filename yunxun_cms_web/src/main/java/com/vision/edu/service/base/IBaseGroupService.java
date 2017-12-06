package com.vision.edu.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.GroupSchoolDTO;
import com.vision.edu.entity.base.BaseGroup;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 会员组 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseGroupService extends IService<BaseGroup> {
	
	/**
	 * 查询分组中的园校
	 * @author jiangwangying
	 * @date 2017年7月23日 下午12:07:49
	 * @param schoolId 园校id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<GroupSchoolDTO> findSchoolGroup(String schoolId,Integer deleteFlag);

	/**
	 * 移除分组
	 * @author jiangwangying
	 * @date 2017年8月9日 上午9:34:45
	 * @param teacherId 教师id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<BaseGroup> findRemoveGroup(String teacherId, Integer deleteFlag);
}
