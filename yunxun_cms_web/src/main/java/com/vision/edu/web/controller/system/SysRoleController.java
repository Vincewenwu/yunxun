package com.vision.edu.web.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.entity.system.SysModular;
import com.vision.edu.entity.system.SysRole;
import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.system.ISysModularService;
import com.vision.edu.service.system.ISysRoleService;

/**
 * 角色管理控制器
 * @author XieFan
 * @date 2017年7月20日 上午10:30:43
 * @version 1.0
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {
	
	/**
	 * 注入sysRoleService
	 */
	@Autowired
	private ISysRoleService sysRoleService;
	
	/**
	 * 注入sysModularService
	 */
	@Autowired
	private ISysModularService sysModularService;
	
	/**
	 * 查询所有角色信息
	 * @author XieFan
	 * @date 2017年7月21日 上午9:10:09
	 * @param roleName 角色名称
	 * @param schoolId 园校ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toSysRoleList")
	public JsonResult toSysRoleList(String roleName,String schoolId){
		JsonResult jsonResult = new JsonResult();
		Page<BaseEntity> page = new Page<BaseEntity>(super.getCurrentPage(),super.getPageSize());
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("roleName", roleName);
		map.put("schoolId", schoolId);
		Page<BaseEntity> sysRoles = this.sysRoleService.findAllSysRole(page, map);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("schools", getSchool("0"));
		map2.put("sysRoles", sysRoles);
		jsonResult.setSuccess(true);
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(map2);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		return jsonResult;
	}
	
	/**
	 * 进入角色编辑页面
	 * @author XieFan
	 * @date 2017年7月20日 下午3:26:12
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toSysRoleEdit")
	public JsonResult toSysRoleEdit(){
		JsonResult jsonResult = new JsonResult();
		Map<String, Object> map = new HashMap<String, Object>();
		List<BaseEntity> schools = this.sysRoleService.findAllSchoolName();
		map.put("schools", schools);
		map.put("modules", getSysModule("0"));
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(map);
		return jsonResult;
	}
	
	/**
	 * 新增保存
	 * @author XieFan
	 * @date 2017年7月20日 下午4:59:35
	 * @param sysRole
	 * @param moduleIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addSysRole")
	public JsonResult addSysRole(SysRole sysRole,String moduleIds){
		if(StringUtils.isNotEmpty(sysRole.getId())){
			return this.sysRoleService.editSysRole(sysRole, moduleIds);
		}else{
			return this.sysRoleService.addSysRole(sysRole, moduleIds);
		}
	}
	
	/**
	 * 跳转编辑页面
	 * @author XieFan
	 * @date 2017年7月21日 下午4:15:50
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findSysRoleById")
	public JsonResult findSysRoleById(String id){
		JsonResult jsonResult = new JsonResult();
		SysRole sysRole = this.sysRoleService.selectById(id);
		List<BaseEntity> ids = this.sysRoleService.findSysModularByRoleId(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", ids);
		map.put("sysRole", sysRole);
		jsonResult.setSuccess(true);
		jsonResult.setObj(map);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功！");
		return jsonResult;
	}
	
	/**
	 * 生成模块树
	 * @author XieFan
	 * @date 2017年7月20日 下午3:48:20
	 * @param farId
	 * @return
	 */
	private List<BaseEntity> getSysModule(String farId){
		List<BaseEntity> modules = new ArrayList<BaseEntity>();
		List<SysModular> sysModulars = this.sysModularService.findSysModularByFarId(farId);
		for(SysModular sysModular : sysModulars){
			BaseEntity baseEntity = new BaseEntity();
			baseEntity.put("id", sysModular.getId());
			baseEntity.put("label", sysModular.getName());
			List<SysModular> modulars = this.sysModularService.findSysModularByFarId(sysModular.getId());
			if(!modulars.isEmpty()){
				baseEntity.put("children", getSysModule(sysModular.getId()));
			}
			modules.add(baseEntity);
		}
		return modules;
	}
	
	/**
	 * 删除角色
	 * @author XieFan
	 * @date 2017年7月22日 上午8:33:35
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteSysRole")
	public JsonResult deleteSysRole(String ids){
		if(ids.indexOf("-") < 0){
			return this.sysRoleService.deleteSysRoleById(ids);
		}else{
			String[] strIds = ids.split("-");
			for(String strId:strIds){
				this.sysRoleService.deleteSysRoleById(strId);
			}
			JsonResult jsonResult = new JsonResult();
			jsonResult.setSuccess(true);
			jsonResult.setMsg("删除成功");
			jsonResult.setStatus(HttpCode.OK.value().toString());
			return jsonResult;
		}
	}
	
	/**
	 * 生成园校树
	 * @author XieFan
	 * @date 2017年7月20日 下午3:48:20
	 * @param farId
	 * @return
	 */
	private List<BaseEntity> getSchool(String farId){
		List<BaseEntity> schools = new ArrayList<BaseEntity>();
		BaseEntity beqb = new BaseEntity();
		beqb.put("id", "");
		beqb.put("label", "全部");
		BaseEntity bept = new BaseEntity();
		bept.put("id", "0");
		bept.put("label", "平台");
		schools.add(beqb);
		schools.add(bept);
		List<BaseEntity> baseSchools = this.sysRoleService.findSchoolTree(farId);
		for(BaseEntity baseSchool : baseSchools){
			List<SysModular> modulars = this.sysModularService.findSysModularByFarId(baseSchool.getString("id"));
			if(!modulars.isEmpty()){
				baseSchool.put("children", getSysModule(baseSchool.getString("id")));
			}
			schools.add(baseSchool);
		}
		return schools;
	}
	
}
