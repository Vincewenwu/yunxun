package com.vision.edu.mapper.member;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.entity.member.MemPraise;

/**
 * <p>
  * 点赞记录 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemPraiseMapper extends BaseMapper<MemPraise> {

	/**
	*根据id进行查询点赞数是否唯一显示相应的状态
	*@author:zyml
	*@date:2017年7月22日下午5:46:45
	*@param userId 用户id
	*/
	MemPraise findByUserId(@Param("id") String userId,@Param("id") String sourceId);

	/**
	 *根据点赞记录id进行查询
	*@author:zyml
	*@date:2017年7月23日下午10:06:42
	*@param priaseId 点赞记录id
	*/
	MemPraise findByPriaseId(@Param("id") String priaseId);


}