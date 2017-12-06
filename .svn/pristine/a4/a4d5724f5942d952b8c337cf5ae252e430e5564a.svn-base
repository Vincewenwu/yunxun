package com.vision.edu.service.system;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.system.SysRole;
import com.vision.edu.platform.common.result.JsonResult;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface ISysRoleService extends IService<SysRole> {
	
	/**
	 * 查询所有园校名称
	 * @author XieFan
	 * @date 2017年7月20日 上午10:38:07
	 * @return
	 */
	List<BaseEntity> findAllSchoolName();
	
	/**
	 * 查询所有角色信息
	 * @author XieFan
	 * @date 2017年7月21日 上午8:56:10
	 * @param page
	 * @param map 参数类型【角色名称，园校ID】
	 * @return
	 */
	Page<BaseEntity> findAllSysRole(Page<BaseEntity> page,Map<String, Object> map);
	
	/**
	 * 添加角色
	 * @author XieFan
	 * @date 2017年7月20日 下午5:51:00
	 * @param sysRole
	 * @param moduleIds
	 * @return
	 */
	JsonResult addSysRole(SysRole sysRole, String moduleIds);
	
	/**
	 * 查询园校  tree
	 * @author XieFan
	 * @date 2017年7月21日 上午11:57:57
	 * @param fatherId 父ID
	 * @return
	 */
	List<BaseEntity> findSchoolTree(String fatherId);
	
	/**
	 * 根据角色ID查询模块
	 * @author XieFan
	 * @date 2017年7月21日 下午4:19:43
	 * @param roleId 角色ID
	 * @return
	 */
	List<BaseEntity> findSysModularByRoleId(String roleId);
	
	/**
	 * 编辑角色
	 * @author XieFan
	 * @date 2017年7月21日 下午5:41:45
	 * @param sysRole 角色实体
	 * @param moduleIds 模块Ids
	 * @return
	 */
	JsonResult editSysRole(SysRole sysRole, String moduleIds);

	/**
	 * 删除权限
	 * @author XieFan
	 * @date 2017年7月27日 上午8:16:20
	 * @param ids
	 * @return
	 */
	JsonResult deleteSysRoleById(String ids);
	
}
