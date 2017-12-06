package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.dto.ParentsContactsDto;
import com.vision.edu.entity.member.MemParentBaby;

/**
 * <p>
  * 家长宝贝 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemParentBabyMapper extends BaseMapper<MemParentBaby> {

	/**
	 * 根据宝贝id查询家长信息
	 * @author lichenglong
	 * @date 2017年7月25日 上午8:36:45
	 * @param babyId 宝贝id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<ParentsContactsDto> findParentsContacts(@Param("babyId")String babyId,@Param("deleteFlag")Integer deleteFlag); 
}