package com.vision.edu.web.controller.eval.base;

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

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.entity.base.BaseEvalContent;
import com.vision.edu.entity.base.BaseEvalProject;
import com.vision.edu.entity.base.BaseGrade;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseEvalContentService;

import jodd.util.StringUtil;
/**
 * @title 老师评价内容、标准、得分范围信息
 * @filename TeacherEvalContentController.java
 * @author WuYing
 * @date 2017年7月21日 上午9:22:49
 * @version 1.0
 */
@Controller
@RequestMapping("/teacherEvalContent")
public class TeacherEvalContentController extends BaseController{
	
	/**
	 * 基于注解注入老师评价内容服务
	 */
	@Autowired
	private IBaseEvalContentService baseEvalContentService;
	/**
	 * 绑定下拉框【年级、老师评价项目】
	 * <p>Title: findGradeAndPro</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 上午9:49:30
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findGradeAndPro")
	public JsonResult findGradeAndPro() {
		JsonResult jsonResult=new JsonResult();
		List<BaseGrade> grades=this.baseEvalContentService.findGrades();
		List<BaseEvalProject> projectNames=this.baseEvalContentService.findPros();
		Map<String , Object> map= new HashMap<String, Object>();
		map.put("grades", grades);
		map.put("projectNames", projectNames);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(map);
		return jsonResult;
	}
	
	/**
	 * 添加、删除老师评价内容信息
	 * <p>Title: addEditTeacherEvalContent</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 上午11:51:01
	 * @param baseEvalContent 对象评价内容
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEditTeacherEvalContent")
	public JsonResult addEditTeacherEvalContent(BaseEvalContent baseEvalContent){
		boolean flag=false;
		JsonResult jsonResult =new JsonResult();
		if (StringUtil.isEmpty(baseEvalContent.getId())) {//新增
			baseEvalContent.setCreateTime(new Date());
			baseEvalContent.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			baseEvalContent.setCreateMan("wuying");
			flag=baseEvalContentService.insert(baseEvalContent);
			}else {//修改
				baseEvalContent.setUpdateTime(new Date());
				baseEvalContent.setUpdateMan("wuying");
				baseEvalContent.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
				flag=baseEvalContentService.updateById(baseEvalContent);
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
	 * 分页查询老师评价内容信息
	 * <p>Title: findAllTeacherEvalContent</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月21日 下午12:16:29
	 * @param baseEvalContent 对象参数
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAllTeacherEvalContent")
	public JsonResult findAllTeacherEvalContent(BaseEvalContent baseEvalContent){
		JsonResult jsonResult =new JsonResult();
		//获取参数
		Integer currentPage = super.getCurrentPage();
		Integer pageSize = super.getPageSize();
		Page<BaseEvalContent> page =new Page<BaseEvalContent>(currentPage,pageSize);
		Page<BaseEvalContent> baseEvalContents = this.baseEvalContentService.findAllTeacherEvalContent(page,baseEvalContent);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(baseEvalContents);
		return jsonResult;
		
	}
	
	/**
	 * 根据主键ID查询老师评价内容
	 * <p>Title: findTeacherEvalContentListById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 上午8:19:14
	 * @param id 主键ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findTeacherEvalContentListById")
	public JsonResult findTeacherEvalContentListById(String id){
		JsonResult jsonResult =new JsonResult();
		BaseEvalContent baseEvalContent=this.baseEvalContentService.selectById(id);
		if (baseEvalContent != null) {
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("请求成功");
			jsonResult.setObj(baseEvalContent);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
		}
		return jsonResult;
	}
	
	/**
	 * 根据主键ID单条删除老师评价内容
	 * <p>Title: deleteTeacherEvalContentById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 上午8:36:14
	 * @param id 主键ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteTeacherEvalContentById")
	public JsonResult deleteTeacherEvalContentById(String id){
		JsonResult jsonResult = new JsonResult();
		BaseEvalContent baseEvalContent=new BaseEvalContent();
		baseEvalContent.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		baseEvalContent.setId(id);
		boolean flag = this.baseEvalContentService.updateById(baseEvalContent);
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
	 * 批量删除老师评价内容
	 * <p>Title: deleteBathTeacherEvalContent</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月22日 上午8:40:37
	 * @param ids 参数集合ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBathTeacherEvalContent")
	public JsonResult deleteBathTeacherEvalContent(String ids){
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isBlank(ids)) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		String[] teacherEvalContentids = ids.split("-");
		if (teacherEvalContentids.length == 0) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		List<BaseEvalContent> baseEvalContentList = new ArrayList<BaseEvalContent>();
		for (int i = 0; i < teacherEvalContentids.length; i++) {
			BaseEvalContent baseEvalContent = new BaseEvalContent();
			baseEvalContent.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			baseEvalContent.setId(teacherEvalContentids[i]);
			baseEvalContentList.add(baseEvalContent);
		}
		boolean flag = this.baseEvalContentService.updateBatchById(baseEvalContentList);
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
