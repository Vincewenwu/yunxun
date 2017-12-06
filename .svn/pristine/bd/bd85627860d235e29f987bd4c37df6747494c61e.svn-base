package com.vision.edu.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemApplyRecordDTO;
import com.vision.edu.entity.member.MemApplyRecord;
import com.vision.edu.mapper.member.MemApplyRecordMapper;
import com.vision.edu.service.member.IMemApplyRecordService;

/**
 * <p>
 * 报名记录 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class MemApplyRecordServiceImpl extends ServiceImpl<MemApplyRecordMapper, MemApplyRecord> implements IMemApplyRecordService {
    @Autowired
    private MemApplyRecordMapper memApplyRecordMapper;
	
	 /**
   * 查询一条接送人
   * @author ChenWenWu
   * @date 2017年7月7日 下午4:16:15
   * @param surrogateid 接送人id
   * @return
   */
	public List<MemApplyRecordDTO> findMemApplyRecord(Pagination page,MemApplyRecordDTO memApplyRecordDTO) {
		return memApplyRecordMapper.findMemApplyRecord( page,memApplyRecordDTO);
	}
	
}
