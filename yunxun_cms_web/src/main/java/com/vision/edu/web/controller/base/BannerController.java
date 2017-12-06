package com.vision.edu.web.controller.base;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthScrollPaneUI;

import org.apache.commons.net.util.SSLSocketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.dto.BaseSchoolInfoTwoDTO;
import com.vision.edu.dto.MemApplyRecordDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseGroup;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemInfoGroup;
import com.vision.edu.enums.EnumCheckFlag;
import com.vision.edu.enums.EnumInfoType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseGroupService;
import com.vision.edu.service.base.IBaseSchoolInfoService;
import com.vision.edu.service.member.IMemApplyRecordService;
import com.vision.edu.service.member.IMemInfoGroupService;
import com.vision.edu.framework.util.UploadUtil;

@Controller
@RequestMapping("/banner")
public class BannerController extends BaseController{

	@Autowired 
	private IBaseSchoolInfoService baseSchoolInfoService;
	@Autowired
	private IMemInfoGroupService memInfoGroupService;
	@Autowired
	private IBaseGroupService baseGroupService;
	@Autowired
	private IMemApplyRecordService memApplyRecordService;
	
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
		uploadImg = UploadUtil.uploadImage(super.getRequest(), "banner");
	}
	/**
	 *1、 新增Banner 2、校园咨询发布 3、发布活动那里的新增
	 *   同时新增咨询组表，
	 * @author ChenWenWu
	 * @date 2017年7月5日 下午4:17:41
	 */
	 @ResponseBody
	 @RequestMapping("/addBaseSchoolInfo")
	public JsonResult addBaseSchoolInfo(BaseSchoolInfo bif,String group,String time){
		 bif.setCoverImages(uploadImg.get("bannerImg"));
		 SysUserDTO sysuser=super.getUserInfo();
		 bif.setCreateMam(sysuser.getUsername());
		 Integer  num1= baseSchoolInfoService.all(bif, group,time);
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
		 * 1、修改单条Banner 2、校园咨询的编辑 
		 * @author ChenWenWu
		 * @date 2017年7月5日 下午4:50:41
		 */
	     @ResponseBody
		 @RequestMapping("/editBaseSchoolInfo")
		public JsonResult editBaseSchoolInfo(BaseSchoolInfo bif,String time,String group,String shoolinofid,String imageUrl){
	    	 String to=(String) super.getRequest().getSession().getServletContext().getAttribute("imgService");
	    	 if(imageUrl.contains(to)){ // 判断是否包含上传路径，
//	    		   http://yunxunimg.xuechenedu.com//upload/20170724233929.jpg
	    	    String jieguo = imageUrl.substring(imageUrl.indexOf(to)+to.length());//截取字符串
	    		   bif.setCoverImages(jieguo);
	    	   }else{
	    		   bif.setCoverImages(uploadImg.get("bannerImg"));
	    	   }
	    	 uploadImg = null;
	    	 SysUserDTO sysuser=super.getUserInfo();
	    	 bif.setUpdateMan(sysuser.getUsername());
	    	 Integer  num= baseSchoolInfoService.edti(bif,time, group, shoolinofid);
	    	 JsonResult re=new JsonResult();
			  if(num>0){
				  re.setObj("修改成功");
		          re.setMsg("ok");
			  }else{
				  re.setObj("修改失败");
		          re.setMsg("false");
			  }
			  System.out.println(num);
	          return re; 
		}
		 /**
		  *1、Banner审核(各种类型)2、校园咨询的下架与审核否
		  * @author ChenWenWu
		  * @date 2017年7月5日 下午9:28:38
		  */
	     @ResponseBody
		 @RequestMapping("/ediCheckFlag")
		 public JsonResult ediCheckFlag(String ids,Integer sentype){
	    	 Integer num=baseSchoolInfoService.checkShoolinfo(ids, sentype);
	    	 JsonResult re=new JsonResult();
			  if(num>0){
				  re.setObj(num+"条数据");
		          re.setMsg("ok");
			  }else{
				  re.setObj("失败");
		          re.setMsg("false");
			  }
			  System.out.println(num);
	          return re; 
		 }
		 /**
		  * 删除Banner
		  * @author ChenWenWu
		  * @date 2017年7月5日 下午4:57:40
		  */
		 @ResponseBody
		 @RequestMapping("/delBaseSchoolInfo")
		 public JsonResult delBaseSchoolInfo(String ids){
			Integer num= baseSchoolInfoService.delShoolinfo(ids);
			  JsonResult re=new JsonResult();
			  if(num>0){
				  re.setObj("删除成功"+num+"条数据");
		          re.setMsg("ok");
			  }else{
				  re.setObj("删除失败");
		          re.setMsg("false");
			  }
			  System.out.println(num);
	          return re; 
		 }
		 /**
		  * 加载数据的查询（banner、咨询。。。各种）+分页
		  * @author ChenWenWu
		  * @date 2017年7月11日 下午9:31:44
		  */
		 @ResponseBody
		 @RequestMapping("/findShoolInfofoPage")
			 public JsonResult  findShoolInfofoPage(String schoolname ,Integer startPage,Integer pageSise,String infotype ){
				SysUserDTO sysUserDTO = super.getUserInfo();
			 Page<BaseSchoolInfoTwoDTO> page =new Page<BaseSchoolInfoTwoDTO>(startPage,pageSise);
			 String shoolid="";
			 if (sysUserDTO.getSchoolId()==null){
				 shoolid="";
			 }else{
				 shoolid=sysUserDTO.getSchoolId();
			 }
	      	List<BaseSchoolInfoTwoDTO> baseSchoolInfo= baseSchoolInfoService.findShoolInfofoPage(page,shoolid,schoolname,infotype);
	          Map<String ,Object> map=new HashMap<String ,Object>();
	          map.put("page", page);
	          map.put("baseSchoolInfo", baseSchoolInfo);
	          JsonResult re=new JsonResult();
	            re.setObj(map);
	            re.setMsg("ok");
	            return re; 
			 }
		 /**
			 * 查询活动
			 * @author ChenWenWu
			 * @date 2017年7月23日 下午3:27:13
			 * @param page
			 * @param baseSchoolInfoTwoDTO 参数实体
			 * @return
			 */
		 @ResponseBody
		 @RequestMapping("/findShoolHuoDong")
			 public JsonResult  findShoolHuoDong(Integer startPage,Integer pageSise,BaseSchoolInfoTwoDTO baseSchoolInfoTwoDTO){
				 Page<BaseSchoolInfoTwoDTO> page =new Page<BaseSchoolInfoTwoDTO>(startPage,pageSise);
			      	List<BaseSchoolInfoTwoDTO> baseSchoolInfo= baseSchoolInfoService.findShoolHuoDong(page, baseSchoolInfoTwoDTO);
			          System.out.println(baseSchoolInfo);
			          Map<String ,Object> map=new HashMap<String ,Object>();
			          map.put("page", page);
			          map.put("baseSchoolInfo", baseSchoolInfo);
			          JsonResult re=new JsonResult();
			            re.setObj(map);
			            re.setMsg("ok");
			            return re; 
			 }
		 /**
		  *1、 分页+模糊查询《Banner》列表  ,同时还根据院校ID 、咨询类型、校园名称查询 
		  * @author ChenWenWu
		  * @date 2017年7月5日 下午5:32:49
		  */
		 @ResponseBody
		 @RequestMapping("/findBaseSchoolInfoPage")
        public JsonResult  findBaseSchoolInfoTwoPage(){
			int infoType=0;
        	Page<BaseSchoolInfoTwoDTO> page =new Page<BaseSchoolInfoTwoDTO>(1,10);
        	String schoolname="";//学校名称
        	int type=0; //咨询类型
        	if(infoType==0){
    			type=EnumInfoType.GG.getValue();
    		}else if(infoType==1){
    			  type=EnumInfoType.ZX.getValue();
    		}else if(infoType==2){
    			  type=EnumInfoType.HD.getValue();
    		}else if(infoType==3){
    			  type=EnumInfoType.BN.getValue();
    		}else{
    			
    		}
        	String schoolId="1";//根据院校ID
        	List<BaseSchoolInfoTwoDTO> baseSchoolInfo= baseSchoolInfoService.findBaseSchoolInfoPage(page, schoolname,type,schoolId);
            System.out.println(baseSchoolInfo);
            JsonResult re=new JsonResult();
            re.setObj(baseSchoolInfo);
            re.setMsg("ok");
            return re; 
        }
		 /**
		  * 《校园咨询》的查询 分页+模糊查询   什么公告活动新闻啊    同时还根据院校ID 、咨询类型、title、校园名称查询 
		  * @author ChenWenWu
		  * @date 2017年7月11日 下午8:10:29
		  */
		  public void finde(int infoType){
			  Page<BaseSchoolInfoTwoDTO> page =new Page<BaseSchoolInfoTwoDTO>(1,10);
	        	String schoolname="";//学校名称
	        	int type=0; //咨询类型
	        	if(infoType==0){
	    			type=EnumInfoType.GG.getValue();
	    		}else if(infoType==1){
	    			  type=EnumInfoType.ZX.getValue();
	    		}else if(infoType==2){
	    			  type=EnumInfoType.HD.getValue();
	    		}else if(infoType==3){
	    			  type=EnumInfoType.BN.getValue();
	    		}else{
	    		} 
	        	String schoolId="1";//根据院校ID
	        	String title="";//标题
	        	List<BaseSchoolInfoTwoDTO> baseSchoolInfo= baseSchoolInfoService.findXiaoYuanZiXunPage(page,title, schoolname,type,schoolId);
	            System.out.println(baseSchoolInfo);
	        }
		 
		 /**
		  * 分页+模糊查询《院所动态》
		  * @author ChenWenWu
		  * @date 2017年7月5日 下午5:32:49
		  */
		 @ResponseBody
		 @RequestMapping("/findYuanSuoDongTai")
        public JsonResult findYuanSuoDongTai(){
        	Page<BaseSchoolInfoTwoDTO> page =new Page<BaseSchoolInfoTwoDTO>(1,10);
        	 String  startTime="2017-07-05 16:54:15";
        	 String endTime="2017-07-05 16:54:15";
        	List<BaseSchoolInfoTwoDTO> baseSchoolInfo= baseSchoolInfoService.findBaseYuanSuoPage(page, startTime, endTime);
            System.out.println(baseSchoolInfo);
            JsonResult re=new JsonResult();
            re.setObj(baseSchoolInfo);
            re.setMsg("ok");
            return  re; 
        }
		  
		  /**
			 * 修改之前查询出来的banner
		       @author ChenWenWu
			 * @param baseSchoolInfo 咨询D 
			 * @return=
			 */
		     @ResponseBody
			 @RequestMapping("/findOneShoolInFo")
		  public JsonResult findOneShoolInFo(String baseSchoolInfo){
			  BaseSchoolInfoTwoDTO basechoolInfoTwoDTO= baseSchoolInfoService.findOneShoolInFo(baseSchoolInfo);
			  JsonResult re=new JsonResult();
			  if(basechoolInfoTwoDTO==null){
				  BaseSchoolInfoTwoDTO basechoolInfoTwoDTO1= baseSchoolInfoService.findOneShoolInFoONGroup(baseSchoolInfo);
				   re.setObj(basechoolInfoTwoDTO1);
			   }else {
				   re.setObj(basechoolInfoTwoDTO);
			   }
	            re.setMsg("ok");
	            return  re; 
		  }
		     /**
		      * 分组
		      * @author ChenWenWu
		      * @date 2017年7月18日 下午12:02:31
		      * @return
		      */
		    @ResponseBody
			@RequestMapping("/findBaseGroup")
		  public JsonResult findBaseGroup(){
			  EntityWrapper<BaseGroup> ew=new EntityWrapper<BaseGroup>();
			  ew.setSqlSelect("id,name");
			List<BaseGroup>  baseGroup = baseGroupService.selectList(ew);
			  JsonResult re=new JsonResult();
	            re.setObj(baseGroup);
	            re.setMsg("ok");
	            return   re; 
		  }
		    /**
		     * 查询报名管理
		     * @author ChenWenWu
		     * @date 2017年7月23日 下午7:49:42
		     * @param name
		     * @param schooliId
		     * @param shoolName
		     * @return
		     */
		    @ResponseBody
			@RequestMapping("/findMemApplyRecord")
		    public JsonResult findMemApplyRecord(Integer startPage,Integer pageSise,MemApplyRecordDTO memApplyRecordDTO){
		    	Page<MemApplyRecordDTO> page =new Page<MemApplyRecordDTO>(startPage,pageSise);
		    	SysUserDTO sysuser=super.getUserInfo();
		    	 if (sysuser.getSchoolId()==null){
		    		 memApplyRecordDTO.setSchooliId("");
		           }else {
		        	 memApplyRecordDTO.setSchooliId(sysuser.getSchoolId());
		           }
		    	List<MemApplyRecordDTO> memApplyRecordDTOlist =memApplyRecordService.findMemApplyRecord(page,memApplyRecordDTO);
		    	 Map<String ,Object> map=new HashMap<String ,Object>();
		          map.put("page", page);
		          map.put("memApplyRecord", memApplyRecordDTOlist);
		          JsonResult re=new JsonResult();
		            re.setObj(map);
		            re.setMsg("ok");
		            return re; 
			  }
}
