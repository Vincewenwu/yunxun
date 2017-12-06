package com.vision.edu.service.member.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemLeaveRecordDto;
import com.vision.edu.entity.member.MemLeaveRecord;
import com.vision.edu.mapper.member.MemLeaveRecordMapper;
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
@Transactional
public class MemLeaveRecordServiceImpl extends ServiceImpl<MemLeaveRecordMapper, MemLeaveRecord> implements IMemLeaveRecordService {
	
	@Autowired
	private MemLeaveRecordMapper memLeaveRecordMapper;//注入MemLeaveRecordMapper
	
	/**
	 * 根据教师id查询请假审批记录
	 * @author lichenglong
	 * @date 2017年7月25日 下午4:12:48
	 * @param addresseeId 教师id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public List<MemLeaveRecordDto> findAskForLeaveApproval(String addresseeId,Integer deleteFlag){
		List<MemLeaveRecordDto> listMemLeaveRecordDto = memLeaveRecordMapper.findAskForLeaveApproval(addresseeId, deleteFlag);
		return listMemLeaveRecordDto;
	}
	
	/**
	 * 根据请假记录id查询出请假信息详情
	 * @author lichenglong
	 * @date 2017年7月25日 下午5:00:33
	 * @param leaveRecordId 请假记录id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public List<MemLeaveRecordDto> findleaveTheDetails(String leaveRecordId,Integer deleteFlag){
		List<MemLeaveRecordDto> listMemLeaveRecordDto = memLeaveRecordMapper.findleaveTheDetails(leaveRecordId, deleteFlag);
		return listMemLeaveRecordDto;
	}
}
