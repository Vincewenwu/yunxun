package com.vision.edu.web.controller.base;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseDuties;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseDutiesService;

@Controller
@RequestMapping("/duties")
public class DutiesController extends BaseController{

	@Autowired
	private IBaseDutiesService baseDutiesService;
	
	/**
	 * 模糊查询职务
	 * @author jiangwangying
	 * @date 2017年7月30日 下午7:39:08
	 * @param vague 搜索词条
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findDutiesByVague")
	public JsonResult findDutiesByVague(Integer startPage,Integer pageSize ,String schoolId,String vague){
		
		JsonResult jsonResult = new JsonResult();
		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memberType = sysUserDTO.getMemberType();
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()) {
		    schoolId = sysUserDTO.getSchoolId();
		}
		if (null ==startPage && null ==pageSize) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取页码信息错误");
			return jsonResult;
		}
		
		Page<BaseDuties> page = new Page<BaseDuties>(startPage,pageSize);
		List<BaseDuties> list = baseDutiesService.findDutiesByVague(page,vague,schoolId);
		if (list.size()==0) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("行数为0");
			return jsonResult;
		}
		jsonResult.setSuccess(true);
		jsonObject.put("total", page.getTotal());
		jsonObject.put("list", list);
		jsonResult.setObj(jsonObject);
		return jsonResult;
	}
	
	/**
	 * 添加职务
	 * @author jiangwangying
	 * @date 2017年7月30日 下午8:38:19
	 * @param dutiesName 职务名
	 * @param schoolId 园校id
	 * @param description 描述
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addDuities")
	public JsonResult addDuities(String dutiesName,String schoolId,String description){
		
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memberType = sysUserDTO.getMemberType();
		String createMan = sysUserDTO.getUsername();
		
		if (StringUtils.isEmpty(dutiesName.trim())|| StringUtils.isEmpty(schoolId.trim()) || StringUtils.isEmpty(description.trim())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("请填写完整在提交");
			return jsonResult;
		}
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()) {
			if (!sysUserDTO.getSchoolId().equals(schoolId)) {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("新增失败");
				return jsonResult;
			}
		}
		
		return baseDutiesService.addDuities(dutiesName, schoolId, memberType,createMan,description);
	}
	
	
	/**
	 * 修改职务 根据职务id查询职务
	 * @author jiangwangying
	 * @date 2017年7月30日 下午8:54:31
	 * @param dutiesId
	 * @param schoolId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findDuitiesById")
	public JsonResult findDuitiesById(String dutiesId,String schoolId){
		
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
	    Integer memberType = sysUserDTO.getMemberType();
        if (StringUtils.isEmpty(sysUserDTO.getUsername()) || StringUtils.isEmpty(dutiesId)) {
        	jsonResult.setMsg("空值");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
	    if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()) {
			if (!sysUserDTO.getSchoolId().equals(schoolId.trim())) {
				jsonResult.setMsg("无权限编辑其他学校的职务");
				jsonResult.setSuccess(false);
				return jsonResult;
			}
		}
		
		EntityWrapper<BaseDuties> ew = new EntityWrapper<BaseDuties>();
		ew.setSqlSelect("duties_name AS dutiesName,school_id AS schoolId,description");
  		ew.where("id = {0}",dutiesId);
		List<BaseDuties> list = baseDutiesService.selectList(ew);
	    if (list.size()>0) {
			jsonResult.setObj(list);
			jsonResult.setSuccess(true);
			return jsonResult;
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("行数为0");
			return jsonResult;
		}
	}
	
	/**
	 * 修改职务
	 * @author jiangwangying
	 * @date 2017年7月30日 下午9:09:04
	 * @param dutiesName
	 * @param description
	 * @param dutiesId
	 * @param schoolId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editDuties")
	public JsonResult editDuties(String dutiesName,String description,String dutiesId,String schoolId){
		
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
	    Integer memberType = sysUserDTO.getMemberType();
        if (StringUtils.isEmpty(sysUserDTO.getUsername()) || StringUtils.isEmpty(dutiesId) || StringUtils.isEmpty(dutiesName) || StringUtils.isEmpty(description)) {
        	jsonResult.setMsg("空值");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
	    if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()) {
			if (!sysUserDTO.getSchoolId().equals(schoolId.trim())) {
				jsonResult.setMsg("无权限编辑其他学校的职务");
				jsonResult.setSuccess(false);
				return jsonResult;
			}
		}
	     BaseDuties baseDuties = new BaseDuties();
	     baseDuties.setId(dutiesId);
	     baseDuties.setDutiesName(dutiesName);
	     baseDuties.setUpdateMan(sysUserDTO.getUsername());
	     baseDuties.setUpdateTime(new Date());
	     baseDuties.setDescription(description);
	     boolean result = baseDutiesService.updateById(baseDuties);
	    
	    if (result) {
	    	jsonResult.setSuccess(true);
			jsonResult.setMsg("修改成功");
			return jsonResult;
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("修改失败");
			return jsonResult;
		}
	}
	
	/**
	 * 删除职务
	 * @author jiangwangying
	 * @date 2017年7月30日 下午8:56:13
	 * @param dutiesId
	 * @param schoolId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delDuties")
	public JsonResult delDuties(String dutiesId,String schoolId){
		
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		String updateMan = sysUserDTO.getUsername();
	    Integer memberType = sysUserDTO.getMemberType();
        if (StringUtils.isEmpty(sysUserDTO.getUsername()) || StringUtils.isEmpty(dutiesId) || StringUtils.isEmpty(schoolId)) {
        	jsonResult.setMsg("空值");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
	    if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()) {
			String[] schoolIds = schoolId.split(",");
			Integer schoolIdsLen = schoolIds.length;
			for (int i = 0; i < schoolIdsLen; i++) {
				if (!sysUserDTO.getSchoolId().equals(schoolIds[i])) {
					jsonResult.setMsg("无权限删除其他学校的职务");
					jsonResult.setSuccess(false);
					return jsonResult;
				} 
			}
		}
	    
	    BaseDuties baseDuties = null;
	    String[] dutiesIds = dutiesId.split(",");
	    Integer dutiesIdsLen = dutiesIds.length;
	    Integer rows = 0 ;
	    for (int i = 0; i < dutiesIdsLen; i++) {
	        baseDuties = new BaseDuties();
	  	    baseDuties.setDeleteFlag2(EnumDeleteFlag.YSC.getValue());
	  	    baseDuties.setId(dutiesIds[i]);
	  	    baseDuties.setUpdateMan(updateMan);
	  	    baseDuties.setUpdateTime(new Date());
	  	    Boolean result = baseDutiesService.updateById(baseDuties);
	  	    if (result) {
	  	    	rows += 1;
			}
		}
		if (rows == dutiesIdsLen) {
			jsonResult.setSuccess(true);
			jsonResult.setMsg("删除成功");
			return jsonResult;
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("删除失败");
			return jsonResult;
		}
	}
}
