package com.vision.edu.web.controller.base;

import java.io.Serializable;
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
import com.vision.edu.dto.BabySurrogateDTO;
import com.vision.edu.dto.BaseBabySchoolDTO;
import com.vision.edu.dto.BaseBabySurrogateDTO;
import com.vision.edu.dto.BaseParentingKnowledgeDTO;
import com.vision.edu.dto.MemClassCircleDTO;
import com.vision.edu.dto.OneBabybaseSurrogateDTO;
import com.vision.edu.dto.ParentBaseMemberDTO;
import com.vision.edu.dto.PreantInfomationDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.base.BaseGroup;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.base.BaseParentingKnowledge;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.entity.base.BaseSurrogate;
import com.vision.edu.entity.member.MemBabyCards;
import com.vision.edu.entity.member.MemBabySurrogate;
import com.vision.edu.entity.member.MemMemberGroup;
import com.vision.edu.entity.member.MemParentBaby;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumGroupType;
import com.vision.edu.framework.util.UploadUtil;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseBabyService;
import com.vision.edu.service.base.IBaseClassService;
import com.vision.edu.service.base.IBaseGroupService;
import com.vision.edu.service.base.IBaseMemberService;
import com.vision.edu.service.base.IBaseParentingKnowledgeService;
import com.vision.edu.service.base.IBaseSurrogateService;
import com.vision.edu.service.base.impl.BaseClassServiceImpl;
import com.vision.edu.service.member.IMemBabyCardsService;
import com.vision.edu.service.member.IMemBabySurrogateService;
import com.vision.edu.service.member.IMemMemberGroupService;
import com.vision.edu.service.member.IMemParentBabyService;
import com.xiaoleilu.hutool.date.DateUtil;
@Controller
@RequestMapping("/baby")
public class BabyController  extends BaseController{
         @Autowired
         private IBaseBabyService baseBabyService;
         @Autowired
         private IBaseSurrogateService baseSurrogateService;
         @Autowired
         private IMemBabySurrogateService memBabySurrogateService;
         @Autowired
         private IMemMemberGroupService memMemberGroupService;
         @Autowired
         private IBaseClassService baseClassService;
         @Autowired
         private IBaseGroupService baseGroupService;
         @Autowired
         private IMemBabyCardsService memBabyCardsService;
        @Autowired
        private IBaseParentingKnowledgeService baseParentingKnowledgeService;//育儿知识
        @Autowired
        private IBaseMemberService baseMemberService;
        
        
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
    		uploadImg = UploadUtil.uploadImage(super.getRequest(), "baby");
    	}
      /**
       * 新增《宝贝》
       * @author ChenWenWu
       * @date 2017年7月9日 下午7:54:09
       */
         @ResponseBody
    	 @RequestMapping("/addBaseBaby")
     	public JsonResult addBaseBaby(BaseBaby baseBaby,String shengri,String ruxueshijian,String  cars){
//        	 baseBaby.setHeadPortrait(uploadImg.get("babyImg"));
        	 Integer num1= baseBabyService.addBaby(baseBaby,shengri,ruxueshijian, cars);
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
         * 修改《宝贝》表
         * @author ChenWenWu
         * @date 2017年7月7日 上午8:56:34
         */
         @ResponseBody
    	 @RequestMapping("/editBaby")
        public JsonResult editBaby(BaseBaby baseBaby,String shengri,String ruxueshijian,String babyid,String imageUrl,String cars){
        	  String to=(String) super.getRequest().getSession().getServletContext().getAttribute("imgService");
 	    	 if(imageUrl.contains(to)){ // 判断是否包含上传路径，
// 	    		   http://yunxunimg.xuechenedu.com//upload/20170724233929.jpg
 	    	    String jieguo = imageUrl.substring(imageUrl.indexOf(to)+to.length());//截取字符串
 	    			 baseBaby.setHeadPortrait(jieguo);
 	    	   }else{
 	    		  baseBaby.setHeadPortrait(uploadImg.get("babyImg"));
 	    	   }
        	 Integer num1= baseBabyService.editBaby(baseBaby,shengri,ruxueshijian,babyid,cars);
      	  JsonResult re=new JsonResult();
  		  if(num1>0){
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
         * 1、删除baby 同时会删除他的联系人
         * 2、同时也是报名表管理那里的删除
         * @author ChenWenWu
         * @date 2017年7月9日 上午9:58:02
         * @param id
         */
         @ResponseBody
    	 @RequestMapping("/delBaby")
        public JsonResult delBaby(String ids){
        	 Integer num1= baseBabyService.delBaby(ids);
        	 JsonResult re=new JsonResult();
     		  if(num1>0){
     			  re.setObj(num1+"条数据修改成功");
     	          re.setMsg("ok");
     		  }else{
     			  re.setObj("修改失败");
     	          re.setMsg("false");
     		  }
     		  System.out.println(num1);
               return re; 
        }
       /**
        * 
        * @author ChenWenWu
        * @date 2017年8月4日 下午4:00:20
        * @param baseMember
        * @param relationship
        * @param babyid  
        * @param disabled 判断是否是新增basemenber
        * @param baseMemberID 用户基础表ID
        * @param imageUrl 修改的图片路径
        * @return
        */
         @ResponseBody
    	 @RequestMapping("/addParentbaby")
        public JsonResult addParentbaby(BaseMember baseMember,Integer relationship,String babyid,boolean disabled,String baseMemberID,String imageUrl){
        	 SysUserDTO sysuser=super.getUserInfo();
        	 String to=(String) super.getRequest().getSession().getServletContext().getAttribute("imgService");
        	 if(imageUrl.contains(to)){ // 判断是否包含上传路径，
//	    		   http://yunxunimg.xuechenedu.com//upload/20170724233929.jpg
	    	    String jieguo = imageUrl.substring(imageUrl.indexOf(to)+to.length());//截取字符串
	    			  	baseMember.setHeadPortrait(jieguo);
	    			  	 baseMember.setHeadPortrait(jieguo);
	    	   }else{
	    		  	baseMember.setHeadPortrait(uploadImg.get("parentImg"));
	    	   }
        	 baseMember.setSchoolId(sysuser.getSchoolId());
        	 Integer num1= baseBabyService.addParentConnection(baseMember, relationship,babyid, sysuser.getUsername(),disabled,baseMemberID);
        	 JsonResult re=new JsonResult();
    		  if(num1>0){
    			  re.setObj(num1+"条数据新增成功");
    	          re.setMsg("ok");
    		  }else{
    			  re.setObj("新增失败");
    	          re.setMsg("false");
    		  }
    		  System.out.println(num1);
              return re; 
         }
     /**
      * 删除《宝贝家长表》 根据家长宝贝表ID,同时删除接送人表和宝贝接送人表，因为家长也属于这里
      * @author ChenWenWu
      * @date 2017年7月9日 上午9:16:31
      * @param 
      */
        public void delParentbaby(){
            
        }
        /**
         * 新增接送人表和宝贝接送人表
         * @author ChenWenWu
         * @date 2017年7月7日 上午10:24:01
         */
        @ResponseBody
   	    @RequestMapping("/addSurrogate")
        public JsonResult addSurrogate(BaseSurrogate baseSurrogate, Integer relationship, String babyid){
        	SysUserDTO sysuser =super.getUserInfo();
        	baseSurrogate.setCreateMam(sysuser.getUsername());
        	baseSurrogate.setHeadurl(uploadImg.get("SurrogateImg"));
        	Integer num1= baseBabyService.addBaseSurrogate(baseSurrogate, relationship, babyid);
        	JsonResult re=new JsonResult();
  		  if(num1>0){
  			  re.setObj(num1+"条数据新增成功");
  	          re.setMsg("ok");
  		  }else{
  			  re.setObj("新增失败");
  	          re.setMsg("false");
  		  }
  		  System.out.println(num1);
            return re; 
        }
        /**
         * 修改接送人表和宝贝接送人表
         * @author ChenWenWu
         * @date 2017年7月7日 上午11:13:22
         */
        public void editSurrogate(){
        	String jiesongrenID="";
        	EntityWrapper<BaseSurrogate> ew = new EntityWrapper<BaseSurrogate>();
        	ew.where("id = {0}", "12ab28f281fa4558895c8b6d47db3cb9");
        	List<BaseSurrogate> baseSurrogate=baseSurrogateService.selectList(ew);
        	jiesongrenID=baseSurrogate.get(0).getId();
        	baseSurrogate=baseSurrogateService.selectList(ew);
        	baseSurrogate.get(0).setName("zengyiqing1");
        	baseSurrogate.get(0).setPhone("131387280881");
        	baseSurrogate.get(0).setIdcard("440988888888888881");
        	baseSurrogate.get(0).setCreateTime(new Date());
        	baseSurrogate.get(0).setCreateMam("wenwu");
        	baseSurrogate.get(0).setUpdateTime(new Date());
        	baseSurrogate.get(0).setUpdateMan("wenwu");
        	baseSurrogate.get(0).setDeleteFlag(0);
        	baseSurrogate.get(0).setId(jiesongrenID);
        	Boolean result= baseSurrogateService.updateById(baseSurrogate.get(0));
        	
        	EntityWrapper<MemBabySurrogate> ew1 = new EntityWrapper<MemBabySurrogate>();
        	ew1.where("surrogate_id = {0}", jiesongrenID);
        	List<MemBabySurrogate> memBabySurrogate=memBabySurrogateService.selectList(ew1);
        	memBabySurrogate.get(0).setSurrogateId(jiesongrenID);
        	memBabySurrogate.get(0).setParentBabyId("0d1df87f942a4cdb90feb0eb4789692c");
        	memBabySurrogate.get(0).setRelationship(2);
        	memBabySurrogate.get(0).setCreateTime(new Date());
        	memBabySurrogate.get(0).setCreateMam("wenwu");
        	memBabySurrogate.get(0).setUpdateTime(new Date());
        	memBabySurrogate.get(0).setUpdateMan("wenwu");
        	memBabySurrogate.get(0).setDeleteFlag(0);
        	memBabySurrogateService.editOneBabySurrogate(memBabySurrogate.get(0));
        		
        }
        /**
         * 删除接送人表传babyID 
         */
        private String ymbabyid;
		
        public String getYmbabyid() {    
			return ymbabyid;
		}
		public void setYmbabyid(String ymbabyid) {
			this.ymbabyid = ymbabyid;
		}
		/**
         * 删除接送人表和宝贝接送人表
         * @author ChenWenWu
         * @date 2017年7月9日 上午9:21:53
         * @param id   数组[]
         */
        public void delSurrogate(){
        	BaseSurrogate baseSurrogate=new BaseSurrogate();
        	String [] ids = ymbabyid.split(",");
			for(String zj : ids){
				baseSurrogate.setDeleteFlag(1);
	        	baseSurrogate.setId(zj);
	            boolean result=	baseSurrogateService.updateById(baseSurrogate);
	            boolean result2=memBabySurrogateService.delOneBabySurrogate(1, baseSurrogate.getId());
				}
        
        	}
        /**
         * 1、分页  《宝贝》 加模糊查询  2、 同时也是报名管理的查询
         * @author ChenWenWu
         * @date 2017年7月6日 下午3:04:02
         */
        @ResponseBody
        @RequestMapping("/findBaby")
        public JsonResult findBaby(BaseBabySchoolDTO baseBabySchoolDTO, Integer startPage,Integer pageSise){
           SysUserDTO sysuser= super.getUserInfo();
           if (sysuser.getSchoolId()==null){
        	   baseBabySchoolDTO.setSchoolid("");
           }else {
        	   baseBabySchoolDTO.setSchoolid(sysuser.getSchoolId());
           }
        	Page<BaseBabySchoolDTO> page =new Page<BaseBabySchoolDTO>(startPage,pageSise);
        	List<BaseBabySchoolDTO> baseBaby= baseBabyService.findBaseBabyPage(page,baseBabySchoolDTO);
           //查询分组 
        	
        	EntityWrapper<BaseGroup> ew = new EntityWrapper<BaseGroup>();
        	ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
        	ew.where("group_type = {0}",EnumGroupType.BB.getValue());
    		ew.setSqlSelect("id,name");
    		List<BaseGroup> grouplist = baseGroupService.selectList(ew);
        	
        	Map<String ,Object> map=new HashMap<String ,Object>();
	          map.put("page", page);
	          map.put("baseBaby", baseBaby);
	          map.put("grouplist", grouplist);
	          JsonResult re=new JsonResult();
	            re.setObj(map);
	            re.setMsg("ok");
	            return re; 
        }
        
        /**
         * 1、分页  《宝贝》 加模糊查询  2、 同时也是报名管理的查询
         * @author ChenWenWu
         * @date 2017年7月6日 下午3:04:02
         */
        @ResponseBody
        @RequestMapping("/findBaseBabyPageAndGroup")
        public JsonResult findBaseBabyPageAndGroup(BaseBabySchoolDTO baseBabySchoolDTO, Integer startPage,Integer pageSise){
          SysUserDTO sysuser=super.getUserInfo();
          if (sysuser.getSchoolId()==null){
        	  baseBabySchoolDTO.setSchoolid("");
			 }else{
				  baseBabySchoolDTO.setSchoolid(sysuser.getSchoolId());
			 }
        
        	Page<BaseBabySchoolDTO> page =new Page<BaseBabySchoolDTO>(startPage,pageSise);
        	List<BaseBabySchoolDTO> baseBabySchoolgroupDTO= baseBabyService.findBaseBabyPageAndGroup(page,baseBabySchoolDTO);
        	Map<String ,Object> map=new HashMap<String ,Object>();
	          map.put("page", page);
	          map.put("baseBabySchoolgroupDTO", baseBabySchoolgroupDTO);
	          JsonResult re=new JsonResult();
	            re.setObj(map);
	            re.setMsg("ok");
	            return re; 
        }
        /**
         * 1、修改baby 为了修改查出来
         * @author ChenWenWu
         * @date 2017年7月6日 下午3:04:02
         */
        @ResponseBody
        @RequestMapping("/findOneBaby")
        public JsonResult findOneBaby(String babyid){
    		BaseBaby baseBaby = baseBabyService.selectById(babyid);
    		EntityWrapper<MemBabyCards> ew = new EntityWrapper<MemBabyCards>();
        	ew.where("baby_id = {0}",babyid);
    		ew.setSqlSelect("id,card_num as cardNum,delete_flag as deleteFlag,blockup_flag as blockupFlag");
    		ew.orderBy("card_num", false);
    		List<MemBabyCards> memBabyCards = memBabyCardsService.selectList(ew);
    		 Map<String ,Object> map=new HashMap<String ,Object>();
    		JsonResult jsonResult = new JsonResult();
    		map.put("baseBaby", baseBaby);
    		map.put("memBabyCards", memBabyCards);
    		jsonResult.setObj(map);
    		return jsonResult;
        }
        /**
    	 * 查找家长信息  注意传入一个babyid是差对应的家长加入传入两个就可以定位对于孩子的家长
    	 * @author ChenWenWu
    	 * @date 2017年7月6日 下午5:35:32
    	 * @return
    	 */
        @ResponseBody
        @RequestMapping("/findParentInfonation")
        public JsonResult findParentInfonation(Integer startPage,Integer pageSise ,String babyid,String parentid,String baseSurrogateid){
        	Page<PreantInfomationDTO> page =new Page<PreantInfomationDTO>(0,10);
        	List<BaseBaby> preantInfomationDTO=baseBabyService.findParentInfonation(page, babyid,parentid);
        
        	Page<OneBabybaseSurrogateDTO> page1 =new Page<OneBabybaseSurrogateDTO>(0,10);
        	List<OneBabybaseSurrogateDTO> OneBabybaseSurrogateDTO=memBabySurrogateService.findOneBabybaseSurrogate(page1,babyid, baseSurrogateid);
        
        	  Map<String ,Object> map=new HashMap<String ,Object>();
	          map.put("OneBabybaseSurrogateDTO", OneBabybaseSurrogateDTO);
	          map.put("preantInfomationDTO", preantInfomationDTO);
	          JsonResult re=new JsonResult();
	            re.setObj(map);
	            re.setMsg("ok");
	            return re; 
        }
        /**
    	 * 根据babyid查询一个接送人为了方便修改接送人
    	 * @author ChenWenWu
    	 * @date 2017年7月6日 下午5:35:32
    	 * @return
    	 */
        @ResponseBody
        @RequestMapping("/findOneBabybaseSurrogate")
        public JsonResult findOneBabybaseSurrogate(String babyid,String baseSurrogateid ){
        	Page<OneBabybaseSurrogateDTO> page =new Page<OneBabybaseSurrogateDTO>(0,10);
        	List<OneBabybaseSurrogateDTO> preantInfomationDTO=memBabySurrogateService.findOneBabybaseSurrogate( page,babyid,baseSurrogateid);
        	JsonResult jsonResult = new JsonResult();
    		jsonResult.setObj(preantInfomationDTO);
    		return jsonResult;
        }
        /**
    	 * 修改家长信息以及他的子关系
    	 * @author ChenWenWu
    	 * @date 2017年7月6日 下午5:35:32
    	 * @return
    	 */
        @ResponseBody
        @RequestMapping("/editParentInfonation")
        public JsonResult editParentInfonation(BaseMember baseMember,Integer relationship,String babyid,String parentid,String fphone,String imageUrl){
        	  String to=(String) super.getRequest().getSession().getServletContext().getAttribute("imgService");
 	    	 if(imageUrl.contains(to)){ // 判断是否包含上传路径，
// 	    		   http://yunxunimg.xuechenedu.com//upload/20170724233929.jpg
 	    	    String jieguo = imageUrl.substring(imageUrl.indexOf(to)+to.length());//截取字符串
 	    			  	baseMember.setHeadPortrait(jieguo);
 	    	   }else{
 	    		  	baseMember.setHeadPortrait(uploadImg.get("parentImg"));
 	    	   }
        	Integer num1=baseBabyService.editParentConnection(baseMember, relationship, babyid,parentid,fphone);
        	JsonResult re = new JsonResult();
        	  if(num1>0){
     			  re.setObj(num1+"条数据修改成功");
     	          re.setMsg("ok");
     		  }else{
     			  re.setObj("修改失败");
     	          re.setMsg("false");
     		  }
     		  System.out.println(num1);
               return re; 
        }
        /**
    	 * 删除家长信息以及他的子关系
    	 * @author ChenWenWu
    	 * @date 2017年7月6日 下午5:35:32
    	 * @return
    	 */
        @ResponseBody
        @RequestMapping("/delParentConnection")
        public JsonResult delParentConnection(String parentid,String fphone){
        	Integer num1=baseBabyService.delParentConnection(parentid,fphone);
        	JsonResult re = new JsonResult();
        	  if(num1>0){
     			  re.setObj("删除成功");
     	          re.setMsg("ok");
     		  }else{
     			  re.setObj("删除失败");
     	          re.setMsg("false");
     		  }
     		  System.out.println(num1);
               return re; 
        }
        /**
    	 * 修改联系人信息以及他的子关系
    	 * @author ChenWenWu
    	 * @date 2017年7月6日 下午5:35:32
    	 * @return
    	 */
        @ResponseBody
        @RequestMapping("/editBaseSurrogate")
        public JsonResult editBaseSurrogate(BaseSurrogate baseSurrogate, Integer relationship,String imageUrl ){
        	SysUserDTO sysuser =super.getUserInfo();
        	baseSurrogate.setUpdateMan(sysuser.getUsername());
        	String to=(String) super.getRequest().getSession().getServletContext().getAttribute("imgService");
 	    	 if(imageUrl.contains(to)){ // 判断是否包含上传路径，
// 	    		   http://yunxunimg.xuechenedu.com//upload/20170724233929.jpg
 	    	    String jieguo = imageUrl.substring(imageUrl.indexOf(to)+to.length());//截取字符串
 	    		System.out.println(jieguo);
 	    	    baseSurrogate.setHeadurl(jieguo);
 	    	   }else{
 	    		  baseSurrogate.setHeadurl(uploadImg.get("SurrogateImg"));
 	    	   }
        	Integer num1=baseBabyService.editBaseSurrogate(baseSurrogate, relationship);
        	JsonResult re = new JsonResult();
        	  if(num1>0){
     			  re.setObj(num1+"条数据修改成功");
     	          re.setMsg("ok");
     		  }else{
     			  re.setObj("修改失败");
     	          re.setMsg("false");
     		  }
     		  System.out.println(num1);
               return re; 
        }
        /**
    	 * 修改联系人信息以及他的子关系
    	 * @author ChenWenWu
    	 * @date 2017年7月6日 下午5:35:32
    	 * @return
    	 */
        @ResponseBody
        @RequestMapping("/delBaseSurrogate")
        public JsonResult delBaseSurrogate(String parentid ){
        	Integer num1=baseBabyService.delBaseSurrogate(parentid);
        	JsonResult re = new JsonResult();
        	  if(num1>0){
     			  re.setObj(num1+"条数据删除成功");
     	          re.setMsg("ok");
     		  }else{
     			  re.setObj("删除失败");
     	          re.setMsg("false");
     		  }
     		  System.out.println(num1);
               return re; 
        }
        /**
    	 * 绑定班级下拉框
    	 * @author wenwu
    	 * @date 2017年7月11日 下午9:45:23
    	 */
    	@ResponseBody
    	@RequestMapping("/findCboClsass")
    	public JsonResult findCboClsass(){
    		EntityWrapper<BaseClass> ew = new EntityWrapper<BaseClass>();
    		ew.setSqlSelect("id,class_name AS className");
    		List<BaseClass> list = baseClassService.selectList(ew);
    		JsonResult jsonResult = new JsonResult();
    		jsonResult.setObj(list);
    		return jsonResult;
    	}
    	 /**
    	 * 学院分组下拉框
    	 * @author wenwu
    	 * @date 2017年7月11日 下午9:45:23
    	 */
    	@ResponseBody
    	@RequestMapping("/findCboBaseGroup")
    	public JsonResult findCboBaseGroup(){
    		EntityWrapper<BaseGroup> ew = new EntityWrapper<BaseGroup>();
        	ew.where("group_type = {0}",EnumGroupType.BB.getValue());
    		ew.setSqlSelect("id,name");
    		List<BaseGroup> grouplist = baseGroupService.selectList(ew);
    		JsonResult jsonResult = new JsonResult();
    		jsonResult.setObj(grouplist);
    		return jsonResult;
    	}
    	  /**
    	 * 新增分组
    	 * @author wenwu
    	 * @date 2017年7月11日 下午9:45:23
    	 */
    	@ResponseBody
    	@RequestMapping("/addbaseGroup")
    	public JsonResult addbaseGroup(BaseGroup baseGroup){
    		SysUserDTO sysuser =super.getUserInfo();
    		baseGroup.setSchoolId(sysuser.getSchoolId());
    		 JsonResult jsonResult = new JsonResult();
        	 baseGroup.setCreateTime(new Date());
        	 baseGroup.setDeleteFlag(0);
        	 boolean result=baseGroupService.insert(baseGroup);
        	 if(result){
     			jsonResult.setObj("新增成功");
     		}else{
     			jsonResult.setObj("新增失败");
     		}
    		return jsonResult;
    	}
    	  /**
    	 * 删除分组同时删除分组中的 宝贝
    	 * @author wenwu
    	 * @date 2017年7月11日 下午9:45:23
    	 */
    	@ResponseBody
    	@RequestMapping("/delbaseGroup")
    	public JsonResult delbaseGroup(String ids){
    		SysUserDTO sysuser =super.getUserInfo();
    		System.out.println(ids);
    	    Integer num=baseBabyService.delgropu(ids);
    		JsonResult re=new JsonResult();
    		 if(num>0){
    			 re.setObj("成功删除"+num+"条数据");
      		}else{
      			re.setObj("删除失败");
      		}
    		return re;
    	}
    	
    	  /**
    	 * 新增宝贝分组
    	 * @author wenwu
    	 * @date 2017年7月11日 下午9:45:23
    	 */
    	@ResponseBody
    	@RequestMapping("/addMemMemberGroup")
    	public JsonResult addMemMemberGroup(MemMemberGroup memMemberGroup,String ids){
    		 JsonResult jsonResult = new JsonResult();
    		 boolean result=false;
    			String [] id = ids.split(",");
    			String []  aa=new String[id.length];
    			 for (int i = 0; i < id.length; i++) {
    				 aa[i]=id[i];
    			}
    			 for(int i = 0; i <aa.length; i++){
    				 MemMemberGroup memMemberGroup1=new MemMemberGroup();
    				 memMemberGroup1.setBabyId(aa[i]);
    				 memMemberGroup1.setCreateTime(new Date());
    				 memMemberGroup1.setDeleteFlag(0);
    				 memMemberGroup1.setCreateMam(memMemberGroup.getCreateMam());
    				 memMemberGroup1.setGroupId(memMemberGroup.getGroupId());
    	        	  result=memMemberGroupService.insert(memMemberGroup1);
    			 }
        	 if(result){
     			jsonResult.setObj("分组成功");
     		}else{
     			jsonResult.setObj("分组失败");
     		}
    		return jsonResult;
    	}
    	
    	  /**
    	 * 修改卡号状态为停用
    	 * @author wenwu
    	 * @date 2017年7月11日 下午9:45:23
    	 */
    	@ResponseBody
    	@RequestMapping("/editBabyCardsService")
    	public JsonResult editBabyCardsService(MemBabyCards memBabyCards){
    		SysUserDTO  sysuser=super.getUserInfo();
    		 JsonResult jsonResult = new JsonResult();
    		 memBabyCards.setUpdateTime(new Date());
    		 memBabyCards.setUpdateMan(sysuser.getUsername());
    		 memBabyCards.setBlockupFlag(1);
        	 boolean result=memBabyCardsService.updateById(memBabyCards);
        	 if(result){
     			jsonResult.setObj("停用成功");
     		}else{
     			jsonResult.setObj("停用失败");
     		}
    		return jsonResult;
    	}
  	     /**
    	 * 删除卡号
    	 * @author wenwu
    	 * @date 2017年7月11日 下午9:45:23
    	 */
    	@ResponseBody
    	@RequestMapping("/delBabyCardsService")
    	public JsonResult delBabyCardsService(MemBabyCards memBabyCards){
    		SysUserDTO  sysuser=super.getUserInfo();
    		 JsonResult jsonResult = new JsonResult();
    		 memBabyCards.setDeleteFlag(EnumDeleteFlag.YSC.getValue());//这里意思已删除
        	 boolean result=memBabyCardsService.updateById(memBabyCards);
        	 if(result){
     			jsonResult.setObj("删除成功");
     		}else{
     			jsonResult.setObj("删除失败");
     		}
    		return jsonResult;
    	}
    	
     /**
      * 新增育儿知识
      * @author ChenWenWu
      * @date 2017年7月28日 上午11:33:20
      * @param baseParentingKnowledge
      * @return
      */
    	@ResponseBody
    	@RequestMapping("/addbaseParentingKnowledge")
    	public JsonResult addbaseParentingKnowledge(BaseParentingKnowledge baseParentingKnowledge,String time){
    		
    		SysUserDTO sysuser=super.getUserInfo();
    		JsonResult jsonResult = new JsonResult();
    		 baseParentingKnowledge.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
    		 baseParentingKnowledge.setPublisherId(sysuser.getId());
    		 baseParentingKnowledge.setCreateMam(sysuser.getUsername());
    		 baseParentingKnowledge.setCreateTime(new Date());
    		 baseParentingKnowledge.setBrowseCount(0);
    		 baseParentingKnowledge.setPointCount(0);
    		 baseParentingKnowledge.setCollectionNum(0);
    		 baseParentingKnowledge.setCommentCount(0);
    		 baseParentingKnowledge.setDisableNo(0);
    		 baseParentingKnowledge.setImage(uploadImg.get("yuerImg"));
    		 Date date = DateUtil.parse(time.substring(0,19));
    	     Date date1 = DateUtil.parse(time.substring(22));
    	     baseParentingKnowledge.setStartTime(date);
    		 baseParentingKnowledge.setEndTime(date1);
        	 boolean result=baseParentingKnowledgeService.insert(baseParentingKnowledge);
        	 if(result){
     			jsonResult.setObj("新增成功");
     		}else{
     			jsonResult.setObj("删除失败");
     		}
    		return jsonResult;
    	}
    	  /**
         *  修改育儿知识
         * @author ChenWenWu
         * @date 2017年7月28日 上午11:33:20
         * @param baseParentingKnowledge
         * @return
         */
       	@ResponseBody
       	@RequestMapping("/editbaseParentingKnowledge")
       	public JsonResult editbaseParentingKnowledge(BaseParentingKnowledge baseParentingKnowledge,String time,String ids,String imageUrl){
       		
       	 String to=(String) super.getRequest().getSession().getServletContext().getAttribute("imgService");
    	 if(imageUrl.contains(to)){ // 判断是否包含上传路径，
//    		   http://yunxunimg.xuechenedu.com//upload/20170724233929.jpg
    	    String jieguo = imageUrl.substring(imageUrl.indexOf(to)+to.length());//截取字符串
    			 baseParentingKnowledge.setImage(jieguo);
    	   }else{
    			 baseParentingKnowledge.setImage(uploadImg.get("yuerImg"));
    	   }
       		SysUserDTO sysuser=super.getUserInfo();
       		JsonResult jsonResult = new JsonResult();
       		 baseParentingKnowledge.setUpdateMan(sysuser.getUsername());
       		 baseParentingKnowledge.setUpdateTime(new Date());
       		 Date date = DateUtil.parse(time.substring(0,19));
       	     Date date1 = DateUtil.parse(time.substring(22));
       	     baseParentingKnowledge.setStartTime(date);
       		 baseParentingKnowledge.setEndTime(date1);
       		baseParentingKnowledge.setId(ids);
           	 boolean result=baseParentingKnowledgeService.updateById(baseParentingKnowledge);
           	 if(result){
        			jsonResult.setObj("修改成功");
        		}else{
        			jsonResult.setObj("修改失败");
        		}
       		return jsonResult;
       	}
    	
    	
    	/**
    	 * 查询育儿知识
    	 * @author ChenWenWu
    	 * @date 2017年8月3日 上午11:26:44
    	 * @param page
    	 * @param baseParentingKnowledgeDTO 育儿知识实体
    	 * @return
    	 */
        @ResponseBody
    	 @RequestMapping("/findBaseParentingKnowledgeDTO")
    	public JsonResult findBaseParentingKnowledgeDTO(Integer startPage,Integer pageSise, BaseParentingKnowledgeDTO baseParentingKnowledgeDTO){
        	  SysUserDTO suer=super.getUserInfo();
        	  if(suer.getSchoolId()==null){
        		  baseParentingKnowledgeDTO.setSchoolID("");
        	  }else{
        		  baseParentingKnowledgeDTO.setSchoolID(suer.getSchoolId()); 
        	  }
        	Page<BaseParentingKnowledgeDTO> page =new Page<BaseParentingKnowledgeDTO>(startPage,pageSise);
        	List<BaseParentingKnowledgeDTO> baseParentingKnowledgelist= baseBabyService.findBaseParentingKnowledge(page, baseParentingKnowledgeDTO);
    	       int  j=baseParentingKnowledgelist.size();
        	for (int i = 0; i < j; i++) {
        		if(baseParentingKnowledgelist.get(i).getMemName()==null){
        			baseParentingKnowledgelist.get(i).setMemName(baseParentingKnowledgelist.get(i).getSysName());
        		} else if(baseParentingKnowledgelist.get(i).getSysName()==null){
        			baseParentingKnowledgelist.get(i).setSysName(baseParentingKnowledgelist.get(i).getMemName());
        		}  
    		}
        	Map<String ,Object> map=new HashMap<String ,Object>();
            map.put("baseParentingKnowledgelist", baseParentingKnowledgelist);
            map.put("page", page);
            JsonResult re=new JsonResult();
            re.setObj(map);
            re.setMsg("ok");
             return re; 
        }
    	/**
    	 * 查询育儿知识
    	 * @author ChenWenWu
    	 * @date 2017年8月3日 上午11:26:44
    	 * @param page
    	 * @param baseParentingKnowledgeDTO 育儿知识实体
    	 * @return
    	 */
        @ResponseBody
    	 @RequestMapping("/findOneBaseParentingKnowledgeDTO")
    	public JsonResult findOneBaseParentingKnowledgeDTO(String ids){
        	BaseParentingKnowledgeDTO baseParentingKnowledgelist= baseBabyService.findOneBaseParentingKnowledge(ids);
            JsonResult re=new JsonResult();
            if(baseParentingKnowledgelist!=null){
                re.setObj(baseParentingKnowledgelist);
                re.setMsg("ok");
            }else{
            	 re.setObj("无法修改");
                 re.setMsg("false");
            }
             return re; 
        }
        /**
         * 
         * @author ChenWenWu
         * @date 2017年8月3日 下午5:39:23
         * @param ids
         * @return
         */
		 @ResponseBody
		 @RequestMapping("/delParentingKnowledge")
		 public JsonResult delParentingKnowledge(String ids){
			Integer num= baseBabyService.delParentingKnowledge(ids);
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
	         * 
	         * @author ChenWenWu
	         * @date 2017年8月3日 下午5:39:23
	         * @param ids
	         * @return
	         */
			 @ResponseBody
			 @RequestMapping("/editParentingKnowledgedisableNo")
			 public JsonResult editParentingKnowledgedisableNo(String ids){
				Integer num= baseBabyService.delParentingKnowledge(ids);
				  JsonResult re=new JsonResult();
				  if(num>0){
					  re.setObj("下架成功"+num+"条数据");
			          re.setMsg("ok");
				  }else{
					  re.setObj("下架失败");
			          re.setMsg("false");
				  }
				  System.out.println(num);
		          return re; 
			 }
			 /**
			  * 添加家长得时候查找家长如果没有就新增
			  * @author ChenWenWu
			  * @date 2017年8月4日 下午2:32:22
			  * @param phone
			  * @return
			  */
			 @ResponseBody
			 @RequestMapping("/findBsememberByPhone")
			 public JsonResult findBsememberByPhone(String phone){
			 EntityWrapper<BaseMember> ew = new EntityWrapper<BaseMember>();
	       		ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
	       		ew.where("phone_num = {0}",phone);
	     		ew.setSqlSelect("id,name,head_portrait as headPortrait");
	     	List<BaseMember> baseMemberList=baseMemberService.selectList(ew); 
	     	  JsonResult re=new JsonResult();
	            if(baseMemberList!=null){
	                re.setObj(baseMemberList);
	                re.setMsg("ok");
	            }else{
	            	 re.setObj("无法修改");
	                 re.setMsg("false");
	            }
	             return re; 
			 }
}
