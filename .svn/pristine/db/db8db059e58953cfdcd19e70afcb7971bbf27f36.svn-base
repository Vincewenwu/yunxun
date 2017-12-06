package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.MemMemberDto;
import com.vision.edu.entity.member.MemMember;

/**
 * <p>
  * 会员表记录的是纯家长信息 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemMemberMapper extends BaseMapper<MemMember> {

	/**
	 * 根据会员id查询会员信息
	 * @author lichenglong
	 * @date 2017年7月14日 下午3:02:15
	 * @param memberId 会员id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemMemberDto> findAccountManagement(@Param("memberId")String memberId,@Param("deleteFlag")Integer deleteFlag);
}