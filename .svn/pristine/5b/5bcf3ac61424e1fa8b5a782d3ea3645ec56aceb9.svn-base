package com.vision.edu.service.base;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.BaseSignRecordDto;
import com.vision.edu.entity.base.BaseSignRecord;

/**
 * <p>
 * 签到记录 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseSignRecordService extends IService<BaseSignRecord> {

	/**
	 * 根据班级id查询考勤签到记录
	 * @author lichenglong
	 * @date 2017年7月16日 下午4:20:02
	 * @param babyId 班级id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<BaseSignRecordDto> findAttendanceSignIn(String classId,Integer resourcesType,Integer deleteFlag);

	/**
	 * 签到集合字段
	 * @author lichenglong
	 * @date 2017年7月18日 下午3:42:37
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<BaseSignRecordDto> findSignInCollectionField(Integer resourcesType, String resourcesId, Integer deleteFlag);

	/**
	 * 根据签到id查询出宝贝签到信息
	 * @author lichenglong
	 * @date 2017年7月25日 下午9:42:11
	 * @param signRecordId 签到id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<BaseSignRecordDto> findAttendanceRetroactive(String signRecordId, Integer deleteFlag);

	/**
	 * 根据班级id查询出宝贝的接送情况
	 * @author lichenglong
	 * @date 2017年7月26日 下午3:48:57
	 * @param classId 班级id
	 * @param recordType 签到记录类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<BaseSignRecordDto> findTransportSituation(String classId, Integer recordType, Integer deleteFlag);
	
}
