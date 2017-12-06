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
import com.vision.edu.entity.base.BaseEvalCrite;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseEvalCriteService;

import jodd.util.StringUtil;

/**
 * @title 家长对孩子评价标准
 * @filename ParentCriteController.java
 * @author WuYing
 * @date 2017年7月18日 上午9:53:45
 * @version 1.0
 */
@Controller
@RequestMapping("/parentCrite")
public class ParentCriteController extends BaseController {

	/**
	 * 基于注解注入宝贝在家评价标准服务
	 */
	@Autowired
	private IBaseEvalCriteService baseEvalCriteService;

	/**
	 * 添加/修改家长对孩子评价标准
	 * <p>Title: addEditParentCrite</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月18日 上午10:07:59
	 */
	@ResponseBody
	@RequestMapping("/addEditParentCrite")
	public JsonResult addParentCrite(BaseEvalCrite baseEvalCrite) {
		boolean flag = false;
		JsonResult jsonResult = new JsonResult();
		if (StringUtil.isEmpty(baseEvalCrite.getId())) {//新增
			baseEvalCrite.setCreateTime(new Date());
			baseEvalCrite.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			baseEvalCrite.setCreateMan("wuying");
			flag = baseEvalCriteService.insert(baseEvalCrite);
		} else {//修改
			baseEvalCrite.setUpdateTime(new Date());
			baseEvalCrite.setUpdateMan("wuying");
			baseEvalCrite.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			flag = baseEvalCriteService.updateById(baseEvalCrite);
		}
		if (flag) {
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("保存成功");
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("保存失败");
		}
		return jsonResult;
	}

	/**
	 * 分页查询、根据项目名称及分页查询
	 * <p>Title: findAllParentCrite</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月19日 上午8:45:37
	 * @param startPage 当前页数
	 * @param pageSise 页大小
	 * @param name 项目名称
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAllParentCrite")
	public JsonResult findAllParentCrite(BaseEvalCrite baseEvalCrite) {
		JsonResult jsonResult = new JsonResult();
		//获取参数
		Integer currentPage = super.getCurrentPage();
		Integer pageSize = super.getPageSize();
		//Integer team = baseEvalCrite.getTeam();
//		System.out.println(team);
		Page<BaseEvalCrite> page = new Page<BaseEvalCrite>(currentPage, pageSize);
		Page<BaseEvalCrite> baseEvalCrites = this.baseEvalCriteService.findAllParentCrite(page, baseEvalCrite);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(baseEvalCrites);
		return jsonResult;
	}

	/**
	 * 根据主键ID查询家长对孩子的评价标准（项目与评价）
	 * <p>Title: findParentCriteById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月20日 上午9:52:04
	 * @param id 主键ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findParentCriteById")
	public JsonResult findParentCriteById(String id) {
		JsonResult jsonResult = new JsonResult();
		BaseEvalCrite baseEvalCrite = this.baseEvalCriteService.selectById(id);
		if (baseEvalCrite != null) {
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("请求成功");
			jsonResult.setObj(baseEvalCrite);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
		}
		return jsonResult;
	}

	/**
	 * 根据选中行主键ID删除 家长对孩子的评价标准信息
	 * <p>Title: deleteParentCriteById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月20日 上午10:50:00
	 * @param id 参数选中行ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteParentCriteById")
	public JsonResult deleteParentCriteById(String id) {
		JsonResult jsonResult = new JsonResult();
		BaseEvalCrite baseEvalCrite = new BaseEvalCrite();
		baseEvalCrite.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		baseEvalCrite.setId(id);
		boolean flag = this.baseEvalCriteService.updateById(baseEvalCrite);
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
	 * 批量删除 家长对孩子的评价标准信息
	 * <p>Title: deleteBathParentCriteById</p>
	 * <p>Description: </p>
	 * @author WuYing
	 * @date 2017年7月20日 上午11:34:00
	 * @param ids 参数 集合ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBathParentCriteById")
	public JsonResult deleteBathParentCriteById(String ids) {
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isBlank(ids)) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		String[] parentCriteids = ids.split("-");
		if (parentCriteids.length == 0) {
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
			return jsonResult;
		}
		List<BaseEvalCrite> baseEvalCriteList = new ArrayList<BaseEvalCrite>();
		for (int i = 0; i < parentCriteids.length; i++) {
			BaseEvalCrite baseEvalCrite = new BaseEvalCrite();
			baseEvalCrite.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			baseEvalCrite.setId(parentCriteids[i]);
			baseEvalCriteList.add(baseEvalCrite);
		}
		boolean flag = this.baseEvalCriteService.updateBatchById(baseEvalCriteList);
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
