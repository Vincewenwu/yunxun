package com.vision.edu.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.system.SysRole;

/**
 * <p>
  * 角色 Mapper 接口
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
	
	/**
	 * 查询所有园校名称
	 * @author XieFan
	 * @date 2017年7月20日 上午10:38:07
	 * @return
	 */
	List<BaseEntity> findAllSchoolName();
	
	/**
	 * 查询所有角色
	 * @author XieFan
	 * @date 2017年7月21日 上午8:51:23
	 * @param page
	 * @param map 传进来的参数【角色名称，园校ID】
	 * @return
	 */
	List<BaseEntity> findAllSysRole(Pagination page,@Param("map")Map<String, Object> map);
	
	/**
	 * 查询园校   tree
	 * @author XieFan
	 * @date 2017年7月21日 上午11:56:14
	 * @param fatherId 父ID
	 * @return
	 */
	List<BaseEntity> findSchoolTree(@Param("fatherId")String fatherId);
	
	/**
	 * 根据角色ID查询模块
	 * @author XieFan
	 * @date 2017年7月21日 下午4:34:13
	 * @param roleId 角色ID
	 * @return
	 */
	List<BaseEntity> findSysModularByRoleId(@Param("roleId")String roleId);
}