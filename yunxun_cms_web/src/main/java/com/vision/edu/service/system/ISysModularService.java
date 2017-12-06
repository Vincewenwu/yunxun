package com.vision.edu.service.system;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.system.SysModular;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface ISysModularService extends IService<SysModular> {
	
	/**
	 * 根据父ID查询模块
	 * @author XieFan
	 * @date 2017年7月18日 上午10:49:24
	 * @param farId 父ID
	 * @return
	 */
	List<SysModular> findSysModularByFarId(String farId);
	
	/**
	 * 查询所有模块
	 * @author XieFan
	 * @date 2017年7月18日 下午2:09:31
	 * @return
	 */
	Page<BaseEntity> findAllSysModule(Page<BaseEntity> page,Map<String, Object> map);
	
	/**
	 * 根据ID查询模块信息
	 * @author XieFan
	 * @date 2017年7月29日 下午5:33:08
	 * @param id
	 * @return
	 */
	SysModular findModularById(String id);
	
}
