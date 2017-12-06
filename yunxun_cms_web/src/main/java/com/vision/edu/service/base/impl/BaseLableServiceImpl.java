package com.vision.edu.service.base.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.BaseLableShoolDTO;
import com.vision.edu.entity.base.BaseLable;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.mapper.base.BaseLableMapper;
import com.vision.edu.service.base.IBaseLableService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseLableServiceImpl extends ServiceImpl<BaseLableMapper, BaseLable> implements IBaseLableService {
   @Autowired
   private BaseLableMapper baseLableMapper;
   /**
    * 查找提醒信息
    * @author ChenWenWu
    * @date 2017年8月1日 下午9:58:25
    * @param startPage
    * @param pageSise
    * @return
    */
	@Override
	public List<BaseLableShoolDTO> findBaseLableShoolDTO(Pagination page, BaseLableShoolDTO baseLableShoolDTO) {
		return baseLableMapper.findBaseLableShoolDTO(page, baseLableShoolDTO);
	}
	
	 /**
	    * 删除标签管理
	    * @author ChenWenWu
	    * @date 2017年8月2日 下午12:02:12
	    * @param ids
	    * @return
	    */
	@Override
	public Integer delbaseLable(String ids,String updateman) {
		  BaseLable baseLable=new BaseLable();
		  baseLable.setUpdateMan(updateman);
		  baseLable.setUpdateTime(new Date());
		  baseLable.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		String [] id = ids.split(",");
		String []  aa=new String[id.length];
		 Integer num=0;
		 for (int i = 0; i < id.length; i++) {
			 aa[i]=id[i];
		}
		 for(String lj : aa){
			  baseLable.setId(lj);
			  num+=  baseLableMapper.updateById(baseLable);
		 }
		return num;
	}
	
}
