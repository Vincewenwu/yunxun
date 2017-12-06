package com.vision.edu.service.base.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseRecipeBank;
import com.vision.edu.entity.base.BaseSchool;
import com.vision.edu.entity.member.MemDynamic;
import com.vision.edu.entity.member.MemSchoolRecipe;
import com.vision.edu.entity.member.MemSchoolRecipeDetail;
import com.vision.edu.entity.system.SysRecipeBank;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.mapper.base.BaseRecipeBankMapper;
import com.vision.edu.mapper.base.BaseSchoolMapper;
import com.vision.edu.mapper.member.MemDynamicMapper;
import com.vision.edu.mapper.member.MemSchoolRecipeDetailMapper;
import com.vision.edu.mapper.member.MemSchoolRecipeMapper;
import com.vision.edu.mapper.system.SysRecipeBankMapper;
import com.vision.edu.service.base.IBaseRecipeBankService;
import com.xiaoleilu.hutool.date.DateUtil;

/**
 * <p>
 * 园校食谱库，用于记录园校的食谱库 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseRecipeBankServiceImpl extends ServiceImpl<BaseRecipeBankMapper, BaseRecipeBank> implements IBaseRecipeBankService {
     @Autowired 
     private BaseRecipeBankMapper baseRecipeBankMapper;
     @Autowired
     private SysRecipeBankMapper sysRecipeBankMapper;
     @Autowired
     private MemSchoolRecipeMapper memSchoolRecipeMapper;
     @Autowired
     private MemSchoolRecipeDetailMapper memSchoolRecipeDetailMapper;
     @Autowired
     private MemDynamicMapper memDynamicMapper;
     @Autowired
     private BaseSchoolMapper baseSchoolMapper;
	
	/**
	 * 查询菜谱表
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午9:37:12
	 * @param page
	 * @param schoolId
	 * @param schoolname
	 * @param infotype
	 * @return
	 */
	public List<BaseRecipeBank> findBaseRecipeBank(Pagination page, BaseRecipeBank baseRecipeBank) {
		return baseRecipeBankMapper.findBaseRecipeBank(page, baseRecipeBank);
	}
	/**
	 * 作为菜谱编号判断
	 * @author ChenWenWu
	 * @date 2017年8月10日 下午8:29:50
	 * @param cc
	 * @return
	 */
	 public static String jiao(String cc){
	    	String aa="0"+ cc;
			return aa;
	    }
	/**
	 * 新增菜谱 同时新增平台菜谱
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午9:37:12
	 * @param page
	 * @param schoolId
	 * @param schoolname
	 * @param infotype
	 * @return
	 */
	public String addSysRecipeBank(BaseRecipeBank baseRecipeBank,String pingtai) {
    
	EntityWrapper<BaseSchool> ew = new EntityWrapper<BaseSchool>();
  	ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue()).and("id = {0}", baseRecipeBank.getSchoolId());
	ew.setSqlSelect("id,name,code");
	List<BaseSchool> baseSchoollist=baseSchoolMapper.selectList(ew);//查询院校编号
	BaseRecipeBank baseRecipeBankcode =baseRecipeBankMapper.findBaseRecipeBankSerialNum(baseRecipeBank.getSchoolId());///查询食谱编号
	String code="";
	String stunumber="";
	Calendar a=Calendar.getInstance();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置你想要的格式
	if(baseRecipeBankcode==null){//第一次进入这个学院新增菜谱的条件
		stunumber =baseSchoollist.get(0).getCode()+   //学院ID
		    		df.format(a.getTime()).substring(2, 4)+ //年份结尾
		    		"001";//菜谱序号
	} else {
		 Integer size=Integer.valueOf(baseRecipeBankcode.getSerialNum().substring(12, 15));
         code=size+1+"";
         while(code.toString().length()<3){
       	  code=jiao(code);
        }
         stunumber=baseSchoollist.get(0).getCode()+   //学院ID
					df.format(a.getTime()).substring(2, 4) //年份结尾
					 +code;
	}
	String num1="新增成功";
	if(baseSchoollist.size()>0){
		baseRecipeBank.setSerialNum(stunumber);
		baseRecipeBank.setPointCount(0);
		baseRecipeBank.setBrowseCount(0);
		baseRecipeBank.setUsedCount(0);
		baseRecipeBank.setDeleteFlag(0);
		baseRecipeBank.setCreateTime(new Date());
	    baseRecipeBankMapper.insert(baseRecipeBank);
		if(pingtai.length()>1){//这里判断是否是平台食谱库
		}else{
			SysRecipeBank SysRecipeBank=new SysRecipeBank();
			SysRecipeBank.setName(baseRecipeBank.getName());
			SysRecipeBank.setCoverImages(baseRecipeBank.getCoverImages());
			SysRecipeBank.setPictureSet(baseRecipeBank.getPictureSet());
			SysRecipeBank.setIntro(baseRecipeBank.getIntro());
			SysRecipeBank.setFoodMaterial(baseRecipeBank.getFoodMaterial());
			SysRecipeBank.setNutrient(baseRecipeBank.getNutrient());
			SysRecipeBank.setSchoolId(baseRecipeBank.getSchoolId());
			SysRecipeBank.setPointCount(0);
			SysRecipeBank.setBrowseCount(0);
			SysRecipeBank.setUsedCount(0);
			SysRecipeBank.setDeleteFlag(0);
			SysRecipeBank.setCreateMam(baseRecipeBank.getCreateMam());
			baseRecipeBank.setCreateTime(new Date());
			Integer num2=	sysRecipeBankMapper.insert(SysRecipeBank);
			num1="新增成功";
		}
	}else {
		num1="新增失败";
	}
	return  num1;
	
	}
	
	/**
	 *修改的时候使用 查询单条菜谱表
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午9:37:12
	 * @param page
	 * @param page
	 * @param baseRecipeBank 条件实体
	 * @return
	 */
	public BaseRecipeBank findOneBaseRecipeBank(BaseRecipeBank baseRecipeBank) {
		return baseRecipeBankMapper.findOneBaseRecipeBank(baseRecipeBank);
	}
	  /**
	   * 发布菜谱，顺便发布动态
	   * @author ChenWenWu
	   * @date 2017年8月4日 下午5:46:02
	   * @param memSchoolRecipeDetail
	   * @param PublishTime
	   * @param weekly
	   * @param xycpName
	   * @return
	   */
	public Integer addMemSchoolRecipe(MemSchoolRecipeDetail memSchoolRecipeDetail,String schoolId, String loginID,String PublishTime,Integer weekly,String xycpName ) {
		Integer num2=0;
		MemSchoolRecipe memSchoolRecipe=new MemSchoolRecipe();
		memSchoolRecipe.setWeekly(weekly);
		memSchoolRecipe.setSchoolId(schoolId);
		memSchoolRecipe.setName(xycpName);
		memSchoolRecipe.setBrowseCount(0);
		memSchoolRecipe.setCreateMan(memSchoolRecipeDetail.getCreateMam());
		Date date =  DateUtil.parse(PublishTime, "yyyy-MM-dd");
		memSchoolRecipe.setPublishTime(date);
		memSchoolRecipe.setPublishId(loginID);
		memSchoolRecipe.setCreateTime(new Date());
		memSchoolRecipe.setCreateMan(memSchoolRecipeDetail.getCreateMam());
		memSchoolRecipe.setBrowseCount(0);
		memSchoolRecipe.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
	    Integer num1=memSchoolRecipeMapper.insert(memSchoolRecipe);
		
		memSchoolRecipeDetail.setSchoolRecipeId(memSchoolRecipe.getId());
		memSchoolRecipeDetail.setCreateTime(new Date());
		memSchoolRecipeDetail.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		 memSchoolRecipeDetailMapper.insert(memSchoolRecipeDetail);
		 
		MemDynamic memDynamic = new MemDynamic();
		memDynamic.setResourcesId(memSchoolRecipe.getId()); //院校食谱ID
		memDynamic.setResourcesType(EnumResourceType.SP.getValue());
		memDynamic.setSchoolId(schoolId);
		memDynamic.setBrowseCount(0);//浏览数
		memDynamic.setPointCount(0);//点赞数
		memDynamic.setCreateTime(new Date());
		memDynamic.setCreateMamId(loginID);
		memDynamic.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		num2+=memDynamicMapper.insert(memDynamic);
		return num2;
	}
	/**
	 *根据下拉框选择绑定平台食谱
	 * @author ChenWenWu
	 * @date 2017年7月24日 下午9:37:12
	 * @param id 平台食谱ID
	 * @return
	 */
	@Override
	public SysRecipeBank findOneSysRecipeBank(String id) {
		return baseRecipeBankMapper.findOneSysRecipeBank(id);
	}
	
}
