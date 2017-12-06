package com.vision.edu.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.BaseBabySchoolDTO;
import com.vision.edu.dto.BaseLableShoolDTO;
import com.vision.edu.entity.base.BaseLable;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface BaseLableMapper extends BaseMapper<BaseLable> {

      /**
       * 
       * @author ChenWenWu
       * @date 2017年8月2日 下午3:34:54
       * @param page
       * @param baseBabySchoolDTO
       * @return
       */
	 List<BaseLableShoolDTO> findBaseLableShoolDTO(Pagination page,@Param("baseLableShoolDTO")BaseLableShoolDTO baseLableShoolDTO);

}