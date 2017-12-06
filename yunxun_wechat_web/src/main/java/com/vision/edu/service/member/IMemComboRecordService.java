package com.vision.edu.service.member;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.member.MemComboRecord;

/**
 * <p>
 * 套餐购买记录 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemComboRecordService extends IService<MemComboRecord> {

	/**
	 * 根据用户id查询套餐记录
	 * @author lichenglong
	 * @date 2017年7月14日 下午3:41:52
	 * @param userId 用户id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	List<MemComboRecord> findSetRecords(String userId, Integer deleteFlag);
	
}
