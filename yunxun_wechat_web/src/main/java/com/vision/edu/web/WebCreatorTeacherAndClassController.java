package com.vision.edu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vision.edu.dto.BaseSignRecordDto;
import com.vision.edu.dto.MemClassCircleDto;
import com.vision.edu.dto.MemClassTeacherDto;
import com.vision.edu.dto.MemLeaveRecordDto;
import com.vision.edu.dto.ResourceCollectionDto;
import com.vision.edu.dto.SysUserDto;
import com.vision.edu.dto.TakeClassCollectionDto;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.member.MemClassCircle;
import com.vision.edu.entity.member.MemDynamic;
import com.vision.edu.entity.member.MemLeaveRecord;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumDynamicType;
import com.vision.edu.enums.EnumRecordType;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseBabyService;
import com.vision.edu.service.base.IBaseSignRecordService;
import com.vision.edu.service.member.IMemClassCircleService;
import com.vision.edu.service.member.IMemClassTeacherService;
import com.vision.edu.service.member.IMemDynamicService;
import com.vision.edu.service.member.IMemLeaveRecordService;
import com.vision.edu.service.system.ISysUserService;
import com.vision.edu.wechat.service.WeixinService;

/**
 * 和班【教师端】
 * @author lichenglong
 * @date 2017年7月23日 下午4:11:37
 * @version 1.0
 */
@Controller
@RequestMapping("/webCreatorTeacherAndClass")
public class WebCreatorTeacherAndClassController {


	@Autowired
	private IMemClassCircleService memClassCircleService;//注入班级圈IMemClassCircleService
	@Autowired
	private IMemDynamicService memDynamicService;//注入动态表IMemDynamicService
	@Autowired
	private IMemClassTeacherService memClassTeacherService;//注入班级教师IMemClassTeacherService
	@Autowired
	private IBaseBabyService baseBabyService;//注入宝贝IBaseBabyService
	@Autowired
	private IMemLeaveRecordService memLeaveRecordService;//注入请假记录IMemLeaveRecordService
	@Autowired
	private ISysUserService sysUserService;//注入后台用户ISysUserService
	@Autowired
	private IBaseSignRecordService baseSignRecordService;//注入签到记录IBaseSignRecordService
	@Autowired
	private WeixinService weixinService;
	
	/**
	 * 主页
	 * @author lichenglong
	 * @date 2017年7月23日 下午4:15:29
	 */
	@ResponseBody
	@RequestMapping("/principalSheet")
	public void principalSheet(){
		System.out.println("12342");
	}

	/**
	 * 发布动态
	 * @author lichenglong
	 * @return 
	 * @throws IOException 
	 * @date 2017年7月23日 下午4:14:31
	 */
	@ResponseBody
	@RequestMapping("/dynamic")
	public JsonResult  releaseTheDynamic(HttpServletRequest request) throws IOException{
		//新增班级圈数据
		String schoolId = request.getParameter("schoolId");//园校ID
		String classId = request.getParameter("classId");//班级id
		String createMamId = request.getParameter("createMamId");//发送人
		String imgs = request.getParameter("imgs");//发送人
		String content = request.getParameter("content");//内容
		JsonResult jsonResult = new JsonResult();
		System.out.println("schoolId="+schoolId+",classId="+classId+",createMamId="+createMamId+",imgs="+imgs+",content="+content);
		if(schoolId != null && classId != null && createMamId != null && imgs != null && content != null){
			String imgStrs = "";
			if(imgs.indexOf(",") >= 0){
				for(String img:imgs.split(",")){
					imgStrs = imgStrs + weixinService.uploadImage(img, "class") + ",";
				}
				imgStrs = imgStrs.substring(0, imgStrs.length() - 1);
			}else{
				imgStrs = weixinService.uploadImage(imgs, "class");
			}
			System.out.println(imgStrs);
			MemClassCircle memClassCircle = new MemClassCircle();
			memClassCircle.setSchoolId(schoolId);
			memClassCircle.setClassId(classId);
			memClassCircle.setLableId(EnumDynamicType.LS.getValue()+"");
			memClassCircle.setImgs(imgStrs);
			memClassCircle.setContent(content);
			memClassCircle.setCommentNum(0);//评论数
			memClassCircle.setPointCount(0);//点赞数
			memClassCircle.setBrowseCount(0);//浏览数
			memClassCircle.setCreateTime(new Date());
			memClassCircle.setCreateMamId(createMamId);
			memClassCircle.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			boolean boolClassCircle = memClassCircleService.insert(memClassCircle);
			if(boolClassCircle){
				//新增状态表数据
				MemDynamic memDynamic = new MemDynamic();
				memDynamic.setResourcesId(memClassCircle.getId());//资源ID
				memDynamic.setResourcesType(EnumResourceType.DT.getValue());
				memDynamic.setSchoolId(schoolId);
				memDynamic.setClassId(classId);
				memDynamic.setBrowseCount(0);//浏览数
				memDynamic.setPointCount(0);//点赞数
				memDynamic.setCreateTime(new Date());
				memDynamic.setCreateMamId(createMamId);
				memDynamic.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
				boolean boolDynamic = memDynamicService.insert(memDynamic);
				if(boolDynamic){
					jsonResult.setMsg("ok");
				}
			}
		}
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 发布菜谱
	 * @author lichenglong
	 * @date 2017年7月25日 上午11:51:16
	 */
	public void releaseTheMenu(){
		
	}
	
	/**
	 * 接送报播
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月25日 上午11:52:40
	 */
	@ResponseBody
	@RequestMapping("/transfersToSow")
	public JsonResult transfersToSow(HttpServletRequest request){
		String memberId = request.getParameter("sysUserId");//教师id
		JsonResult jsonResult = new JsonResult();
		//根据班级教师表中的教师id查询出班级id
		List<MemClassTeacherDto> listMemClassTeacherDto = memClassTeacherService.findClassInformationQuery(memberId, EnumDeleteFlag.WSC.getValue());
		for (MemClassTeacherDto memClassTeacherDto : listMemClassTeacherDto) {
			List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordService.findTransportSituation(memClassTeacherDto.getClassId(), EnumRecordType.JR.getValue(),  EnumDeleteFlag.WSC.getValue());
			jsonResult.setObj(listBaseSignRecordDto);
		}
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	//EnumRecordType 0-接人，1-送人，2-补签
	//EnumRecordState 0-待签，1-已签，2-待接，3-已接，4-补签，5-缺勤，6-请假
	
	/**
	 * 班级圈
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月25日 上午11:56:26
	 */
	@ResponseBody
	@RequestMapping("/classRing")
	public JsonResult classRing(HttpServletRequest request){
		String memberId = request.getParameter("sysUserId");//教师id
		JsonResult jsonResult = new JsonResult();
		//根据班级教师表中的教师id查询出班级id
		List<MemClassTeacherDto> listMemClassTeacherDto = memClassTeacherService.findClassInformationQuery(memberId, EnumDeleteFlag.WSC.getValue());
		for (MemClassTeacherDto memClassTeacherDto : listMemClassTeacherDto) {
			//通过班级id查询出班级宝贝签到情况
			List<MemClassCircleDto> list = new ArrayList<MemClassCircleDto>();
			List<MemClassCircleDto> listMemClassCircleDto = memClassCircleService.findClassRingDynamic(memClassTeacherDto.getClassId(), EnumResourceType.DT.getValue(), EnumDeleteFlag.WSC.getValue());
			for (MemClassCircleDto memClassCircleDto : listMemClassCircleDto) {
				MemClassCircleDto data = new MemClassCircleDto();
				data.setMemMemberHeadPortrait(memClassCircleDto.getMemMemberHeadPortrait());
				data.setMemMemberName(memClassCircleDto.getMemMemberName());
				data.setSysUserHeadPortrait(memClassCircleDto.getSysUserHeadPortrait());
				data.setSysUserName(memClassCircleDto.getSysUserName());
				data.setCircleDutiesName(memClassCircleDto.getCircleDutiesName());
				data.setSchoolId(memClassCircleDto.getSchoolId());
				data.setClassId(memClassCircleDto.getClassId());
				data.setLableId(memClassCircleDto.getLableId());
				data.setImgs(memClassCircleDto.getImgs());
				data.setContent(memClassCircleDto.getContent());
				data.setCommentNum(memClassCircleDto.getCommentNum());
				data.setPointCount(memClassCircleDto.getPointCount());
				data.setBrowseCount(memClassCircleDto.getBrowseCount());
				data.setCreateTime(memClassCircleDto.getCreateTime());
				data.setCreateMamId(memClassCircleDto.getCreateMamId());
				data.setResourcesId(memClassCircleDto.getResourcesId());
				
				ArrayList<ResourceCollectionDto> listTwo = new ArrayList<ResourceCollectionDto>();
				ResourceCollectionDto resourceCollection = null;
				String str = memClassCircleDto.getImgs();
				String[] strs=str.split(",");
				for (int i = 0; i < strs.length; i++) {
					String string = strs[i];
					System.out.println(string);
					resourceCollection = new ResourceCollectionDto();
					resourceCollection.setUniformResourceLocator(strs[i].toString());
					listTwo.add(resourceCollection);
				}
				data.setListResourceCollectionDto(listTwo);
				list.add(data);
			}
			jsonResult.setObj(list);
		}
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 考勤补签
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月25日 上午11:57:26
	 */
	@ResponseBody
	@RequestMapping("/attendanceRetroactive")
	public JsonResult attendanceRetroactive(HttpServletRequest request){
		String memberId = request.getParameter("sysUserId");//教师id
		JsonResult jsonResult = new JsonResult();
		//根据班级教师表中的教师id查询出班级id
		List<MemClassTeacherDto> listMemClassTeacherDto = memClassTeacherService.findClassInformationQuery(memberId, EnumDeleteFlag.WSC.getValue());
		for (MemClassTeacherDto memClassTeacherDto : listMemClassTeacherDto) {
			//通过班级id查询出班级宝贝签到情况
			List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordService.findAttendanceSignIn(memClassTeacherDto.getClassId(),EnumResourceType.QD.getValue() ,EnumDeleteFlag.WSC.getValue());
			jsonResult.setObj(listBaseSignRecordDto);
		}
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 班级宝贝接送情况集合
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月26日 下午6:18:23
	 */
	@ResponseBody
	@RequestMapping("/takeClassCollection")
	public JsonResult takeClassCollection(HttpServletRequest request){
		String memberId = request.getParameter("sysUserId");//教师id
		JsonResult jsonResult = new JsonResult();
		int campOn = 0;//待接
		int received = 0;//已接
		int PeopleNum = 0;//班级总人数
		String className = "";//班级名称
		List<TakeClassCollectionDto> listTakeClassCollectionDto = new ArrayList<TakeClassCollectionDto>();
		TakeClassCollectionDto takeClassCollectionDto = new TakeClassCollectionDto();
		//根据班级教师表中的教师id查询出班级id
		List<MemClassTeacherDto> listMemClassTeacherDto = memClassTeacherService.findClassInformationQuery(memberId, EnumDeleteFlag.WSC.getValue());
		for (MemClassTeacherDto memClassTeacherDto : listMemClassTeacherDto) {
			List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordService.findTransportSituation(memClassTeacherDto.getClassId(), EnumRecordType.JR.getValue(),  EnumDeleteFlag.WSC.getValue());
			System.out.println(listBaseSignRecordDto);
			for (BaseSignRecordDto baseSignRecordDto : listBaseSignRecordDto) {
				if(baseSignRecordDto.getSignStatus() == 2){
					campOn = campOn + 1;
				}
				if(baseSignRecordDto.getSignStatus() == 3){
					received = received + 1;
				}
				PeopleNum = baseSignRecordDto.getPeopleNum();
				className = baseSignRecordDto.getClassName();
			}
			takeClassCollectionDto.setCampOn(campOn);
			takeClassCollectionDto.setReceived(received);
			takeClassCollectionDto.setPeopleNum(PeopleNum);
			takeClassCollectionDto.setClassName(className);
			takeClassCollectionDto.setListBaseSignRecordDto(listBaseSignRecordDto);
			listTakeClassCollectionDto.add(takeClassCollectionDto);
		}
		System.out.println(listTakeClassCollectionDto);
		jsonResult.setObj(listTakeClassCollectionDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 考勤补签
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月25日 下午9:24:25
	 */
	@ResponseBody
	@RequestMapping("/attendanceRetroactive1")
	public JsonResult attendanceRetroactive1(HttpServletRequest request){
		//根据签到id查询出个人签到的信息
		String signRecordId = request.getParameter("signRecordId");//签到id
		List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordService.findAttendanceRetroactive(signRecordId, EnumDeleteFlag.WSC.getValue());
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listBaseSignRecordDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 绑定请假审批数据
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月25日 上午11:58:28
	 */
	@ResponseBody
	@RequestMapping("/askForLeaveApproval")
	public JsonResult askForLeaveApproval(HttpServletRequest request){
		String addresseeId = request.getParameter("sysUserId");//教师id
		List<MemLeaveRecordDto> listMemLeaveRecordDto = memLeaveRecordService.findAskForLeaveApproval(addresseeId, EnumDeleteFlag.WSC.getValue());
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listMemLeaveRecordDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 根据请假记录id查询出请假信息详情
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月25日 下午5:04:04
	 */
	@ResponseBody
	@RequestMapping("/leaveTheDetails")
	public JsonResult leaveTheDetails(HttpServletRequest request){
		String leaveRecordId = request.getParameter("leaveRecordId");//教师id
		List<MemLeaveRecordDto> listMemLeaveRecordDto = memLeaveRecordService.findleaveTheDetails(leaveRecordId, EnumDeleteFlag.WSC.getValue());
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listMemLeaveRecordDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 请假审批
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月25日 下午5:37:32
	 */
	@ResponseBody
	@RequestMapping("/examineAndApprove")
	public JsonResult examineAndApprove(HttpServletRequest request){
		String id = request.getParameter("id");//请假审批id
		String sysUserId = request.getParameter("checkMan");//教师id
		String checkFlag = request.getParameter("checkFlag");//请假类型
		System.out.println("id="+id+",sysUserId="+sysUserId+",checkFlag="+checkFlag);
		JsonResult jsonResult = new JsonResult();
		List<SysUserDto> listSysUserDto = sysUserService.findMainPage(sysUserId, EnumDeleteFlag.WSC.getValue());
		System.out.println(listSysUserDto);
		for (SysUserDto sysUserDto : listSysUserDto) {
			MemLeaveRecord memLeaveRecord = new MemLeaveRecord();
			memLeaveRecord.setId(id);
			memLeaveRecord.setCheckTime(new Date());
			memLeaveRecord.setCheckMan(sysUserDto.getMemberName());
			memLeaveRecord.setCheckFlag(Integer.parseInt(checkFlag));
			boolean boolLeaveRecord =  memLeaveRecordService.updateById(memLeaveRecord);
			if(boolLeaveRecord){
				jsonResult.setMsg("ok");
			}
		}
		return jsonResult;
	}
	
	/**
	 * 我的班级
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月25日 上午11:59:18
	 */
	@ResponseBody
	@RequestMapping("/myClass")
	public JsonResult myClass(HttpServletRequest request){
		String memberId = request.getParameter("sysUserId");//教师id
		//根据教师id查询班级信息
		List<MemClassTeacherDto> listMemClassTeacherDto = memClassTeacherService.findClassInformationQuery(memberId, EnumDeleteFlag.WSC.getValue());
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listMemClassTeacherDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 根据班级id查询全班宝贝信息
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月25日 下午2:54:52
	 */
	@ResponseBody
	@RequestMapping("/babyOfTheClassInformation")
	public JsonResult babyOfTheClassInformation(HttpServletRequest request){
		String classId = request.getParameter("classId");//班级id
		EntityWrapper<BaseBaby> ewBaby = new EntityWrapper<BaseBaby>();
		ewBaby.where("base_baby.class_id = {0}",classId);
		ewBaby.setSqlSelect("base_baby.id,base_baby.class_id AS classId,base_baby.name,base_baby.head_portrait AS headPortrait");
		List<BaseBaby> listMemClassTeacher = baseBabyService.selectList(ewBaby);
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listMemClassTeacher);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	
}
