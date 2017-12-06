package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.BaseSchoolInfoTwoDTO;
import com.vision.edu.entity.base.BaseRecipeBank;
import com.vision.edu.entity.system.SysRecipeBank;

/**
 * <p>
  * 园校食谱库，用于记录园校的食谱库 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseRecipeBankMapper extends BaseMapper<BaseRecipeBank> {
	/**
	 * 查询菜谱表
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午9:37:12
	 * @param page
	 * @param baseRecipeBank 条件实体
	 * @return
	 */
	List<BaseRecipeBank> findBaseRecipeBank(Pagination page,@Param ("baseRecipeBank") BaseRecipeBank baseRecipeBank);

	/**
	 *修改的时候使用 查询单条菜谱表
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午9:37:12
	 * @param page
	 * @param page
	 * @param baseRecipeBank 条件实体
	 * @return
	 */
	BaseRecipeBank findOneBaseRecipeBank(@Param ("baseRecipeBank") BaseRecipeBank baseRecipeBank);

	/**
	 *根据下拉框选择绑定平台食谱
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午9:37:12
	 * @param page
	 * @param page
	 * @param baseRecipeBank 条件实体
	 * @return
	 */
	SysRecipeBank findOneSysRecipeBank(@Param ("id") String id);

	/**
	 * 查询菜谱最大编码
	 * @author ChenWenWu
	 * @date 2017年8月5日 下午9:34:55
	 * @param id
	 * @return
	 */
	BaseRecipeBank findBaseRecipeBankSerialNum(@Param ("schoolId") String schoolId);
}