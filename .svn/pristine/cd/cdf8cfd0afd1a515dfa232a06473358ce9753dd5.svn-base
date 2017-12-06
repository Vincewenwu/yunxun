package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.MemSchoolRecipeDetailDto;
import com.vision.edu.entity.member.MemSchoolRecipeDetail;

/**
 * <p>
 * 园校食谱明细，用于记录每天的餐时 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemSchoolRecipeDetailService extends IService<MemSchoolRecipeDetail> {

	/**
	 * 根据学校id查询该学校的食谱
	 * @author lichenglong
	 * @date 2017年7月16日 下午2:51:56
	 * @param schoolId 学校id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemSchoolRecipeDetailDto> findSchoolRecipes(String schoolId,Integer resourcesType, Integer deleteFlag);

	/**
	 * 和班菜谱集合
	 * @author lichenglong
	 * @date 2017年7月18日 下午3:29:41
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemSchoolRecipeDetailDto> findRecipeCollectionField(Integer resourcesType, String resourcesId,Integer deleteFlag);
	
}
