package com.vision.edu.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseCombo;
import com.vision.edu.entity.member.MemMessage;
import com.vision.edu.entity.system.SysMessage;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.mapper.base.BaseComboMapper;
import com.vision.edu.mapper.member.MemMessageMapper;
import com.vision.edu.mapper.system.SysMessageMapper;
import com.vision.edu.service.base.IBaseComboService;

/**
 * <p>
 * 套餐 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseComboServiceImpl extends ServiceImpl<BaseComboMapper, BaseCombo> implements IBaseComboService {
      @Autowired
      private BaseComboMapper baseComboMapper;
      
      @Autowired
      private MemMessageMapper memMessageMapper;
      /**
	    * 查找提醒信息
	    * @author ChenWenWu
	    * @date 2017年8月1日 下午9:58:25
	    * @param startPage
	    * @param pageSise
	    * @return
	    */
	@Override
	public List<BaseCombo> findBaseCombopage(Pagination page, BaseCombo baseCombo) {
		return baseComboMapper.findBaseCombopage(page, baseCombo);
	}
	/**
	 * 确认提醒消息的确认
	 * @author ChenWenWu
	 * @date 2017年8月2日 上午9:17:58
	 * @param ids
	 * @return
	 */
	@Override
	public Integer editBaseCombo(String ids) {
		MemMessage memMessage=new MemMessage();
		String [] id = ids.split(",");
		String []  aa=new String[id.length];
		 Integer num=0;
		 for (int i = 0; i < id.length; i++) {
			 aa[i]=id[i];
		}
		 for(int i = 0; i <aa.length; i++){
			 memMessage.setId(aa[i]);
			 memMessage.setConfirmFlag(EnumDeleteFlag.YSC.getValue());//这是已确认得代表
			 num+= memMessageMapper.updateById(memMessage);
		 }
		return num;
	}
	
}
