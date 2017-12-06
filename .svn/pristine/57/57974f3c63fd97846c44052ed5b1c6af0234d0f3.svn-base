package com.vision.edu.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseDuties;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 职务表 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseDutiesService extends IService<BaseDuties> {
	
	/**
	 * 模糊查询职务
	 * @author jiangwangying
	 * @date 2017年7月30日 下午8:01:01
	 * @param page 分页
	 * @param vague 搜索词条
	 * @param schoolId 园校id
	 * @return
	 */
	List<BaseDuties> findDutiesByVague(Pagination page,String vague, String schoolId);
	
	/**
	 * 添加职务
	 * @author jiangwangying
	 * @date 2017年7月30日 下午8:16:53
	 * @param dutiesName 职务
	 * @param schoolId 园校id
	 * @param memberType 用户类型
	 * @param createMan 新建人
	 * @param description 描述
	 * @return
	 */
	public JsonResult addDuities(String dutiesName,String schoolId,Integer memberType, String createMan,String description);
}
