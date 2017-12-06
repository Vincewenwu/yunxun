package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.MemLeaveRecordDto;
import com.vision.edu.entity.member.MemLeaveRecord;

/**
 * <p>
  * 请假记录表 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemLeaveRecordMapper extends BaseMapper<MemLeaveRecord> {
	
	/**
	 * 根据教师id查询请假审批记录
	 * @author lichenglong
	 * @date 2017年7月25日 下午4:12:48
	 * @param addresseeId 教师id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<MemLeaveRecordDto> findAskForLeaveApproval(@Param("addresseeId")String addresseeId,@Param("deleteFlag")Integer deleteFlag);

	/**
	 * 根据请假记录id查询出请假信息详情
	 * @author lichenglong
	 * @date 2017年7月25日 下午5:00:33
	 * @param leaveRecordId 请假记录id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<MemLeaveRecordDto> findleaveTheDetails(@Param("leaveRecordId")String leaveRecordId,@Param("deleteFlag")Integer deleteFlag);
}