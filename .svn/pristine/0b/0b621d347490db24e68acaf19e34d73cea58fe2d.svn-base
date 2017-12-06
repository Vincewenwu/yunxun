package com.vision.edu.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.SysRecipeBankDTO;
import com.vision.edu.entity.base.BaseRecipeBank;
import com.vision.edu.entity.member.MemSchoolRecipe;
import com.vision.edu.entity.member.MemSchoolRecipeDetail;
import com.vision.edu.entity.system.SysRecipeBank;

/**
 * <p>
 * 园校食谱库，用于记录园校的食谱库 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseRecipeBankService extends IService<BaseRecipeBank> {
	
	/**
	 * 查询菜谱表
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午9:37:12
	 * @param page
	 * @param schoolId
	 * @param schoolname
	 * @param infotype
	 * @return
	 */
	List<BaseRecipeBank> findBaseRecipeBank(Pagination page, BaseRecipeBank baseRecipeBank);
	/**
	 * 新增校园菜谱和平台菜谱
	 * @author ChenWenWu
	 * @date 2017年7月25日 下午2:34:17
	 * @param baseRecipeBank
	 * @return
	 */
	String addSysRecipeBank(BaseRecipeBank baseRecipeBank,String pingtai);
	
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
	   * 发布菜谱，顺便发布动态
	   * @author ChenWenWu
	   * @date 2017年8月4日 下午5:46:02
	   * @param memSchoolRecipeDetail
	   * @param PublishTime
	   * @param weekly
	   * @param xycpName
	   * @return
	   */
	Integer addMemSchoolRecipe(MemSchoolRecipeDetail memSchoolRecipeDetail,String shoolid,String loginID,String PublishTime,Integer weekly,String xycpName);
	
	/**
	 *根据下拉框选择绑定平台食谱
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午9:37:12
	 * @param id 平台食谱ID
	 * @return
	 */
	SysRecipeBank findOneSysRecipeBank( String id);
}
