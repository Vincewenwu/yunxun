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
import com.vision.edu.entity.base.BaseEvalCrite;
import com.vision.edu.entity.member.MemBabyEval;
import com.vision.edu.entity.member.MemChildHomeEval;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.mapper.base.BaseEvalCriteMapper;
import com.vision.edu.mapper.member.MemBabyEvalMapper;
import com.vision.edu.service.member.IMemBabyEvalService;

/**
 * <p>
 * 宝贝评测 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemBabyEvalServiceImpl extends ServiceImpl<MemBabyEvalMapper, MemBabyEval> implements IMemBabyEvalService {

	@Autowired
	private MemBabyEvalMapper memBabyEvalMapper;
	@Autowired
	private BaseEvalCriteMapper baseEvalCriteMapper;
	
	/**
	 * 分页查询老师对宝贝评价信息
	 * <p>Title: findEvaluatingInformation</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 下午11:07:11
	 * @param page 分页
	 * @param map 参数集合
	 * @return
	 */
	@Override
	public Page<BaseEntity> findEvaluatingInformation(Page<BaseEntity> page, Map<String, Object> map) {
		page.setRecords(super.baseMapper.findEvaluatingInformation(page, map));
		return page;
	}
	/**
	 * 根据宝贝学期ID查询教师评价信息
	 * <p>Title: findEvaluatingById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月24日 下午12:16:02
	 * @param id
	 * @return
	 */
	@Override
	public List<BaseEntity> findEvaluatingById(String babyTeamId) {
		List<BaseEntity> memBabyEvals=this.memBabyEvalMapper.findEvaluatingById(babyTeamId);
		return memBabyEvals;
	}
	/**
	 * 根据宝贝学期ID查询宝贝信息
	 * <p>Title: updateMemBabyDeleteFlag</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月26日 下午4:49:06
	 * @param string 宝贝学期ID
	 * @return
	 */
	@Override
	public Integer updateMemBabyDeleteFlag(MemBabyEval memBabyEval) {
		memBabyEval.setUpdateTime(new Date());
		memBabyEval.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		Wrapper<MemBabyEval> wrapper=new EntityWrapper<>();
		wrapper.where("baby_team_id={0}", memBabyEval.getBabyTeamId());
		Integer i= this.baseMapper.update(memBabyEval, wrapper);
		return i;
	}
	/**
	 * 根据宝贝学期ID查询家长对宝贝评测信息  
	 * <p>Title: findPanrentEvaluatingByBabyTeamId</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年8月9日 下午10:11:46
	 * @param babyTeamId 宝贝学期ID
	 * @return
	 */
	@Override
	public List<BaseEntity> findPanrentEvaluatingByBabyTeamId(String babyTeamId) {
		List<BaseEntity> memBabyEvals=this.memBabyEvalMapper.findPanrentEvaluatingByBabyTeamId(babyTeamId);
		return memBabyEvals;
	}
	
}
