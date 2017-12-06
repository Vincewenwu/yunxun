package com.vision.edu.service.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.MemSchoolRecipeDetailDTO;
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
	 * 根据年份月份查询周谱
	 * @author ChenWenWu
	 * @date 2017年7月31日 上午11:39:06
	 * @param page
	 * @param memSchoolRecipeDetailDTO 条件实体
	 * @param year 年份
	 * @param month 月份
	  * @return
	 */
	List<MemSchoolRecipeDetailDTO> findMemSchoolRecipeDetails(Pagination page, MemSchoolRecipeDetailDTO memSchoolRecipeDetailDTO,String year,String month);
	
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
	List<MemSchoolRecipeDetailDTO> findzhouandyears(Pagination page,@Param ("memSchoolRecipeDetailDTO") MemSchoolRecipeDetailDTO memSchoolRecipeDetailDTO,String year,String month);
   
	Integer delMemSchoolRecipeDetail(String ids);
}
