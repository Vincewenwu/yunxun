package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.MemSchoolRecipeDetailDTO;
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
 * 根据年份月份查询周谱
 * @author ChenWenWu
 * @date 2017年7月31日 上午11:39:06
 * @param page
 * @param memSchoolRecipeDetailDTO 条件实体
 * @param year 年份
 * @param month 月份
  * @return
 */
	List<MemSchoolRecipeDetailDTO> findMemSchoolRecipeDetails(Pagination page, @Param ("memSchoolRecipeDetailDTO") MemSchoolRecipeDetailDTO memSchoolRecipeDetailDTO,@Param ("year") String year,@Param("month")String month);

	
	/**
	 *  根据年份月查询周次
	 * @author ChenWenWu
	 * @date 2017年7月31日 上午11:40:32
	 * @param page
	 * @param memSchoolRecipeDetailDTO
	 * @param year 年分
	 * @param month 月份
	 * @return
	 */
	List<MemSchoolRecipeDetailDTO> findzhouandyears(Pagination page,@Param ("memSchoolRecipeDetailDTO") MemSchoolRecipeDetailDTO memSchoolRecipeDetailDTO,@Param ("year") String year,@Param("month")String month);

}