package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.BaseSignRecordDto;
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
	 * 根据班级id查询考勤签到记录
	 * @author lichenglong
	 * @date 2017年7月16日 下午4:13:49
	 * @param babyId 班级id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<BaseSignRecordDto> findAttendanceSignIn(@Param("classId")String classId,@Param("resourcesType")Integer resourcesType,@Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 签到集合字段
	 * @author lichenglong
	 * @date 2017年7月18日 下午3:42:37
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<BaseSignRecordDto> findSignInCollectionField(@Param("resourcesType")Integer resourcesType,@Param("resourcesId")String resourcesId,@Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 根据签到id查询出宝贝签到信息
	 * @author lichenglong
	 * @date 2017年7月25日 下午9:42:11
	 * @param signRecordId 签到id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<BaseSignRecordDto> findAttendanceRetroactive(@Param("signRecordId")String signRecordId,@Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 根据班级id查询出宝贝的接送情况
	 * @author lichenglong
	 * @date 2017年7月26日 下午3:48:57
	 * @param classId 班级id
	 * @param recordType 签到记录类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<BaseSignRecordDto> findTransportSituation(@Param("classId")String classId,@Param("recordType")Integer recordType,@Param("deleteFlag")Integer deleteFlag);
}