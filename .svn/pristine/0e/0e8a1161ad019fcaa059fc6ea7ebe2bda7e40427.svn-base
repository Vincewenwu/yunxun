package com.vision.edu.web.controller.eval.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.entity.base.BaseEvalProject;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseEvalProjectService;

import jodd.util.StringUtil;

/**
 * @title 老师评价项目
 * @filename TeacherEvalProController.java
 * @author WuYing
 * @date 2017年7月20日 下午4:32:02
 * @version 1.0
 */
@Controller
@RequestMapping("/teacherEvalPro")
public class TeacherEvalProController extends BaseController{

	/**
	 * 基于注解注入老师评价项目服务
	 */
	@Autowired
	private IBaseEvalProjectService baseEvalProjectService;
	
	/**
	 *添加、修改老师评价项目信息 
	 * <p>Title: addEditTeacherEvalPro</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月20日 下午4:39:00
	 * @param baseEvalProject 实体对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEditTeacherEvalPro")
	public JsonResult addEditTeacherEvalPro(BaseEvalProject baseEvalProject){
		boolean flag=false;
		JsonResult jsonResult =new JsonResult();
		if (StringUtil.isEmpty(baseEvalProject.getId())) {//新增
			baseEvalProject.setCreateTime(new Date());
			baseEvalProject.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			baseEvalProject.setCreateMan("wuying");
			flag=baseEvalProjectService.insert(baseEvalProject);
			}else {//修改
				baseEvalProject.setUpdateTime(new Date());
				baseEvalProject.setUpdateMan("wuying");
				baseEvalProject.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
				flag=baseEvalProjectService.updateById(baseEvalProject);
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
	 * 分页查询老师评价项目
	 * <p>Title: findAllTeacherEvalPro</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月20日 下午5:28:39
	 * @param currentPage
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAllTeacherEvalPro")
	public JsonResult findAllTeacherEvalPro(Integer currentPage,Integer pageSize,String name){
		JsonResult jsonResult=new JsonResult();
		Page<BaseEvalProject> page =new Page<BaseEvalProject>(currentPage,pageSize);
		Page<BaseEvalProject> baseEvalProjects = this.baseEvalProjectService.findAllTeacherEvalPro(page,name);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(baseEvalProjects);
		return jsonResult;
	}
	
	/**
	 * 根据主键ID查询老师评价项目信息
	 * <p>Title: findTeacherEvalProById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月20日 下午11:30:31
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findTeacherEvalProById")
	public JsonResult findTeacherEvalProById(String id){
		JsonResult jsonResult = new JsonResult();
		BaseEvalProject baseEvalProject=this.baseEvalProjectService.selectById(id);
		if (baseEvalProject != null) {
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("请求成功");
			jsonResult.setObj(baseEvalProject);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
		}
		return jsonResult;
	}
	
	/**
	 * 根据主键ID删除老师评价项目信息
	 * <p>Title: deleteTeacherEvalProById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 上午7:40:46
	 * @param id 参数主键ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteTeacherEvalProById")
	public JsonResult deleteTeacherEvalProById(String id){
		JsonResult jsonResult = new JsonResult();
		BaseEvalProject baseEvalProject=new BaseEvalProject();
		baseEvalProject.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		baseEvalProject.setId(id);
		boolean flag = this.baseEvalProjectService.updateById(baseEvalProject);
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
	 * 批量删除
	 * <p>Title: deleteBathTeacherEvalPro</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 上午7:46:56
	 * @param ids 参数集合ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBathTeacherEvalPro")
	public JsonResult deleteBathTeacherEvalPro(String ids){
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isBlank(ids)) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		String[] teacherEvalProids = ids.split("-");
		if (teacherEvalProids.length == 0) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		List<BaseEvalProject> baseEvalProjectList = new ArrayList<BaseEvalProject>();
		for (int i = 0; i < teacherEvalProids.length; i++) {
			BaseEvalProject baseEvalProject = new BaseEvalProject();
			baseEvalProject.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			baseEvalProject.setId(teacherEvalProids[i]);
			baseEvalProjectList.add(baseEvalProject);
		}
		boolean flag = this.baseEvalProjectService.updateBatchById(baseEvalProjectList);
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
}
