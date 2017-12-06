package com.vision.edu.service.base.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.PrincipalMsgDTO;
import com.vision.edu.dto.WebUserVo;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.base.BaseWechat;
import com.vision.edu.entity.member.MemMember;
import com.vision.edu.entity.member.MemParentBaby;
import com.vision.edu.entity.system.SysUser;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.framework.exception.BusinessException;
import com.vision.edu.mapper.base.BaseBabyMapper;
import com.vision.edu.mapper.base.BaseMemberMapper;
import com.vision.edu.mapper.member.MemMemberMapper;
import com.vision.edu.mapper.member.MemParentBabyMapper;
import com.vision.edu.mapper.system.SysUserMapper;
import com.vision.edu.service.base.IBaseMemberService;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseMemberServiceImpl extends ServiceImpl<BaseMemberMapper, BaseMember> implements IBaseMemberService {

	@Autowired
	private BaseMemberMapper baseMemberMapper; //注入BaseMemberMapper

	@Autowired
	private MemMemberMapper MemMemberMapper;

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private MemParentBabyMapper memParentBabyMapper;

	@Autowired
	private BaseBabyMapper baseBabyMapper;

	/**
	 * 根据学校的id查找园长的基本信息
	 * @param strSchoolId 学校id
	 * @param roleId 角色id
	 */
	@Override
	public BaseEntity findPrincipalById(String schoolId, Integer memberType) {
		BaseEntity principalMsgPo = baseMemberMapper.findPrincipalById(schoolId, memberType);
		return principalMsgPo;
	}

	/**
	 * 根据学校的id查找园长的详细信息
	 * @param userId 用户id
	 * @param sourceId 资源id
	 */
	@Override
	public PrincipalMsgDTO findPrincipalDetailByUserId(String userId) {
		PrincipalMsgDTO principalMsgPo = baseMemberMapper.findPrincipalDetailByUserId(userId);
		return principalMsgPo;
	}

	/**
	 * 查询一个园校所有老师的基本信息
	 * @param strCode 学校id
	 */
	@Override
	public List<BaseEntity> findListTeacher(String schoolId, Integer memberType) {
		List<BaseEntity> listGardenerPo = baseMemberMapper.findListTeacher(schoolId, memberType);
		return listGardenerPo;
	}

	/**
	 * 根据园丁id查询所有的详细信息
	 * @author:zyml
	 * @date:2017年7月9日下午5:47:13
	 * @param strCode 园丁的id
	 */
	@Override
	public BaseEntity findListTeacherDetailById(String strCode) {
		BaseEntity gardenerPo = baseMapper.findListTeacherDetailById(strCode);
		return gardenerPo;
	}

	/**
	 * 查询一个园校所有老师的更多信息
	 * @param strCode 学校id
	 */
	@Override
	public List<BaseEntity> findListTeacherMore(String schoolId, Integer memberType) {
		List<BaseEntity> listGardenerPo = baseMemberMapper.findListTeacherMore(schoolId, memberType);
		return listGardenerPo;
	}

	@Override
	public WebUserVo checkMember(BaseWechat baseWechat) {

		WebUserVo webUserVo = new WebUserVo();
		webUserVo.setBaseWechat(baseWechat);

		//如果没有基础信息则为游客
		BaseMember member = new BaseMember();
		member.setUnionid(baseWechat.getUnionId());
		BaseMember baseMember = baseMapper.selectOne(member);
		if (baseMember == null) {
			webUserVo.setUserFlag(WebUserVo.YOUKE);
			return webUserVo;
		}
		webUserVo.setBaseMember(baseMember);

		//如果是会员，则是报名中用户或已开通用户
		MemMember member2 = new MemMember();
		member2.setBaseMemberId(baseMember.getId());
		MemMember memMember = MemMemberMapper.selectOne(member2);
		if (memMember != null) {
			webUserVo.setUser(memMember);
			//如果家长宝贝表中没有当前家长信息，则说明是未绑定孩子【报名中】
			Wrapper<MemParentBaby> wrapper = new EntityWrapper<>();
			wrapper.where("member_id={0} AND delete_flag={1}", memMember.getId(), EnumDeleteFlag.WSC.getValue());
			List<MemParentBaby> list = memParentBabyMapper.selectList(wrapper);
			if (list == null || list.isEmpty()) {
				webUserVo.setUserFlag(WebUserVo.JZ_BMZ);
				return webUserVo;
			}

			//如果家长宝贝表中有当前家长信息，则说明是有绑定的孩子，先从家长的上次访问孩子中获取，如果没有则获取列表中的第一个
			String babyId = "";
			if (StringUtils.isNotBlank(memMember.getBabyId())) {
				babyId = memMember.getBabyId();
			} else {
				babyId = list.get(0).getBabyId();
			}
			BaseBaby baseBaby = baseBabyMapper.selectById(babyId);
			webUserVo.setBaseBaby(baseBaby);
			webUserVo.setUserFlag(WebUserVo.JZ_YBM);
			return webUserVo;
		}

		//如果是后台用户，则是老师或院长
		SysUser user = new SysUser();
		user.setBaseMemberId(baseMember.getId());
		SysUser sysUser = sysUserMapper.selectOne(user);
		if (sysUser != null) {
			webUserVo.setUser(sysUser);
			if (EnumMemberType.LS.getValue() == sysUser.getMemberType()) {//老师
				webUserVo.setUserFlag(WebUserVo.LS);
				return webUserVo;
			} else if (EnumMemberType.YZ.getValue() == sysUser.getMemberType()) {//园长
				webUserVo.setUserFlag(WebUserVo.YZ);
				return webUserVo;
			} else if (EnumMemberType.PTGL.getValue() == sysUser.getMemberType()) {
				webUserVo.setUserFlag(WebUserVo.PTGL);
				return webUserVo;
			}

		}
		throw new BusinessException("非法账号登陆");
	}

}
