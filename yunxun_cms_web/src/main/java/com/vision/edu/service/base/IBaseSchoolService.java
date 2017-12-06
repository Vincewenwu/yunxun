package com.vision.edu.service.base;

import java.util.List;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.platform.common.result.JsonResult;

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
	 * 模糊查询园校                                   
	 * @author jiangwangying
	 * @date 2017年7月6日 上午10:49:08
	 * @param page
	 * @param schoolId
	 * @param schoolName
	 * @param deleteFlag
	 * @return
	 */
	List<BaseSchool> findSchoolByDynamic(Pagination page, String schoolId, String schoolName, Integer deleteFlag);
	
	/**
	 * 新增园校
	 * @author jiangwangying
	 * @date 2017年8月7日 下午2:14:05
	 * @param baseSchool
	 * @param createMan
	 * @return
	 */
	JsonResult addSchool(BaseSchool baseSchool,String createMan);
	
	/**
	 * 逻辑删除园校/停用园校
	 * @author jiangwangying
	 * @date 2017年7月18日 上午8:00:57
	 * @param schoolIds 园校id集合
	 * @param delOrStopSchool 0:逻辑删除  1:停用园校
	 * @param updateMan 修改人
	 * @return 
	 */
	JsonResult delOrStopSchool(String schoolIds,Integer delOrStopSchool, String updateMan);
	
	/**
	 * 编辑园校
	 * @author jiangwangying
	 * @date 2017年7月18日 下午8:11:04
	 * @param baseSchool
	 * @return
	 */
	JsonResult editSchool(BaseSchool baseSchool);
}
