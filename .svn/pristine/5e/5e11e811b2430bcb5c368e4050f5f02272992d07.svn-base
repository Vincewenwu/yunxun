package com.vision.edu.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemMemberDto;
import com.vision.edu.entity.member.MemMember;
import com.vision.edu.mapper.member.MemMemberMapper;
import com.vision.edu.service.member.IMemMemberService;

/**
 * <p>
 * 会员表记录的是纯家长信息 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class MemMemberServiceImpl extends ServiceImpl<MemMemberMapper, MemMember> implements IMemMemberService {
	
	@Autowired
	private MemMemberMapper memMemberMapper;//注入MemMemberMapper
	
	/**
	 * 根据会员id查询会员信息
	 * @author lichenglong
	 * @date 2017年7月14日 下午3:05:54
	 * @param memberId 会员id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<MemMemberDto> findAccountManagement(String memberId,Integer deleteFlag){
		List<MemMemberDto> listMemMemberInfo = memMemberMapper.findAccountManagement(memberId, deleteFlag);
		return listMemMemberInfo;
	}
}
