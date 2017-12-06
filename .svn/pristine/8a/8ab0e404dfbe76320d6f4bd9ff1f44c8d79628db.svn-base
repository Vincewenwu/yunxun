package com.vision.edu.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.dto.MemMessageDTO;
import com.vision.edu.entity.system.SysMessage;

/**
 * <p>
 * 系统通知 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-08-11
 */
public interface SysMessageMapper extends BaseMapper<SysMessage> {
	/**
	 * 
	 * @author ChenWenWu
	 * @date 2017骞�鏈�鏃�涓嬪崍9:53:01
	 * @param page
	 * @param shoolid 瀛﹂櫌ID
	 * @return
	 */
	List<MemMessageDTO> findSysRecipeBankDTO(Pagination page,@Param("memMessageDTO") MemMessageDTO memMessageDTO);

}