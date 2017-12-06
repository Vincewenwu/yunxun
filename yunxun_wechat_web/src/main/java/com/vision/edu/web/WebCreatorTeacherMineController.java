package com.vision.edu.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vision.edu.dto.MyMessageDto;
import com.vision.edu.dto.ParentsContactsDto;
import com.vision.edu.dto.SysUserDto;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.member.MemClassTeacher;
import com.vision.edu.entity.system.SysMessage;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseBabyService;
import com.vision.edu.service.base.IBaseGroupService;
import com.vision.edu.service.member.IMemClassTeacherService;
import com.vision.edu.service.member.IMemParentBabyService;
import com.vision.edu.service.system.ISysMessageService;
import com.vision.edu.service.system.ISysUserService;

/**
 * 我的【教师端】
 * @author lichenglong
 * @date 2017年7月23日 下午4:12:18
 * @version 1.0
 */
@Controller
@RequestMapping("/mine")
public class WebCreatorTeacherMineController {

	@Autowired
	private ISysUserService sysUserService;//注入后台用户ISysUserService
	@Autowired
	private ISysMessageService sysMessageService;//注入消息通知ISysMessageService
	@Autowired
	private IBaseGroupService baseGroupService;//注入会员组IBaseGroupService
	@Autowired
	private IMemClassTeacherService memClassTeacherService;//注入班级教师IMemClassTeacherService
	@Autowired
	private IMemParentBabyService memParentBabyService;//注入家长宝贝IMemParentBabyService
	@Autowired
	private IBaseBabyService baseBabyService;//注入宝贝IBaseBabyService
	
	/**
	 * 主页面
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月23日 下午10:02:47
	 */
	@ResponseBody
	@RequestMapping("/mainPage")
	public JsonResult mainPage(HttpServletRequest request){
		//根据教师id获取到我的主页信息
		String sysUserId = request.getParameter("sysUserId");//教师id
		List<SysUserDto> listSysUserDto = sysUserService.findMainPage(sysUserId, EnumDeleteFlag.WSC.getValue());
		List<SysMessage> listSysMessage = sysMessageService.findDidnReadTheMessage(sysUserId, 0, EnumDeleteFlag.WSC.getValue());
		Map<String, Object> map = new HashMap<String, Object>();
		JsonResult jsonResult = new JsonResult();
		map.put("listSysUserDto", listSysUserDto);
		map.put("listSysMessage", listSysMessage.size());
		jsonResult.setObj(map);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 个人资料
	 * @author lichenglong
	 * @date 2017年7月24日 上午11:55:03
	 * @param request
	 * @return 
	 */
	@ResponseBody
	@RequestMapping("/personalData")
	public JsonResult personalData(HttpServletRequest request){
		String sysUserId = request.getParameter("sysUserId");//教师id
		List<SysUserDto> listSysUserDto = sysUserService.findMainPage(sysUserId, EnumDeleteFlag.WSC.getValue());
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listSysUserDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 我的消息
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月24日 下午2:05:58
	 */
	@ResponseBody
	@RequestMapping("/myMessage")
	public JsonResult myMessage(HttpServletRequest request){
		String sysUserId = request.getParameter("sysUserId");//教师id
		List<MyMessageDto> listMyMessageDto = sysMessageService.findtheTeacherAMessage(sysUserId, EnumDeleteFlag.WSC.getValue());
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listMyMessageDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 根据消息id查询消息详情
	 * @author lichenglong
	 * @date 2017年7月24日 下午3:36:59
	 */
	@ResponseBody
	@RequestMapping("/messageForDetails")
	public JsonResult messageForDetails(HttpServletRequest request){
		String messageId = request.getParameter("messageId");//消息id
		List<MyMessageDto> listMyMessageDto = sysMessageService.findMessageForDetails(messageId);
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listMyMessageDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 家长通信录
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月24日 下午9:40:32
	 */
	@ResponseBody
	@RequestMapping("/patriarchAddressBook")
	public JsonResult patriarchAddressBook(HttpServletRequest request){
		String sysUserId = request.getParameter("sysUserId");//教师id
		List<ParentsContactsDto> list = new ArrayList<ParentsContactsDto>();
		if(!sysUserId.equals("")){
			//根据教师id查询班级id
			EntityWrapper<MemClassTeacher> ewClassTeacher = new EntityWrapper<MemClassTeacher>();
			ewClassTeacher.where("mem_class_teacher.member_id = {0}","4df3ff518d434e88b9ec9d762f461c49");
			ewClassTeacher.setSqlSelect("mem_class_teacher.id,mem_class_teacher.class_id AS classId");
			List<MemClassTeacher> listMemClassTeacher = memClassTeacherService.selectList(ewClassTeacher);
			for (MemClassTeacher memClassTeacher : listMemClassTeacher) {
				//根据班级id查询宝贝集合
				EntityWrapper<BaseBaby> ewBaby = new EntityWrapper<BaseBaby>();
				ewBaby.where("base_baby.class_id = {0}",memClassTeacher.getClassId());
				ewBaby.setSqlSelect("base_baby.id");
				List<BaseBaby> listBaby = baseBabyService.selectList(ewBaby);
				for (BaseBaby baseBaby : listBaby) {
					//根据宝贝id集合查询出家长信息集合
					List<ParentsContactsDto> listParentsContacts = memParentBabyService.findParentsContacts(baseBaby.getId(), EnumDeleteFlag.WSC.getValue());
					for (ParentsContactsDto parentsContactsDto : listParentsContacts) {
						list.add(parentsContactsDto);
					}
				}
			}
		}
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(list);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 老师通信录
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月24日 下午9:40:55
	 */
	@ResponseBody
	@RequestMapping("/teacherAddressBook")
	public JsonResult teacherAddressBook(HttpServletRequest request){
		String sysUserId = request.getParameter("sysUserId");//教师id
		JsonResult jsonResult = new JsonResult();
		if(!sysUserId.equals("")){
			//根据教师id查询出园校id
			SysUserDto sysUserDto = sysUserService.findSysUserData(sysUserId, EnumDeleteFlag.WSC.getValue());
			//根据园校id查询出全部教师信息
			List<SysUserDto> listSysUserDto = sysUserService.findTeacherAddressBook(sysUserDto.getSchoolId(), EnumDeleteFlag.WSC.getValue());
			jsonResult.setObj(listSysUserDto);
		}
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	 
	
}
