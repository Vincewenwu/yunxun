package com.vision.edu.service.base.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.vision.edu.dto.KaoQinTongJiDTO;
import com.vision.edu.dto.SignDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseClass;
import com.vision.edu.entity.base.BaseSign;
import com.vision.edu.entity.base.BaseSignRecord;
import com.vision.edu.enums.EnumBabyState;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumRecordState;
import com.vision.edu.mapper.base.BaseBabyMapper;
import com.vision.edu.mapper.base.BaseSignMapper;
import com.vision.edu.mapper.base.BaseSignRecordMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseSignService;

/**
 * <p>
 * 签到表，宝贝排班的时候就要添加到签到表，每天定时更新这表的状态。签到，签离时候更新这签到状态，同时同步新增一条签到记录到 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseSignServiceImpl extends ServiceImpl<BaseSignMapper, BaseSign> implements IBaseSignService {
	
	@Autowired
	private BaseSignMapper baseSignMapper;
	
	@Autowired
	private  BaseSignRecordMapper baseSignRecordMapper;
	
	@Autowired
	private BaseBabyMapper baseBabyMapper;
	
	@Autowired
	private BaseBabyMapper basebabyMapper;
	
	/**
	 * 查询签到
	 * @author jiangwangying
	 * @date 2017年8月3日 下午3:40:46
	 * @param page 分页
	 * @param schoolId 学校id
	 * @param vague 关键字
	 * @param classId 班级id
	 * @param signState 签到状态
	 * @return
	 */
	public List<SignDTO> findSign(Pagination page,String schoolId,String classId, String vague,Integer signState) {
		
		return baseSignMapper.findSign(page,schoolId,classId,vague,signState);
	
	}
	
	/**
	 * 查询未签到宝贝
	 * @author jiangwangying
	 * @date 2017年8月2日 下午8:41:26
	 * @param schoolId 学校id
	 * @param classId 班级id
	 * @return
	 */
	public List<SignDTO> findNoSignBaby(String schoolId,String classId){
		
		return baseSignMapper.findNoSignBaby(schoolId, classId);
		
	}
	
	
	/**
	 * 补考勤
	 * @author jiangwangying
	 * @date 2017年8月3日 上午7:52:12
	 * @param babyId 宝贝id集合
	 * @param signType 签到类型
	 * @param signState 签到状态
	 * @return
	 */
	public JsonResult buKaoQin(String babyId, Integer signType, Integer signState,String updateMan){
		
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isEmpty(babyId) || babyId.trim() == "" || null == signType || null == signState) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("空值");
			return jsonResult;
		}
		
		String[] strBabyId = babyId.split(",");
		Integer strBabyIdLen = strBabyId.length;
		
		BaseSignRecord baseSignRecord = null;
		Integer result = 0;
		// 新增到签到记录
		for (int i = 0; i < strBabyIdLen; i++) {
			baseSignRecord = new BaseSignRecord();
			baseSignRecord.setBabyId(strBabyId[i]);
			baseSignRecord.setRecordType(signType);
			baseSignRecord.setSignStatus(signState);
			baseSignRecord.setSignTime(new Date());
			baseSignRecord.setUpdateMan(updateMan);
			baseSignRecord.setUpdateTime(new Date());
			baseSignRecord.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			result += baseSignRecordMapper.insert(baseSignRecord);
		}
		EntityWrapper<BaseSign> ew = null;
		// 修改签到表签到状态
		for (int i = 0; i < strBabyIdLen; i++) {
			ew = new EntityWrapper<BaseSign>();
			ew.setSqlSelect("id");
			ew.where("baby_id = {0} and delete_flag = {1}", strBabyId[i],EnumDeleteFlag.WSC.getValue());
            List<BaseSign> baseSignList = baseSignMapper.selectList(ew);
            if (baseSignList.size() == 1) {
            	baseSignList.get(0).setRecordType(signType);
            	baseSignList.get(0).setSingState(signState);
            	baseSignList.get(0).setSignTime(new Date());
            	baseSignList.get(0).setUpdateMan(updateMan);
            	baseSignList.get(0).setUpdateTime(new Date());
            	result += baseSignMapper.updateById(baseSignList.get(0));
			}
		}
		if (result == strBabyIdLen * 2) {
			jsonResult.setSuccess(true);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("出错啦");
		}
		return jsonResult;
	}
	
	/**
	 * 根据签到id删除签到
	 * @author jiangwangying
	 * @date 2017年8月3日 下午2:44:44
	 * @param signId 签到id
	 * @param updateMan 签到宝贝
	 * @return
	 */
	public JsonResult delSignById(String signId, String updateMan) {
		
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isEmpty(signId)) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("请选择要删除的签到宝贝");
			return jsonResult;
		}
		
		String[] strSignId = signId.split(",");
		Integer strSignIdLen = strSignId.length;
		
		BaseSign baseSign = null;
		Integer result = 0;
		for (int i = 0; i < strSignIdLen; i++) {
			baseSign = new BaseSign();
			baseSign.setId(strSignId[i]);
			baseSign.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			baseSign.setUpdateMan(updateMan);
			baseSign.setUpdateTime(new Date());
			baseSign.setRecordType(null);
			baseSign.setSingState(null);
			baseSign.setSignTime(null);
			result += baseSignMapper.updateById(baseSign);
		}
		if (result == strSignIdLen) {
			jsonResult.setSuccess(true);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("删除失败啦");
		}
		return jsonResult;
	}
	
	/**
	 * 更新签到类别  不是重置  是将未纳入或者已在签到表中删除的正常的宝贝加入进签到表
	 * @author jiangwangying
	 * @date 2017年8月3日 下午3:08:41
	 * createMan 新建人
	 * @return
	 */
	public JsonResult gengxinQianDao(String createMan,String schoolId){
		
		
		JsonResult jsonResult = new JsonResult();
		Integer result = 0;
		Integer result1 = 0;
		EntityWrapper<BaseBaby> ew = new EntityWrapper<BaseBaby>();
		ew.setSqlSelect("id");
		ew.where("state = {0} and delete_flag = {1} and class_id != {2}", EnumBabyState.ZC.getValue(),EnumDeleteFlag.WSC.getValue(),"");
        if (!StringUtils.isEmpty(schoolId) || schoolId.trim() !="") {
        ew.where("school_id = {0}", schoolId);
		}
		List<BaseBaby> babyList = basebabyMapper.selectList(ew);
        Integer len = babyList.size();
        if (len > 0) {
        	EntityWrapper<BaseSign> ew1 = null;
        	BaseSign baseSign = null;
			for (int i = 0; i < len; i++) {
				ew1 = new EntityWrapper<BaseSign>();
				ew1.where("baby_id = {0} and delete_flag = {1}", babyList.get(i).getId(),EnumDeleteFlag.WSC.getValue());
			    Integer rows = baseSignMapper.selectCount(ew1);
			    if (rows == 0) {
			    	baseSign = new BaseSign();
			    	baseSign.setBabyId(babyList.get(i).getId());
			    	baseSign.setCreateMan(createMan);
			    	baseSign.setCreateTime(new Date());
			    	baseSign.setSingState(EnumRecordState.DQ.getValue());
			    	baseSign.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
			    	result += baseSignMapper.insert(baseSign);
				} 
			}
		} 
        
        
        // 对账号停了、过期的 、被删除的、未分班的宝贝进行移除
        EntityWrapper<BaseBaby> ew1 = new EntityWrapper<BaseBaby>();
        ew1.setSqlSelect("id");
        ew1.where("state = {0} OR state = {1} OR delete_flag = {2} OR class_id = {3}", EnumBabyState.WFF.getValue(),EnumBabyState.YGQ.getValue(),EnumDeleteFlag.YSC.getValue(),"");
        if (!StringUtils.isEmpty(schoolId) || schoolId.trim() !="") {
        ew1.where("school_id = {0}", schoolId);
		}
		List<BaseBaby> babyList1 = basebabyMapper.selectList(ew1);
		if (babyList1.size()>0) {
			Integer count = babyList1.size();
			
        	EntityWrapper<BaseSign> ew2 = null;
        	BaseSign baseSign = null;
			for (int i = 0; i < count; i++) {
				ew2 = new EntityWrapper<BaseSign>();
				ew2.setSqlSelect("id");
				ew2.where("baby_id = {0} and delete_flag = {1}", babyList1.get(i).getId(),EnumDeleteFlag.WSC.getValue());
			    List<BaseSign> signList = baseSignMapper.selectList(ew2);
			    if (signList.size() > 0) {
			    	Integer signListLeng = signList.size();
			    	for (int j = 0; j < signListLeng; j++) {
			    		baseSign = new BaseSign();
				    	baseSign.setId(signList.get(j).getId());
				    	baseSign.setUpdateMan(createMan);
				    	baseSign.setUpdateTime(new Date());
				    	baseSign.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
				    	result1 += baseSignMapper.updateById(baseSign);
					}
				} 
			}
			
		}
		if (result > 0 || result1 >0) {
			jsonResult.setSuccess(true);
			jsonResult.setMsg("新增 "+result+" 位需要签到的宝贝,移除 "+result1+" 位账号停止、未付费、已标记删除、或者还没分班的宝贝");
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("无更新记录");
		}
		return jsonResult;
	}
	
	/**
	 * 考勤统计
	 * @author jiangwangying
	 * @date 2017年8月3日 下午9:17:18
	 * @param schoolId 学校id
	 * @param babyId 宝贝id
	 * @param classId 班级id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param deleteFlag 删除标记
	 * @param signState 签到状态
	 * @return
	 */
	public List<KaoQinTongJiDTO> kaoQinTongJiBySign(Pagination page,String schoolId,String babyId,String classId,Integer deleteFlag) {
		
		return baseSignMapper.kaoQinTongJiBySign(page,schoolId, babyId, classId, deleteFlag);
	}
}
