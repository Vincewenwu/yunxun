package com.vision.edu.web.controller.base;

import java.util.ArrayList;
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
import com.vision.edu.dto.GradeClassDTO;
import com.vision.edu.dto.KaoQinTongJiDTO;
import com.vision.edu.dto.LeaveRecordDTO;
import com.vision.edu.dto.SigStatisticsDTO;
import com.vision.edu.dto.SignDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.base.BaseGrade;
import com.vision.edu.entity.base.BaseSignRecord;
import com.vision.edu.entity.member.MemLeaveRecord;
import com.vision.edu.enums.EnumBabyState;
import com.vision.edu.enums.EnumCheckFlag;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.enums.EnumRecordState;
import com.vision.edu.enums.EnumRecordType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseBabyService;
import com.vision.edu.service.base.IBaseClassService;
import com.vision.edu.service.base.IBaseGradeService;
import com.vision.edu.service.base.IBaseSignRecordService;
import com.vision.edu.service.base.IBaseSignService;
import com.vision.edu.service.member.IMemLeaveRecordService;

/**
 * @author jiangwangying
 * @date 2017年7月9日 下午5:20:05
 * @version 1.0
 */
@Controller
@RequestMapping("/sign")
public class SignController extends BaseController {

	@Autowired
	private IBaseSignRecordService baseSigRecordService;

	@Autowired
	private IBaseBabyService baseBabyService;

	@Autowired
	private IMemLeaveRecordService memLeaveRecordService;
	
	@Autowired
	private IBaseClassService baseClassService;
	
	@Autowired
	private IBaseSignService baseSignService;
	
	@Autowired
	private IBaseGradeService baseGradeService;

	/**
	 * 查询宝贝签到
	 * @author jiangwangying
	 * @date 2017年8月3日 下午15:42:13
	 * @param startPage 开始页码
	 * @param pageSize 页码
	 * @param schoolId 学校id
	 * @param classId 班级id
	 * @param babyName 宝贝姓名
	 * @param signState 签到状态
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findSign")
	public JsonResult findSignRecord(Integer startPage, Integer pageSize, String schoolId,String classId, String vague,Integer signState) {

		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
			if (!StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
				schoolId = sysUserDTO.getSchoolId();
			}
		}
		
		Page<SignDTO> page = new Page<SignDTO>(startPage, pageSize);
		List<SignDTO> list = baseSignService.findSign(page,schoolId, vague, classId,signState);
		if (list.size()>0) {
			jsonObject.put("total", page.getTotal());
			jsonObject.put("list", list);
			jsonResult.setObj(jsonObject);
			jsonResult.setSuccess(true);
		}else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("无符合条件的数据");
		}
		return jsonResult;
	}

	/**
	 * 根据学校id绑定班级下拉框
	 * @author jiangwangying
	 * @date 2017年8月2日 下午2:23:08
	 * @param schoolId
	 * @return
	 */
  	@ResponseBody
	@RequestMapping("/findCboClassBySchoolId")
  	public JsonResult findTeacherGroup(String schoolId){

  		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
			if (!StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
				schoolId = sysUserDTO.getSchoolId();
			}
		}
		if (StringUtils.isEmpty(schoolId)) {
  			jsonResult.setSuccess(false);
  			return jsonResult;
		}
  		
		// 查询一级节点 年级
		List<GradeClassDTO> gradelist = baseGradeService.findGrade(null);
		if(gradelist.size()>0){
			Integer gradelistLen = gradelist.size();
			EntityWrapper<BaseClass> ew1 = null;
			for (int i = 0; i < gradelistLen; i++) {
				ew1 = new EntityWrapper<BaseClass>();
				ew1.where("school_id = {0}", schoolId);
				ew1.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
				ew1.where("grade_id = {0}",gradelist.get(i).getId());
				ew1.setSqlSelect("id,class_name AS className"); // as 后面为实体对应的名称
				// 查询二级节点 班级
				List<BaseClass> classList = baseClassService.selectList(ew1);
				if (classList.size()>0) {
					gradelist.get(i).setChildren((ArrayList<BaseClass>) classList);
				}
			}
			jsonResult.setSuccess(true);
			jsonResult.setObj(gradelist);
		} else {
			jsonResult.setSuccess(false);
		}
     	return jsonResult;
  	}
  	
  	/**
  	 * 查询未签到宝贝
  	 * @author jiangwangying
  	 * @date 2017年8月2日 下午8:56:37
  	 * @param schoolId
  	 * @param classId
  	 * @return
  	 */
  	@ResponseBody
	@RequestMapping("/findNoSignBaby")
  	public JsonResult findNoSignBaby(String schoolId,String classId){
		
  		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
			if (!StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
				schoolId = sysUserDTO.getSchoolId();
			}
		}
		List<SignDTO> list = baseSignService.findNoSignBaby(schoolId, classId);
		if (list.size()>0) {
			jsonObject.put("list", list);
			jsonResult.setObj(jsonObject);
			jsonResult.setSuccess(true);
		}else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("没有没有符合条件的宝贝");
		}
  		return jsonResult;
  	}
  	/**
  	 * 补考勤
  	 * @author jiangwangying
  	 * @date 2017年8月2日 下午11:06:07
  	 * @param babyId 宝贝id (一个或多个)
  	 * @return
  	 */
  	@ResponseBody
	@RequestMapping("/buKaoQin")
  	public JsonResult buKaoQin(String babyId,Integer signType,Integer signState){
		
  		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		String schoolId = "";
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
			if (!StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
				schoolId = sysUserDTO.getSchoolId();
			}
		}
		String updateMan = sysUserDTO.getUsername();
		return baseSignService.buKaoQin(babyId,signType,signState,updateMan);
  	}
	/**
	 * 根据签到id删除签到
	 * @author jiangwangying
	 * @date 2017年8月3日 下午2:59:08
	 * @param signId 签到id
	 * @return
	 */
  	@ResponseBody
	@RequestMapping("/delSignById")
  	public JsonResult delSignById(String signId){
		
  		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		
		String updateMan = sysUserDTO.getUsername();
		
		return  baseSignService.delSignById(signId,updateMan);
  	}
  	
  	/**
	 * 更新签到类别  不是重置  是将未纳入或者已在签到表中删除的正常的宝贝加入进签到表
	 * @author jiangwangying
	 * @date 2017年8月3日 下午3:08:41
	 * @return
	 */
  	@ResponseBody
	@RequestMapping("/gengxinQianDao")
	public JsonResult gengxinQianDao() {
		
		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		String schoolId = "";
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
			schoolId = sysUserDTO.getSchoolId();
		}
		String createMan = sysUserDTO.getUsername();
		return baseSignService.gengxinQianDao(createMan,schoolId);
	}
  	
  	
	/**
	 * 查询宝贝请假记录
	 * @author jiangwangying
	 * @date 2017年8月8日 上午10:12:48
	 * @param startPage 起始页码
	 * @param pageSize 每页大小
	 * @param vague 关键字
	 * @param schoolId 园校id
	 * @param classId 班级id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findLeaveRecord")
	public JsonResult findLeaveRecord( Integer startPage, Integer pageSize,String vague, String schoolId,String classId) {

		
		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
			schoolId = sysUserDTO.getSchoolId();
		}
		
		Integer checkFlag = null; // 审核标记
		Integer memberType = null; // 用户类型
		Integer deleteFlag = null; //  删除标记
		Integer total = 0;
		Page<LeaveRecordDTO> page = new Page<LeaveRecordDTO>(startPage, pageSize);
		List<LeaveRecordDTO> list = memLeaveRecordService.findBabyLeaveRecord(page,schoolId,classId,vague,checkFlag,memberType,deleteFlag);
		
		if (list.size()>0) {
			jsonResult.setSuccess(true);
			total = page.getTotal();
			jsonObject.put("total", total);
			jsonObject.put("list", list);
			jsonResult.setObj(jsonObject);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("无符合条件的数据");
		}
		return jsonResult;
	}

	/**
	 * 审核请假人
	 * @author jiangwangying
	 * @date 2017年7月24日 下午5:06:38
	 * @param id
	 * @param checkState 1： 审核通过  2:审核不通过
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkLeaveRecord")
	public JsonResult checkLeaveRecord(String id,String checkState) {

		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		String updateMan = sysUserDTO.getUsername();
		return memLeaveRecordService.checkLeaveRecord(id,checkState,updateMan);
	
	}
	
	/**
	 * 考勤统计
	 * @author jiangwangying
	 * @date 2017年8月3日 下午9:17:18
	 * @param schoolId 学校id
	 * @param babyId 宝贝id
	 * @param classId 班级id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param deleteFlag 删除标记
	 * @param signState 签到状态
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/kaoQinTongJi")
	public JsonResult kaoQinTongJi(Integer startPage,Integer pageSize,String schoolId,String classId,String starteTime,String endTime){
		
		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || StringUtils.isEmpty(sysUserDTO.getUsername())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
			schoolId = sysUserDTO.getSchoolId();
		}
		Page<KaoQinTongJiDTO> page = new Page<KaoQinTongJiDTO>(startPage, pageSize);
		return baseSigRecordService.TongJi(page,schoolId,classId,starteTime,endTime,sysUserDTO.getUsername());
	}
}
