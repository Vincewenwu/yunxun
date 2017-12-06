package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.member.MemBabyEval;

/**
 * <p>
 * 宝贝评测 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemBabyEvalService extends IService<MemBabyEval> 
{
	/**
	 * 新增评测记录
	 * @author ChenYuanRong
	 * @date 2017年7月26日 上午8:17:23
	 * @param list
	 * @param bodyId
	 * @return
	 */
	public Boolean add (List<Object> list, String bodyId,String memBabyTeamId);
}
