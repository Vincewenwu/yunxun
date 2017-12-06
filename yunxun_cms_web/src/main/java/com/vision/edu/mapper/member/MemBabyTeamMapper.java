package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.member.MemBabyTeam;

/**
 * <p>
  * 宝贝学期表 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-25
 */
public interface MemBabyTeamMapper extends BaseMapper<MemBabyTeam> {

	/**
	 * 根据宝贝ID查询宝贝学期信息
	 * <p>Title: findTreamByBabyId</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月25日 上午9:25:24
	 * @param babyId 参数id
	 * @return
	 */
	List<BaseEntity> findTreamByBabyId(@Param("babyId")String babyId);

}