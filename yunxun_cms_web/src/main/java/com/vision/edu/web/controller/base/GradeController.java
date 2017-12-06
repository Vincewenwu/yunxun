package com.vision.edu.web.controller.base;

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
import com.vision.edu.entity.base.BaseGrade;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseGradeService;

import jodd.util.StringUtil;

/**
 * @title 年级管理
 * @filename GradeController.java
 * @author WuYing
 * @date 2017年7月22日 下午4:49:35
 * @version 1.0
 */
@Controller
@RequestMapping("/gradeManage")
public class GradeController extends BaseController{
	
	/**
	 * 基于注解注入年级管理服务
	 */
	@Autowired
	private IBaseGradeService baseGradeService;
	
	/**
	 * 添加、修改年级信息
	 * <p>Title: addEditGrade</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 下午4:55:38
	 * @param baseGrade
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEditGrade")
	public JsonResult addEditGrade(BaseGrade baseGrade){
		boolean flag=false;
		JsonResult jsonResult =new JsonResult();
		if (StringUtil.isEmpty(baseGrade.getId())) {//新增
			baseGrade.setCreateTime(new Date());
			baseGrade.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			baseGrade.setCreateMan("wuying");
			flag=baseGradeService.insert(baseGrade);
			}else {//修改
				baseGrade.setUpdateTime(new Date());
				baseGrade.setUpdateMan("wuying");
				baseGrade.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
				flag=baseGradeService.updateById(baseGrade);
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
	 * 分页查找年级信息
	 * <p>Title: findAllGrade</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 下午4:59:20
	 * @param gradeName 年级名称
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAllGrade")
	public JsonResult findAllGrade(String gradeName){
		JsonResult jsonResult=new JsonResult();
		//获取参数
		Integer currentPage=super.getCurrentPage();
		Integer pageSize=super.getPageSize();
		Page<BaseGrade> page =new Page<BaseGrade>(currentPage,pageSize);
		Page<BaseGrade> baseGrades = this.baseGradeService.findAllGrade(page,gradeName);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(baseGrades);
		return jsonResult;
	}
	
	/**
	 * 根据主键ID查询年级信息
	 * <p>Title: findGradeById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 下午5:12:57
	 * @param id 参数主键ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findGradeById")
	public JsonResult findGradeById(String id){
		JsonResult jsonResult = new JsonResult();
		BaseGrade baseGrade=this.baseGradeService.selectById(id);
		if (baseGrade != null) {
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("请求成功");
			jsonResult.setObj(baseGrade);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
		}
		return jsonResult;
	}
	
	/**
	 * 根据主键ID删除
	 * <p>Title: deleteGradeById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 下午5:14:26
	 * @param id 参数主键ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteGradeById")
	public JsonResult deleteGradeById(String id){
		JsonResult jsonResult = new JsonResult();
		BaseGrade baseGrade=new BaseGrade();
		baseGrade.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		baseGrade.setId(id);
		boolean flag = this.baseGradeService.updateById(baseGrade);
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
	 * <p>Title: deleteBathGrade</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 下午5:29:51
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBathGrade")
	public JsonResult deleteBathGrade(String ids){
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isBlank(ids)) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		String[] gradeids = ids.split("-");
		if (gradeids.length == 0) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		List<BaseGrade> gradeList = new ArrayList<BaseGrade>();
		for (int i = 0; i < gradeids.length; i++) {
			BaseGrade baseGrade = new BaseGrade();
			baseGrade.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			baseGrade.setId(gradeids[i]);
			gradeList.add(baseGrade);
		}
		boolean flag = this.baseGradeService.updateBatchById(gradeList);
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
