package com.vision.edu.service.member.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.member.MemBabyEval;
import com.vision.edu.enums.EnumDeleteFlag;
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

	/**
	 * <p>Title: add</p>
	 * <p>Description: </p>
	 * @param list
	 * @param bodyId
	 * @return=
	 */
	@Override
	public Boolean add(List<Object> list, String bodyId,String memBabyTeamId) 
	{
		Boolean b = true;
		 for(int i=0;i<list.size();i++)
		    {
		    	@SuppressWarnings("unchecked")
				Map<String ,String > map =(Map<String ,String >) list.get(i);
		    	MemBabyEval MemBabyEval = new MemBabyEval();
				MemBabyEval.setCreateTime(new Date());
				MemBabyEval.setCreateMan("cry");
				MemBabyEval.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
				MemBabyEval.setBabyId(bodyId);
				MemBabyEval.setBabyTeamId(memBabyTeamId);
		    	MemBabyEval.setEvalItemId(map.get("projectId").toString());
		    	MemBabyEval.setEvalContentId(map.get("contentId").toString());
		    	MemBabyEval.setScore( Integer.parseInt( map.get("score").toString()));
		    	try 
		    	{
					insert(MemBabyEval);
				} catch (Exception e) {
					b = false;
					System.out.println("新增失败！！！");
					e.printStackTrace();
				}
		    }
		return b;
	}
	
}
