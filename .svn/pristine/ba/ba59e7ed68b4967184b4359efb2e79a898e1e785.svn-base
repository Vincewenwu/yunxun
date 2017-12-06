package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vision.edu.entity.member.MemComboRecord;

/**
 * <p>
  * 套餐购买记录 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemComboRecordMapper extends BaseMapper<MemComboRecord> {

	/**
	 * 根据用户id查询套餐记录
	 * @author lichenglong
	 * @date 2017年7月14日 下午3:30:24
	 * @param userId 用户id
	 * @param deleteFlag  删除标记
	 * @return
	 */
	List<MemComboRecord> findSetRecords(@Param("userId")String userId,@Param("deleteFlag")Integer deleteFlag);
}