package com.vision.edu.web.controller.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.core.base.BaseController;
import com.vision.edu.dto.ClassDTO;
import com.vision.edu.dto.ClassTeacherDTO;
import com.vision.edu.dto.GradeClassDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.dto.TeacherDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.base.BaseGrade;
import com.vision.edu.entity.member.MemClassTeacher;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseBabyService;
import com.vision.edu.service.base.IBaseClassService;
import com.vision.edu.service.base.IBaseGradeService;
import com.vision.edu.service.member.IMemClassTeacherService;
import com.vision.edu.service.system.ISysUserService;

@Controller
@RequestMapping("/class")
public class ClassController extends BaseController{

	@Autowired
	private IBaseClassService baseClassService;
	
	@Autowired
	private ISysUserService sysUserService;
	
	@Autowired
	private IBaseGradeService baseGradeService;
	
	@Autowired
	private IBaseBabyService baseBabyService;
	
	@Autowired
	private IMemClassTeacherService memClassTeacherService;

	/**
	 * 查询班级
	 * @author jiangwangying
	 * @date 2017年7月25日 上午9:22:00
	 * @param className 班级名称
	 * @param schoolName 班级名称
	 * @param startPage 开始页码
	 * @param pageSize 页码
	 */
	@ResponseBody
	@RequestMapping("/findClassByDynamic")
	public JsonResult findClassByDynamic( Integer startPage, Integer pageSize, String schoolId,String gradeId,String vague) {

		
//		gradeId: this.cboGradeId,
//        schoold: this.cboSchoolId,
//        vague: this.vague
		
		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		
		Integer memberType = sysUserDTO.getMemberType(); //用户类型
		
	    if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()) {
		 
	    	schoolId = sysUserDTO.getSchoolId(); // 园校id
		
	    } else if (memberType == EnumMemberType.PTGL.getValue()) {
	
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("无法确认当前用户身份");
			return jsonResult;
		}
		
		Integer total = 0;
		Page<BaseClass> page = new Page<BaseClass>(startPage, pageSize);
		List<ClassDTO> list = baseClassService.findClassByDynamic(page,schoolId, gradeId, vague);
		if (list.size()>0) {
			total = page.getTotal();
            jsonResult.setSuccess(true);
            jsonObject.put("total", total);
    		jsonObject.put("list", list);
    		jsonResult.setObj(jsonObject);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("没有符合条件的数据");
		}
		
		
		return jsonResult;
	}

	
	/**
	 * 绑定年级下拉框
	 * @author jiangwangying
	 * @date 2017年7月25日 上午10:49:20
	 * @param schoolId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findGrade")
	public JsonResult findGrade(String schoolId) {

		JsonResult jsonResult = new JsonResult();
		EntityWrapper<BaseGrade> ew = new EntityWrapper<BaseGrade>();
		ew.setSqlSelect("id,grade_name AS gradeName").where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
		List<BaseGrade> gradeList = baseGradeService.selectList(ew);
	    if (gradeList.size()>0) {
	    	jsonResult.setSuccess(true);
	    	jsonResult.setObj(gradeList);
		}else {
			jsonResult.setMsg("查询不到年级信息");
			jsonResult.setSuccess(false);
		}
	    return jsonResult;
	}
	
	/**
	 * 班级树形下拉框 一级年级、二级班级
	 * @author jiangwangying
	 * @date 2017年8月2日 下午2:23:08
	 * @param schoolId
	 * @return
	 */
  	@ResponseBody
	@RequestMapping("/findCboClassBySidAndGid")
  	public JsonResult findTeacherGroup(String schoolId){

  		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		
		if (StringUtils.isEmpty(schoolId)) {
  			jsonResult.setSuccess(false);
  			return jsonResult;
		} else {
		if (sysUserDTO.getMemberType() == EnumMemberType.YZ.getValue() || sysUserDTO.getMemberType() == EnumMemberType.LS.getValue()) {
			if (!StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
				schoolId = sysUserDTO.getSchoolId();
			}
		 }
	  }
  		
		// 查询一级节点 年级
		List<GradeClassDTO> gradelist = baseGradeService.findGrade(null);
		if(gradelist.size()>0){
			Integer gradelistLen = gradelist.size();
			EntityWrapper<BaseClass> ew1 = null;
			for (int i = 0; i < gradelistLen; i++) {
				ew1 = new EntityWrapper<BaseClass>();
				ew1.where("school_id = {0}", schoolId);
				ew1.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
				ew1.where("grade_id = {0}",gradelist.get(i).getId());
				ew1.setSqlSelect("id,class_name AS className"); // as 后面为实体对应的名称
				// 查询二级节点 班级
				List<BaseClass> classList = baseClassService.selectList(ew1);
				if (classList.size()>0) {
					gradelist.get(i).setChildren((ArrayList<BaseClass>) classList);
				}
			}
			jsonResult.setSuccess(true);
			jsonResult.setObj(gradelist);
		} else {
			jsonResult.setSuccess(false);
		}
     	return jsonResult;
  	}
	
	/**
	 * 根据园校id查询教师 绑定教师下拉框
	 * @author jiangwangying
	 * @date 2017年7月25日 上午11:09:54
	 * @param schoolId
	 */
	@ResponseBody
	@RequestMapping("/findTeacherBySchoolId")
	public JsonResult findTeacherBySchoolId(String schoolId,String classId) {
		JsonResult jsonResult = new JsonResult();
		List<TeacherDTO> list =  sysUserService.findTeacherBySchoolId(schoolId,EnumMemberType.LS.getValue(),classId);
		if (list.size()>0) {
			jsonResult.setSuccess(true);
			jsonResult.setObj(list);
		}else{
			jsonResult.setSuccess(false);
			jsonResult.setMsg("找不到还没做班主任的教师,请新增教师");
		}
		return jsonResult;
	}

	/**
	 * 新增班级
	 * @author jiangwangying
	 * @date 2017年7月31日 下午4:54:54
	 * @param baseClass
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addClass")
	public JsonResult addClass(BaseClass baseClass) {
		
		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || null == sysUserDTO.getUsername()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		
		Integer memberType = sysUserDTO.getMemberType(); //用户类型
		
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()) {
			if (!baseClass.getSchoolId().equals(sysUserDTO.getSchoolId())) {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("所选园校与当前用户所属园校不一样");
				return jsonResult;
			}
		}
		
		String createMan = sysUserDTO.getUsername();
		
		return baseClassService.addClass(baseClass,createMan);

	}
	
	/**
	 * 根据班级id查询班级
	 * 
	 * @author jiangwangying
	 * @date 2017年7月10日 上午9:07:32
	 */
	@ResponseBody
	@RequestMapping("/findClassById")
	public JsonResult findClassById(String classId) {

		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
        Integer memberType = sysUserDTO.getMemberType(); //用户类型
		EntityWrapper<BaseClass> ew = new EntityWrapper<BaseClass>();
		ew.setSqlSelect("school_id AS schoolId,teacher_id AS teacherId,grade_id AS gradeId,class_name AS className,description").where("id = {0}",classId);
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()) {
			if (!StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
				ew.where("school_id = {0}", sysUserDTO.getSchoolId());
			}
		} else if (memberType == EnumMemberType.PTGL.getValue()) {
			
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("没有权限");
			return jsonResult;
		}
		
		List<BaseClass> classList = baseClassService.selectList(ew);
	    if (classList.size()>0) {
	    	jsonResult.setSuccess(true);
	    	jsonResult.setObj(classList.get(0));
		}else {
			jsonResult.setMsg("获取班级信息失败");
			jsonResult.setSuccess(false);
		}
	    return jsonResult;

	}
	
	/**
	 * 编辑班级
	 * @author jiangwangying
	 * @date 2017年7月10日 上午9:07:32
	 */
	@ResponseBody
	@RequestMapping("/editClass")
	public JsonResult editClass(BaseClass baseClass) {

		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
        String updateMan = "";
        if(!StringUtils.isEmpty(sysUserDTO.getUsername())){
        	updateMan = sysUserDTO.getUsername(); 
        }
        
		return baseClassService.editClass(baseClass,updateMan);

	}
	
  	
  	/**
  	 * 删除班级
  	 * @author jiangwangying
  	 * @date 2017年7月25日 下午5:04:48
  	 * @param classIds 班级id集合
  	 * @return
  	 */
  	@ResponseBody
	@RequestMapping("/delClassById")
	public JsonResult delClassById(String classIds) {

  		JsonResult jsonResult = new JsonResult();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		
		String updateMan = sysUserDTO.getUsername();
  		
  		
		return baseClassService.delClassById(classIds,updateMan);

	}
  	
  //--------------------------------------宝贝分班--------------------------------------\\
  	/**
  	 * 查询已分班学生、未分班学生、全部学生
  	 * @author jiangwangying
  	 * @date 2017年8月7日 下午9:59:48
  	 * @param startPage 起始页面
  	 * @param pageSize 每页大小
  	 * @param selType 查询类型
  	 * @param classId 班级id
  	 * @param schoolId 园校id
  	 * @param vague 关键字
  	 * @return
  	 */
  	@ResponseBody
	@RequestMapping("/findBabyToFenBan")
  	public JsonResult findBabyToFenBan(Integer startPage,Integer pageSize,String selType,String schoolId,String classId,String vague){

  		
  		JsonResult jsonResult = new JsonResult();
  		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memeberType = sysUserDTO.getMemberType() ;
		if (memeberType == EnumMemberType.YZ.getValue() || memeberType == EnumMemberType.LS.getValue()) {
			schoolId = sysUserDTO.getSchoolId();
		}
		Integer total = 0;
        Page<BaseBaby> page = new Page<BaseBaby>(startPage, pageSize);
		List<BaseBaby> list = baseBabyService.findBabyToFenBan(page,selType,schoolId, classId, vague);
		if (list.size()>0) {
			total = page.getTotal();
			jsonResult.setSuccess(true);
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
	 * 绑定查询页面班级下拉框
	 * @author jiangwangying
	 * @date 2017年7月25日 上午10:49:20
	 * @param schoolId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findCboClass")
	public JsonResult findCboClass(String schoolId) {

		JsonResult jsonResult = new JsonResult();
  		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memeberType = sysUserDTO.getMemberType() ;
		EntityWrapper<BaseClass> ew = new EntityWrapper<BaseClass>();
		ew.setSqlSelect("id,class_name AS className").where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
		if (memeberType == EnumMemberType.YZ.getValue() || memeberType == EnumMemberType.LS.getValue()) {
			if (!StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
				schoolId = sysUserDTO.getSchoolId();
				ew.where("school_id = {0}", schoolId);
			}
		}
		List<BaseClass> classList = baseClassService.selectList(ew);
	    if (classList.size()>0) {
	    	jsonResult.setSuccess(true);
	    	jsonResult.setObj(classList);
		}else {
			jsonResult.setMsg("查询不到班级信息");
			jsonResult.setSuccess(false);
		}
	    return jsonResult;
	}
	
	
	/**
	 * 绑定新增页面班级下拉框
	 * @author jiangwangying
	 * @date 2017年7月25日 上午10:49:20
	 * @param schoolId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findCboClassBySchoolId")
	public JsonResult findCboClassBySchoolId(String schoolIds) {

		JsonResult jsonResult = new JsonResult();
  		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		
		if (StringUtils.isEmpty(schoolIds)) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("出错啦");
			return jsonResult;
		}
		
		String[] strSchoolId = schoolIds.split(",");
		Integer strSchoolIdLen = strSchoolId.length;
		
		Integer memberType = sysUserDTO.getMemberType();
  	    if (memberType == EnumMemberType.LS.getValue() || memberType == EnumMemberType.YZ.getValue()) {
			for (int i = 0; i < strSchoolIdLen; i++) {
				if (!strSchoolId[i].equals(sysUserDTO.getSchoolId())) {
					jsonResult.setSuccess(false);
					jsonResult.setMsg("出错啦");
					return jsonResult;
				}
			}
		}
  	    if (memberType == EnumMemberType.PTGL.getValue()) {
  	    	for (int i = 0; i < strSchoolIdLen; i++) {
  	    		for (int j = 0; j < strSchoolIdLen; j++) {
				   if (!strSchoolId[i].equals(strSchoolId[j])) {
					   jsonResult.setSuccess(false);
						jsonResult.setMsg("只能操作同一学校里面的哦");
						return jsonResult;
				   }
			    }
  	        }
        }
		
		EntityWrapper<BaseClass> ew = new EntityWrapper<BaseClass>();
		ew.setSqlSelect("id,class_name AS className").where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
		ew.where("school_id = {0}", strSchoolId[0]);
		List<BaseClass> classList = baseClassService.selectList(ew);
	    if (classList.size()>0) {
	    	jsonResult.setSuccess(true);
	    	jsonResult.setObj(classList);
		}else {
			jsonResult.setMsg("还没新增有班级吖");
			jsonResult.setSuccess(false);
		}
	    return jsonResult;
	}
	
	/**
	 * 对选中的学生进行分班
	 * @author jiangwangying
	 * @date 2017年7月25日 上午10:49:20
	 * @param schoolId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toFenBan")
	public JsonResult toFenBan(String fenBanClassId,String babyIds,Integer teamValue) {

		JsonResult jsonResult = new JsonResult();
  		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || StringUtils.isEmpty(sysUserDTO.getUsername())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		
		return baseClassService.toFenBan(fenBanClassId,babyIds,sysUserDTO,teamValue);
	}
	
	/**
	 * 对已分班的学生进行移除
	 * @author jiangwangying
	 * @date 2017年8月5日 上午10:00:56
	 * @param babyIds 宝贝id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toRemoveBaby")
	public JsonResult toRemoveBaby(String babyIds) {
		JsonResult jsonResult = new JsonResult();
  		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || StringUtils.isEmpty(sysUserDTO.getUsername())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		} 
		String schoolId = "";
		if (sysUserDTO.getMemberType() == EnumMemberType.LS.getValue() ||sysUserDTO.getMemberType() ==  EnumMemberType.YZ.getValue()) {
			if (StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("检测到当前园长没有对应的园校");
				return jsonResult;
			}
			schoolId = sysUserDTO.getSchoolId();
		}
		String updateMan  = sysUserDTO.getUsername();
		return baseClassService.toRemoveBaby(babyIds,schoolId,updateMan);
	}
	
	/**
	 * 刷新班级人数
	 * @author jiangwangying
	 * @date 2017年8月5日 上午10:01:33
	 * @param babyIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/refreshBabyNum")
	public JsonResult refreshBabyNum() {

		JsonResult jsonResult = new JsonResult();
  		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || StringUtils.isEmpty(sysUserDTO.getUsername())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		} 
		String schoolId = "";
		if (sysUserDTO.getMemberType() == EnumMemberType.LS.getValue() ||sysUserDTO.getMemberType() ==  EnumMemberType.YZ.getValue()) {
			if (StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("检测到当前园长没有对应的园校");
				return jsonResult;
			}
			schoolId = sysUserDTO.getSchoolId();
		}
		String updateMan  = sysUserDTO.getUsername();
		return baseClassService.refreshBabyNum(schoolId,updateMan);
	}
	
	
	//--------------------------------------宝贝分班--------------------------------------\\
	
	
	
	//--------------------------------------教师分班--------------------------------------\\
	/**
	 * 查询教师 已分班、未分班、全部
	 * @author jiangwangying
	 * @date 2017年8月1日 上午10:49:06
	 * @param startPage
	 * @param pageSize
	 * @param selType
	 * @param name
	 * @param classId
	 * @return
	 */
  	@ResponseBody
	@RequestMapping("/findClassTeacher")
  	public JsonResult findClassTeacher(Integer startPage,Integer pageSize,Integer selType,String schoolId,String classId,String vague){
  		
  		JsonResult jsonResult = new JsonResult();
  		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType()) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		Integer memberType = sysUserDTO.getMemberType() ;
		
		if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()) {
		    if (StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
		    	jsonResult.setSuccess(false);
				jsonResult.setMsg("无法确认用户所属学校信息");
				return jsonResult;
			}
			schoolId = sysUserDTO.getSchoolId();
			memberType = EnumMemberType.LS.getValue();
		} else if (memberType == EnumMemberType.PTGL.getValue()) {
			memberType = EnumMemberType.LS.getValue();
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("无法确认用户类型");
			return jsonResult;
		}
      
		Integer total = 0;
        Page<ClassTeacherDTO> page = new Page<ClassTeacherDTO>(startPage, pageSize);
		List<ClassTeacherDTO> list = sysUserService.findClassTeacher(page,schoolId, classId, selType, vague, memberType);
		
		// 装载未分组的老师
		List<ClassTeacherDTO> list1= new ArrayList<ClassTeacherDTO>();
		if (selType == 2) { // 对未分班的且在班级教师表删除标记为1 教师进行格式化
			Integer Leng = list.size();
			Integer index = 0;
			Integer leng1 = Leng;
			for (int i = 0; i < Leng; i++) {
				if (null != list.get(i).getDeleteFlag() && list.get(i).getDeleteFlag() == EnumDeleteFlag.YSC.getValue()) {
					index += i;
					EntityWrapper<MemClassTeacher> memClassTeacherEW = new EntityWrapper<MemClassTeacher>();
					memClassTeacherEW.where("member_id = {0} and delete_flag = {1} ", list.get(i).getId(),EnumDeleteFlag.WSC.getValue());
					Integer count = memClassTeacherService.selectCount(memClassTeacherEW);
					if (count == 0) {
						list.get(i).setDeleteFlag(EnumDeleteFlag.WSC.getValue());
						list.get(i).setClassName("未分班");
						list.get(i).setGradeName("分班显示");
						list.get(i).setMemClassTeacherId(null);
						list1.add(list.get(i));
					} 
				} else {
					list1.add(list.get(i));
				}
			}
		}
		if (selType == 2) {
			if (list1.size()>0) {
				total = list1.size();
				jsonObject.put("total", total);
				jsonObject.put("list", list1);
				jsonResult.setObj(jsonObject);
				jsonResult.setSuccess(true);
			} else {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("没有符合条件的数据");
			}
		} else {
			if (list.size()>0) {
				total = page.getTotal();
				jsonObject.put("total", total);
				jsonObject.put("list", list);
				jsonResult.setObj(jsonObject);
				jsonResult.setSuccess(true);
			} else {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("没有符合条件的数据");
			}
		}
		
        return jsonResult;
		
  	}
  	/**
	 * 对选中的教师进行分班
	 * @author jiangwangying
	 * @date 2017年7月25日 上午10:49:20
	 * @param schoolId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selTeachersToFenBan")
	public JsonResult selTeachersToFenBan(String fenBanClassId,String teacherIds) {

		JsonResult jsonResult = new JsonResult();
  		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || StringUtils.isEmpty(sysUserDTO.getUsername())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		
		return sysUserService.selTeachersToFenBan(fenBanClassId,teacherIds,sysUserDTO);
	}
	
	/**
	 * 对分班的教师进行移除
	 * @author jiangwangying
	 * @date 2017年8月5日 下午8:43:21
	 * @param memClassTeacherIds 班级教师id
	 * @param schoolIds 园校id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toRemoveTeacher")
	public JsonResult toRemoveTeacher(String memClassTeacherIds,String schoolIds,String teacherIds) {

		JsonResult jsonResult = new JsonResult();
  		JSONObject jsonObject = new JSONObject();
		SysUserDTO sysUserDTO = super.getUserInfo();
		if (null == sysUserDTO || null == sysUserDTO.getMemberType() || StringUtils.isEmpty(sysUserDTO.getUsername())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("获取用户信息失败,请重新登录");
			return jsonResult;
		}
		if (StringUtils.isEmpty(schoolIds) || StringUtils.isEmpty(memClassTeacherIds)) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("请选择要移除的已经分班的教师");
			return jsonResult;
		}
		String[] strSchoolId = schoolIds.split(",");
		Integer leng = strSchoolId.length;
		
		
		if (sysUserDTO.getMemberType() == EnumMemberType.LS.getValue() ||sysUserDTO.getMemberType() ==  EnumMemberType.YZ.getValue()) {
			if (StringUtils.isEmpty(sysUserDTO.getSchoolId())) {
				jsonResult.setSuccess(false);
				jsonResult.setMsg("检测到当前园长没有对应的园校");
				return jsonResult;
			}
			for (int i = 0; i < leng; i++) {
				if (!strSchoolId[i].equals(sysUserDTO.getSchoolId())) {
					jsonResult.setSuccess(false);
					jsonResult.setMsg("出错啦");
					return jsonResult;
				}
			}
		}
		
		for (int i = 0; i < leng; i++) {
			for (int j = 0; j < leng; j++) {
				if (!strSchoolId[i].equals(strSchoolId[j])) {
					jsonResult.setSuccess(false);
					jsonResult.setMsg("只能移除同一个学校里的哦");
					return jsonResult;
				}
			}
		}
		
		String updateMan  = sysUserDTO.getUsername();
		return baseClassService.toRemoveTeacher(memClassTeacherIds,updateMan,teacherIds);
	}
	
  //--------------------------------------教师分班--------------------------------------\\
}
