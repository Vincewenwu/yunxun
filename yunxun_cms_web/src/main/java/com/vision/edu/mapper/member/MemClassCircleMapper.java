package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.MemClassCircleDTO;
import com.vision.edu.dto.OneBabybaseSurrogateDTO;
import com.vision.edu.entity.member.MemBabySurrogate;
import com.vision.edu.entity.member.MemClassCircle;

/**
 * <p>
  * 班级圈 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemClassCircleMapper extends BaseMapper<MemClassCircle> {

	/**
	 * 查询班级《圈》信息
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午3:27:03
	 * @param page
	 * @param memClassCircleDTO 班级圈实体
	 * @return
	 */
	 List<MemClassCircleDTO> findMemClassCircleDTO(Pagination page, @Param ("memClassCircleDTO")MemClassCircleDTO memClassCircleDTO );
		
}