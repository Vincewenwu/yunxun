package com.vision.edu.service.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.LeaveRecordDTO;
import com.vision.edu.entity.member.MemLeaveRecord;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 请假记录表 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemLeaveRecordService extends IService<MemLeaveRecord> {

	/**
	 * 查询宝贝请假记录
	 * @author jiangwangying
	 * @date 2017年8月8日 上午10:13:54
	 * @param page 分页
	 * @param schoolId
	 * @param classId
	 * @param vague 关键字
	 * @param checkFlag
	 * @param memberType
	 * @param deleteFlag
	 * @return
	 */
	List<LeaveRecordDTO> findBabyLeaveRecord(Pagination page,String schoolId,String classId,String vague,
			Integer checkFlag,Integer memberType,Integer deleteFlag);

	/**
	 * 审核请假人
	 * @author jiangwangying
	 * @date 2017年7月24日 下午5:06:38
	 * @param id
	 * @param checkState 1： 审核通过  2:审核不通过
	 * @param checkMan 审核人
	 * @return
	 */
	JsonResult checkLeaveRecord(String id, String checkState,String checkMan);
	
}
