package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.LeaveRecordDTO;
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
	 * 查询宝贝请假记录
	 * @author jiangwangying
	 * @date 2017年7月22日 下午4:32:57
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param classId 班级id
	 * @param babyName 宝贝名称
	 * @param checkFlag 审核否
	 * @param memberType 类型  宝贝/教师
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<LeaveRecordDTO> findBabyLeaveRecord(Pagination page,@Param("schoolId")String schoolId,@Param("classId")String classId,@Param("vague") String babyName,
			@Param("checkFlag") Integer checkFlag,@Param("memberType") Integer memberType,@Param("deleteFlag") Integer deleteFlag);

}