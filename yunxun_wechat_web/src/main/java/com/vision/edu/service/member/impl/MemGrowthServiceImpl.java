package com.vision.edu.service.member.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemGrowthDto;
import com.vision.edu.entity.member.MemGrowth;
import com.vision.edu.mapper.member.MemGrowthMapper;
import com.vision.edu.service.member.IMemGrowthService;

/**
 * <p>
 * 成长轨迹 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class MemGrowthServiceImpl extends ServiceImpl<MemGrowthMapper, MemGrowth> implements IMemGrowthService {
	
	@Autowired
	private MemGrowthMapper memGrowthMapper;
	
	/**
	 * 根据班级id查询和班中的成长轨迹
	 * @author lichenglong
	 * @date 2017年7月16日 下午9:46:18
	 * @param classId 班级id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public List<MemGrowthDto> findGrowthTrack(String classId,Integer resourcesType,Integer deleteFlag){
		List<MemGrowthDto> listMemGrowthDto = memGrowthMapper.findGrowthTrack(classId, resourcesType, deleteFlag);
		return listMemGrowthDto;
	}
	
	/**
	 * 成长轨迹集合字段
	 * @author lichenglong
	 * @date 2017年7月18日 下午3:59:37
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<MemGrowthDto> findGrowthTrajectoryCollectionField(Integer resourcesType,String resourcesId,Integer deleteFlag){
		List<MemGrowthDto> listMemGrowthDto = memGrowthMapper.findGrowthTrajectoryCollectionField(resourcesType, resourcesId, deleteFlag);
		return listMemGrowthDto;
	}
}
