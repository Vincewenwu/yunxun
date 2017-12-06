package com.vision.edu.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemDynamicDto;
import com.vision.edu.entity.member.MemDynamic;
import com.vision.edu.mapper.member.MemDynamicMapper;
import com.vision.edu.service.member.IMemDynamicService;

/**
 * <p>
 * 动态表包含[成长轨迹，营养食谱，班级圈，课堂动态，考勤签到....] 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-17
 */
@Service
@Transactional
public class MemDynamicServiceImpl extends ServiceImpl<MemDynamicMapper, MemDynamic> implements IMemDynamicService {
	
	@Autowired
	private MemDynamicMapper memDynamicMapper;//注入MemDynamicMapper
	
	/**
	 * 和班-全部动态 
	 * @author lichenglong
	 * @date 2017年7月17日 下午2:45:34
	 * @param classId 班级id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<MemDynamicDto> findWholeInformation(Pagination page,String classId,Integer deleteFlag){
		List<MemDynamicDto> listMemDynamicDto = memDynamicMapper.findWholeInformation(page,classId, deleteFlag);
		return listMemDynamicDto;
	}
	
	/**
	 * 根据状态查询和班信息
	 * @author lichenglong
	 * @date 2017年7月23日 上午10:23:28
	 * @param page 翻页集合
	 * @param classId 班级id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<MemDynamicDto> findAKindOfDynamic(Pagination page,String classId,Integer resourcesType,Integer deleteFlag){
		List<MemDynamicDto> listMemDynamicDto = memDynamicMapper.findAKindOfDynamic(page,classId,resourcesType,deleteFlag);
		return listMemDynamicDto;
	}
}
