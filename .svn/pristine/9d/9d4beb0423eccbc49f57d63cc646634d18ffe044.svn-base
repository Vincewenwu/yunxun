package com.vision.edu.service.member.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.LeaveRecordDTO;
import com.vision.edu.entity.member.MemLeaveRecord;
import com.vision.edu.enums.EnumCheckFlag;
import com.vision.edu.mapper.member.MemLeaveRecordMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.member.IMemLeaveRecordService;

/**
 * <p>
 * 请假记录表 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemLeaveRecordServiceImpl extends ServiceImpl<MemLeaveRecordMapper, MemLeaveRecord> implements IMemLeaveRecordService {

	
	@Autowired
	private MemLeaveRecordMapper memLeaveRecordMapper;
	
	/**
	 * 查询宝贝请假记录
	 * @param page 分页
	 * @param schoolId
	 * @param classId
	 * @param vague 关键字
	 * @param checkFlag
	 * @param memberType
	 * @param deleteFlag
	 * @return=
	 */
	public List<LeaveRecordDTO> findBabyLeaveRecord(Pagination page,String schoolId,String classId,String vague,Integer checkFlag,Integer memberType,Integer deleteFlag){
		
		return memLeaveRecordMapper.findBabyLeaveRecord(page,schoolId,classId,vague,checkFlag,memberType,deleteFlag);
	}
	
	/**
	 * 审核请假人
	 * @author jiangwangying
	 * @date 2017年7月24日 下午5:06:38
	 * @param id
	 * @param checkState 1： 审核通过  2:审核不通过
	 * @param checkMan 审核人
	 * @return
	 */
	public JsonResult checkLeaveRecord(String id, String checkState,String checkMan) {
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.setSuccess(false);
		int result = 0;
		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(checkMan)) {
			return jsonResult;
		}
		
		MemLeaveRecord memLeaveRecord = new MemLeaveRecord();
		memLeaveRecord.setId(id);
		memLeaveRecord.setCheckFlag(EnumCheckFlag.YSH.getValue());
		memLeaveRecord.setCheckMan(checkMan);
		memLeaveRecord.setCheckTime(new Date());
		result += memLeaveRecordMapper.updateById(memLeaveRecord);
		
		if (result > 0) {
			
			jsonResult.setSuccess(true);
		}
		
		return jsonResult;
	}
	
}
