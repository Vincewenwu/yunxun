package com.vision.edu.service.member.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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

	/**
	 * <p>Title: findMemBabyTeamByBadyId</p>
	 * <p>Description: </p>
	 * @param BadyId
	 * @return=
	 */
	@Override
	public String findMemBabyTeamByBadyId(String BadyId) {
		EntityWrapper<MemBabyTeam>  entityWrapper =new EntityWrapper<MemBabyTeam> ();
		entityWrapper.setSqlSelect("");
		entityWrapper.where("baby_id = {} and delete_flag = 0", BadyId);
		MemBabyTeam memBabyTeam =(com.vision.edu.entity.member.MemBabyTeam) selectObj(entityWrapper);
		return memBabyTeam.getId();
	}
	
	
}
