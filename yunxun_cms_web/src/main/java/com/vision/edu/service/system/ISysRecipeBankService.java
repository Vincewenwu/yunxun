package com.vision.edu.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.SysRecipeBankDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.system.SysRecipeBank;

/**
 * <p>
 * 平台食谱库 服务类
 * </p>
 *
 * @author zhangfeihong
 * @since 2017-07-09
 */
public interface ISysRecipeBankService extends IService<SysRecipeBank> {

	/**
	 * 查询食谱
	 * @author ChenWenWu
	 * @date 2017年7月10日 上午11:55:02
	 * @param page 分页实体
	 * @param dishNmae 菜名
	 * @param schoolName 院所名称
	 * @return
	 */
	List<SysRecipeBankDTO> findSysRecipeBankDTO(Pagination page, String dishNmae, String baseSchoolName);
    
}
