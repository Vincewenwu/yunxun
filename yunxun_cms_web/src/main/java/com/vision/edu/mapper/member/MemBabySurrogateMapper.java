package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.OneBabybaseSurrogateDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.member.MemBabySurrogate;

/**
 * <p>
 * 宝贝接送人表 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-03
 */
public interface MemBabySurrogateMapper extends BaseMapper<MemBabySurrogate> {
	/**
	 * 查询一条接送人
	 * @author ChenWenWu
	 * @date 2017年7月7日 下午4:16:15
	 * @param surrogateid 接送人id
	 * @return
	 */
	List<MemBabySurrogate> findOneBabySurrogate(@Param ("surrogateid") String surrogateid);
	/**
	 * 修改接送人表
	 * @author ChenWenWu
	 * @date 2017年7月9日 上午9:29:48
	 * @param memBabySurrogate 宝贝接送人表实体
	 * @return
	 */
	boolean editOneBabySurrogate(@Param ("memBabySurrogate") MemBabySurrogate memBabySurrogate);

	/**
	 * 删除接送人表
	 * @author ChenWenWu
	 * @date 2017年7月9日 下午7:44:10
	 * @param deleteFlag  删除否
	 * @param surrogateId 接送人id
	 * @return
	 */
	boolean delOneBabySurrogate(@Param ("deleteFlag") int deleteFlag,@Param ("surrogateId") String surrogateId);
	/**
	 * 根据babyid查询接送人
	 * @author ChenWenWu
	 * @date 2017年7月7日 下午4:16:15
	 * @param surrogateid 接送人id
	 * @return
	 */
	List<OneBabybaseSurrogateDTO> findOneBabybaseSurrogate(Pagination page, @Param ("babyid") String babyid,@Param ("baseSurrogateid") String baseSurrogateid);

	/**
	 * 根据宝贝id查询宝贝接送人信息
	 * @author zhangfeihong
	 * @date 2017年7月31日 上午10:12:22
	 * @param baseBaby
	 * @return
	 */
	List<MemBabySurrogate> findBabySurrogateByBabyId(@Param("baseBaby") BaseBaby baseBaby);

}