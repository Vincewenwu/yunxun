package com.vision.edu.service.member.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.member.MemBabyCards;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.mapper.member.MemBabyCardsMapper;
import com.vision.edu.service.member.IMemBabyCardsService;

/**
 * <p>
 * 宝贝卡包 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-26
 */
@Service
public class MemBabyCardsServiceImpl extends ServiceImpl<MemBabyCardsMapper, MemBabyCards> implements IMemBabyCardsService {

	@Override
	public List<MemBabyCards> findCardByBabyId(BaseBaby baseBaby) {
		Wrapper<MemBabyCards> wrapper=new EntityWrapper<>();
		wrapper.where("baby_id={0} AND delete_flag={1}", baseBaby.getId(), EnumDeleteFlag.WSC.getValue());
		return baseMapper.selectList(wrapper);
	}

}
