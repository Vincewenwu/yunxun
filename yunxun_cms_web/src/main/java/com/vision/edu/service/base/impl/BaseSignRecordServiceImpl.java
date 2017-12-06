package com.vision.edu.service.base.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.KaoQinTongJiDTO;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseSign;
import com.vision.edu.entity.base.BaseSignRecord;
import com.vision.edu.entity.member.MemDynamic;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.mapper.base.BaseBabyMapper;
import com.vision.edu.mapper.base.BaseSignMapper;
import com.vision.edu.mapper.base.BaseSignRecordMapper;
import com.vision.edu.mapper.member.MemDynamicMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseSignRecordService;

/**
 * <p>
 * 签到记录 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseSignRecordServiceImpl extends ServiceImpl<BaseSignRecordMapper, BaseSignRecord> implements IBaseSignRecordService {

	@Autowired
	private BaseSignRecordMapper baseSignRecordMapper;
	@Autowired
	private BaseSignMapper baseSignMapper;

	@Autowired
	private BaseBabyMapper baseBabyMapper;

	@Autowired
	private MemDynamicMapper memDynamicMapper;

	@Override
	public BaseSign addBabySurrogate(BaseSignRecord baseSignRecord) {

		Wrapper<BaseSign> wrapper = new EntityWrapper<>();
		wrapper.where("baby_id={0} AND delete_flag={1}", baseSignRecord.getBabyId(), EnumDeleteFlag.WSC.getValue());
		//判断当前宝贝是否存在签到名单
		List<BaseSign> baseSigns = baseSignMapper.selectList(wrapper);
		if (baseSigns == null || baseSigns.isEmpty()) {
			return null;
		}
		BaseSign baseSign = baseSigns.get(0);
		//新增签到记录
		baseSignRecord.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		baseMapper.insert(baseSignRecord);
		//新增签到动态
		MemDynamic dynamic = new MemDynamic();
		BaseBaby baby = baseBabyMapper.selectById(baseSign.getBabyId());
		if (baby == null) {
			return null;
		}
		dynamic.setBrowseCount(0);
		dynamic.setClassId(baby.getClassId());
		dynamic.setSchoolId(baby.getSchoolId());
		dynamic.setCreateTime(new Date());
		dynamic.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		dynamic.setPointCount(0);
		dynamic.setResourcesId(baseSignRecord.getId());
		dynamic.setResourcesType(EnumResourceType.QD.getValue());
		memDynamicMapper.insert(dynamic);
		//修改签到状态
		BaseSign baseSign2 = new BaseSign();
		baseSign2.setId(baseSign.getId());
		baseSign2.setSignTime(baseSignRecord.getSignTime());
		baseSign2.setRecordType(baseSignRecord.getRecordType());
		baseSign2.setSingState(baseSignRecord.getSignStatus());
		baseSignMapper.updateById(baseSign2);
		return baseSign;
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
	@Override
	public List<KaoQinTongJiDTO> kaoQinTongJi(String schoolId,String babyId,String classId,String startTime,String endTime,Integer deleteFlag) {

		return baseSignRecordMapper.kaoQinTongJi(schoolId, babyId, classId, startTime, endTime, deleteFlag);
	}



	/**
	 * 辅助考勤统计
	 * @author jiangwangying
	 * @date 2017年8月3日 下午9:40:23
	 * @param schoolId 园校id
	 * @param classId 班级id
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	@Override
	public JsonResult TongJi(Pagination page,String schoolId, String classId, String startTime, String endTime,String updateMan) {

		JSONObject jsonObject = new JSONObject();
		JsonResult jsonResult = new JsonResult();
		List<KaoQinTongJiDTO> list1 =  baseSignMapper.kaoQinTongJiBySign(page, schoolId, null, classId, EnumDeleteFlag.WSC.getValue());
		List<KaoQinTongJiDTO> list3 = new ArrayList<KaoQinTongJiDTO>();
		if (list1.size()>0) {
			KaoQinTongJiDTO kaoQinTongJiDTO = null;
			for (int i = 0; i < list1.size(); i++) {
				List<KaoQinTongJiDTO> list2 = baseSignRecordMapper.kaoQinTongJi(null, list1.get(i).getBabyId(), null, startTime, endTime, EnumDeleteFlag.WSC.getValue());
				kaoQinTongJiDTO = new KaoQinTongJiDTO();
				if (list2.size()>0) {
					Integer signDays = list2.size();//天数
					Integer signCount = 0;
					//统计签到数
					for (int j = 0; j < list2.size(); j++) {
						signCount += list2.get(j).getSignCount();
					}
					kaoQinTongJiDTO.setBabyName(list2.get(0).getBabyName());
					kaoQinTongJiDTO.setHeadPortrait(list2.get(0).getHeadPortrait());
					kaoQinTongJiDTO.setClassName(list2.get(0).getClassName());
					kaoQinTongJiDTO.setGradeName(list2.get(0).getGradeName());
					kaoQinTongJiDTO.setSchoolName(list2.get(0).getSchoolName());
					kaoQinTongJiDTO.setSignCount(signCount);
					kaoQinTongJiDTO.setSignDatas(signDays);
				} else {
					//签到记录没数据的设默认值
					kaoQinTongJiDTO.setBabyName(list1.get(i).getBabyName());
					kaoQinTongJiDTO.setHeadPortrait(list1.get(i).getHeadPortrait());
					kaoQinTongJiDTO.setClassName(list1.get(i).getClassName());
					kaoQinTongJiDTO.setGradeName(list1.get(i).getGradeName());
					kaoQinTongJiDTO.setSchoolName(list1.get(i).getSchoolName());
					kaoQinTongJiDTO.setSignCount(0);
					kaoQinTongJiDTO.setSignDatas(0);
				}
				list3.add(kaoQinTongJiDTO);
			}
		}
		if (list3.size()>0) {
			jsonObject.put("total", page.getTotal());
			jsonObject.put("list", list3);
			jsonResult.setObj(jsonObject);
			jsonResult.setSuccess(true);
		} else {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("没有符合条件的数据");
		}

		return jsonResult;
	}
}
