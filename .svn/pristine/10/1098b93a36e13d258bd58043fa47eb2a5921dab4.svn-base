package com.vision.edu.mapper.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.member.MemChildHomeEval;

/**
 * <p>
  * 家长给孩子的在家表现评价 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemChildHomeEvalMapper extends BaseMapper<MemChildHomeEval> {

	/**
	 * 分页查询宝贝在家评价信息
	 * <p>Title: findAtHomeEvaluating</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月27日 上午11:44:48
	 * @param page 分页参数
	 * @param map 参数集合
	 * @return
	 */
	List<BaseEntity> findAtHomeEvaluating(Page<BaseEntity> page,@Param("map") Map<String, Object> map);
	/**
	 * 根据年级ID查询家长对宝贝的评价的项目、评价标准
	 * <p>Title: findParentEvalContent</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月27日 下午8:39:17
	 * @param babyTeamId 参数年级ID
	 * @return
	 */
	List<BaseEntity> findParentEvalContent(@Param("babyTeamId")String babyTeamId);
}