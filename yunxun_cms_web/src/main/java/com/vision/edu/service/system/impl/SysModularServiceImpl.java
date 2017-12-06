package com.vision.edu.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.system.SysModular;
import com.vision.edu.mapper.system.SysModularMapper;
import com.vision.edu.service.system.ISysModularService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class SysModularServiceImpl extends ServiceImpl<SysModularMapper, SysModular> implements ISysModularService {

	/**
	 * 根据父ID查询模块
	 * @author XieFan
	 * @date 2017年7月18日 上午10:49:24
	 * @param farId 父ID
	 * @return
	 */
	public List<SysModular> findSysModularByFarId(String farId) {
		EntityWrapper<SysModular> ewSysModular = new EntityWrapper<SysModular>();
		ewSysModular.setSqlSelect("id,name");
		ewSysModular.where(" father_id = {0} AND delete_flag = 0 ", farId);
		return selectList(ewSysModular);
	}

	/**
	 * 查询所有模块
	 * <p>Title: findAllSysModule</p>
	 * <p>Description: </p>
	 * @return
	 */
	public Page<BaseEntity> findAllSysModule(Page<BaseEntity> page,Map<String, Object> map) {
		page.setRecords(super.baseMapper.findAllSysModule(page,map));
		return page;
	}

	/**
	 * 根据ID查询模块信息
	 * @author XieFan
	 * @date 2017年7月29日 下午5:33:08
	 * @param id
	 * @return
	 */
	@Override
	public SysModular findModularById(String id) {
		return this.baseMapper.findModularById(id);
	}
	
}
