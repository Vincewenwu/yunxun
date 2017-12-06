package com.vision.edu.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vision.edu.dto.CommentinfoDto;
import com.vision.edu.dto.MemMemberDto;
import com.vision.edu.dto.MyMessageDto;
import com.vision.edu.dto.TheTeacherAddressBookDao;
import com.vision.edu.entity.member.MemComboRecord;
import com.vision.edu.entity.member.MemComment;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.member.IMemComboRecordService;
import com.vision.edu.service.member.IMemCommentService;
import com.vision.edu.service.member.IMemMemberService;
import com.vision.edu.service.system.ISysMessageService;

/**
 * 我的【家长端】
 * @author lichenglong
 * @date 2017年7月14日 上午11:44:55
 * @version 1.0
 */
@Controller
@RequestMapping("/parentsSideMine")
public class ParentsSideMineController {

	@Autowired
	private IMemMemberService memMemberService;//注入会员IMemMemberService
	@Autowired
	private IMemComboRecordService memComboRecordService;//注入套餐记录IMemComboRecordService
	@Autowired
	private ISysMessageService sysMessageService;//注入消息通知ISysMessageService
	@Autowired
	private IMemCommentService memCommentService;//注入评论记录IMemCommentService
	
	/**
	 * 我的主页
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月14日 上午11:47:53
	 */
	@ResponseBody
	@RequestMapping("/mine")
	public JsonResult mine(){
		String memberId = "12bb6cc0612b430aaf727a5ce603b5a";//会员id
		List<MemMemberDto> listMemMemberInfo = memMemberService.findAccountManagement(memberId, EnumDeleteFlag.WSC.getValue());
		List<MemComboRecord> listMemComboRecord = memComboRecordService.findSetRecords(memberId,EnumDeleteFlag.WSC.getValue());
		Integer countDown = 0;
		for (MemComboRecord memComboRecord : listMemComboRecord) {
			memComboRecord.getExpireTime();
			countDown += (int) ((memComboRecord.getExpireTime().getTime()-(new Date()).getTime())/1000/(24*3600));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		JsonResult jsonResult = new JsonResult();
		map.put("MemMemberInfo", listMemMemberInfo);
		map.put("countDown", countDown);
		jsonResult.setObj(map);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 账号管理
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月14日 上午11:46:49
	 */
	@ResponseBody
	@RequestMapping("/accountManagement")
	public JsonResult accountManagement(){
		String memberId = "12bb6cc0612b430aaf727a5ce603b5a";//会员id
		List<MemMemberDto> listMemMemberInfo = memMemberService.findAccountManagement(memberId, EnumDeleteFlag.WSC.getValue());
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listMemMemberInfo);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 消息 --我的消息（根据宝贝id查询个人消息）
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月19日 下午9:17:56
	 */
	@ResponseBody
	@RequestMapping("/myMessage")
	public JsonResult myMessage(HttpServletRequest request){
		String sendeeId = request.getParameter("sendeeId");//宝贝id
		List<MyMessageDto> listMyMessageDto = sysMessageService.findPersonalDetails(sendeeId, EnumDeleteFlag.WSC.getValue());
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listMyMessageDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 根据消息id查询消息详情
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月20日 下午8:50:00
	 */
	@ResponseBody
	@RequestMapping("/messageForDetails")
	public JsonResult messageForDetails(HttpServletRequest request){
		String messageId = request.getParameter("messageId");
		List<MyMessageDto> listMyMessageDto = sysMessageService.findMessageForDetails(messageId);
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listMyMessageDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	
	/**
	 * 根据消息id查询消息评论
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月23日 上午11:28:11
	 */
	@ResponseBody
	@RequestMapping("/commentinfo")
	public JsonResult commentinfo(HttpServletRequest request){
		String sourceId = request.getParameter("sourceId");
		List<CommentinfoDto> listCommentinfoDto = memCommentService.findCommentinfo(sourceId, EnumDeleteFlag.WSC.getValue());
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listCommentinfoDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 消息回复
	 * @author lichenglong
	 * @date 2017年7月23日 下午3:12:32
	 * @param request
	 * @return 
	 */
	@ResponseBody
	@RequestMapping("/addreplyMessage")
	public JsonResult addreplyMessage(HttpServletRequest request){
		String messageId = request.getParameter("messageId");
		String sourceId = request.getParameter("sourceId");
		String comment = request.getParameter("comment");
		System.out.println("memberId="+messageId + ",sourceId=" + sourceId + ",comment=" + comment);
		JsonResult jsonResult = new JsonResult();
		if(!messageId.equals("") && !sourceId.equals("") && !comment.equals("")){
			MemComment memComment = new MemComment();
			memComment.setMemberId(sourceId);
			memComment.setComment(comment);
			memComment.setFatherId("0");
			memComment.setSourceId(messageId);
			memComment.setCommentType(0);
			memComment.setCreateTime(new Date());
			memComment.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			boolean boolMemComment = memCommentService.insert(memComment);
			if(boolMemComment){
			  jsonResult.setMsg("ok");
			}
		}
		return jsonResult;
	}
	
	
	/**
	 * 老师通讯录
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月21日 下午4:28:12
	 */
	@ResponseBody
	@RequestMapping("/addressBook")
	public JsonResult addressBook(HttpServletRequest request){
		String babyId = request.getParameter("babyId");
		List<TheTeacherAddressBookDao> listTheTeacherAddressBookDao = sysMessageService.findAddressBook(babyId);
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listTheTeacherAddressBookDao);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
}
