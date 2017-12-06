package com.vision.edu.web.controller.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.framework.util.UploadUtil;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseDistrictService;
import com.vision.edu.service.base.IBaseSchoolService;

@Controller
@RequestMapping("/school")
public class SchoolController extends BaseController {

	@Autowired
	private IBaseSchoolService baseSchoolService;

	@Autowired
	private IBaseDistrictService baseDistrictService;

	Map<String, String> uploadImg;//[{shcool:eww}]

	/**
	 * 动态模糊查询园校
	 * @author jiangwangying
	 * @date 2017年7月11日 上午9:54:04
	 * @param schoolName 园校名称
	 * @param deleteFlag 删除标记
	 * @param startPage 起始页码
	 * @param pageSize 每页大小
	 */
	@ResponseBody
	@RequestMapping("/findSchoolByDynamic")
	public JsonResult findSchoolByDynamic(Integer startPage,Integer pageSise,String schoolId,Integer deleteFlag) {


		JsonResult jsonResult = new JsonResult();
		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memberType = sysUserDTO.getMemberType();

		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue() ) {
			schoolId = sysUserDTO.getSchoolId();
		}
		Page<BaseSchool> page = new Page<BaseSchool>(startPage,pageSise);
		List<BaseSchool> list = baseSchoolService.findSchoolByDynamic(page,schoolId,"",deleteFlag);

		if (list.size()>0) {
			jsonResult.setSuccess(true);
			jsonObject.put("total", list.size());
			jsonObject.put("school", list);
			jsonResult.setObj(jsonObject);

		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("无符合条件的数据");
		}
		return jsonResult;
	}
	/**
	 * 根据schooId查询园校
	 * @author jiangwangying
	 * @date 2017年7月18日 上午11:39:29
	 * @param schoolId 园校id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findSchoolById")
	public JsonResult findSchoolById(String schoolId){

		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memberType = sysUserDTO.getMemberType();
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue() ) {
			if (!schoolId.equals(sysUserDTO.getSchoolId())) {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("失败,非本校管理员");
				return jsonResult;
			}
		}

		BaseSchool baseSchool = new BaseSchool();
		baseSchool= baseSchoolService.selectById(schoolId);
		List<BaseSchool> list = new ArrayList<BaseSchool>();
		list.add(baseSchool);
		jsonResult.setObj(list);
		return jsonResult;
	}

	/**
	 * 逻辑删除园校
	 * @author jiangwangying
	 * @date 2017年7月11日 上午9:56:38
	 * @param schoolID 园校id
	 */
	@ResponseBody
	@RequestMapping("/delSchool")
	public JsonResult delSchool(String schoolIds) {

		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		String updateMan = sysUserDTO.getUsername();
		return baseSchoolService.delOrStopSchool(schoolIds,0,updateMan);

	}

	/**
	 * 新增园校
	 * @author jiangwangying
	 * @date 2017年7月11日 上午10:00:43
	 * @param baseSchool
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addSchoool")
	public JsonResult addSchoool(BaseSchool baseSchool) {
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || null == sysUserDTO.getUsername()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue() ) {
			jsonResult.setMsg("非平台管理员");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		if (null == uploadImg) {
			jsonResult.setMsg("总要给个logo吧");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		baseSchool.setLogo(uploadImg.get("schoolLogo"));
		jsonResult = baseSchoolService.addSchool(baseSchool, sysUserDTO.getUsername());
		uploadImg = null;
		return jsonResult;
	}

	/**
	 * 停用账号
	 * @author jiangwangying
	 * @date 2017年7月18日 上午10:06:30
	 * @param schoolIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/stopSchool")
	public JsonResult stopSchool(String schoolIds) {

		JsonResult jsonResult = new JsonResult();
		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memberType = sysUserDTO.getMemberType();
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue() ) {
			jsonResult.setMsg("非平台管理员");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		String updateMan = sysUserDTO.getUsername();
		return baseSchoolService.delOrStopSchool(schoolIds,1,updateMan);

	}

	/**
	 *  上传图片
	 * @author jiangwangying
	 * @date 2017年7月11日 上午11:06:37
	 * @param baseSchool
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadLogo")
	public void uploadLogo()
	{
		uploadImg = new HashMap<String,String>();
		uploadImg = UploadUtil.uploadImage(super.getRequest(), "school");
	}

	/**
	 *  编辑园校
	 * @author jiangwangying
	 * @date 2017年7月11日 上午11:06:37
	 * @param baseSchool
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editSchool")
	public JsonResult editSchool(BaseSchool baseSchool) {

		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memberType = sysUserDTO.getMemberType();
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue() ) {
			if (!baseSchool.getId().equals(sysUserDTO.getSchoolId())) {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("失败,非本校管理员");
				return jsonResult;
			}
		}
		if (!StringUtils.isEmpty(sysUserDTO.getUsername())) {
			baseSchool.setUpdateMan(sysUserDTO.getUsername());
		}
		if (null != uploadImg) {
			baseSchool.setLogo(uploadImg.get("schoolLogo"));
		}
		uploadImg = null;//避免下一次使用上次的图
		return baseSchoolService.editSchool(baseSchool);
	}

	/**
	 * 绑定园校下拉框
	 * @author jiangwangying
	 * @date 2017年7月11日 下午9:45:23
	 */
	@ResponseBody
	@RequestMapping("/findCboSchool")
	public JsonResult findCboSchool(){

		JsonResult jsonResult = new JsonResult();
		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}

		EntityWrapper<BaseSchool> ew = new EntityWrapper<BaseSchool>();
		//ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
		ew.setSqlSelect("id,name");

		Integer memberType = sysUserDTO.getMemberType();
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue() ) {
			ew.where("id={0}", sysUserDTO.getSchoolId());
		}

		List<BaseSchool> list = baseSchoolService.selectList(ew);
		jsonResult.setObj(list);
		return jsonResult;

	}

	/**
	 * 绑定省市区下拉框
	 * @author jiangwangying
	 * @date 2017年7月27日 上午11:43:56
	 * @param pid 父亲id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findDistrict")
	public JsonResult findDistrict(Integer pid){

		return baseDistrictService.findDistricts(pid);

	}
	/**
	 * 根据用户类型绑定学校下拉框
	 * @author jiangwangying
	 * @date 2017年7月30日 下午10:10:16
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCboSchool")
	public JsonResult getCboSchool(){

		JsonResult jsonResult = new JsonResult();
		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}

		EntityWrapper<BaseSchool> ew = new EntityWrapper<BaseSchool>();
		//ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
		ew.setSqlSelect("id,name");

		Integer memberType = sysUserDTO.getMemberType();
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue() ) {
			ew.where("id={0}", sysUserDTO.getSchoolId());
		}
		List<BaseSchool> list = baseSchoolService.selectList(ew);
		if (list.size()>0) {
			jsonResult.setSuccess(true);
			jsonResult.setObj(list);
		}else {
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		return jsonResult;
	}
}
