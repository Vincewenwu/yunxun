package com.vision.edu.mapper.member;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.ParentBaseMemberDTO;
import com.vision.edu.entity.member.MemParentBaby;

/**
 * <p>
  * 家长宝贝表 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-03
 */
public interface MemParentBabyMapper extends BaseMapper<MemParentBaby> {
	/**
	 * 根据家长ID查家长的基本信息
	 * @author ChenWenWu
	 * @date 2017年7月8日 下午10:07:43
	 * @param memberid 家长ID
	 * @return
	 */
	ParentBaseMemberDTO findParentBaseMemberDTO(@Param ("memberid") String memberid);
} 