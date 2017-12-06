package com.vision.edu.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.member.MemComboRecord;
import com.vision.edu.mapper.member.MemComboRecordMapper;
import com.vision.edu.service.member.IMemComboRecordService;

/**
 * <p>
 * 套餐购买记录 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class MemComboRecordServiceImpl extends ServiceImpl<MemComboRecordMapper, MemComboRecord> implements IMemComboRecordService {
	
	@Autowired
	private MemComboRecordMapper memComboRecordMapper;//注入MemComboRecordMapper
	
	/**
	 * 根据用户id查询套餐记录
	 * @author lichenglong
	 * @date 2017年7月14日 下午3:36:13
	 * @param userId 用户id
	 * @param deleteFlag 删除标记
	 * @return
	 */
	@Override
	public List<MemComboRecord> findSetRecords(String userId,Integer deleteFlag){
		List<MemComboRecord> listMemComboRecord = memComboRecordMapper.findSetRecords(userId, deleteFlag);
		return listMemComboRecord;
	}
}
