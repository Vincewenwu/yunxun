package com.vision.edu.service.member;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.member.MemChildHomeEval;

/**
 * <p>
 * 家长给孩子的在家表现评价 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemChildHomeEvalService extends IService<MemChildHomeEval> {

	/**
	 * 分页查询宝贝在家评价信息
	 * <p>Title: findAtHomeEvaluating</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月27日 上午11:37:47
	 * @param page 分页参数
	 * @param map 参数封装
	 * @return
	 */
	Page<BaseEntity> findAtHomeEvaluating(Page<BaseEntity> page, Map<String, Object> map);

	/**
	 * 根据年级ID查询家长对宝贝的评价的项目、评价标准得星数
	 * <p>Title: findParentEvalContent</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月27日 下午11:55:05
	 * @param babyTeamId
	 * @return
	 */
	List<BaseEntity> findParentEvalContent(String babyTeamId);

	/**
	 * 删除宝贝在家评价信息
	 * <p>Title: updateParentEvaluatingById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月28日 上午12:45:47
	 * @param babyTeamId 宝贝学期id
	 * @return
	 */
	Integer updateParentEvaluatingById(MemChildHomeEval memChildHomeEval);
}
