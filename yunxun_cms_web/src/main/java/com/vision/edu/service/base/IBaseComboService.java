package com.vision.edu.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseCombo;

/**
 * <p>
 * 套餐 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseComboService extends IService<BaseCombo> {
	
	/**
	 * 
	 * @author ChenWenWu
	 * @date 2017年7月28日 下午3:54:51
	 * @param page
	 * @param baseCombo 套餐实体
	 * @return
	 */
	 List<BaseCombo> findBaseCombopage(Pagination page,BaseCombo baseCombo);
	 /**
	  * 修改提醒消息得确认标记
	  * @author ChenWenWu
	  * @date 2017年8月2日 上午9:02:34
	  * @return
	  */
	 Integer editBaseCombo(String ids);

}
