package com.vision.edu.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.entity.system.SysUser;
import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.framework.util.UploadUtil;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.system.ISysRoleService;
import com.vision.edu.service.system.ISysUserService;

@Controller
@RequestMapping("/sysUser")
public class SysUserController extends BaseController{
	
	/**
	 * 注入sysRoleService
	 */
	@Autowired
	private ISysRoleService sysRoleService;
	
	/**
	 * 注入sysUserService
	 */
	@Autowired
	private ISysUserService sysUserService;
	
	private Map<String, String> userImgMap;
	
	/**
	 * 查询用户角色
	 * @author XieFan
	 * @date 2017年7月23日 下午2:03:48
	 * @param schoolId 园校ID
	 * @param nameNum 姓名或账号
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAllSysUserBySchoolId")
	public JsonResult findAllSysUserBySchoolId(String schoolId,String nameNum){
		JsonResult jsonResult = new JsonResult();
		Page<BaseEntity> page = new Page<BaseEntity>(super.getCurrentPage(),super.getPageSize());
		Page<BaseEntity> userList = this.sysUserService.findUserRoleBySchoolId(page, schoolId, nameNum);
		List<BaseEntity> schools = this.sysUserService.findAllSchoolName(null);//判断session中园校是否存在
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userList", userList);
		map.put("schools", schools);
		jsonResult.setSuccess(true);
		jsonResult.setObj(map);
		jsonResult.setMsg("请求成功");
		jsonResult.setStatus(HttpCode.OK.value().toString());
		return jsonResult;
	}
	
	/**
	 * 跳转新增用户页面
	 * @author XieFan
	 * @date 2017年7月24日 上午11:16:08
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toAddUser")
	public JsonResult toAddUser(){
		JsonResult jsonResult = new JsonResult();
		//查询园校信息
		List<BaseEntity> schools = this.sysRoleService.findAllSchoolName();
		//查询平台角色信息
		List<BaseEntity> roles = this.sysUserService.findRoleNames("");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("schools", schools);
		map.put("roles", roles);
		jsonResult.setSuccess(true);
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(map);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		return jsonResult;
	}
	
	/**
	 * 根据园校ID查询角色
	 * @author XieFan
	 * @date 2017年7月31日 下午3:57:19
	 * @param schoolId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findRoleNames")
	public JsonResult findRoleNames(String schoolId){
		JsonResult jsonResult = new JsonResult();
		//查询园校角色
		List<BaseEntity> roles = this.sysUserService.findRoleNames(schoolId);
		jsonResult.setSuccess(true);
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(roles);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		return jsonResult;
	}
	
	/**
	 * 用户新增修改
	 * @author XieFan
	 * @date 2017年7月24日 下午4:16:05
	 * @param sysUser
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEditUser")
	public JsonResult addEditUser(SysUser sysUser){
		String userName = super.getRequest().getParameter("name");
		String userPhoneNum = super.getRequest().getParameter("phoneNum");
		String schoolId = super.getRequest().getParameter("schoolId");
		String roleId = super.getRequest().getParameter("roleId");
		Map<String, String> map = new HashMap<String, String>();
		JsonResult jsonResult = new JsonResult();
		if(StringUtils.isAnyEmpty(userName, userPhoneNum, schoolId, roleId) && sysUser == null){
			jsonResult.setSuccess(false);
			jsonResult.setMsg("请求参数错误");
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			return jsonResult;
		}
		map.put("userName", userName);
		map.put("userPhoneNum", userPhoneNum);
		map.put("schoolId", schoolId);
		map.put("roleId", roleId);
		if (userImgMap != null && userImgMap.size() > 0) {
			map.put("headImg", userImgMap.get("headImg"));
		}
		jsonResult = this.sysUserService.addEditUser(sysUser, map);
		return jsonResult;
	}
	
	/**
	 * 根据ID查询用户信息
	 * @author XieFan
	 * @date 2017年7月31日 下午3:11:54
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findUserByUserId")
	public JsonResult findUserByUserId(String id){
		//返回的json结果集
		JsonResult jsonResult = new JsonResult();
		//根据用户ID查询用户信息
		BaseEntity baseEntity = this.sysUserService.findSysUserByUserId(id);
		jsonResult.setObj(baseEntity);
		jsonResult.setSuccess(true);
		jsonResult.setMsg("请求成功");
		jsonResult.setStatus(HttpCode.OK.value().toString());
		return jsonResult;
	}
	
	/**
	 * 上传头像
	 * @author XieFan
	 * @date 2017年7月25日 上午9:29:15
	 */
	@ResponseBody
	@RequestMapping("/uploadHeadImg")
	public void uploadHeadImg(){
		userImgMap = new HashMap<String, String>();
		userImgMap = UploadUtil.uploadImage(super.getRequest(), "user");
	}
	
}
