package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.MemSchoolRecipeDetailDto;
import com.vision.edu.entity.member.MemSchoolRecipeDetail;

/**
 * <p>
  * 园校食谱明细，用于记录每天的餐时 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemSchoolRecipeDetailMapper extends BaseMapper<MemSchoolRecipeDetail> {

	/**
	 * 根据学校id查询该学校的食谱
	 * @author lichenglong
	 * @date 2017年7月16日 下午2:45:31
	 * @param schoolId 学校id
	 * @param resourcesType 资源类型
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemSchoolRecipeDetailDto> findSchoolRecipes(@Param("schoolId")String schoolId,@Param("resourcesType")Integer resourcesType,@Param("deleteFlag")Integer deleteFlag);
	
	/**
	 * 和班菜谱集合
	 * @author lichenglong
	 * @date 2017年7月18日 下午3:27:16
	 * @param resourcesType 资源类型
	 * @param resourcesId 资源id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemSchoolRecipeDetailDto> findRecipeCollectionField(@Param("resourcesType")Integer resourcesType,@Param("resourcesId")String resourcesId,@Param("deleteFlag")Integer deleteFlag);
}