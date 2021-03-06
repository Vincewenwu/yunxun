package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.MemMemberDto;
import com.vision.edu.entity.member.MemMember;

/**
 * <p>
 * 会员表记录的是纯家长信息 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemMemberService extends IService<MemMember> {

	/**
	 * 根据会员id查询会员信息
	 * @author lichenglong
	 * @date 2017年7月14日 下午3:12:02
	 * @param memberId 会员id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemMemberDto> findAccountManagement(String memberId, Integer deleteFlag);
	
}
