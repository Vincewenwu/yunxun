package com.vision.edu.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.BaseLableShoolDTO;
import com.vision.edu.entity.base.BaseLable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseLableService extends IService<BaseLable> {
	  /**
     * 
     * @author ChenWenWu
     * @date 2017年8月2日 下午3:34:54
     * @param page
     * @param baseBabySchoolDTO
     * @return
     */
	 List<BaseLableShoolDTO> findBaseLableShoolDTO(Pagination page,BaseLableShoolDTO baseLableShoolDTO);
     /**
      * 删除标签
      * @author ChenWenWu
      * @date 2017年8月2日 下午5:08:19
      * @param ids
      * @return
      */
	 Integer delbaseLable(String ids,String updateman);
}
