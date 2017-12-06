package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.OneBabybaseSurrogateDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.member.MemBabySurrogate;

/**
 * <p>
 * 宝贝接送人表 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-03
 */
public interface IMemBabySurrogateService extends IService<MemBabySurrogate> {

	/**
	 * 查询一条接送人
	 * @author ChenWenWu
	 * @date 2017年7月7日 下午4:16:15
	 * @param surrogateid  接送人ID
	 * @return
	 */
	List<MemBabySurrogate> findOneBabySurrogate(String surrogateid);
	/**
	 * 修改接送人表
	 * @author ChenWenWu
	 * @date 2017年7月9日 上午9:29:48
	 * @param memBabySurrogate 送人表实体
	 * @return
	 */
	boolean editOneBabySurrogate(MemBabySurrogate memBabySurrogate);

	/**
	 * 删除接送人表
	 * @author ChenWenWu
	 * @date 2017年7月9日 上午9:38:05
	 * @param deleteFlag 删除否
	 * @param surrogateId 接送人ID
	 * @return
	 */
	boolean delOneBabySurrogate (int deleteFlag, String surrogateId);

	/**
	 * 根据babyid查询接送人
	 * @author ChenWenWu
	 * @date 2017年7月7日 下午4:16:15
	 * @param surrogateid 接送人id
	 * @return
	 */
	List<OneBabybaseSurrogateDTO> findOneBabybaseSurrogate(Pagination page, String babyid,String baseSurrogateid);

	/**
	 * 根据宝贝id查询宝贝接送人信息
	 * @author zhangfeihong
	 * @date 2017年7月31日 上午9:25:23
	 * @param baseBaby
	 * @return
	 */
	List<MemBabySurrogate> findBabySurrogateByBabyId(BaseBaby baseBaby);

}
