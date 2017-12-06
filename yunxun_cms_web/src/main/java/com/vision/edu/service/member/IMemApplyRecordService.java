package com.vision.edu.service.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.dto.MemApplyRecordDTO;
import com.vision.edu.entity.member.MemApplyRecord;

/**
 * <p>
 * 报名记录 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IMemApplyRecordService extends IService<MemApplyRecord> {
	 /**
     * 查询报名管理列表
     * @author ChenWenWu
     * @date 2017年7月7日 下午4:16:15
     * @param memApplyRecordDTO 接送人
     * @return
     */
	 List<MemApplyRecordDTO> findMemApplyRecord(Pagination page,MemApplyRecordDTO memApplyRecordDTO);

}
