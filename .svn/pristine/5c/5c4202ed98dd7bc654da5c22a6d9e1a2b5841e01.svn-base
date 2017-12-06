package com.vision.edu.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseDistrict;
import com.vision.edu.mapper.base.BaseDistrictMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseDistrictService;

/**
 * <p>
 * 地区 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseDistrictServiceImpl extends ServiceImpl<BaseDistrictMapper, BaseDistrict> implements IBaseDistrictService {

	@Autowired
	private BaseDistrictMapper baseDistrictMapper;
	
	/**
	 * 查询地区
	 * @param pid
	 * @return=
	 */
	public JsonResult findDistricts(int pid){
		
		JsonResult jsonResult = new JsonResult();
		EntityWrapper<BaseDistrict> ew = new EntityWrapper<BaseDistrict>();		
        ew.where("pid = {0}",pid);
        ew.setSqlSelect("id,name");
		List<BaseDistrict> list = baseDistrictMapper.selectList(ew);
		if (list.size()>0) {
			jsonResult.setSuccess(true);
			jsonResult.setObj(list);
		} else {
			jsonResult.setSuccess(false);
		}
		return jsonResult;
	}
	
}
