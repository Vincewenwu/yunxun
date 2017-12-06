package com.vision.edu.service.base.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.SorecastRecord;
import com.vision.edu.entity.base.BaseSorecastRecord;
import com.vision.edu.entity.system.SysPrincipalMailbox;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.mapper.base.BaseSorecastRecordMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseSorecastRecordService;

/**
 * <p>
 * 预报名记录 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseSorecastRecordServiceImpl extends ServiceImpl<BaseSorecastRecordMapper, BaseSorecastRecord> implements IBaseSorecastRecordService {

	@Autowired
	private BaseSorecastRecordMapper baseSorecastRecordMapper;
	
	/**
	 * 查询预报名家长
	 * @author jiangwangying
	 * @date 2017年7月16日 下午5:26:42
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param name 家长姓名
	 * @return=List 预报名家长list集合
	 */
	public List<SorecastRecord> findSorecastRecord(Pagination page, String schoolId, String name) {

		return baseSorecastRecordMapper.findSorecastRecord(page, schoolId, name);
		
	}
	
	/**
	 * 删除预报名家长
	 * @author jiangwangying
	 * @date 2017年7月25日 上午1:45:24
	 * @param ids 主键id集合
	 * @param updateMan 修改人
	 * @return
	 */
	public JsonResult delSorecastRecord(String ids,String updateMan){
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.setSuccess(false);
		if (StringUtils.isEmpty(ids)) {
			return jsonResult;
		}
		
		String[] SorecastRecordIds = ids.split(",");
		Integer idsLength = SorecastRecordIds.length;
		Integer result = 0;
		
		BaseSorecastRecord baseSorecastRecord = null;
		
		for (int i = 0; i < idsLength; i++) {
			baseSorecastRecord = new BaseSorecastRecord();
			baseSorecastRecord.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			baseSorecastRecord.setUpdateMan(updateMan);
			baseSorecastRecord.setUpdateTime(new Date());
			baseSorecastRecord.setId(SorecastRecordIds[i]);
			result += baseSorecastRecordMapper.updateById(baseSorecastRecord);
			if (result==idsLength) {
				jsonResult.setSuccess(true);
			}
		}
		
		return jsonResult;
	}
	
	
}
