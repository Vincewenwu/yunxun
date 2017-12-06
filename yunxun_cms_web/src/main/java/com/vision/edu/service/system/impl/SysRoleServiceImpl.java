package com.vision.edu.service.system.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.entity.system.SysModular;
import com.vision.edu.entity.system.SysRole;
import com.vision.edu.entity.system.SysRoleModular;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.mapper.system.SysModularMapper;
import com.vision.edu.mapper.system.SysRoleMapper;
import com.vision.edu.mapper.system.SysRoleModularMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.system.ISysRoleService;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

	/**
	 * 注入sysModularMapper
	 */
	@Autowired
	private SysModularMapper sysModularMapper;
	
	/**
	 * 注入sysRoleModularMapper
	 */
	@Autowired
	private SysRoleModularMapper sysRoleModularMapper;
	
	/**
	 * 查询所有园校名称
	 * @author XieFan
	 * @date 2017年7月20日 上午10:38:07
	 * @return
	 */
	@Override
	public List<BaseEntity> findAllSchoolName() {
		return super.baseMapper.findAllSchoolName();
	}

	/**
	 * 查询所有角色信息
	 * @author XieFan
	 * @date 2017年7月21日 上午8:56:10
	 * @param page
	 * @param map 参数类型【角色名称，园校ID】
	 * @return
	 */
	@Override
	public Page<BaseEntity> findAllSysRole(Page<BaseEntity> page,
			Map<String, Object> map) {
		page.setRecords(super.baseMapper.findAllSysRole(page, map));
		return page;
	}

	/**
	 * 添加角色
	 * @author XieFan
	 * @date 2017年7月20日 下午5:51:00
	 * @param sysRole 角色实体
	 * @param moduleIds 模块实体
	 * @return
	 */
	@Override
	public JsonResult addSysRole(SysRole sysRole, String moduleIds) {
		// 返回json的结果集
		JsonResult jsonResult = new JsonResult();
		// 判断传过来的参数是否为空
		// 参数错误
		if (sysRole == null && StringUtils.isEmpty(moduleIds)) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("请求参数出错");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			return jsonResult;
		}
		if ("0".equals(sysRole.getRoleType())) {
			sysRole.setSchoolId("0");
		}
		sysRole.setCreateTime(new Date());
		sysRole.setCreateMam("xiefan");
		sysRole.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		// 新增角色
		boolean sysRoleb = this.insert(sysRole);
		// 获取角色ID
		String roleId = sysRole.getId();
		// 判断是否新增角色成功
		if (!sysRoleb) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("添加角色失败");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			return jsonResult;
		}
		// 分割模块ID
		String[] modularIds = moduleIds.split(",");
		if (modularIds == null) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("请求参数出错");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			return jsonResult;
		}
		jsonResult = insertSysRoleModule(modularIds,roleId);
		return jsonResult;
	}

	/**
	 * 查询园校   tree
	 * @author XieFan
	 * @date 2017年7月21日 上午11:56:14
	 * @param fatherId 父ID
	 * @return
	 */
	@Override
	public List<BaseEntity> findSchoolTree(String fatherId) {
		return super.baseMapper.findSchoolTree(fatherId);
	}

	/**
	 * 根据角色ID查询模块
	 * @author XieFan
	 * @date 2017年7月21日 下午4:19:43
	 * @param roleId 角色ID
	 * @return
	 */
	@Override
	public List<BaseEntity> findSysModularByRoleId(String roleId) {
		return super.baseMapper.findSysModularByRoleId(roleId);
	}

	/**
	 * 编辑角色
	 * @author XieFan
	 * @date 2017年7月21日 下午5:41:45
	 * @param sysRole 角色实体
	 * @param moduleIds 模块Ids
	 * @return
	 */
	@Override
	public JsonResult editSysRole(SysRole sysRole, String moduleIds) {
		//实例化返回的json实体
		JsonResult jsonResult = new JsonResult();
		//判断参数是否错误
		if(sysRole == null && StringUtils.isEmpty(moduleIds)){
			jsonResult.setSuccess(false);
			jsonResult.setMsg("请求参数出错");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			return jsonResult;
		}
		sysRole.setUpdateTime(new Date());
		sysRole.setUpdateMan("xiefan");
		boolean uSysRole = this.updateById(sysRole);
		if(!uSysRole){
			jsonResult.setSuccess(false);
			jsonResult.setMsg("修改失败");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			return jsonResult;
		}
		String[] modularIds = moduleIds.split(",");
		List<BaseEntity> sysModulars = this.findSysModularByRoleId(sysRole.getId());
		if(modularIds == null && sysModulars == null){
			jsonResult.setSuccess(false);
			jsonResult.setMsg("请求参数出错");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			return jsonResult;
		}
		EntityWrapper<SysRoleModular> wrapper = new EntityWrapper<SysRoleModular>();
		wrapper.where(" role_id = {0}", sysRole.getId());
		sysRoleModularMapper.delete(wrapper);
		jsonResult = insertSysRoleModule(modularIds,sysRole.getId());
		return jsonResult;
	}
	
	/**
	 * 新增角色模块
	 * @author XieFan
	 * @date 2017年7月21日 下午10:57:45
	 * @param modularIds
	 * @param roleId
	 * @return
	 */
	private JsonResult insertSysRoleModule(String[] modularIds,String roleId){
		JsonResult jsonResult = new JsonResult();
		boolean insertb = false;
		// 遍历模块ID集合
		for (String modularId : modularIds) {
			// 通过模块ID查询模块信息
			SysModular sysModular = this.sysModularMapper.selectById(modularId);
			// 判断查询出来的模块是否为空
			if (sysModular != null) {
				// 判断是否为最顶级节点(不是最顶级节点)
				if (!"0".equals(sysModular.getFatherId())) {
					SysRoleModular sysRoleModular = new SysRoleModular();
					sysRoleModular.setRoleId(roleId);
					sysRoleModular.setModularId(modularId);
					sysRoleModular.setCreateTime(new Date());
					sysRoleModular.setCreateMam("xiefan");
					sysRoleModular.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
					Integer srmCount = sysRoleModularMapper.insert(sysRoleModular);
					if (srmCount > 0) {
						insertb = true;
					} else {
						insertb = false;
						break;
					}
				}
			}
		}
		if (insertb) {
			jsonResult.setSuccess(true);
			jsonResult.setMsg("保存成功");
			jsonResult.setStatus(HttpCode.OK.value().toString());
			// 添加角色失败
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("添加角色失败");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
		}
		return jsonResult;
	}

	/**
	 * 删除角色
	 * @author XieFan
	 * @date 2017年7月22日 上午8:15:59
	 * @param id
	 * @return
	 */
	@Override
	public JsonResult deleteSysRoleById(String id) {
		JsonResult jsonResult = new JsonResult();
		if(StringUtils.isEmpty(id)){
			jsonResult.setSuccess(false);
			jsonResult.setMsg("参数错误");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			return jsonResult;
		}
		SysRole sysRole = this.selectById(id);
		if(sysRole == null){
			jsonResult.setSuccess(false);
			jsonResult.setMsg("参数错误");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			return jsonResult;
		}
		sysRole.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		boolean delSysRole = this.updateById(sysRole);
		if(!delSysRole){
			jsonResult.setSuccess(false);
			jsonResult.setMsg("删除失败");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			return jsonResult;
		}
		EntityWrapper<SysRoleModular> ewWrapper = new EntityWrapper<SysRoleModular>();
		ewWrapper.where("delete_flag = 0 and role_id = {0}", id);
		List<SysRoleModular> sysRoleModulars = this.sysRoleModularMapper.selectList(ewWrapper);
		for(SysRoleModular sysRoleModular:sysRoleModulars){
			SysRoleModular roleModular = new SysRoleModular();
			roleModular.setId(sysRoleModular.getId());
			roleModular.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			this.sysRoleModularMapper.updateById(roleModular);
		}
		jsonResult.setSuccess(true);
		jsonResult.setMsg("删除成功");
		jsonResult.setStatus(HttpCode.OK.value().toString());
		return jsonResult;
	}
	
}
