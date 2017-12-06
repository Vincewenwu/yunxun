package com.vision.edu.service.member.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemSchoolRecipeDetailDto;
import com.vision.edu.entity.member.MemSchoolRecipeDetail;
import com.vision.edu.mapper.member.MemSchoolRecipeDetailMapper;
import com.vision.edu.service.member.IMemSchoolRecipeDetailService;

/**
 * <p>
 * 园校食谱明细，用于记录每天的餐时 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class MemSchoolRecipeDetailServiceImpl extends ServiceImpl<MemSchoolRecipeDetailMapper, MemSchoolRecipeDetail> implements IMemSchoolRecipeDetailService {
	
	@Autowired
	private MemSchoolRecipeDetailMapper memSchoolRecipeDetailMapper;//注入MemSchoolRecipeDetailMapper
	
	/**
	 * 根据学校id查询该学校的食谱
	 * @author lichenglong
	 * @date 2017年7月16日 下午2:51:01
	 * @param schoolId 学校id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<MemSchoolRecipeDetailDto> findSchoolRecipes(String schoolId,Integer resourcesType,Integer deleteFlag){
		List<MemSchoolRecipeDetailDto> listMemSchoolRecipeDetailDto = memSchoolRecipeDetailMapper.findSchoolRecipes(schoolId,resourcesType, deleteFlag);
		return listMemSchoolRecipeDetailDto;
	}
	
	/**
	 * 和班菜谱集合
	 * @author lichenglong
	 * @date 2017年7月18日 下午3:29:41
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<MemSchoolRecipeDetailDto> findRecipeCollectionField(Integer resourcesType,String resourcesId,Integer deleteFlag){
		List<MemSchoolRecipeDetailDto> listMemSchoolRecipeDetailDto = memSchoolRecipeDetailMapper.findRecipeCollectionField(resourcesType, resourcesId, deleteFlag);
		return listMemSchoolRecipeDetailDto;
	}
}
