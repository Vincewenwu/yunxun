package com.vision.edu.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.OneBabybaseSurrogateDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.member.MemBabySurrogate;
import com.vision.edu.mapper.member.MemBabySurrogateMapper;
import com.vision.edu.service.member.IMemBabySurrogateService;

/**
 * <p>
 * 宝贝接送人表 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-03
 */
@Service
public class MemBabySurrogateServiceImpl extends ServiceImpl<MemBabySurrogateMapper, MemBabySurrogate> implements IMemBabySurrogateService {

	@Autowired
	private MemBabySurrogateMapper memBabySurrogateMapper;

	/**
	 * 查询一条接送人
	 * @author ChenWenWu
	 * @date 2017年7月7日 下午4:16:15
	 * @param surrogateid
	 * @return
	 */
	@Override
	public List<MemBabySurrogate> findOneBabySurrogate(String surrogateid){
		return  memBabySurrogateMapper.findOneBabySurrogate(surrogateid);
	}

	/**
	 * 修改接送人表
	 * @author ChenWenWu
	 * @date 2017年7月9日 上午9:29:48
	 * @param memBabySurrogate
	 * @return
	 */
	@Override
	public boolean editOneBabySurrogate(MemBabySurrogate memBabySurrogate){
		return  memBabySurrogateMapper.editOneBabySurrogate(memBabySurrogate);
	}
	/**
	 * 删除接送人表
	 * @param deleteFlag
	 * @param surrogateId
	 * @return=
	 */
	@Override
	public boolean delOneBabySurrogate(int deleteFlag, String surrogateId) {

		return memBabySurrogateMapper.delOneBabySurrogate(deleteFlag, surrogateId);
	}
	/**
	 * 根据babyid查询接送人
	 * @author ChenWenWu
	 * @date 2017年7月7日 下午4:16:15
	 * @param surrogateid 接送人id
	 * @return
	 */
	@Override
	public List<OneBabybaseSurrogateDTO> findOneBabybaseSurrogate(Pagination page ,String babyid,String baseSurrogateid){
		return  memBabySurrogateMapper.findOneBabybaseSurrogate(page, babyid,baseSurrogateid);
	}

	@Override
	public List<MemBabySurrogate> findBabySurrogateByBabyId(BaseBaby baseBaby) {
		return baseMapper.findBabySurrogateByBabyId(baseBaby);
	}

}
