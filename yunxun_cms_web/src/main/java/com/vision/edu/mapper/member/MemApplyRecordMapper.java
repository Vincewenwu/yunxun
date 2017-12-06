package com.vision.edu.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.MemApplyRecordDTO;
import com.vision.edu.entity.member.MemApplyRecord;
import com.vision.edu.entity.member.MemBabySurrogate;

/**
 * <p>
  * 报名记录 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface MemApplyRecordMapper extends BaseMapper<MemApplyRecord> {
        
	 /**
     * 查询一条接送人
     * @author ChenWenWu
     * @date 2017年7月7日 下午4:16:15
     * @param surrogateid 接送人id
     * @return
     */
	 List<MemApplyRecordDTO> findMemApplyRecord(Pagination page, @Param ("memApplyRecordDTO") MemApplyRecordDTO memApplyRecordDTO);

}