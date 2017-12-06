package com.vision.edu.service.member.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemSchoolRecipeDetailDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseGroup;
import com.vision.edu.entity.member.MemSchoolRecipe;
import com.vision.edu.entity.member.MemSchoolRecipeDetail;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumGroupType;
import com.vision.edu.mapper.member.MemSchoolRecipeDetailMapper;
import com.vision.edu.mapper.member.MemSchoolRecipeMapper;
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
public class MemSchoolRecipeDetailServiceImpl extends ServiceImpl<MemSchoolRecipeDetailMapper, MemSchoolRecipeDetail> implements IMemSchoolRecipeDetailService {
   
	@Autowired
	private MemSchoolRecipeDetailMapper memSchoolRecipeDetailMapper;
	@Autowired
	private MemSchoolRecipeMapper memSchoolRecipeMapper;
	
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
	@Override
	public List<MemSchoolRecipeDetailDTO> findMemSchoolRecipeDetails(Pagination page,
			MemSchoolRecipeDetailDTO memSchoolRecipeDetailDTO,String year,String month) {
		return memSchoolRecipeDetailMapper.findMemSchoolRecipeDetails(page, memSchoolRecipeDetailDTO, year, month);
	}

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
	@Override
	public List<MemSchoolRecipeDetailDTO> findzhouandyears(Pagination page,
			MemSchoolRecipeDetailDTO memSchoolRecipeDetailDTO, String year, String month) {
		return memSchoolRecipeDetailMapper.findzhouandyears(page, memSchoolRecipeDetailDTO, year, month);
	}
	/**
	 *  删除周谱
	 * @author ChenWenWu
	 * @date 2017年7月31日 上午11:40:32
	 * @return
	 */
	@Override
	public Integer delMemSchoolRecipeDetail(String ids) {
		MemSchoolRecipe memSchoolRecipe=new  MemSchoolRecipe();
		MemSchoolRecipeDetail memSchoolRecipeDetail =new MemSchoolRecipeDetail();
		memSchoolRecipe.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		memSchoolRecipeDetail.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		String [] id = ids.split(",");
		String []  aa=new String[id.length];
		 Integer num=0;
		 for (int i = 0; i < id.length; i++) {
			 aa[i]=id[i];
		}
		 for(int i = 0; i <aa.length; i++){
			 memSchoolRecipe.setId(aa[i]);
			 memSchoolRecipeMapper.updateById(memSchoolRecipe);
				EntityWrapper<MemSchoolRecipeDetail> ew = new EntityWrapper<MemSchoolRecipeDetail>();
	        	ew.where("school_recipe_id = {0}",aa[i]);
	    		ew.setSqlSelect("id");
	    		List<MemSchoolRecipeDetail> list= memSchoolRecipeDetailMapper.selectList(ew);
	    		int z=list.size();
	    		for (int j = 0; j < z; j++) {
	    			memSchoolRecipeDetail.setId(list.get(j).getId());
				}
	    	num+=memSchoolRecipeDetailMapper.updateById(memSchoolRecipeDetail);
		 }
		
		return num;
	}
}
