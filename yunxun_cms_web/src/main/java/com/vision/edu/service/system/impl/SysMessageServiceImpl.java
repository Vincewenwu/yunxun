package com.vision.edu.service.system.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.MemMessageDTO;
import com.vision.edu.entity.system.SysMessage;
import com.vision.edu.mapper.system.SysMessageMapper;
import com.vision.edu.service.system.ISysMessageService;

/**
 * <p>
 * 系统通知 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-08-11
 */
@Service
public class SysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage> implements ISysMessageService {
	    private SysMessageMapper sysMessageMapper;
		   /**
		    * 鏌ユ壘鎻愰啋淇℃伅
		    * @author ChenWenWu
		    * @date 2017骞�鏈�鏃�涓嬪崍9:58:25
		    * @param startPage
		    * @param pageSise
		    * @return
		    */
		public List<MemMessageDTO> findSysRecipeBankDTO(Pagination page, MemMessageDTO memMessageDTO) {
			return sysMessageMapper.findSysRecipeBankDTO(page, memMessageDTO);
		}
		
}
