package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.member.MemBabyCards;

/**
 * <p>
 * 宝贝卡包 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-26
 */
public interface IMemBabyCardsService extends IService<MemBabyCards> {

	/**
	 * 根据宝贝id查询宝贝所拥有卡号
	 * @author zhangfeihong
	 * @date 2017年7月30日 下午11:08:27
	 * @param baseBaby
	 * @return
	 */
	List<MemBabyCards> findCardByBabyId(BaseBaby baseBaby);

}
