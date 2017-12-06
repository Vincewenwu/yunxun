package com.vision.edu.service.member.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.ParentsContactsDto;
import com.vision.edu.dto.WebUserVo;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.member.MemMember;
import com.vision.edu.entity.member.MemParentBaby;
import com.vision.edu.enums.EnumBabyState;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumDisableFlag;
import com.vision.edu.enums.EnumRelationship;
import com.vision.edu.mapper.base.BaseBabyMapper;
import com.vision.edu.mapper.base.BaseMemberMapper;
import com.vision.edu.mapper.member.MemMemberMapper;
import com.vision.edu.mapper.member.MemParentBabyMapper;
import com.vision.edu.service.member.IMemParentBabyService;

/**
 * <p>
 * 家长宝贝 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class MemParentBabyServiceImpl extends ServiceImpl<MemParentBabyMapper, MemParentBaby> implements IMemParentBabyService {

	private static final Logger LOG = LoggerFactory.getLogger(MemParentBabyServiceImpl.class);
	@Autowired
	private MemParentBabyMapper memParentBabyMapper;

	@Autowired
	private MemMemberMapper memMemberMapper;

	@Autowired
	private BaseMemberMapper baseMemberMapper;

	@Autowired
	private BaseBabyMapper baseBabyMapper;

	/**
	 * 根据宝贝id查询家长信息
	 * @author lichenglong
	 * @date 2017年7月25日 上午8:36:45
	 * @param babyId 宝贝id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	@Override
	public List<ParentsContactsDto> findParentsContacts(String babyId,Integer deleteFlag){
		List<ParentsContactsDto> parentsContactsDto = memParentBabyMapper.findParentsContacts(babyId, deleteFlag);
		return parentsContactsDto;
	}

	@Override
	public WebUserVo doBinDingChild(WebUserVo userVo, Map<String, Object> map) {

		//查询宝贝信息
		BaseBaby baseBaby = new BaseBaby();
		baseBaby.setBindingCode(map.get("bingDingCode").toString());
		baseBaby.setName(map.get("kidName").toString());
		baseBaby.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		baseBaby.setState(EnumBabyState.ZC.getValue());
		baseBaby = baseBabyMapper.selectOne(baseBaby);
		if (baseBaby == null) {
			LOG.error("宝贝信息不存在或未激活");
			return userVo;
		}

		//判断当前家长是否已经在后台添加,如果没有则新增会员基本信息
		BaseMember member = new BaseMember();
		member.setPhoneNum(map.get("mobile").toString());
		BaseMember baseMember = baseMemberMapper.selectOne(member);
		if (baseMember == null) {
			baseMember = new BaseMember();
			baseMember.setName(map.get("parentName").toString());
			baseMember.setPhoneNum(map.get("mobile").toString());
			baseMember.setUnionid(userVo.getBaseWechat().getUnionId());
			baseMember.setOpenid(userVo.getBaseWechat().getOpenId());
			baseMember.setHeadPortrait(userVo.getBaseWechat().getHeadImgUrl());
			baseMember.setCreateTime(new Date());
			baseMember.setSchoolId(baseBaby.getSchoolId());
			baseMember.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			baseMemberMapper.insert(baseMember);
		}

		//判断是否会员，如果是会员则进一步绑定，否则创建会员信息
		MemMember memMember = memMemberMapper.selectById(baseMember.getId());
		if (memMember == null) {
			memMember = new MemMember();
			memMember.setBaseMemberId(baseMember.getId());
			memMember.setCreateTime(new Date());
			memMember.setBabyId(baseBaby.getId());
			memMember.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			memMember.setDisableFlag(EnumDisableFlag.WTY.getValue());
			memMember.setLastLandingTime(new Date());
			memMemberMapper.insert(memMember);
		}

		//创建家长宝贝信息，实现家长宝贝绑定
		MemParentBaby parentBaby=new MemParentBaby();
		parentBaby.setBabyId(baseBaby.getId());
		parentBaby.setMemberId(memMember.getId());
		parentBaby.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		MemParentBaby memParentBaby = baseMapper.selectOne(parentBaby);
		if (memParentBaby == null) {
			memParentBaby = new MemParentBaby();
			memParentBaby.setMemberId(memMember.getId());
			memParentBaby.setBabyId(baseBaby.getId());
			memParentBaby.setRelationship(EnumRelationship.get(Integer.parseInt(map.get("kinship").toString(), 10)).getValue());
			memParentBaby.setCreateTime(new Date());
			memParentBaby.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			baseMapper.insert(memParentBaby);
		}
		userVo.setBaseBaby(baseBaby);
		userVo.setBaseMember(baseMember);
		userVo.setUser(memMember);
		userVo.setUserFlag(WebUserVo.JZ_YBM);
		return userVo;
	}
}
