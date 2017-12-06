package com.vision.edu.service.member;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.ParentsContactsDto;
import com.vision.edu.dto.WebUserVo;
import com.vision.edu.entity.member.MemParentBaby;

/**
 * <p>
 * 家长宝贝 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemParentBabyService extends IService<MemParentBaby> {

	/**
	 * 根据宝贝id查询家长信息
	 * @author lichenglong
	 * @date 2017年7月25日 上午8:36:45
	 * @param babyId 宝贝id
	 * @param deleteFlag 删除类型
	 * @return
	 */
	List<ParentsContactsDto> findParentsContacts(String babyId, Integer deleteFlag);

	/**
	 * 家长通过绑定码绑定孩子
	 * @author zhangfeihong
	 * @date 2017年7月26日 上午10:35:28
	 * @param userVo
	 * @param map
	 * @return
	 */
	WebUserVo doBinDingChild(WebUserVo userVo, Map<String, Object> map);

}
