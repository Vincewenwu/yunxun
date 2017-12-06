package com.vision.edu.web.controller.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.entity.system.SysModular;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.framework.support.HttpCode;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.platform.util.StringUtil;
import com.vision.edu.service.system.ISysModularService;

/**
 * 模块Controller
 * @author XieFan
 * @date 2017年7月18日 上午10:53:50
 * @version 1.0
 */
@Controller
@RequestMapping("/sysModule")
public class SysModuleController extends BaseController {
	
	/**
	 * 注入sysModularService
	 */
	@Autowired
	private ISysModularService sysModularService;
	
	/**
	 * 根据FarId查询模块信息
	 * @author XieFan
	 * @date 2017年7月18日 上午10:56:33
	 * @param farId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findSysModeularByFarId")
	public JsonResult findSysModularByFarId(String farId){
		JsonResult jsonResult = new JsonResult();
	    List<SysModular> sysModulars = this.sysModularService.findSysModularByFarId(farId);
	    jsonResult.setSuccess(true);
	    jsonResult.setStatus(HttpCode.OK.value().toString());
	    jsonResult.setMsg("请求成功");
	    jsonResult.setObj(sysModulars);
	    return jsonResult;
	}
	
	/**
	 * 查询所有模块
	 * @author XieFan
	 * @date 2017年7月18日 下午2:12:54
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAllSysModule")
	public JsonResult findAllSysModule(){
		JsonResult jsonResult = new JsonResult();
		Integer currentPage = super.getCurrentPage();
		Integer pageSize = super.getPageSize();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("moduleName", super.getRequest().getParameter("moduleName"));
		map.put("moduleType", super.getRequest().getParameter("moduleType"));
		Page<BaseEntity> page = new Page<BaseEntity>(currentPage, pageSize);
		Page<BaseEntity> modules = this.sysModularService.findAllSysModule(page,map);
		jsonResult.setSuccess(true);
		jsonResult.setStatus(HttpCode.OK.value().toString());
		jsonResult.setMsg("请求成功");
		jsonResult.setObj(modules);
		return jsonResult;
	}
	
	/**
	 * 
	 * @author XieFan
	 * @date 2017年7月18日 上午11:54:57
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEditSysModular")
	public JsonResult addEditSysModular(SysModular sysModular,String pageFatherId){
		boolean sysModularb = false;
		JsonResult jsonResult = new JsonResult();
		if(StringUtil.isEmpty(sysModular.getFatherId())){
			sysModular.setFatherId("0");
		}
		if(StringUtil.isNotEmpty(pageFatherId)){
			sysModular.setFatherId(pageFatherId);
		}
		if(StringUtil.isEmpty(sysModular.getId())){
			sysModular.setCreateTime(new Date());
			sysModular.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			sysModular.setCreatMan("XieFan");
			sysModularb = this.sysModularService.insert(sysModular);
		} else {
			sysModular.setUpdateTime(new Date());
			sysModular.setCreatMan("XieFan");
			sysModularb = this.sysModularService.updateById(sysModular);
		}
		if(sysModularb){
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
	 * 根据ID查询模块信息
	 * @author XieFan
	 * @date 2017年7月18日 下午4:06:07
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findSysModularById")
	public JsonResult findSysModularById(String id){
		JsonResult jsonResult = new JsonResult();
		SysModular sysModular = this.sysModularService.findModularById(id);
		if(sysModular != null){
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("请求成功");
			jsonResult.setObj(sysModular);
		}else{
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
		}
		return jsonResult;
	}
	
	/**
	 * 删除模块
	 * @author XieFan
	 * @date 2017年7月18日 下午4:43:34
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteSysModularById")
	public JsonResult deleteSysModularById(String id){
		SysModular sysModular = new SysModular();
		sysModular.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		sysModular.setId(id);
		JsonResult jsonResult = new JsonResult();
		boolean delSysModular = this.sysModularService.updateById(sysModular);
		if(delSysModular){
			jsonResult.setSuccess(true);
			jsonResult.setStatus(HttpCode.OK.value().toString());
			jsonResult.setMsg("删除成功");
		}else{
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("删除失败");
		}
		return jsonResult;
	}
	
	/**
	 * 批量删除模块
	 * @author XieFan
	 * @date 2017年7月19日 上午8:50:17
	 * @param sysModulars
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBathSysModularById")
	public JsonResult deleteBathSysModularById(String ids){
		JsonResult jsonResult = new JsonResult();
		if(StringUtil.isNotEmpty(ids)){
			String[] moduleIds = ids.split("-");
			if(moduleIds.length > 0){
				List<SysModular> sysModularList = new ArrayList<SysModular>();
				for(int i = 0; i < moduleIds.length; i++){
					SysModular sysModular = new SysModular();
					sysModular.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
					sysModular.setId(moduleIds[i]);
					sysModularList.add(sysModular);
				}
				boolean bSysModular = this.sysModularService.updateBatchById(sysModularList);
				if(bSysModular){
					jsonResult.setSuccess(true);
					jsonResult.setStatus(HttpCode.OK.value().toString());
					jsonResult.setMsg("删除成功");
				}else{
					jsonResult.setSuccess(false);
					jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
					jsonResult.setMsg("删除失败");
				}
			}else{
				jsonResult.setSuccess(false);
				jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
				jsonResult.setMsg("请求失败");
			}
		}else{
			jsonResult.setSuccess(false);
			jsonResult.setStatus(HttpCode.BAD_REQUEST.value().toString());
			jsonResult.setMsg("请求失败");
		}
		return jsonResult;
	}
	
}
