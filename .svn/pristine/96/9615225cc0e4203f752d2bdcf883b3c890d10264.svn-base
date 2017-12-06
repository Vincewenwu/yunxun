package com.vision.edu.service.base.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mysql.fabric.xmlrpc.base.Data;
import com.vision.edu.entity.base.BaseDistrict;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.entity.system.SysUser;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.enums.EnumSchoolState;
import com.vision.edu.framework.util.BindingCodeUtil;
import com.vision.edu.framework.util.EncryptUtil;
import com.vision.edu.mapper.base.BaseDistrictMapper;
import com.vision.edu.mapper.base.BaseDutiesMapper;
import com.vision.edu.mapper.base.BaseMemberMapper;
import com.vision.edu.mapper.base.BaseSchoolMapper;
import com.vision.edu.mapper.system.SysUserMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseSchoolService;

/**
 * <p>
 * 园校，记录的是园校的基本信息 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseSchoolServiceImpl extends ServiceImpl<BaseSchoolMapper, BaseSchool> implements IBaseSchoolService {
	
	@Autowired
     BaseSchoolMapper baseSchoolMapper;
	
	@Autowired 
	BaseMemberMapper baseMemberMapper;
	
	@Autowired
	SysUserMapper SysUserMapper;
	
	@Autowired
	BaseDistrictMapper  baseDistrictMapper;
	
	/**
	 * 动态模糊查询园校
	 * @author jiangwangying
	 * @date 2017年7月11日 上午9:05:24
	 * @param page 分页
	 * @param schoolId 园校id
	 * @param schoolName 园校名称
	 * @param deleteFlag 删除标记
	 * @return=List 园校list集合
	 */
	public List<BaseSchool> findSchoolByDynamic(Pagination page, String schoolId, String schoolName,
			Integer deleteFlag) {
		
		return baseSchoolMapper.findSchoolByDynamic(page, schoolId, schoolName, deleteFlag);
	}
	
	/**
	 * 新增园校
	 * @param baseSchool 
	 * @param createMan 新建人
	 * @return=
	 */
    public JsonResult addSchool(BaseSchool baseSchool,String createMan){

    	
    JsonResult jsonResult = new JsonResult();
   
    if (null == baseSchool.getProvinceId() || null == baseSchool.getCityId()) {

    	jsonResult.setSuccess(false);
		jsonResult.setMsg("请完善学校地址");
		return jsonResult;
    }
    boolean ifCounty = true; //默认当前市下一级还有县
    
    // 判断当前市下一级是否还有县
    if (null == baseSchool.getCountyId()) {
    	EntityWrapper<BaseDistrict> ew = new EntityWrapper<BaseDistrict>();		
        ew.where("pid = {0}",baseSchool.getCityId());
    	List<BaseDistrict> list = baseDistrictMapper.selectList(ew);
    	if (list.size()>0) {
    		// 存在县则提示
        	jsonResult.setSuccess(false);
    		jsonResult.setMsg("请完善学校地址");
    		return jsonResult;
    	} else {
    		// 不存在县
    	    ifCounty = false;
    	}
	}
    // 根据地区id 获取地区编码
    EntityWrapper<BaseDistrict> ew1 = new EntityWrapper<BaseDistrict>();
    ew1.setSqlSelect("code");
    if (ifCounty) {
    	// 存在县就查县的
		ew1.where("id = {0}", baseSchool.getCountyId());
	} else {
		// 不存在县就查市的
		ew1.where("id = {0}", baseSchool.getCityId());
	}
    List<BaseDistrict> list = baseDistrictMapper.selectList(ew1);
    String districtCode = "";
    if (list.size() == 1) {
    	districtCode = list.get(0).getCode();
	} else {
		jsonResult.setSuccess(false);
		jsonResult.setMsg("获取地区编码出错啦");
		return jsonResult;
	}
   
    // 根据地区id 查询园校
    EntityWrapper<BaseSchool> ew2 = new EntityWrapper<BaseSchool>();
    if (ifCounty) {
        ew2.where("county_id = {0}", baseSchool.getCountyId());
	} else {
		// 新增的园校没有县    查询市条件也要一样
		ew2.where("city_id = {0}", baseSchool.getCityId());
		ew2.where("county_id is NULL");
	}
    
    // 获取当前地区学校的数量
    // 当前地区学校的数量 + 1 则为新园校的序号
    Integer schoolCount = baseSchoolMapper.selectCount(ew2) + 1;
    
    
    //格式化当前学校的序号 （变成4位数）
    DecimalFormat df=new DecimalFormat("0000");
    String schoolNum=df.format(schoolCount);
    
    //地区编码 + 4位数的学校编码  = 园校的编号
    baseSchool.setCode(districtCode + schoolNum);
  
    
    baseSchool.setState(EnumSchoolState.ZC.getValue());
    baseSchool.setUpdateMan(createMan);
    baseSchool.setUpdateTime(new Date());
    baseSchool.setCreateMam(createMan);
    baseSchool.setCreateTime(new Date());
    baseSchool.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
    if (StringUtils.isEmpty(baseSchool.getFatherId())) {
    	baseSchool.setFatherId("0");
	}
    Integer result1 =  baseSchoolMapper.insert(baseSchool);
  
    if (result1 >0) {
    	 jsonResult.setSuccess(true);
	}else{
		 jsonResult.setSuccess(false);
		 jsonResult.setMsg("新增园校失败");
	}
    return jsonResult;
    
  }
    
    /**
	 * 逻辑删除园校/停用园校
	 * @author jiangwangying
	 * @date 2017年7月18日 上午8:00:57
	 * @param schoolIds 园校id集合
	 * @param delOrStopSchool 0:逻辑删除  1:停用园校
	 * @param updateMan 修改人
	 * @return
	 */
	public JsonResult delOrStopSchool(String schoolIds,Integer delOrStopSchool,String updateMan){
		JsonResult jsonResult = new JsonResult();
		BaseSchool baseSchool = null;
		String[] ids = schoolIds.split(",");
		Integer idsLength = ids.length;
		Integer result = 0;
		switch (delOrStopSchool) {
		case 0:// 删除园校
			for (int i = 0; i < idsLength; i++) {
				baseSchool = new BaseSchool();
				baseSchool.setId(ids[i]);
				baseSchool.setUpdateMan(updateMan);
				baseSchool.setUpdateTime(new Date());
				baseSchool.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			    result += baseSchoolMapper.updateById(baseSchool);
			}
			if (result==ids.length) {
				jsonResult.setSuccess(true);
			}else {
 				jsonResult.setSuccess(false);
 				jsonResult.setMsg("操作失败");
 				return jsonResult;
			}
			break;
         case 1://停用园校
        	 for (int i = 0; i < idsLength; i++) {
        		baseSchool = new BaseSchool();
 				baseSchool.setId(ids[i]);
 				baseSchool.setUpdateMan(updateMan);
				baseSchool.setUpdateTime(new Date());
 				baseSchool.setState(EnumSchoolState.YGQ.getValue());
 			    result += baseSchoolMapper.updateById(baseSchool);
 			}
 			if (result==ids.length) {
 				jsonResult.setSuccess(true);
 			} else {
 				jsonResult.setSuccess(false);
 				jsonResult.setMsg("操作失败");
 				return jsonResult;
			}
			break;
		default:
			jsonResult.setSuccess(false);
			jsonResult.setMsg("操作失败");
			break;
		}
		return jsonResult;
	}
	/**
	 * 编辑园校
	 * @author jiangwangying
	 * @date 2017年7月18日 下午8:11:04
	 * @param baseSchool
	 * @return
	 */
	public JsonResult editSchool(BaseSchool baseSchool){
		
		baseSchool.setUpdateTime(new Date());
		Integer result = baseSchoolMapper.updateById(baseSchool);
		JsonResult jsonResult = new JsonResult();
		if (result>0) {
			jsonResult.setSuccess(true);
		}else{
			jsonResult.setSuccess(false);
		}
			
		return jsonResult;
	}
}
