package com.vision.edu.web.controller.base;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.dto.MemClassCircleDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.base.BaseLable;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.entity.member.MemClassCircle;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.framework.util.UploadUtil;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseClassService;
import com.vision.edu.service.base.IBaseLableService;
import com.vision.edu.service.base.IBaseSchoolService;
import com.vision.edu.service.member.IMemClassCircleService;

@Controller
@RequestMapping("/classquan")
public class ClassRoomController  extends BaseController{
    @Autowired
    private IMemClassCircleService memClassCircleService;
    @Autowired
	private IBaseSchoolService baseSchoolService;
    @Autowired
    private IBaseClassService baseClassService;
    @Autowired 
    private IBaseLableService baseLableService;
	Map<String, String> uploadImg;
 	
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
		uploadImg = UploadUtil.uploadImage(super.getRequest(), "classquan");
	}
	/**
	 * 查询班级《圈》信息
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午3:27:03
	 * @param page
	 * @param memClassCircleDTO 班级圈实体
	 * @return
	 */
    @ResponseBody
	 @RequestMapping("/findMemClassCircleDTO")
	public JsonResult findMemClassCircleDTO(Integer startPage,Integer pageSise, MemClassCircleDTO memClassCircleDTO){
    	  SysUserDTO suer=super.getUserInfo();
    	  memClassCircleDTO.setSchoolID(suer.getSchoolId());
    	Page<MemClassCircleDTO> page =new Page<MemClassCircleDTO>(startPage,pageSise);
    	List<MemClassCircleDTO> memClassCircleList= memClassCircleService.findMemClassCircleDTO(page, memClassCircleDTO);
	       int  j=memClassCircleList.size();
    	for (int i = 0; i < j; i++) {
    		if(memClassCircleList.get(i).getMemName()==null){
    			memClassCircleList.get(i).setMemName(memClassCircleList.get(i).getBaseName());
    		} else if(memClassCircleList.get(i).getBaseName()==null){
    			memClassCircleList.get(i).setBaseName(memClassCircleList.get(i).getMemName());
    		}  
    	    if(memClassCircleList.get(i).getMemMemberHeadPortrait()==null){
    			memClassCircleList.get(i).setMemMemberHeadPortrait(memClassCircleList.get(i).getSysUserHeadPortrait());
    		} else if(memClassCircleList.get(i).getSysUserHeadPortrait()==null){
    			memClassCircleList.get(i).setMemMemberHeadPortrait(memClassCircleList.get(i).getMemMemberHeadPortrait());
    		} 
		}
    	Map<String ,Object> map=new HashMap<String ,Object>();
      map.put("memClassCircleList", memClassCircleList);
      map.put("page", page);
      JsonResult re=new JsonResult();
        re.setObj(map);
        re.setMsg("ok");
         return re; 
    }
    
	/**
	 * 查询班级《圈》信息
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午3:27:03
	 * @param page
	 * @param memClassCircleDTO 班级圈实体
	 * @return
	 */
    @ResponseBody
	 @RequestMapping("/findOneMemClassCircleDTO")
	public JsonResult findOneMemClassCircleDTO(String id){
    	  SysUserDTO suer=super.getUserInfo();
    	  EntityWrapper<MemClassCircle> ew = new EntityWrapper<MemClassCircle>();		
       MemClassCircle memClassCircleList= memClassCircleService.selectById(id);
      JsonResult re=new JsonResult();
        re.setObj(memClassCircleList);
        re.setMsg("ok");
         return re; 
    }
    
    /**
     * 新增班级圈
     * @author ChenWenWu
     * @date 2017年7月29日 上午12:06:13
     * @param memClassCircle
     * @return
     */
    @ResponseBody
  	 @RequestMapping("/addMemClassCircle")
  	public JsonResult addMemClassCircle(MemClassCircle memClassCircle){
    	SysUserDTO sysuser=super.getUserInfo();
    	memClassCircle.setCreateMamId(sysuser.getId());
    	memClassCircle.setImgs(uploadImg.get("classRoomImg"));
     	Integer num1= memClassCircleService.addClassDT(memClassCircle);
      JsonResult re=new JsonResult();
  	  if(num1>0){
  		  re.setObj("新增成功");
          re.setMsg("ok");
  	  }else{
  		  re.setObj("新增失败");
          re.setMsg("false");
  	  }
  	  System.out.println(num1);
      return re; 
     }
    /**
     * 修改班级圈
     * @author ChenWenWu
     * @date 2017年7月29日 上午12:06:13
     * @param memClassCircle
     * @return
     */
    @ResponseBody
  	 @RequestMapping("/editMemClassCircle")
  	public JsonResult editMemClassCircle(MemClassCircle memClassCircle,String imageUrl,String idd){
    	memClassCircle.setId(idd);
    	String to=(String) super.getRequest().getSession().getServletContext().getAttribute("imgService");
   	 if(imageUrl.contains(to)){ // 判断是否包含上传路径，
//   		   http://yunxunimg.xuechenedu.com//upload/20170724233929.jpg
   	    String jieguo = imageUrl.substring(imageUrl.indexOf(to)+to.length());//截取字符串
   		memClassCircle.setImgs(uploadImg.get(jieguo));
   	   }else{
   		memClassCircle.setImgs(uploadImg.get("classRoomImg"));
   	   }
    	SysUserDTO sysuser=super.getUserInfo();
    	memClassCircle.setUpdateTime(new Date());
    	memClassCircle.setUpdateMan(sysuser.getUsername());
     	boolean num1= memClassCircleService.updateById(memClassCircle);
      JsonResult re=new JsonResult();
  	  if(num1){
  		  re.setObj("修改成功");
          re.setMsg("ok");
  	  }else{
  		  re.setObj("修改失败");
          re.setMsg("false");
  	  }
  	  System.out.println(num1);
      return re; 
     }
    /**
     * 删除班级圈
     * @author ChenWenWu
     * @date 2017年7月29日 上午12:30:53
     * @param ids
     * @param updateMan
     * @return
     */
     @ResponseBody
	 @RequestMapping("/delMemClassCircle")
	public JsonResult delMemClassCircle(String ids){
    	 SysUserDTO sysuser=super.getUserInfo();
   	Integer num1= memClassCircleService.delMemClassCircle(ids,sysuser.getUsername());
    JsonResult re=new JsonResult();
	  if(num1>0){
		  re.setObj("删除成功"+num1+"条数据");
        re.setMsg("ok");
	  }else{
		  re.setObj("删除失败");
        re.setMsg("false");
	  }
	  System.out.println(num1);
    return re; 
   }
     /**
 	 * 绑定园校下拉框
 	 * @author wenwu
 	 * @date 2017年7月11日 下午9:45:23
 	 */
 	@ResponseBody
 	@RequestMapping("/findClassBySchoolId")
 	public JsonResult findClassBySchoolId(){

		JsonResult jsonResult = new JsonResult();
		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}

		EntityWrapper<BaseLable> ew = new EntityWrapper<BaseLable>();
		ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
		ew.setSqlSelect("id,lable_name as lableName");

		Integer memberType = sysUserDTO.getMemberType();
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue() ) {
			ew.where("school_id={0}", sysUserDTO.getSchoolId());
		}
		List<BaseLable>  list = baseLableService.selectList(ew);
		if (list.size()>0) {
			jsonResult.setSuccess(true);
			jsonResult.setObj(list);
		}else {
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		return jsonResult;
 	}
    /**
 	 * 绑定园校标签
 	 * @author wenwu
 	 * @date 2017年7月11日 下午9:45:23
 	 */
 	@ResponseBody
 	@RequestMapping("/findLableBySchoolId")
 	public JsonResult findLableBySchoolId(){
 		JsonResult jsonResult = new JsonResult();
 		JSONObject jsonObject = new JSONObject();
 		SysUserDTO sysUserDTO = super.getUserInfo();
 		if (null == sysUserDTO) {
 			jsonResult.setSuccess(false);
 			jsonResult.setMsg("获取用户信息失败,请重新登录");
 			return jsonResult;
 		}
 		EntityWrapper<BaseLable> ew = new EntityWrapper<BaseLable>();
   		ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
   		ew.where("school_id = {0}",sysUserDTO.getSchoolId());
 		ew.setSqlSelect("id,lable_name as lableName");
 		
 		Integer memberType = sysUserDTO.getMemberType();
 		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue() ) {
 			//ew.where("id={0}", sysUserDTO.getSchoolId());
 		}
 		List<BaseLable> list = baseLableService.selectList(ew);
 		jsonResult.setObj(list);
      	return jsonResult;
 	}
}
