package com.vision.edu.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.member.MemBabyTeam;
import com.vision.edu.mapper.member.MemBabyTeamMapper;
import com.vision.edu.service.member.IMemBabyTeamService;

/**
 * <p>
 * 宝贝学期表 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-25
 */
@Service
public class MemBabyTeamServiceImpl extends ServiceImpl<MemBabyTeamMapper, MemBabyTeam> implements IMemBabyTeamService {

	@Autowired
	private MemBabyTeamMapper memBabyTeamMapper;
	/**
	 * 根据宝贝ID查询宝贝学期信息
	 * <p>Title: findTreamByBabyId</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月25日 上午9:23:41
	 * @param babyId 参数id
	 * @return
	 */
	@Override
	public List<BaseEntity> findTreamByBabyId(String babyId) {
		List<BaseEntity> memBabyTeams=this.memBabyTeamMapper.findTreamByBabyId(babyId);
		return memBabyTeams;
	}
	
}
