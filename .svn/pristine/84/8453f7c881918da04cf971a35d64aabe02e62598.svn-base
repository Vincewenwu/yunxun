package com.vision.edu.web.controller.eval;

import java.util.ArrayList;
import java.util.Date;
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
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseEvalContent;
import com.vision.edu.entity.base.BaseEvalProject;
import com.vision.edu.entity.member.MemBabyEval;
import com.vision.edu.entity.member.MemBabyTeam;
import com.vision.edu.entity.member.MemChildHomeEval;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseBabyService;
import com.vision.edu.service.base.IBaseEvalContentService;
import com.vision.edu.service.member.IMemBabyEvalService;
import com.vision.edu.service.member.IMemBabyTeamService;
import com.vision.edu.service.member.IMemChildHomeEvalService;
import com.xiaoleilu.hutool.util.ObjectUtil;

import jodd.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @title 评价管理
 * @filename evaluatingManage.java
 * @author WuYing
 * @date 2017年7月23日 上午9:20:22
 * @version 1.0
 */
@Controller
@RequestMapping("/evaluatingManage")
public class EvaluatingManage extends BaseController {
	
	/**
	 * 基于注解注入老师评价服务
	 */
	@Autowired
	private IMemBabyEvalService memBabyEvalService;
	/**
	 * 基于注解注入宝贝服务
	 */
	@Autowired
	private IBaseBabyService baseBabyService;
	/**
	 * 基于注解注入教师评价内容服务
	 */
	@Autowired
	private IBaseEvalContentService baseEvalContentService;
	
	/**
	 * 基于注解注入宝贝学期服务
	 */
	@Autowired
	private IMemBabyTeamService memBabyTeamService;
	
	/**
	 * 基于注解注入宝贝在家评价服务
	 */
	@Autowired
	private IMemChildHomeEvalService memChildHomeEvalService;
	
	
	/**
	 * 绑定年级信息
	 * <p>Title: findGradeInformation</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 上午9:46:10
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findGradeAndClass")
	public JsonResult findGradeAndClass() {
		JsonResult jsonResult=new JsonResult();
		//获取参数，装进map
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gradeName", super.getRequest().getParameter("gradeName"));
		map.put("babyName", super.getRequest().getParameter("babyName"));
		map.put("className", super.getRequest().getParameter("className"));
		List<BaseBaby> baseClasses = this.baseBabyService.findGradeAndClass(map);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(baseClasses);
		return jsonResult;
	}
	/**
	 * 根据宝贝id查询宝贝学期
	 * <p>Title: findTreamByBabyId</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月25日 上午9:52:08
	 * @param babyId 宝贝ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findTreamByBabyId")
	public JsonResult findTreamByBabyId(String babyId){
		JsonResult jsonResult = new JsonResult();
		if (StringUtil.isBlank(babyId)) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		List<BaseEntity> memBabyTeams=this.memBabyTeamService.findTreamByBabyId(babyId);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(memBabyTeams);
		return jsonResult;
	}
	
	/**
	 * 绑定教师评价内容信息
	 * <p>Title: findTeacherEvalContentInfo</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 下午3:33:35
	 * @param gradeName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findTeacherEvalContentInfo")
	public JsonResult findTeacherEvalContentInfo(String gradeName){
		JsonResult jsonResult=new JsonResult();
		List<BaseEvalContent> baseEvalContents=this.baseEvalContentService.findTeacherEvalContentInfo(gradeName);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(baseEvalContents);
		return jsonResult;
	}
	/**
	 * 添加、修改老师对宝贝评价信息
	 * <p>Title: addEditTeacherEvaluating</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 下午7:55:42
	 * @param memBabyEval 对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEditTeacherEvaluating")
	public JsonResult addEditTeacherEvaluating(MemBabyEval memBabyEval,String tableData){
		JsonResult jsonResult =new JsonResult();
		List<MemBabyEval> mbes = new ArrayList<MemBabyEval>();
		boolean flag=false;
		//将json字符串转化为json数组
		JSONArray jsonArray = JSONArray.fromObject(tableData);
		for (int i = 0; i < jsonArray.size(); i++) {
			MemBabyEval mbe = new MemBabyEval();
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			if(!jsonObject.isNullObject()){
				Object evalItemId = jsonObject.get("evalProjectId");
				Object evalContentId = jsonObject.get("id");
				Object score = jsonObject.get("scoring");
				if(ObjectUtil.isNull(evalItemId) && ObjectUtil.isNull(evalContentId) && ObjectUtil.isNull(score) && memBabyEval != null){
					jsonResult.setSuccess(false);
					jsonResult.setMsg("请求参数错误");
					jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
					return jsonResult;
				}
				mbe.setScore(Integer.valueOf(String.valueOf(score)));
				System.out.println(mbe.getScore());
				if (StringUtil.isEmpty(memBabyEval.getId())) {//新增
					mbe.setBabyId(memBabyEval.getBabyId());
					mbe.setBabyTeamId(memBabyEval.getBabyTeamId());
					mbe.setEvalItemId(String.valueOf(evalItemId));
					mbe.setEvalContentId(String.valueOf(evalContentId));
					mbe.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
					mbe.setCreateMan("wuying");
					mbe.setCreateTime(new Date());
				}else{
					mbe.setId(String.valueOf(evalContentId));
					mbe.setUpdateMan("wuying");
					mbe.setUpdateTime(new Date());
				}
				mbes.add(mbe);	
			}
		}
		if (StringUtil.isEmpty(memBabyEval.getId())) {//新增
				flag=memBabyEvalService.insertBatch(mbes);
			}else {//修改
				flag=memBabyEvalService.updateBatchById(mbes);
			}if(flag){
				jsonResult.setSuccess(true);
				jsonResult.setStatus(HttpCode.OK.value().toString());
				jsonResult.setMsg("保存成功");
			}else{
				jsonResult.setSuccess(false);
				jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
				jsonResult.setMsg("保存失败");
			}
			return jsonResult;
	}
	
	/**
	 * 分页查询老师对宝贝评价信息
	 * <p>Title: findEvaluatingInformation</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月23日 下午11:05:46
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findEvaluatingInformation")
	public JsonResult findEvaluatingInformation(){
		JsonResult jsonResult =new JsonResult();
		//获取参数
		Integer currentPage = super.getCurrentPage();
		Integer pageSize = super.getPageSize();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("babyName1", super.getRequest().getParameter("babyName1"));
		map.put("babyTeamId", super.getRequest().getParameter("babyTeamId"));
		Page<BaseEntity> page =new Page<BaseEntity>(currentPage,pageSize);
		Page<BaseEntity> memBabyEvals = this.memBabyEvalService.findEvaluatingInformation(page,map);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(memBabyEvals);
		return jsonResult;
	}
	/**
	 * 根据宝贝学期ID查询老师对宝贝评价信息
	 * <p>Title: findEvaluatingById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月24日 上午11:04:13
	 * @param id 参数主键id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findEvaluatingById")
	public JsonResult findEvaluatingById(String babyTeamId){
		JsonResult jsonResult =new JsonResult();
		List<BaseEntity> memBabyEvals=this.memBabyEvalService.findEvaluatingById(babyTeamId);
		if (memBabyEvals != null) {
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("请求成功");
			jsonResult.setObj(memBabyEvals);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
		}
		return jsonResult;
	}
	
	
	/**
	 * 根据宝贝学期ID删除选中行数据
	 * <p>Title: deleteTeacherEvaluatingIdById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月24日 上午10:27:06
	 * @param babyTeamIds 宝贝学期ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteTeacherEvaluatingById")
	public JsonResult deleteTeacherEvaluatingIdById(String babyTeamId){
		JsonResult jsonResult = new JsonResult();
		//MemBabyEval memBabyEval=new MemBabyEval();
		//根据宝贝学期id查找教师评价信息
		List<BaseEntity> memBabyEvals=this.memBabyEvalService.findEvaluatingById(babyTeamId);
		List<MemBabyEval> list=new ArrayList<>();
		for (int i = 0; i < memBabyEvals.size(); i++) {
			MemBabyEval memBabyEval = new MemBabyEval();
			memBabyEval.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			memBabyEval.setId(memBabyEvals.get(i).get("id").toString());
			memBabyEval.setUpdateMan("wuying");
			memBabyEval.setUpdateTime(new Date());
			list.add(memBabyEval);
		}
		boolean flag = this.memBabyEvalService.updateBatchById(list);
		if (flag) {
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("删除成功");
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("删除失败");
		}
		return jsonResult;
	}
	
	/**
	 * 批量删除 老师对宝贝评价信息
	 * <p>Title: deleteBathTeacherEvaluating</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月24日 上午10:32:17
	 * @param ids 参数
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBathTeacherEvaluating")
	public JsonResult deleteBathTeacherEvaluating(String ids){
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isBlank(ids)) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		String[] babyTeamIds = ids.split("-");
		if (babyTeamIds.length == 0) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		for (int i = 0; i < babyTeamIds.length; i++) {
			MemBabyEval memBabyEval=new MemBabyEval();
			memBabyEval.setUpdateMan("wuying");
			memBabyEval.setBabyTeamId(babyTeamIds[i]);
			Integer j=this.memBabyEvalService.updateMemBabyDeleteFlag(memBabyEval);
			if (j>0) {
				jsonResult.setSuccess(true);
				jsonResult.setStatus(HttpCode.OK.value().toString());
				jsonResult.setMsg("删除成功");
			} else {
				jsonResult.setSuccess(false);
				jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
				jsonResult.setMsg("删除失败");
			}
		}
		return jsonResult;
	}
	
	//**********************************************宝贝在家评价********************************************************************
	
	/**
	 * 分页查询宝贝在家评价信息
	 * <p>Title: findAtHomeEvaluating</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月27日 上午11:37:03
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAtHomeEvaluating")
	public JsonResult findAtHomeEvaluating() {
		JsonResult jsonResult =new JsonResult();
		//获取参数
		Integer currentPage = super.getCurrentPage();
		Integer pageSize = super.getPageSize();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("babyName1", super.getRequest().getParameter("babyName1"));
		map.put("babyTeamId", super.getRequest().getParameter("babyTeamId"));
		Page<BaseEntity> page =new Page<BaseEntity>(currentPage,pageSize);
		Page<BaseEntity> memBabyAtHomeEvals = this.memChildHomeEvalService.findAtHomeEvaluating(page,map);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(memBabyAtHomeEvals);
		return jsonResult;
	}
	
	/**
	 * 根据宝贝学期ID查询家长对宝贝的评价的项目、评价标准
	 * <p>Title: findParentEvalContent</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月27日 下午8:23:50
	 * @param gradeId 参数年级Id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findParentEvalContent")
	public JsonResult findParentEvalContent(String babyTeamId){
		JsonResult jsonResult =new JsonResult();
		List<BaseEntity> baseEvalCrites=this.memChildHomeEvalService.findParentEvalContent(babyTeamId);
		if (baseEvalCrites != null) {
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("请求成功");
			jsonResult.setObj(baseEvalCrites);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
		}
		return jsonResult;
	}
	/**
	 * 根据宝贝学期ID查询家长对宝贝评价信息
	 * <p>Title: findPanrentEvaluatingByBabyTeamId</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月24日 上午11:04:13
	 * @param id 参数主键id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPanrentEvaluatingByBabyTeamId")
	public JsonResult findPanrentEvaluatingByBabyTeamId(String babyTeamId){
		JsonResult jsonResult =new JsonResult();
		List<BaseEntity> memBabyEvals=this.memBabyEvalService.findPanrentEvaluatingByBabyTeamId(babyTeamId);
		if (memBabyEvals != null) {
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("请求成功");
			jsonResult.setObj(memBabyEvals);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
		}
		return jsonResult;
	}
	
	/**
	 * 根据宝贝学期ID删除选中行数据:宝贝在家评价
	 * <p>Title: deleteParentEvaluating</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月24日 上午10:27:06
	 * @param babyTeamIds 宝贝学期ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteParentEvaluating")
	public JsonResult deleteParentEvaluating(String babyTeamId){
		JsonResult jsonResult = new JsonResult();
		MemChildHomeEval memChildHomeEval=new MemChildHomeEval();
		memChildHomeEval.setBabyTeamId(babyTeamId);
		memChildHomeEval.setUpdateMan("wuying");
		Integer i = this.memChildHomeEvalService.updateParentEvaluatingById(memChildHomeEval);
		if (i>0) {
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("删除成功");
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("删除失败");
		}
		return jsonResult;
	}
	
	/**
	 * 批量删除 家长对宝贝评价信息
	 * <p>Title: deleteBathTeacherEvaluating</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月24日 上午10:32:17
	 * @param ids 参数
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBathParentEvaluating")
	public JsonResult deleteBathParentEvaluating(String ids){
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isBlank(ids)) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		String[] babyTeamIds = ids.split("-");
		if (babyTeamIds.length == 0) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		
		for (int i = 0; i < babyTeamIds.length; i++) {
			MemChildHomeEval memChildHomeEval=new MemChildHomeEval();
			memChildHomeEval.setUpdateMan("wuying");
			memChildHomeEval.setBabyTeamId(babyTeamIds[i]);
			Integer j=this.memChildHomeEvalService.updateParentEvaluatingById(memChildHomeEval);
			if (j>0) {
				jsonResult.setSuccess(true);
				jsonResult.setStatus(HttpCode.OK.value().toString());
				jsonResult.setMsg("删除成功");
			} else {
				jsonResult.setSuccess(false);
				jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
				jsonResult.setMsg("删除失败");
			}
		}
		return jsonResult;
	}
	
}
