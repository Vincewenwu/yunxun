package com.vision.edu.service.member;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.member.MemBabyEval;

/**
 * <p>
 * 宝贝评测 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemBabyEvalService extends IService<MemBabyEval> {

	/**
	 * 分页查询老师对宝贝评价
	 * <p>Title: findEvaluatingInformation</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 下午11:06:23
	 * @param page 分页
	 * @param map 参数集合
	 * @return
	 */
	Page<BaseEntity> findEvaluatingInformation(Page<BaseEntity> page, Map<String, Object> map);

	/**
	 * 根据宝贝ID查询老师对宝贝的评价
	 * <p>Title: findEvaluatingById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月24日 上午11:24:01
	 * @param id 主键ID
	 * @return
	 */
	List<BaseEntity> findEvaluatingById(String babyTeamId);

	/**
	 * 根据宝贝学期ID查询宝贝信息
	 * <p>Title: updateMemBabyDeleteFlag</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月26日 下午4:47:11
	 * @param memBabyEval 对象
	 * @return
	 */
	Integer updateMemBabyDeleteFlag(MemBabyEval memBabyEval);

	/**
	 * 根据宝贝学期ID查询家长对宝贝评测信息  
	 * <p>Title: findPanrentEvaluatingByBabyTeamId</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年8月9日 下午10:10:56
	 * @param babyTeamId 宝贝学期id
	 * @return
	 */
	List<BaseEntity> findPanrentEvaluatingByBabyTeamId(String babyTeamId);

}
