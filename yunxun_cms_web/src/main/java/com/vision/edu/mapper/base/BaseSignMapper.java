package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.KaoQinTongJiDTO;
import com.vision.edu.dto.SignDTO;
import com.vision.edu.entity.base.BaseSign;

/**
 * <p>
  * 签到表，宝贝排班的时候就要添加到签到表，每天定时更新这表的状态。签到，签离时候更新这签到状态，同时同步新增一条签到记录到 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseSignMapper extends BaseMapper<BaseSign> {

	/**
	 * 查询签到
	 * @author jiangwangying
	 * @date 2017年8月3日 下午3:40:46
	 * @param page 分页
	 * @param schoolId 学校id
	 * @param vague 关键字
	 * @param classId 班级id
	 * @param signState 签到状态
	 * @return
	 */
	List<SignDTO> findSign(Pagination page,@Param("schoolId") String schoolId,@Param("vague") String vague,@Param("classId") String classId,@Param("signState")Integer signState);
	
	/**
	 * 查询未签到宝贝
	 * @author jiangwangying
	 * @date 2017年8月2日 下午8:41:26
	 * @param schoolId
	 * @param classId
	 * @return
	 */
	List<SignDTO> findNoSignBaby(@Param("schoolId") String schoolId,@Param("classId") String classId);

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
	List<KaoQinTongJiDTO> kaoQinTongJiBySign(Pagination page,@Param("schoolId")String schoolId,@Param("babyId") String babyId,@Param("classId") String classId,@Param("deleteFlag") Integer deleteFlag);
}