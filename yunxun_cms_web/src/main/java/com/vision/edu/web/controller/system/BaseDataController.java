package com.vision.edu.web.controller.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.dto.BaseLableShoolDTO;
import com.vision.edu.dto.MemMessageDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseCombo;
import com.vision.edu.entity.base.BaseLable;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseComboService;
import com.vision.edu.service.base.IBaseLableService;
import com.vision.edu.service.system.ISysMessageService;
import com.xiaoleilu.hutool.date.DateUtil;

@Controller
@RequestMapping("/baseData")
public class BaseDataController extends BaseController {
   @Autowired
   private IBaseComboService baseComboService;
   @Autowired
   private ISysMessageService sysMessageService;
   @Autowired
   private IBaseLableService baseLableService; //标签表
   
   /**
    * 新增套餐
    * @author ChenWenWu
    * @date 2017年7月28日 下午2:30:10
    * @param baseCombo 套餐表实体
    * @return
    */
   @ResponseBody
   @RequestMapping("/addBaseCombo")
   public JsonResult addBaseCombo(BaseCombo baseCombo,String kaishi,String jieshu){
	   SysUserDTO sysuser =super.getUserInfo();
	   baseCombo.setUpdateMan(sysuser.getUsername());
		Date start = DateUtil.parse(kaishi);
		Date end = DateUtil.parse(jieshu);
		baseCombo.setStartTime(start);
		baseCombo.setEndTime(end);
	   baseCombo.setCreateTime(new Date());
	   baseCombo.setCreateMam(sysuser.getUsername());
	   baseCombo.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
	 boolean result =  baseComboService.insert(baseCombo);
	   JsonResult re=new JsonResult();
		  if(result){
			  re.setObj("新增成功");
	          re.setMsg("ok");
		  }else{
			  re.setObj("新增失败");
	          re.setMsg("false");
		  }
		  System.out.println(result);
       return re; 
   }
   /**
    * 修改套餐
    * @author ChenWenWu
    * @date 2017年7月28日 下午2:30:10
    * @param baseCombo 套餐表实体
    * @return
    */
   @ResponseBody
   @RequestMapping("/editBaseCombo")
   public JsonResult editBaseCombo(BaseCombo baseCombo,String ids){
	   SysUserDTO sysuser=super.getUserInfo();
	   baseCombo.setId(ids);
	   baseCombo.setUpdateMan(sysuser.getUsername());
	   baseCombo.setUpdateTime(new Date());
	   baseCombo.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
	 boolean result =  baseComboService.updateById(baseCombo);
	   JsonResult re=new JsonResult();
		  if(result){
			  re.setObj("修改成功");
	          re.setMsg("ok");
		  }else{
			  re.setObj("修改失败");
	          re.setMsg("false");
		  }
		  System.out.println(result);
       return re; 
   }

	  /**
	    * 查询套餐列表
	    * @author ChenWenWu
	    * @date 2017年7月28日 下午2:30:10
	    * @param baseCombo 套餐表实体
	    * @return
	    */
	   @ResponseBody
	   @RequestMapping("/findBaseCombopage")
	   public JsonResult findBaseCombopage(BaseCombo baseCombo,Integer startPage,Integer pageSise){
		   SysUserDTO sysuser=super.getUserInfo();
		   Page<BaseCombo> page =new Page<BaseCombo>(startPage,pageSise);
		   if(sysuser.getSchoolId()==null){
			   baseCombo.setShoolID("");
     	  }else{
     		 baseCombo.setShoolID(sysuser.getSchoolId());
     	  }
		  
		 List<BaseCombo> baseCombolist=  baseComboService.findBaseCombopage(page, baseCombo);
		    Map<String ,Object> map=new HashMap<String ,Object>();
	          map.put("page", page);
	          map.put("baseCombolist", baseCombolist);
	          JsonResult re=new JsonResult();
	            re.setObj(map);
	            re.setMsg("ok");
	            return re; 
	   }
	   /**
	    * 查询套餐列表
	    * @author ChenWenWu
	    * @date 2017年7月28日 下午2:30:10
	    * @param baseCombo 套餐表实体
	    * @return
	    */
	   @ResponseBody
	   @RequestMapping("/findOneBaseCombo")
	   public JsonResult findOneBaseCombo(String id){
		EntityWrapper<BaseCombo> ew = new EntityWrapper<BaseCombo>();
	  	ew.where("id = {0}",id);
		ew.setSqlSelect("id,name,start_time as startTime,end_time as endTime,when_long as whenLong,discount,create_time as createTime,create_mam as createMam,price,delete_flag as deleteFlag,shool_id as shoolID");
		 List<BaseCombo> baseComboList= baseComboService.selectList(ew);
	        JsonResult re=new JsonResult();
	          re.setObj(baseComboList);
	          re.setMsg("ok");
	         return re;
	   }
	   /**
	    * 查找提醒信息
	    * @author ChenWenWu
	    * @date 2017年8月1日 下午9:58:25
	    * @param startPage
	    * @param pageSise
	    * @return
	    */
	   @ResponseBody
	   @RequestMapping("/findSysRecipeBankDTO")
	   public JsonResult findSysRecipeBankDTO(Integer startPage,Integer pageSise,MemMessageDTO memMessageDTO){
		   Page<BaseCombo> page =new Page<BaseCombo>(startPage,pageSise);
		   SysUserDTO sysuser=super.getUserInfo();
		   memMessageDTO.setSchoolId(sysuser.getSchoolId());
		 List<MemMessageDTO> memMessagelist=sysMessageService.findSysRecipeBankDTO(page, memMessageDTO);
		 Map<String ,Object> map=new HashMap<String ,Object>();
         map.put("page", page);
         map.put("memMessagelist", memMessagelist);
         JsonResult re=new JsonResult();
           re.setObj(map);
           re.setMsg("ok");
           return re; 
	   }
	/**
	 * 确认提醒消息的确认
	 * @author ChenWenWu
	 * @date 2017年8月2日 上午9:17:58
	 * @param ids
	 * @return
	 */
	   @ResponseBody
	   @RequestMapping("/editbaseCombo")
	   public JsonResult editbaseCombo(String ids){
		   SysUserDTO sysuser=super.getUserInfo();
		 Integer num1=baseComboService.editBaseCombo(ids);
		    JsonResult re=new JsonResult();
		   if(num1>0){
	        	  re.setObj("删除"+num1+"条数据成功");
	              re.setMsg("ok");
	          }else{
	        	  re.setObj("新增失败");
	              re.setMsg("false");
	          }
           return re; 
	   }
	   /**
	    * 新增标签管理
	    * @author ChenWenWu
	    * @date 2017年8月2日 下午12:02:12
	    * @param ids
	    * @return
	    */
	   @ResponseBody
	   @RequestMapping("/addbaseLable")
	   public JsonResult addbaseLable(BaseLable baseLable){
		   SysUserDTO sysuser=super.getUserInfo();
		   baseLable.setCreateMan(sysuser.getUsername());
		   baseLable.setCreateTime(new Date());
		   baseLable.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		 boolean result=  baseLableService.insert(baseLable);
		    JsonResult re=new JsonResult();
		   if(result){
	        	  re.setObj("新增成功");
	              re.setMsg("ok");
	          }else{
	        	  re.setObj("新增失败");
	              re.setMsg("false");
	          }
           return re; 
	   }
	   /**
	    * 修改标签管理
	    * @author ChenWenWu
	    * @date 2017年8月2日 下午12:02:12
	    * @param ids
	    * @return
	    */
	   @ResponseBody
	   @RequestMapping("/editbaseLable")
	   public JsonResult editbaseLable(BaseLable baseLable,String ids){
		   SysUserDTO sysuser=super.getUserInfo();
		   baseLable.setId(ids);
		   baseLable.setUpdateMan(sysuser.getUsername());
		   baseLable.setUpdateTime(new Date());
		 boolean result= baseLableService.updateById(baseLable);
		    JsonResult re=new JsonResult();
		   if(result){
	        	  re.setObj("修改成功");
	              re.setMsg("ok");
	          }else{
	        	  re.setObj("修改失败");
	              re.setMsg("false");
	          }
           return re; 
	   }
	   /**
	    * 删除标签管理
	    * @author ChenWenWu
	    * @date 2017年8月2日 下午12:02:12
	    * @param ids
	    * @return
	    */
	   @ResponseBody
	   @RequestMapping("/delbaseLable")
	   public JsonResult delbaseLable(String ids){
		   SysUserDTO sysuser=super.getUserInfo();
		 
		 Integer num= baseLableService.delbaseLable(ids, sysuser.getUsername());
		    JsonResult re=new JsonResult();
		   if(num>0){
	        	  re.setObj("删除"+num+"成功");
	              re.setMsg("ok");
	          }else{
	        	  re.setObj("修改失败");
	              re.setMsg("false");
	          }
           return re; 
	   }
	   /**
	    * 查找提醒信息
	    * @author ChenWenWu
	    * @date 2017年8月1日 下午9:58:25
	    * @param startPage
	    * @param pageSise
	    * @return
	    */
	   @ResponseBody
	   @RequestMapping("/findBaseLableShoolDTO")
	   public JsonResult findBaseLableShoolDTO(BaseLableShoolDTO baseLableShoolDTO,Integer startPage,Integer pageSise){
		   Page<BaseLableShoolDTO> page =new Page<BaseLableShoolDTO>(startPage,pageSise);
		   SysUserDTO sysuser=super.getUserInfo();
		   if (sysuser.getSchoolId()==null) {
			   baseLableShoolDTO.setShoolID("");
		   }else{
			   baseLableShoolDTO.setShoolID(sysuser.getSchoolId());
		   }
		 List<BaseLableShoolDTO> baseLableShoollist=baseLableService.findBaseLableShoolDTO(page, baseLableShoolDTO);
		 Map<String ,Object> map=new HashMap<String ,Object>();
         map.put("page", page);
         map.put("baseLableShoollist", baseLableShoollist);
         JsonResult re=new JsonResult();
           re.setObj(map);
           re.setMsg("ok");
           return re; 
	   }
	   
	   /**
	    * 查找一条标签
	    * @author ChenWenWu
	    * @date 2017年8月1日 下午9:58:25
	    * @param startPage
	    * @param pageSise
	    * @return
	    */
	   @ResponseBody
	   @RequestMapping("/findOneBaseLableShool")
	   public JsonResult findOneBaseLableShool(String id){
			JsonResult jsonResult = new JsonResult();
			EntityWrapper<BaseLable> ew = new EntityWrapper<BaseLable>();		
	        ew.where("id = {0}",id);
	        ew.setSqlSelect("lable_name as lableName,leble_type as lebleType,school_id as schoolId");
			List<BaseLable> list = baseLableService.selectList(ew);
			jsonResult.setObj(list);
	     	return jsonResult;
	   }
	   
	   
	   /**
	    * 查找一条提醒信息by    id
	    * @author ChenWenWu
	    * @date 2017年8月1日 下午9:58:25
	    * @param startPage
	    * @param pageSise
	    * @return
	    */
	   @ResponseBody
	   @RequestMapping("/findCBOBaseLableShool")
	   public JsonResult findCBOBaseLableShool(){
			JsonResult jsonResult = new JsonResult();
			EntityWrapper<BaseLable> ew = new EntityWrapper<BaseLable>();		
	        ew.where("delete_flag = {0}",true);
	        ew.setSqlSelect("id,lable_name as lableName");
			List<BaseLable> list = baseLableService.selectList(ew);
			jsonResult.setObj(list);
	     	return jsonResult;
	   }
}
