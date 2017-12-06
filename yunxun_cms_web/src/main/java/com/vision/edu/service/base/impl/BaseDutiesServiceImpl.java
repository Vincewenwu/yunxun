package com.vision.edu.service.base.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseDuties;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.mapper.base.BaseDutiesMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseDutiesService;

/**
 * <p>
 * 职务表 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseDutiesServiceImpl extends ServiceImpl<BaseDutiesMapper, BaseDuties> implements IBaseDutiesService {
	
	@Autowired
	private BaseDutiesMapper baseDutiesMapper;
	
	/**
	 * 模糊查询职务
	 * @author jiangwangying
	 * @date 2017年7月30日 下午8:01:01
	 * @param page 分页
	 * @param vague 搜索词条
	 * @param schoolId 园校id
	 * @return
	 */
	public List<BaseDuties> findDutiesByVague(Pagination page,String vague, String schoolId){
		
		return baseDutiesMapper.findDutiesByVague(page,vague,schoolId);

	}
	
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
	public JsonResult addDuities(String dutiesName,String schoolId,Integer memberType,String createMan,String description){
		
		JsonResult jsonResult = new JsonResult();
		Integer result = 0;
		BaseDuties baseDuties = new BaseDuties();
		baseDuties.setDutiesName(dutiesName);
		baseDuties.setSchoolId(schoolId);
		baseDuties.setCreateMam(createMan);
		baseDuties.setCreateTime(new Date());
		baseDuties.setDeleteFlag2(EnumDeleteFlag.WSC.getValue());
		baseDuties.setDescription(description);
		result += baseDutiesMapper.insert(baseDuties);
		
		if (result > 0) {
			jsonResult.setSuccess(true);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("新增失败");
		}
		return jsonResult;
	}
}
