package com.vision.edu.web.controller.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.dto.AnnouncementDTO;
import com.vision.edu.dto.EmailDTO;
import com.vision.edu.dto.GroupSchoolDTO;
import com.vision.edu.dto.PlatformDTO;
import com.vision.edu.dto.SorecastRecord;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseGroup;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemInfoGroup;
import com.vision.edu.entity.system.SysPrincipalMailbox;
import com.vision.edu.entity.system.SysUser;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumDisableFlag;
import com.vision.edu.enums.EnumInfoType;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.enums.EnumMessageState;
import com.vision.edu.enums.EnumPaymentType;
import com.vision.edu.enums.EnumPlatform;
import com.vision.edu.enums.EnumRangeType;
import com.vision.edu.framework.util.UploadUtil;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseGroupService;
import com.vision.edu.service.base.IBaseSchoolInfoService;
import com.vision.edu.service.base.IBaseSchoolService;
import com.vision.edu.service.base.IBaseSorecastRecordService;
import com.vision.edu.service.member.IMemInfoGroupService;
import com.vision.edu.service.system.ISysPrincipalMailboxService;
import com.vision.edu.service.system.ISysUserService;

@Controller
@RequestMapping("/Inform")
public class InformController extends BaseController {

	@Autowired
	private IBaseSchoolInfoService baseSchoolInfoService;
	
	@Autowired 
	IBaseGroupService baseGroupService; 
	
	@Autowired
	IMemInfoGroupService memInfoGroupService;
	
	@Autowired
	ISysPrincipalMailboxService  sysPrincipalMailboxService;
	
	@Autowired
	IBaseSorecastRecordService baseSorecastRecordService;
	
	@Autowired
	IBaseSchoolService baseSchoolService;
	
	@Autowired
	ISysUserService  sysUserService;
	
	Map<String, String> uploadImg;
	
	
	/**
	 * 查询公告
	 * 
	 * @author jiangwangying
	 * @date 2017年7月10日 上午11:12:09
	 * @param startPage
	 *            起始页码
	 * @param pageSize
	 *            每页大小
	 * @param title
	 *            标签
	 * @param schoolName
	 *            学校名称
	 */
	@ResponseBody
	@RequestMapping("/findAnnouncement")
	public JsonResult findAnnouncement(Integer startPage, Integer pageSize, String title, String schoolId) {

		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		
		Integer Platform = null;// 平台标记
		
		if (sysUserDTO.getMemberType() == EnumMemberType.PTGL.getValue()) {
		 Platform = EnumPlatform.PT.getValue(); // 平台标记
		} 
		else if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
			Platform = EnumPlatform.YX.getValue(); // 园校标记
			schoolId = sysUserDTO.getSchoolId();
		}
		Integer rangeType = null; //范围
		Integer InfoType = EnumInfoType.GG.getValue(); // 资讯类型
		
		Page<AnnouncementDTO> page = new Page<AnnouncementDTO>(startPage, pageSize);
		List<AnnouncementDTO> list = baseSchoolInfoService.findAnnouncement(page, InfoType, title, "", schoolId, rangeType, Platform);
		Integer total = 0;
		total = page.getTotal();
		
		if (list.size()>0 && total>0) {
			jsonObject.put("total", total);
			jsonObject.put("list", list);
			jsonResult.setSuccess(true);
			jsonResult.setObj(jsonObject);
		}else {
			jsonResult.setMsg("没有符合条件的数据");
			jsonResult.setSuccess(false);
		}
		return jsonResult;
	}

	/**
	 * 绑定发布公告 用户分组下拉框
	 * @author jiangwangying
	 * @date 2017年7月28日 上午11:17:34
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findGroup")
	public JsonResult findGroup() {
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memberType = sysUserDTO.getMemberType();// 获取登录人员类型 3 \ 4
		String schoolId = sysUserDTO.getSchoolId();// 获取园校id
		
		List<PlatformDTO> Platformlist = null;
		List<GroupSchoolDTO> groupSchoolList = null;
		
		if (memberType == EnumMemberType.PTGL.getValue()) {
			// 查询学校
			groupSchoolList = baseGroupService.findSchoolGroup(null, null); // schoolId + deleteFlag
			//一级节点 平台
			Platformlist = new ArrayList<>();
			PlatformDTO platformDTO = new PlatformDTO();
			Platformlist.add(platformDTO);
			if (groupSchoolList.size()>0) {
				//二级节点 学校
				Platformlist.get(0).setChildren((ArrayList<GroupSchoolDTO>) groupSchoolList);
			}
			jsonResult.setObj(Platformlist);
			return  jsonResult;
		} else if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()){
			 // 一级节点 学校
			groupSchoolList = baseGroupService.findSchoolGroup(schoolId, null); // schoolId + deleteFlag
			   if (groupSchoolList.size()==1) {
					for (int i = 0; i < groupSchoolList.size(); i++) {
						EntityWrapper<BaseGroup> ew = new EntityWrapper<BaseGroup>();
						ew.setSqlSelect("id,name").where("school_id = {0}", groupSchoolList.get(i).getId());
						List<BaseGroup> groupList = baseGroupService.selectList(ew);
					    if (groupList.size()>0) {
					    	// 二级节点 会员组
					    	groupSchoolList.get(i).setChildren((ArrayList<BaseGroup>) groupList);
						}
					}
					 jsonResult.setSuccess(true);
					 jsonResult.setObj(groupSchoolList);
				}else {
					 jsonResult.setSuccess(false);
					 jsonResult.setMsg("该学校不存在或已经被删除");
				}
				
				return  jsonResult;
	    	} else {
	    		jsonResult.setSuccess(false);
	    		jsonResult.setMsg("无法确认管理员身份");
	    		return jsonResult;
	    	}
	}
	
	/**
	 * 上传公告图片
	 * @author jiangwangying
	 * @date 2017年7月27日 下午3:25:55
	 */
	@ResponseBody
	@RequestMapping("/uploadImg")
	public void uploadGongGaoImg() 
	{
		uploadImg = new HashMap<String,String>();
		uploadImg = UploadUtil.uploadImage(super.getRequest(), "gongGao");
	}
	
	/**
	 * 发布公告
	 * @author jiangwangying
	 * @date 2017年7月23日 下午3:39:22
	 * @param baseSchoolInfo
	 * @param groupIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addAnnouncement")
	public JsonResult addAnnouncement(BaseSchoolInfo baseSchoolInfo,String groupIds) {
 
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memberType = sysUserDTO.getMemberType();
		String schoolId = sysUserDTO.getSchoolId();
		String createMan = sysUserDTO.getUsername();
		
		if (null==uploadImg) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("没图咋行？");
			return jsonResult;
		}
		
		
		baseSchoolInfo.setCoverImages(uploadImg.get("gongGaoImg"));
		return baseSchoolInfoService.addAnnouncement(baseSchoolInfo, groupIds, schoolId,memberType,createMan);

	}

	/**
	 * 下架\审核通过\审核不通过 公告
	 * @author jiangwangying
	 * @date 2017年7月23日 下午8:57:18
	 * @param schoolInfoIds 公告id集合
	 * @param flag 操作标记:flag=1为下架操作 flag=2为审核通过操作 flag=3为审核不通过操作
	 * @param updateMan 修改人
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/CheckAnnouncement")
	public JsonResult stopOrCheckAnnouncement(String schoolInfoIds,Integer flag) {

		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		String updateMan = sysUserDTO.getUsername();
		
		return baseSchoolInfoService.CheckAnnouncement(schoolInfoIds,flag,updateMan);

	}
	
	/**
	 * 根据id查询园校资讯
	 * @author jiangwangying
	 * @date 2017年7月23日 下午10:12:58
	 * @param schoolInfoId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAnnouncementById")
	public JsonResult findAnnouncementById(String schoolInfoId) {

  		JsonResult jsonResult = new JsonResult();
  		JSONObject jsonObject = new JSONObject();
  		jsonResult.setSuccess(false);
		
  		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
  		
  		if (StringUtils.isEmpty(schoolInfoId)) {
  			jsonResult.setMsg("没主键查啥出来？");
  			return jsonResult;
		}
  		
		// 平台管理员登录
		if (sysUserDTO.getMemberType()==EnumMemberType.PTGL.getValue()) {
			
			EntityWrapper<BaseSchoolInfo> ew = new EntityWrapper<BaseSchoolInfo>();
	  		ew.where("id = {0}",schoolInfoId);
			ew.setSqlSelect("title,content,cover_images AS coverImages,range_type AS rangeType,platform_flag AS platformFlag");
			List<BaseSchoolInfo> schoolInfoList = baseSchoolInfoService.selectList(ew);
			if (schoolInfoList.size() == 1) {
				//全平台推送  一条数据
				if (schoolInfoList.get(0).getRangeType() == EnumRangeType.QPT.getValue()) {
					jsonObject.put("rangeType", EnumRangeType.QPT.getValue());//全平台推送标记
					jsonObject.put("platform", EnumPlatform.PT.getValue());//平台标记
					jsonObject.put("platformId", new PlatformDTO().getId());
					jsonObject.put("schoolInfoList", schoolInfoList);
					jsonResult.setSuccess(true);
				    jsonResult.setObj(jsonObject);
				    return jsonResult;
				} //分园校推送  一条 到 多条数据
				else if (schoolInfoList.get(0).getRangeType() == EnumRangeType.QYX.getValue()){
					EntityWrapper<BaseSchoolInfo> ew1 = new EntityWrapper<BaseSchoolInfo>();
			  		ew1.where("title = {0}",schoolInfoList.get(0).getTitle());
			  		ew1.where("range_type = {0}",EnumRangeType.QYX.getValue());
			  		ew1.where("platform_flag = {0}",EnumPlatform.PT.getValue());
			  		ew1.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
					ew1.setSqlSelect("school_id AS schoolId");
					ew1.groupBy("school_id,delete_flag");
					//查询出分园校推送的同一条公告  根据推送内容、推送范围、平台标记 来查询
					List<BaseSchoolInfo> schoollist = baseSchoolInfoService.selectList(ew1);
					if (schoollist.size()>0) {
						int listLenght = schoollist.size();
						String[] strSchoolId = new String[schoollist.size()];
						//获取学校id集合
						for (int i = 0; i < listLenght; i++) {
							strSchoolId[i] = schoollist.get(i).getSchoolId();
						}
						jsonObject.put("schoolInfoList", schoolInfoList);
						jsonObject.put("strIds", strSchoolId);
						jsonObject.put("platform", EnumPlatform.PT.getValue());//平台标记
						jsonObject.put("rangeType", EnumRangeType.QYX.getValue());//分园校
						jsonResult.setObj(jsonObject);
						jsonResult.setSuccess(true);
						return jsonResult;
					} else {
						jsonResult.setMsg("查询不到所推送的园校");
						return jsonResult;
					}
				} else {
					 jsonResult.setMsg("无法确定该公告推送范围");
					 return jsonResult;
				}
			}else {
			    jsonResult.setMsg("查询不到该公告");
				return jsonResult;
			}
		}// 园长、老师登录
		else if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
	 	
			EntityWrapper<BaseSchoolInfo> ew = new EntityWrapper<BaseSchoolInfo>();
	  		ew.where("id = {0}",schoolInfoId);
			ew.setSqlSelect("title,content,range_type AS rangeType,cover_images AS coverImages,platform_flag AS platformFlag,school_id AS schoolId");
			List<BaseSchoolInfo> schoolInfoList = baseSchoolInfoService.selectList(ew);
			if (schoolInfoList.size()==1) {
				//全园校
				if (schoolInfoList.get(0).getRangeType() == EnumRangeType.QYX.getValue()) {
					jsonObject.put("platform", EnumPlatform.YX.getValue());//园校标记
					jsonObject.put("rangeType", EnumRangeType.QYX.getValue()); // 整个园校
					jsonObject.put("schoolInfoList", schoolInfoList);
					jsonResult.setSuccess(true);
					jsonResult.setObj(jsonObject);
					return jsonResult;
				} // 分会员组推送
				else if (schoolInfoList.get(0).getRangeType() == EnumRangeType.FZTS.getValue()) {
					//查询资讯对应的资讯组
					EntityWrapper<MemInfoGroup> ew1 = new EntityWrapper<MemInfoGroup>();
					ew1.setSqlSelect("base_group_id AS baseGroupId");
			  		ew1.where("school_info_id = {0}",schoolInfoId);
			  		ew1.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
			  		ew1.groupBy("base_group_id");
			  		List<MemInfoGroup> infoGroupList = memInfoGroupService.selectList(ew1);
					if (infoGroupList.size()>0) {
						int listLenght = infoGroupList.size();
						String[] arrGroupId = new String[infoGroupList.size()];
						// 获取资讯组的会员组id
						for (int i = 0; i < listLenght; i++) {
							arrGroupId[i] = infoGroupList.get(i).getBaseGroupId();
						}
						jsonObject.put("schoolInfoList", schoolInfoList);
						jsonObject.put("strIds", arrGroupId);
						jsonObject.put("platform", EnumPlatform.YX.getValue());//园校标记
						jsonObject.put("rangeType", EnumRangeType.FZTS.getValue()); // 分会员组推送
						jsonResult.setObj(jsonObject);
						jsonResult.setSuccess(true);
						return jsonResult;
					}else{
					    jsonResult.setMsg("查询不到该公告所在资讯组");
					}
				} else {
					 jsonResult.setMsg("无法确定该公告推送范围");
					 return jsonResult;
				}
			} else {
			    jsonResult.setMsg("查询不到该资讯");
				return jsonResult;
			}
		} else {
			 jsonResult.setMsg("无法确认管理员身份");
		     return jsonResult;
		}
		return jsonResult;
	}
	
	/**
	 * 编辑公告
	 * @author jiangwangying
	 * @date 2017年7月23日 下午10:54:01
	 * @param schoolInfoId 资讯id
	 * @param title 标题
	 * @param content 内容
	 * @param groupIds 资讯组id集合
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editAnnouncement")
	public JsonResult editAnnouncement(String title,String content,String schoolInfoId,String groupIds) {

		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		String updateMan = sysUserDTO.getUsername();
		Integer memberType = sysUserDTO.getMemberType();
		String gongGaoImg = "";
		if (null!=uploadImg) {
		 gongGaoImg = uploadImg.get("gongGaoImg");
		} 
		uploadImg = null;//避免下一次使用上次的图
		return baseSchoolInfoService.editAnnouncement(title,content,schoolInfoId,groupIds,updateMan,memberType,gongGaoImg);
	}
	
	/**
	 * 查询园长信箱
	 * @author jiangwangying
	 * @date 2017年8月7日 上午8:48:23
	 * @param startPage 每页大小
	 * @param pageSize 每页大小
	 * @param vague 模糊搜索
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPrincipalMail")
	public JsonResult findPrincipalMail(Integer startPage,Integer pageSize,String schoolId,Integer memberType,String vague){
		   
		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		
		Integer total = 0;
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue()) {
			if(!StringUtils.isEmpty(sysUserDTO.getSchoolId()) || sysUserDTO.getSchoolId().trim() !="") {
				schoolId = sysUserDTO.getSchoolId();
			} else {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("获取用户所属园校失败");
				return jsonResult;
			}
		}
		
		Page<EmailDTO> page = new Page<EmailDTO>(startPage, pageSize);
		List<EmailDTO> list =  sysPrincipalMailboxService.findPrincipalMail(page,memberType,schoolId,vague);
		if (list.size() > 0) {
			total = page.getTotal();
			jsonResult.setSuccess(true);
			jsonObject.put("total", total);
			jsonObject.put("list", list);
			jsonResult.setObj(jsonObject);
		} else {
			jsonResult.setMsg("无符合条件的数据");
			jsonResult.setSuccess(false);
		}
	    return jsonResult;
	}
	
	/**
	 * 园长回复
	 * @author jiangwangying
	 * @date 2017年7月16日 下午4:48:06
	 */
	@ResponseBody
	@RequestMapping("/addPrincipalMail")
	public JsonResult addPrincipalMail(String id,String content){
	
		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || sysUserDTO.getMemberType() !=EnumMemberType.YZ.getValue() || StringUtils.isEmpty(sysUserDTO.getUsername())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("只限园长回复i");
			return jsonResult;
		}
		
		String memberId = "";
		if(!StringUtils.isEmpty(sysUserDTO.getId()) || sysUserDTO.getId().trim() !="") {
			
			EntityWrapper<SysUser> ew = new EntityWrapper<SysUser>();
			ew.setSqlSelect("base_member_id AS baseMemberId");
			ew.where("id = {0}", sysUserDTO.getId());
			ew.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
			ew.where("disable_no = {0}", EnumDisableFlag.WTY.getValue());
	        List<SysUser> sysUserList = sysUserService.selectList(ew);
			if (sysUserList.size() == 1) {
				if (!StringUtils.isEmpty(sysUserList.get(0).getBaseMemberId())) {
					memberId = sysUserList.get(0).getBaseMemberId();
				} else {
					jsonResult.setSuccess(false);
					jsonResult.setMsg("出错啦");
					return jsonResult;
				}
			} else {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("检查到当前用户已被删除或已被停用");
				return jsonResult;
			}
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("出错啦");
			return jsonResult;
		}
		
		
		String createMan = sysUserDTO.getUsername();
		return sysPrincipalMailboxService.addPrincipalMail(id,content,memberId,createMan);
		
	}
	
	/**
	 * 查询发件人发送内容
	 * @author jiangwangying
	 * @date 2017年7月24日 下午8:40:23
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findMailById")
	public JsonResult findMailById(String id){
	
		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || sysUserDTO.getMemberType() !=EnumMemberType.YZ.getValue() || StringUtils.isEmpty(sysUserDTO.getUsername())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("只限园长回复i");
			return jsonResult;
		}
		
		String memberId = "";
		if(!StringUtils.isEmpty(sysUserDTO.getId()) || sysUserDTO.getId().trim() !="") {
			
			EntityWrapper<SysUser> ew = new EntityWrapper<SysUser>();
			ew.setSqlSelect("base_member_id AS baseMemberId");
			ew.where("id = {0}", sysUserDTO.getId());
			ew.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
			ew.where("disable_no = {0}", EnumDisableFlag.WTY.getValue());
	        List<SysUser> sysUserList = sysUserService.selectList(ew);
			if (sysUserList.size() == 1) {
				if (!StringUtils.isEmpty(sysUserList.get(0).getBaseMemberId())) {
					memberId = sysUserList.get(0).getBaseMemberId();
				} else {
					jsonResult.setSuccess(false);
					jsonResult.setMsg("出错啦");
					return jsonResult;
				}
			} else {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("检查到当前用户已被删除或已被停用");
				return jsonResult;
			}
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("出错啦");
			return jsonResult;
		}
		// 根据信箱id 和 接收人id 查询
	    List<EmailDTO> list = sysPrincipalMailboxService.findMailById(id,memberId);
	    if (list.size()>0) {
	    	jsonObject.put("letterContent", list.get(0).getLetterContent());
	    	jsonObject.put("sender", list.get(0).getSender());
	    	jsonResult.setSuccess(true);
		}else{
			jsonResult.setSuccess(false);
			jsonResult.setMsg("出错啦");
		}
		jsonResult.setObj(jsonObject);
		return jsonResult;
	}
	
	/**
	 * 检查邮箱是否已回复或者已删除
	 * @author jiangwangying
	 * @date 2017年7月24日 下午10:00:33
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkMail")
	public JsonResult checkMail(String id){
	
		JsonResult jsonResult = new JsonResult();
		jsonResult.setSuccess(true);
		
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || sysUserDTO.getMemberType() !=EnumMemberType.YZ.getValue() || StringUtils.isEmpty(sysUserDTO.getUsername())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("只限园长回复i");
			return jsonResult;
		}
		
		
		
		EntityWrapper<SysPrincipalMailbox> ew = new EntityWrapper<SysPrincipalMailbox>();
  		ew.where("id = {0}",id);
		ew.setSqlSelect("state,delete_flag as deleteFlag");
		List<SysPrincipalMailbox> mailList = sysPrincipalMailboxService.selectList(ew);
		if (mailList.size()>0) {
			if (mailList.get(0).getState() == EnumMessageState.YHF.getValue()
					|| mailList.get(0).getDeleteFlag() == EnumDeleteFlag.YSC.getValue()) {
				jsonResult.setMsg("该信件已经回复或者已经删除啦");
				jsonResult.setSuccess(false);
			}
		}
		return jsonResult;
	}
	
	/**
	 * 删除信件
	 * @author jiangwangying
	 * @date 2017年7月24日 下午11:34:24
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delMail")
	public JsonResult delMail(String mailIds){
	
		return sysPrincipalMailboxService.delMail(mailIds);
	}
	
	/**
	 * 查询预报名家长
	 * @author jiangwangying
	 * @date 2017年7月25日 上午1:44:34
	 * @param startPage
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findSorecastRecord")
	public JsonResult findSorecastRecord(Integer startPage,Integer pageSize,String name){
		
		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}  
		
		String schoolId = "";
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
			schoolId = sysUserDTO.getSchoolId();
		}
		Integer total = 0;
		
		Page<SorecastRecord> page = null;
		page = new Page<SorecastRecord>(startPage, pageSize);
		List<SorecastRecord> list = baseSorecastRecordService.findSorecastRecord(page,schoolId,name);
		
		if (list.size()>0) {
			jsonResult.setSuccess(true);
			total = page.getTotal();
			jsonObject.put("total", total);
			jsonObject.put("list", list);
			jsonResult.setObj(jsonObject);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("无符合条件的数据");
		}

	    return jsonResult;

	}
	
	/**
	 * 删除预报名家长
	 * @author jiangwangying
	 * @date 2017年7月24日 下午11:34:24
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delSorecastRecord")
	public JsonResult del(String ids){
	
		return baseSorecastRecordService.delSorecastRecord(ids,"jwy");
	}
	
	/**
	 * 新增资讯组
	 * @author jiangwangying
	 * @date 2017年7月10日 下午5:54:21
	 * @param memInfoGroup
	 */
	@ResponseBody
	@RequestMapping("/addinfGroup")
	public void addinfGroup(MemInfoGroup memInfoGroup) {

		memInfoGroup.setSchoolInfoId("资讯id");
		boolean insertb = memInfoGroupService.insert(memInfoGroup);

	}
	
	/**
	 * 查询平台消息
	 * @author jiangwangying
	 * @date 2017年7月16日 下午4:52:59
	 * @param sysPrincipalMailbox
	 */
	@ResponseBody
	@RequestMapping("/findSysMessage")
	public void findSysMessage(){
		    
	}
}
