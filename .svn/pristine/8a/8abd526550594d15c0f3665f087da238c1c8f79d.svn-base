package com.vision.edu.service.base.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.ClassDTO;
import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.base.BaseGrade;
import com.vision.edu.entity.base.BaseSign;
import com.vision.edu.entity.member.MemBabyTeam;
import com.vision.edu.entity.member.MemClassTeacher;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.enums.EnumTeam;
import com.vision.edu.mapper.base.BaseBabyMapper;
import com.vision.edu.mapper.base.BaseClassMapper;
import com.vision.edu.mapper.base.BaseSignMapper;
import com.vision.edu.mapper.member.MemBabyTeamMapper;
import com.vision.edu.mapper.member.MemClassTeacherMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseClassService;

/**
 * <p>
 * 班级 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
@Transactional
public class BaseClassServiceImpl extends ServiceImpl<BaseClassMapper, BaseClass> implements IBaseClassService {
	
	@Autowired
	private BaseClassMapper baseClassMapper;
	
	@Autowired 
	BaseBabyMapper baseBabyMapper;
	
	@Autowired
	BaseSignMapper baseSignMapper;
	
	@Autowired
	MemBabyTeamMapper memBabyTeamMapper;
	
	@Autowired
	MemClassTeacherMapper memClassTeacherMapper;
	
	
	/**
	 * 动态查询班级
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param gradeId 年级id
	 * @param vague 关键字
	 * @return=
	 */
	public List<ClassDTO> findClassByDynamic(Pagination page,String schoolId,String gradeId,String vague) {
		
		return baseClassMapper.findClassByDynamic( page,schoolId, gradeId, vague);
	}
	
	/**
	 * 新增班级
	 * @author jiangwangying
	 * @date 2017年7月25日 下午2:28:18
	 * @param baseClass 班级实体
	 * @param createMan 创建人
	 * @return
	 */
	public JsonResult addClass(BaseClass baseClass, String createMan){
		
		JsonResult jsonResult = new JsonResult();
		Integer result = 0 ;
		if(StringUtils.isEmpty(baseClass.getSchoolId()) || StringUtils.isEmpty(baseClass.getGradeId()) || StringUtils.isEmpty(baseClass.getClassName().trim()) || StringUtils.isEmpty(createMan)){
			jsonResult.setSuccess(false);
			jsonResult.setMsg("空值啦");
			return jsonResult;
		}
		baseClass.setCreateTime(new Date());
		baseClass.setCreateMam(createMan);
		baseClass.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		result += baseClassMapper.insert(baseClass);
		
		if (!StringUtils.isEmpty(baseClass.getTeacherId()) && !StringUtils.isEmpty(baseClass.getId())) {
			
			String teacherId = baseClass.getTeacherId();
			String classId = baseClass.getId();
			EntityWrapper<MemClassTeacher> ew = new EntityWrapper<MemClassTeacher>();
			ew.where("class_id = {0}", classId);
			ew.where("member_id = {0}", teacherId);
			ew.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
			Integer count = memClassTeacherMapper.selectCount(ew);
			if (count == 0) {
				MemClassTeacher memClassTeacher = new MemClassTeacher();
				memClassTeacher.setClassId(classId);
				memClassTeacher.setMemberId(teacherId);
				memClassTeacher.setCreateMam(createMan);
				memClassTeacher.setCreateTime(new Date());
				memClassTeacher.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
				memClassTeacherMapper.insert(memClassTeacher);
			}
		}

		if (result>0) {
			jsonResult.setSuccess(true);
		}else{
			jsonResult.setSuccess(false);
			jsonResult.setMsg("新增失败啦");
		}
		return jsonResult;
	}
	
	/**
	 * 修改班级
	 * @author jiangwangying
	 * @date 2017年7月25日 下午2:45:15
	 * @param baseClass 班级实体
	 * @param updateMan 修改人
	 * @return
	 */
	public JsonResult editClass(BaseClass baseClass, String updateMan){
		
		JsonResult jsonResult = new JsonResult();
		Integer result = 0;
		
		if(StringUtils.isEmpty(baseClass.getId()) || StringUtils.isEmpty(baseClass.getGradeId()) || StringUtils.isEmpty(baseClass.getClassName().trim()) || StringUtils.isEmpty(updateMan)){
			
			jsonResult.setSuccess(false);
			jsonResult.setMsg("空值啦");
			return jsonResult;
		}
		
		EntityWrapper<BaseClass> ew = new EntityWrapper<BaseClass>();
		ew.setSqlSelect("teacher_id AS teacherId");
		ew.where("id = {0}", baseClass.getId());
		ew.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
		List<BaseClass> OldClassList = baseClassMapper.selectList(ew);
		
		if (OldClassList.size()==0) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("修改失败、班级已经被删除");
			return jsonResult;
		}
		//判断是否跟换班主任  更换班主任就移除旧的班主任 添加新的班主任
		
		if (!StringUtils.isEmpty(OldClassList.get(0).getTeacherId())) {
			//原先有班主任
			
			if (!StringUtils.isEmpty(baseClass.getTeacherId()) && !baseClass.getTeacherId().equals("")) {
				//判断当前选择的班主任不为空
				
				//原来的班主任和现在选择的班主任不一样     从班级教师表里面移除旧的   插入新的
				if (!OldClassList.get(0).getTeacherId().equals(baseClass.getTeacherId())) {
					
					//移除旧的
					EntityWrapper<MemClassTeacher> ew1 = new EntityWrapper<MemClassTeacher>();
					ew1.where("member_id = {0}", OldClassList.get(0).getTeacherId());
					ew1.where("class_id = {0}", baseClass.getId());
					ew1.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
					List<MemClassTeacher> OldMemClassTealist = memClassTeacherMapper.selectList(ew1);
					if (OldMemClassTealist.size() == 1) {
						OldMemClassTealist.get(0).setDeleteFlag(EnumDeleteFlag.YSC.getValue());
						OldMemClassTealist.get(0).setUpdateMan(updateMan);
						OldMemClassTealist.get(0).setUpdateTime(new Date());
						memClassTeacherMapper.updateById(OldMemClassTealist.get(0));
					}
				} 
			} else {
				//原先有班主任 现在没了
				//移除旧的
				EntityWrapper<MemClassTeacher> ew1 = new EntityWrapper<MemClassTeacher>();
				ew1.where("member_id = {0}", OldClassList.get(0).getTeacherId());
				ew1.where("class_id = {0}", baseClass.getId());
				ew1.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
				List<MemClassTeacher> OldMemClassTealist = memClassTeacherMapper.selectList(ew1);
				if (OldMemClassTealist.size() == 1) {
					OldMemClassTealist.get(0).setDeleteFlag(EnumDeleteFlag.YSC.getValue());
					OldMemClassTealist.get(0).setUpdateMan(updateMan);
					OldMemClassTealist.get(0).setUpdateTime(new Date());
					memClassTeacherMapper.updateById(OldMemClassTealist.get(0));
				}
			}
		} 
		
        baseClass.setSchoolId(null);//为 null 则不作修改
		baseClass.setUpdateMan(updateMan);
		baseClass.setUpdateTime(new Date());
		result += baseClassMapper.updateById(baseClass);
		
		// 判断现在的班主任 是否已经分配到该班  没有分配到的就插入
       if (!StringUtils.isEmpty(baseClass.getTeacherId()) && !StringUtils.isEmpty(baseClass.getId())) {
			String teacherId = baseClass.getTeacherId();
			String classId = baseClass.getId();
			EntityWrapper<MemClassTeacher> ew1 = new EntityWrapper<MemClassTeacher>();
			ew1.where("class_id = {0}", classId);
			ew1.where("member_id = {0}", teacherId);
			ew1.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
			Integer count = memClassTeacherMapper.selectCount(ew1);
			if (count == 0) {
				MemClassTeacher memClassTeacher = new MemClassTeacher();
				memClassTeacher.setClassId(classId);
				memClassTeacher.setMemberId(teacherId);
				memClassTeacher.setCreateMam(updateMan);
				memClassTeacher.setCreateTime(new Date());
				memClassTeacher.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
				memClassTeacherMapper.insert(memClassTeacher);
			}
		}
	    if (result > 0) {
			jsonResult.setSuccess(true);
		}else{
			jsonResult.setSuccess(false);
			jsonResult.setMsg("修改失败!");
		}
	    return jsonResult;
	}
	
	/**
	 * 删除班级
	 * @author jiangwangying
	 * @date 2017年7月25日 下午5:05:12
	 * @param classIds 班级id集合
	 * @param updateMan 修改人
	 * @return
	 */
	public JsonResult delClassById(String classIds, String updateMan){
		
		JsonResult jsonResult = new JsonResult();
		Integer result = 0;
		
		if(StringUtils.isEmpty(classIds) || StringUtils.isEmpty(updateMan.trim())){
			jsonResult.setSuccess(false);
			jsonResult.setMsg("空值啦");
			return jsonResult;
		}
		String[] ids = classIds.split(",");
		Integer idsLength = ids.length;
		BaseClass baseClass = new BaseClass();
		for (int i = 0; i < idsLength; i++) {
			baseClass.setId(ids[i]);
			baseClass.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			baseClass.setUpdateMan(updateMan);
			baseClass.setUpdateTime(new Date());
			result += baseClassMapper.updateById(baseClass);
			if (result == idsLength) {
				jsonResult.setSuccess(true);
			}else{
				jsonResult.setSuccess(false);
				jsonResult.setMsg("删除失败");
			}
		}
		 return jsonResult;
	}
	
	/**
	 * 进行分班
	 * @author jiangwangying
	 * @date 2017年7月26日 上午1:25:22
	 * @param fenBanClassId 班级id
	 * @param babyIds 宝贝id集合
	 * @param teamValue 学期
	 * @param updateMan 修改人
	 * @return
	 */
	public JsonResult toFenBan(String fenBanClassId, String babyIds, SysUserDTO sysUserDTO,Integer teamValue){
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.setSuccess(false);
		int result = 0;
		if (StringUtils.isEmpty(fenBanClassId) || StringUtils.isEmpty(babyIds) || null == teamValue) {
			jsonResult.setMsg("空值");
			return jsonResult;
		}
		
		
		if (teamValue != EnumTeam.LAST.getValue() && teamValue != EnumTeam.NEXT.getValue()) {
			jsonResult.setMsg("学期值出错啦");
			return jsonResult;
		}
		
		
		String[] strBabyId = babyIds.split(",");
		int strBabyIdLength = strBabyId.length;
		
		// 判断宝贝所属的园校和班级所属园校是否一样
		EntityWrapper<BaseClass> ewC = new EntityWrapper<BaseClass>();
		ewC.setSqlSelect("school_id AS schoolId").where("id = {0}",fenBanClassId);
		List<BaseClass> CList = baseClassMapper.selectList(ewC);
		if (CList.size() > 0) {
			
			for (int k = 0; k < strBabyIdLength; k++) {
				EntityWrapper<BaseBaby> ewBB = new EntityWrapper<BaseBaby>();
				ewBB.setSqlSelect("school_id AS schoolId").where("id = {0}",strBabyId[k]);
				List<BaseBaby> BBList = baseBabyMapper.selectList(ewBB);
				
				if (BBList.size() > 0) {
					if (!BBList.get(0).getSchoolId().equals(CList.get(0).getSchoolId())) {
						jsonResult.setMsg("班级所属的园校和孩子所属的园校不一样还分个毛球班");
						return jsonResult;
					}
				}
			}
			
		} else {
			jsonResult.setMsg("没有该班级");
			return jsonResult;
		}
		
		
		BaseBaby baby = null;
		String haveDel = "";
		for (int i = 0; i < strBabyIdLength; i++) {
			EntityWrapper<BaseBaby> ew = new EntityWrapper<BaseBaby>();
			ew.setSqlSelect("name,delete_flag AS deleteFlag,class_id AS classId,school_id AS schoolId").where("id = {0}",strBabyId[i]);
			List<BaseBaby> babyList = baseBabyMapper.selectList(ew);
		    if (babyList.size()>0) {
		    	if (babyList.get(0).getDeleteFlag() != EnumDeleteFlag.YSC.getValue()) {
                        // 在签到表中查询是否有未删除的记录  如果没有就新增
		    			EntityWrapper<BaseSign> baseSignEW = new EntityWrapper<BaseSign>();
		    			baseSignEW.where("baby_id = {0}",strBabyId[i]);
		    			baseSignEW.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
		    			Integer row = baseSignMapper.selectCount(baseSignEW);
		    			if (row == 0) {
		    				BaseSign baseSign = new BaseSign();
		    				baseSign.setBabyId(strBabyId[i]);
		    				baseSign.setCreateMan(sysUserDTO.getUsername());
		    				baseSign.setCreateTime(new Date());
		    				baseSign.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		    				baseSignMapper.insert(baseSign);
						}
		    			 // 在宝贝学期表中查询是否有未删除的记录  如果没有就新增
		    			MemBabyTeam memBabyTeam = null;
		    			EntityWrapper<MemBabyTeam> memBabyTeamEW = new EntityWrapper<MemBabyTeam>();
		    			//memBabyTeamEW.where("class_id = {0}", fenBanClassId);
		    			memBabyTeamEW.setSqlSelect("id,team,year,class_id AS classId,update_man AS updateMan,update_time AS updateTime,delete_flag AS deleteFlag");
		    			memBabyTeamEW.where("baby_id = {0}",strBabyId[i]);
		    			//memBabyTeamEW.where("team = {0}",teamValue);
		    			//memBabyTeamEW.where("year = {0} ",Calendar.getInstance().get(Calendar.YEAR));
		    			memBabyTeamEW.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
		    			List<MemBabyTeam> babyTeamList = memBabyTeamMapper.selectList(memBabyTeamEW);
		    			if (babyTeamList.size() == 0) {
		    			    memBabyTeam = new MemBabyTeam();
		    				memBabyTeam.setBabyId(strBabyId[i]);
		    				memBabyTeam.setSchoolId(babyList.get(0).getSchoolId());
		    				memBabyTeam.setClassId(fenBanClassId);
		    				memBabyTeam.setTeam(teamValue);
		    				memBabyTeam.setYear(Calendar.getInstance().get(Calendar.YEAR));
		    				memBabyTeam.setCreateMan(sysUserDTO.getUsername());
		    				memBabyTeam.setCreateTime(new Date());
		    				memBabyTeam.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		    				memBabyTeamMapper.insert(memBabyTeam);
						} else {
							for (int j = 0; j < babyTeamList.size(); j++) {
								// 有记录的话判断班级id 是否 和分班的一样 不一样的先删除 再新增
								if (!babyTeamList.get(j).getClassId().equals(fenBanClassId)) {
									babyTeamList.get(j).setUpdateMan(sysUserDTO.getUsername());
									babyTeamList.get(j).setUpdateTime(new Date());
									babyTeamList.get(j).setDeleteFlag(EnumDeleteFlag.YSC.getValue());
									memBabyTeamMapper.updateById(babyTeamList.get(j));
									
									memBabyTeam = new MemBabyTeam();
				    				memBabyTeam.setBabyId(strBabyId[i]);
				    				memBabyTeam.setSchoolId(babyList.get(0).getSchoolId());
				    				memBabyTeam.setClassId(fenBanClassId);
				    				memBabyTeam.setTeam(teamValue);
				    				memBabyTeam.setYear(Calendar.getInstance().get(Calendar.YEAR));
				    				memBabyTeam.setCreateMan(sysUserDTO.getUsername());
				    				memBabyTeam.setCreateTime(new Date());
				    				memBabyTeam.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
				    				memBabyTeamMapper.insert(memBabyTeam);
									
								} else {
									// 班级一样   判断 学期和年份是否一样 不一样的的新增
									if (!babyTeamList.get(i).getYear().equals(Calendar.getInstance().get(Calendar.YEAR)) && !babyTeamList.get(i).getTeam().equals(teamValue)) {
										
									    memBabyTeam = new MemBabyTeam();
					    				memBabyTeam.setBabyId(strBabyId[i]);
					    				memBabyTeam.setSchoolId(babyList.get(0).getSchoolId());
					    				memBabyTeam.setClassId(fenBanClassId);
					    				memBabyTeam.setTeam(teamValue);
					    				memBabyTeam.setYear(Calendar.getInstance().get(Calendar.YEAR));
					    				memBabyTeam.setCreateMan(sysUserDTO.getUsername());
					    				memBabyTeam.setCreateTime(new Date());
					    				memBabyTeam.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
					    				memBabyTeamMapper.insert(memBabyTeam);
										
									}
								}
							}
						}
		    		baby = new BaseBaby();
					baby.setId(strBabyId[i]);
					baby.setUpdateMan(sysUserDTO.getUsername());
					baby.setUpdateTime(new Date());
					baby.setClassId(fenBanClassId);
					result += baseBabyMapper.updateById(baby);
				}else{
					haveDel +=(babyList.get(0).getName() + " ");
				}
		    } else {
                jsonResult.setMsg("数据已被物理删除");
                return jsonResult;
		    }
		}
		if (haveDel!="") {
			haveDel="以下宝贝:" + haveDel + "已标记为删除,无法进行操作";
			jsonResult.setMsg(haveDel);
		}
		if (result > 0) {
			jsonResult.setSuccess(true);
		}
		
		return jsonResult;
	}
	
	@Override
	public List<BaseClass> selectClassByGradeId(BaseGrade baseGrade) {
		Wrapper<BaseClass> wrapper = new EntityWrapper<>();
		wrapper.where("grade_id", baseGrade.getId());
		return baseMapper.selectList(wrapper);
	}
	
	/**
	 * 对已分班的学生进行移除
	 * @author jiangwangying
	 * @date 2017年8月5日 上午8:38:37
	 * @param babyIds 宝贝id
	 * @param schoolId 园校id
	 * @param updateMan 修改人
	 * @return
	 */
	public JsonResult toRemoveBaby(String babyIds, String schoolId, String updateMan){
		
		JsonResult jsonResult = new JsonResult();
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isEmpty(babyIds)) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("请选择要移除的宝贝");
			return jsonResult;
		}
		String[] strBabyId = babyIds.split(",");
		Integer leng = strBabyId.length;
		EntityWrapper<BaseBaby> ew = null;
		
		String noClass = "";
		Integer success = 0;
		Integer fail = 0;
		
		if (!StringUtils.isEmpty(schoolId)) {
			
			// 检测 园长或者老师 操作的宝贝的所属园校是否和自己所属的园校对应
			for (int i = 0; i < leng; i++) {
				
			    ew = new EntityWrapper<BaseBaby>();
				ew.setSqlSelect("school_id AS schoolId").where("id = {0}",strBabyId[i]);
				List<BaseBaby> babyList = baseBabyMapper.selectList(ew);
				if (!babyList.get(0).getSchoolId().equals(schoolId)) {
					jsonResult.setSuccess(false);
					jsonResult.setMsg("出错啦");
					return jsonResult;
				}
			}
		} 
		
		// 还没分班的进行记录 已经分班的进行移除
		for (int i = 0; i < leng; i++) {
		     
			ew = new EntityWrapper<BaseBaby>();
			ew.setSqlSelect("id,name,school_id AS schoolId,class_id AS classId").where("id = {0}",strBabyId[i]);
			List<BaseBaby> babyList = baseBabyMapper.selectList(ew);
			if (StringUtils.isEmpty(babyList.get(0).getClassId())) {
				fail += 1;
				noClass += babyList.get(0).getName() + " . ";
			} else {
				babyList.get(0).setClassId("");
				babyList.get(0).setUpdateMan(updateMan);
				babyList.get(0).setUpdateTime(new Date());
				success += baseBabyMapper.updateById(babyList.get(0));
			}
		}
		jsonObject.put("fail", fail);
		jsonObject.put("noClass", noClass);
		jsonObject.put("success", success);
		
		jsonResult.setSuccess(true);
		jsonResult.setObj(jsonObject);
		
		return jsonResult;
	}
	
	/**
	 * 刷新班级人数
	 * @author jiangwangying
	 * @date 2017年8月5日 上午10:02:46
	 * @param schoolId 园校id
	 * @param updateMan 修改人
	 * @return
	 */
	public JsonResult refreshBabyNum(String schoolId, String updateMan){
		
		JsonResult jsonResult = new JsonResult();
		
		EntityWrapper<BaseClass> classEW = new EntityWrapper<BaseClass>();
		classEW.setSqlSelect("id");
		if (!StringUtils.isEmpty(schoolId)) {
			classEW.where("school_id = {0}", schoolId);
		}
		List<BaseClass> classList = baseClassMapper.selectList(classEW);
	    Integer classLeng = classList.size();
		Integer result = 0;
	    EntityWrapper<BaseBaby> babyEW = null;
		for (int i = 0; i < classLeng; i++) {
			babyEW = new EntityWrapper<BaseBaby>();
			babyEW.where("class_id = {0}",classList.get(i).getId());
			Integer count = baseBabyMapper.selectCount(babyEW);
			classList.get(i).setPeopleNum(count);
			classList.get(i).setUpdateMan(updateMan);
			classList.get(i).setUpdateTime(new Date());
			result += baseClassMapper.updateById(classList.get(i));
		}
		if (result > 0 ) {
			jsonResult.setSuccess(true);
		} else {
			jsonResult.setSuccess(false);
		}
		return jsonResult;
	}
	
	/**
	 * 移除已经分班的教师
	 * @author jiangwangying
	 * @date 2017年8月5日 下午8:57:18
	 * @param memClassTeacherIds 班级教师id
	 * @param updateMan 修改人
	 * @param teacherIds 教师id
	 * @return
	 */
	public JsonResult toRemoveTeacher(String memClassTeacherIds, String updateMan,String teacherIds) {
		
		JsonResult jsonResult = new JsonResult();
		JSONObject jsonObject = new JSONObject();
		String[] strId = memClassTeacherIds.split(","); // 班级教师id
		Integer leng = strId.length;
		Integer result = 0;
		
		String[] strTeacherId = teacherIds.split(","); //教师id
		Integer teachIdLeng = strTeacherId.length;
		if (teachIdLeng != leng) {
			jsonResult.setMsg("移除失败啦");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		
		
		
		
		MemClassTeacher memClassTeacher = new MemClassTeacher();
		for (int i = 0; i < leng; i++) {
			memClassTeacher = new MemClassTeacher();
			memClassTeacher.setId(strId[i]);
			memClassTeacher.setUpdateMan(updateMan);
			memClassTeacher.setUpdateTime(new Date());
			memClassTeacher.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			result += memClassTeacherMapper.updateById(memClassTeacher);
		}
		
		
		// 检查是否有班主任 有的就从班级表里移除
		EntityWrapper<BaseClass> baseClassEW = new EntityWrapper<BaseClass>();
		Integer banZhuRenNum = 0;
		for (int i = 0; i < teachIdLeng; i++) {
			baseClassEW.where("teacher_id = {0}", strTeacherId[i]);
			baseClassEW.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
			List<BaseClass> list = baseClassMapper.selectList(baseClassEW);
			if(list.size() == 1){
				list.get(0).setTeacherId("");
				list.get(0).setUpdateMan(updateMan);
				list.get(0).setUpdateTime(new Date());
				baseClassMapper.updateById(list.get(0));
				banZhuRenNum += 1;
			}
		}
		
		if (result>0) {
            jsonResult.setSuccess(true);
            jsonObject.put("banzhuren", banZhuRenNum);
            jsonResult.setObj(jsonObject);
		} else {
			jsonResult.setMsg("移除失败啦");
			jsonResult.setSuccess(false);
		}
		return jsonResult;
	}
}
