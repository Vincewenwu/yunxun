package com.vision.edu.mapper.base;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.KaoQinTongJiDTO;
import com.vision.edu.dto.SigStatisticsDTO;
import com.vision.edu.dto.SignDTO;
import com.vision.edu.entity.base.BaseSignRecord;

/**
 * <p>
  * 签到记录 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseSignRecordMapper extends BaseMapper<BaseSignRecord> {

	/**
	 * 考勤统计
	 * @author jiangwangying
	 * @date 2017年8月3日 下午9:17:18
	 * @param schoolId 学校id
	 * @param babyId 宝贝id
	 * @param classId 班级id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param deleteFlag 删除标记
	 * @param signState 签到状态
	 * @return
	 */
	List<KaoQinTongJiDTO> kaoQinTongJi(@Param("schoolId")String schoolId,@Param("babyId") String babyId,@Param("classId") String classId,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("deleteFlag") Integer deleteFlag);


	

}