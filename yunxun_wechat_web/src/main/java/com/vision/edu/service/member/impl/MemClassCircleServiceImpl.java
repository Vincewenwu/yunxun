package com.vision.edu.service.member.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemClassCircleDto;
import com.vision.edu.entity.member.MemClassCircle;
import com.vision.edu.mapper.member.MemClassCircleMapper;
import com.vision.edu.service.member.IMemClassCircleService;

/**
 * <p>
 * 班级圈 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class MemClassCircleServiceImpl extends ServiceImpl<MemClassCircleMapper, MemClassCircle> implements IMemClassCircleService {
	
	@Autowired
	private MemClassCircleMapper memClassCircleMapper;//注入MemClassCircleMapper
	
	/**
	 * 根据班级id查询班级圈
	 * @author lichenglong
	 * @date 2017年7月17日 上午10:03:03
	 * @param classId 班级id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<MemClassCircleDto> findClassRingDynamic(String classId,Integer resourcesType,Integer deleteFlag){
		List<MemClassCircleDto> listMemClassCircleDto = memClassCircleMapper.findClassRingDynamic(classId, resourcesType, deleteFlag);
		return listMemClassCircleDto;
	}
	
	/**
	 * 班级圈动态集合
	 * @author lichenglong
	 * @date 2017年7月18日 下午4:14:16
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<MemClassCircleDto> findDynamicCollectionClassRing(Integer resourcesType,String resourcesId,Integer deleteFlag){
		List<MemClassCircleDto> listMemClassCircleDto = memClassCircleMapper.findDynamicCollectionClassRing(resourcesType, resourcesId, deleteFlag);
		return listMemClassCircleDto;
	}
	
	/**
	 * 根据资源id查询班级圈详情
	 * @author lichenglong
	 * @date 2017年7月22日 上午8:50:41
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<MemClassCircleDto> findClassRingDetails(String resourcesId,Integer deleteFlag){
		List<MemClassCircleDto> listMemClassCircleDto = memClassCircleMapper.findClassRingDetails(resourcesId, deleteFlag);
		return listMemClassCircleDto;
	}
	
}
