package com.vision.edu.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.BaseSignRecordDto;
import com.vision.edu.entity.base.BaseSignRecord;
import com.vision.edu.mapper.base.BaseSignRecordMapper;
import com.vision.edu.service.base.IBaseSignRecordService;

/**
 * <p>
 * 签到记录 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class BaseSignRecordServiceImpl extends ServiceImpl<BaseSignRecordMapper, BaseSignRecord> implements IBaseSignRecordService {
	
	@Autowired
	private BaseSignRecordMapper baseSignRecordMapper;//注入BaseSignRecordMapper
	
	/**
	 * 根据班级id查询考勤签到记录
	 * @author lichenglong
	 * @date 2017年7月16日 下午4:19:06
	 * @param babyId 班级id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<BaseSignRecordDto> findAttendanceSignIn(String classId,Integer resourcesType,Integer deleteFlag){
		List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordMapper.findAttendanceSignIn(classId,resourcesType,deleteFlag);
		return listBaseSignRecordDto;
	}
	
	/**
	 * 签到集合字段
	 * @author lichenglong
	 * @date 2017年7月18日 下午3:42:37
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<BaseSignRecordDto> findSignInCollectionField(Integer resourcesType,String resourcesId,Integer deleteFlag){
		List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordMapper.findSignInCollectionField(resourcesType, resourcesId, deleteFlag);
		return listBaseSignRecordDto;
	}
	
	/**
	 * 根据签到id查询出宝贝签到信息
	 * @author lichenglong
	 * @date 2017年7月25日 下午9:42:11
	 * @param signRecordId 签到id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<BaseSignRecordDto> findAttendanceRetroactive(String signRecordId,Integer deleteFlag){
		List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordMapper.findAttendanceRetroactive(signRecordId, deleteFlag);
		return listBaseSignRecordDto;
	}
	
	/**
	 * 根据班级id查询出宝贝的接送情况
	 * @author lichenglong
	 * @date 2017年7月26日 下午3:48:57
	 * @param classId 班级id
	 * @param recordType 签到记录类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<BaseSignRecordDto> findTransportSituation(String classId,Integer recordType,Integer deleteFlag){
		List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordMapper.findTransportSituation(classId, recordType, deleteFlag);
		return listBaseSignRecordDto;
	}
}
