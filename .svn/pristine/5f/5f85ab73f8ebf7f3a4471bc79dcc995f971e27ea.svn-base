package com.vision.edu.service.member.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.member.MemChildHomeEval;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.mapper.member.MemChildHomeEvalMapper;
import com.vision.edu.service.member.IMemChildHomeEvalService;

/**
 * <p>
 * 家长给孩子的在家表现评价 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemChildHomeEvalServiceImpl extends ServiceImpl<MemChildHomeEvalMapper, MemChildHomeEval> implements IMemChildHomeEvalService {

	@Autowired
	private MemChildHomeEvalMapper memChildHomeEvalMapper;
	/**
	 * <p>Title: findAtHomeEvaluating</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月27日 上午11:38:57
	 * @param page
	 * @param map
	 * @return
	 */
	@Override
	public Page<BaseEntity> findAtHomeEvaluating(Page<BaseEntity> page, Map<String, Object> map) {
		page.setRecords(super.baseMapper.findAtHomeEvaluating(page, map));
		return page;
	}
	/**
	 * 根据年级ID查询家长对宝贝的评价的项目、评价标准得星数
	 * findParentEvalContent
	 * <p>Title: findParentEvalContent</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月27日 下午8:27:55
	 * @param gradeId 参数年级ID
	 * @return
	 */
	@Override
	public List<BaseEntity> findParentEvalContent(String babyTeamId) {
		return this.memChildHomeEvalMapper.findParentEvalContent(babyTeamId);
	}
	/**
	 * 删除宝贝在家评价信息
	 * <p>Title: updateParentEvaluatingById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月28日 上午12:47:48
	 * @param babyTeamId
	 * @return
	 */
	@Override
	public Integer updateParentEvaluatingById(MemChildHomeEval memChildHomeEval) {
		memChildHomeEval.setUpdateTime(new Date());
		memChildHomeEval.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		Wrapper<MemChildHomeEval> wrapper=new EntityWrapper<>();
		wrapper.where("baby_team_id={0}", memChildHomeEval.getBabyTeamId());
		Integer i= this.baseMapper.update(memChildHomeEval, wrapper);
		return i;
	}
	
}
