package com.vision.edu.mapper.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.member.MemBabyEval;

/**
 * <p>
  * 宝贝评测 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemBabyEvalMapper extends BaseMapper<MemBabyEval> {

	/**
	 * 分页查询老师对宝贝评价信息
	 * <p>Title: findEvaluatingInformation</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 下午11:09:18
	 * @param page 分页
	 * @param map 参数集合
	 * @return
	 */
	List<BaseEntity> findEvaluatingInformation(Page<BaseEntity> page,@Param("map") Map<String, Object> map);
	/**
	 * 根据宝贝学期ID查询老师对宝贝的评价
	 * <p>Title: findEvaluatingById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月24日 上午11:24:01
	 * @param id 主键ID
	 * @return
	 */
	List<BaseEntity> findEvaluatingById(@Param("babyTeamId") String babyTeamId);
	/**
	 * 根据宝贝学期ID查询教师对宝贝的评价
	 * <p>Title: updateMemBabyDeleteFlag</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月26日 下午4:52:40
	 * @param babyTeamId 宝贝学期ID
	 * @return
	 */
	Integer updateMemBabyDeleteFlag(@Param("babyTeamId") String babyTeamId);
	/**
	 * 根据宝贝学期ID查询家长对宝贝的评价
	 * <p>Title: findPanrentEvaluatingByBabyTeamId</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月24日 上午11:24:01
	 * @param id 主键ID
	 * @return
	 */
	List<BaseEntity> findPanrentEvaluatingByBabyTeamId(@Param("babyTeamId") String babyTeamId);
	

	
}