package com.vision.edu.service.base.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vision.edu.dto.AnnouncementDTO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.dto.BaseSchoolInfoTwoDTO;
import com.vision.edu.dto.PlatformDTO;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemInfoGroup;
import com.vision.edu.enums.EnumCheckFlag;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumInfoType;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.enums.EnumPlatform;
import com.vision.edu.enums.EnumRangeType;
import com.vision.edu.framework.util.DateEditor;
import com.vision.edu.mapper.base.BaseSchoolInfoMapper;
import com.vision.edu.mapper.member.MemInfoGroupMapper;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseSchoolInfoService;
import com.xiaoleilu.hutool.date.DateUtil;

/**
 * <p>
 * 校园资讯表 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-03
 */
@Service
public class BaseSchoolInfoServiceImpl extends ServiceImpl<BaseSchoolInfoMapper, BaseSchoolInfo> implements IBaseSchoolInfoService {

	@Autowired
	private BaseSchoolInfoMapper baseSchoolInfoMapper;
	
	 @Autowired
     private MemInfoGroupMapper memInfoGroupMapper;
	
	
	public BaseSchoolInfoMapper getBaseSchoolInfoMapper() {
		return baseSchoolInfoMapper;
	}


	public void setBaseSchoolInfoMapper(BaseSchoolInfoMapper baseSchoolInfoMapper) {
		this.baseSchoolInfoMapper = baseSchoolInfoMapper;
	}


	public MemInfoGroupMapper getMemInfoGroupMapper() {
		return memInfoGroupMapper;
	}


	public void setMemInfoGroupMapper(MemInfoGroupMapper memInfoGroupMapper) {
		this.memInfoGroupMapper = memInfoGroupMapper;
	}


	/**
	 * 只根据学院ID查询所有  学院名称是模糊查询
	 * @author ChenWenWu
	 * @date 2017年7月13日 下午5:48:18
	 * @param page 分页实体
	 * @param schoolId 学院id 
	 * @param schoolname 学院名称
	 * @return
	 */
	public List<BaseSchoolInfoTwoDTO> findShoolInfofoPage(Pagination page,String schoolId,String schoolname,String infotype) {
		return baseSchoolInfoMapper.findShoolInfofoPage(page,schoolId,schoolname,infotype);
	}
	
	
	/**
	 * 分页+模糊查询Banner
	 * @param page  分页实体
	 * @param schoolname 学校名称
	 * @param infoType banner类型
	 * @return=
	 */
	public List<BaseSchoolInfoTwoDTO> findBaseSchoolInfoPage(Page<BaseSchoolInfoTwoDTO> page, String schoolname, int infoType,String schoolId) {
		    return 	baseSchoolInfoMapper.findBaseSchoolInfoPage(page, schoolname,infoType,schoolId);
	}
	
	/**
	 * 分页+模糊查询 校园咨询的查询
	 * @author ChenWenWu
	 * @date 2017年7月11日 下午8:24:55
	 * @param page 分页实体
	 * @param title 标题
	 * @param schoolname 学院名称
	 * @param infoType 咨询类型
	 * @param schoolId 学院ID
	 * @return
	 */
	public List<BaseSchoolInfoTwoDTO> findXiaoYuanZiXunPage(Pagination page, String title, String schoolname,
			int infoType, String schoolId) {
		return baseSchoolInfoMapper.findXiaoYuanZiXunPage(page, title, schoolname, infoType, schoolId);
		 
	}

	/**
	 * 查询院所动态根据时间段
	 * @author ChenWenWu
	 * @date 2017年7月9日 下午9:35:57
	 * @param page
	 * @param startTime 开始时间 
	 * @param endTime 介绍时间
	 * @return
	 */
	public List<BaseSchoolInfoTwoDTO> findBaseYuanSuoPage(Pagination page, String startTime, String endTime) {
		return baseSchoolInfoMapper.findBaseYuanSuoPage(page, startTime, endTime);
	}

	/**
	 *1、 新增Banner 2、校园咨询发布 3、发布活动那里的新增
	 *   同时新增咨询组表，
	 * @author ChenWenWu
	 * @date 2017年7月5日 下午4:17:41
	 */
	public Integer all(BaseSchoolInfo bif, String group,String  time) {
		 int inoftype=bif.getInfoType();
		 int type=0;
		if(inoftype==0){//判断资讯的类型
			type=EnumInfoType.GG.getValue();
		}else if(inoftype==1){
			  type=EnumInfoType.ZX.getValue();
		}else if(inoftype==2){
			  type=EnumInfoType.HD.getValue();
		}else if(inoftype==3){
			  type=EnumInfoType.BN.getValue();
		}else{
		} 
		Date date = DateUtil.parse(time.substring(0,19));
		Date date1 = DateUtil.parse(time.substring(22));
		bif.setApplyCount(0);
		bif.setPointCount(0);
		bif.setBrowseCount(0);
		bif.setCommentCount(0);
		bif.setCollectionCount(0);
		bif.setStartTime(date);
		bif.setEndTime(date1);
 		bif.setCreateTime(new Date());
		bif.setCheckFlag(0);
		bif.setDeleteFlag(0);
		bif.setContentImgs("图片集内容");
		Integer num1 = baseSchoolInfoMapper.insert(bif);
		String zixunid = bif.getId();//controller null  serviceImpl 可以获取
		if(group.length()>0 && group!=null){
			MemInfoGroup memInfoGroup=new MemInfoGroup(); //新增咨询组表
			memInfoGroup.setSchoolInfoId(zixunid);
			memInfoGroup.setBaseGroupId(group);//会员组ID  下拉框选择
			memInfoGroup.setCreateTime(new Date());
			memInfoGroup.setCreateMam("wenwu");
			memInfoGroup.setDeleteFlag(0);
			Integer num2=memInfoGroupMapper.insert(memInfoGroup);
		}
		return num1;
		
	}
	/**
	 * 修改之前查询出来
       @author ChenWenWu
	 * @param baseSchoolInfo 咨询D 
	 * @return=
	 */
	public BaseSchoolInfoTwoDTO findOneShoolInFo(String baseSchoolInfo) {
		return baseSchoolInfoMapper.findOneShoolInFo(baseSchoolInfo);
	}
	
	/**
	 * 修改之前查询出来(差的是《没》有咨询分组得分组)
       @author ChenWenWu
	 * @param baseSchoolInfo 咨询D 
	 * @return=
	 */
	public BaseSchoolInfoTwoDTO findOneShoolInFoONGroup(String baseSchoolInfo) {
		
		return baseSchoolInfoMapper.findOneShoolInFoONGroup(baseSchoolInfo);
	}

	/**
	 * 1、修改单条Banner 2、校园咨询的编辑 
	 * @author ChenWenWu
	 * @date 2017年7月5日 下午4:50:41
	 */
	public Integer edti(BaseSchoolInfo bif,String time, String group, String shoolinofid) {
		 Date date = DateUtil.parse(time.substring(0,19));
   	     Date date1 = DateUtil.parse(time.substring(22));
		 bif.setId(shoolinofid);
		 bif.setStartTime(date);
		 bif.setEndTime(date1);
    	 bif.setUpdateTime(new Date());
    	 bif.setContentImgs("图片集内容");
		Integer insertb =baseSchoolInfoMapper.updateById(bif);
		if(group.length()>0){
			MemInfoGroup memInfoGroup=new MemInfoGroup();
			memInfoGroup.setSchoolInfoId(shoolinofid);
			memInfoGroup.setBaseGroupId(group);//会员组ID  下拉框选择
			memInfoGroup.setUpdateTime(new Date());
			memInfoGroup.setUpdateMan(bif.getUpdateMan());
			boolean num2=memInfoGroupMapper.editOnemeninfoGroup(memInfoGroup);
		}
		return insertb;
	}

	/**
	 * 删除——banner
	 * @author ChenWenWu
	 * @date 2017年7月18日 下午3:01:22
	 * @param ids 咨询IDs
	 * @return
	 */
	public Integer delShoolinfo(String ids) {
		String [] id = ids.split(",");
		String []  aa=new String[id.length];
		 BaseSchoolInfo baseSchoolInfo=new BaseSchoolInfo();
		 baseSchoolInfo.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
		 Integer num=0;
		 for (int i = 0; i < id.length; i++) {
			 aa[i]=id[i];
		}
		 for(String lj : aa){
			 baseSchoolInfo.setId(lj);
			  num+= baseSchoolInfoMapper.updateById(baseSchoolInfo);
		 }
		return num;
	}

	/**
	 * 审核——banner
	 * @author ChenWenWu
	 * @date 2017年7月18日 下午3:01:22
	 * @return
	 */
	public Integer checkShoolinfo(String ids,Integer sentype) {
		 BaseSchoolInfo baseSchoolInfo=new BaseSchoolInfo();
		  int type=0;
			 if(sentype==0){
				 type=EnumCheckFlag.WSH.getValue();
			 } else if(sentype==1){
				 type=EnumCheckFlag.YSH.getValue();
			 }else if(sentype==2){
				 type=EnumCheckFlag.BTG.getValue();
			 }
		String [] id = ids.split(",");
		String []  aa=new String[id.length];
		 Integer num=0;
		 for (int i = 0; i < id.length; i++) {
			 aa[i]=id[i];
		}
		 for(String lj : aa){
			 baseSchoolInfo.setCheckFlag(type);//审核状态
			 baseSchoolInfo.setId(lj);
			 num+=baseSchoolInfoMapper.updateById(baseSchoolInfo);
		 }
		return num;
	}
	/**
	 * 查询活动
	 * @author ChenWenWu
	 * @date 2017年7月23日 下午3:27:13
	 * @param page
	 * @param baseSchoolInfoTwoDTO 参数实体
	 * @return
	 */

	public List<BaseSchoolInfoTwoDTO> findShoolHuoDong(Pagination page, BaseSchoolInfoTwoDTO baseSchoolInfoTwoDTO) {
		return baseSchoolInfoMapper.findShoolHuoDong(page, baseSchoolInfoTwoDTO);
	}

	/**
	 * 查询公告
	 * @author jiangwangying
	 * @date 2017年7月22日 下午10:43:02
	 * @param page 分页
	 * @param InfoType 资讯类型
	 * @param title 标题
	 * @param schoolName 园校名称
	 * @param schoolId 园校id
	 * @param rangeType 推送范围
	 * @param platform 平台标记
	 * @return
	 */
	public List<AnnouncementDTO> findAnnouncement(Pagination page, Integer InfoType, String title, String schoolName,String schoolId,Integer rangeType, Integer platform){
		
	   return baseSchoolInfoMapper.findAnnouncement(page,InfoType,title, schoolName,schoolId,rangeType,platform);
	   
	}
	
	/**
	 * 新增公告
	 * @author jiangwangying
	 * @date 2017年7月23日 下午2:47:54
	 * @param groupIds 分组id集合
	 * @param schoolId 园校id
	 * @param createMan 创建人
	 * @return
	 */
	public JsonResult addAnnouncement(BaseSchoolInfo baseSchoolInfo,String groupIds,String schoolId,Integer memberType,String createMan){

		JsonResult jsonResult = new JsonResult();
		jsonResult.setSuccess(false);
		Integer result = 0 ;
		
		if (StringUtils.isEmpty(baseSchoolInfo.getTitle()) || StringUtils.isEmpty(baseSchoolInfo.getContent()) ||StringUtils.isEmpty(baseSchoolInfo.getCoverImages()) || StringUtils.isEmpty(groupIds) || StringUtils.isEmpty(createMan)) {
			jsonResult.setMsg("空值啦");
			return jsonResult;
		}
		
		//将分组id截取成字符串数组
		String[] strGroupIds = groupIds.split(",");
		//获取数组长度
		Integer groupIdsLenght = strGroupIds.length;
		
		baseSchoolInfo.setCreateMam(createMan);
		baseSchoolInfo.setCreateTime(new Date());
		baseSchoolInfo.setCheckFlag(EnumCheckFlag.WSH.getValue());
		baseSchoolInfo.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
		baseSchoolInfo.setInfoType(EnumInfoType.GG.getValue());
		baseSchoolInfo.setBrowseCount(0);
		
		 // 平台管理员
		if (memberType == EnumMemberType.PTGL.getValue()) {
			// 用于获取自定义的平台id
			PlatformDTO platformDTO = new PlatformDTO();
			
			//标记为平台推送
			baseSchoolInfo.setPlatformFlag(EnumPlatform.PT.getValue());
			
			// 判断是否选择全平台推送
			boolean ifPlatform = false;
			for (int i = 0; i < groupIdsLenght; i++) {
				if (strGroupIds[i].trim().equals(platformDTO.getId().trim())) {
					ifPlatform = true;//全平台
				} 
			}
			if (ifPlatform) {
				//全平台推送
				baseSchoolInfo.setRangeType(EnumRangeType.QPT.getValue());
				result += baseSchoolInfoMapper.insert(baseSchoolInfo);
			} else {
				for (int i = 0; i < groupIdsLenght; i++) {
					//园校推送
					baseSchoolInfo.setId("");//多次新增同样的数据时要设置主键为空 因为新增第一条数据成功的时候会返回一个主键id 这个id不能再插进表里
					baseSchoolInfo.setRangeType(EnumRangeType.QYX.getValue());
					baseSchoolInfo.setSchoolId(strGroupIds[i]);
					result += baseSchoolInfoMapper.insert(baseSchoolInfo);
				}
			}
			if (result == 1 || result == groupIdsLenght) {
				jsonResult.setSuccess(true);
				return jsonResult;
			}
			
		// 园长、教师管理员
		} else if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()){
			if (StringUtils.isEmpty(schoolId)) {
				jsonResult.setMsg("查询不到您所在的学校");
				return jsonResult;
			}
			//标记为园校推送
			baseSchoolInfo.setPlatformFlag(EnumPlatform.YX.getValue());
			
			MemInfoGroup memInfoGroup = null;
			baseSchoolInfo.setSchoolId(schoolId);
			// 判断是否选择全园推送
			boolean ifSchool = false;
			for (int i = 0; i < groupIdsLenght; i++) {
				if (strGroupIds[i].trim().equals(schoolId)) {
					ifSchool = true;
				}
			}
			if (ifSchool) {
				//全园推送
				baseSchoolInfo.setRangeType(EnumRangeType.QYX.getValue());
				result += baseSchoolInfoMapper.insert(baseSchoolInfo);
			
			} else {
				//会员组分组推送
				baseSchoolInfo.setRangeType(EnumRangeType.FZTS.getValue());
				result += baseSchoolInfoMapper.insert(baseSchoolInfo);
				String schoolInfoId = baseSchoolInfo.getId();
					for (int i = 0; i < groupIdsLenght; i++) {
					    memInfoGroup = new MemInfoGroup();
						memInfoGroup.setSchoolInfoId(schoolInfoId);
						memInfoGroup.setBaseGroupId(strGroupIds[i]);
						memInfoGroup.setCreateMam(createMan);
						memInfoGroup.setCreateTime(new Date());
						memInfoGroup.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
						result += memInfoGroupMapper.insert(memInfoGroup);
					}
			}
			if (result == 1 || result== groupIdsLenght + 1) {
				jsonResult.setSuccess(true);
				return jsonResult;
			}
		} else {
			jsonResult.setMsg("查询管理员的类型");
			return jsonResult;
		}
		return jsonResult;
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
    public JsonResult CheckAnnouncement(String schoolInfoIds,Integer flag,String updateMan){
    	JsonResult jsonResult = new JsonResult();
    	jsonResult.setSuccess(false);
    	Integer result = 0;
    	if (StringUtils.isEmpty(schoolInfoIds) || null==flag || StringUtils.isEmpty(updateMan)) {
    		jsonResult.setMsg("值为空");
			return jsonResult;
		}
    	String[] ids = schoolInfoIds.split(",");
		Integer idsLength = ids.length;
    	BaseSchoolInfo baseSchoolInfo =  null;
		switch (flag) {
		case 1:// 下架
		   for (int i = 0; i < idsLength; i++) {
			   baseSchoolInfo = new BaseSchoolInfo();
			   baseSchoolInfo.setId(ids[i]);
			   baseSchoolInfo.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
			   result += baseSchoolInfoMapper.updateById(baseSchoolInfo);
		   }
			break;
		case 2:// 审核通过	
			for (int i = 0; i < idsLength; i++) {
			   baseSchoolInfo = new BaseSchoolInfo();
			   baseSchoolInfo.setId(ids[i]);
			   baseSchoolInfo.setCheckFlag(EnumCheckFlag.YSH.getValue());
			   result += baseSchoolInfoMapper.updateById(baseSchoolInfo);
			   }
			break;
		case 3:// 审核不通过	
			for (int i = 0; i < idsLength; i++) {
			   baseSchoolInfo = new BaseSchoolInfo();
			   baseSchoolInfo.setId(ids[i]);
			   baseSchoolInfo.setCheckFlag(EnumCheckFlag.BTG.getValue());
			   result += baseSchoolInfoMapper.updateById(baseSchoolInfo);
			   }
			break;
		default:
			break;
		}
		if (result == idsLength) {
			jsonResult.setSuccess(true);
		}else{
			jsonResult.setMsg("操作失败");
		}
    	return jsonResult;
    }
    /**
     * 编辑公告
     * @author jiangwangying
     * @date 2017年7月29日 上午08:46:08
     * @param title 标题
     * @param content 内容
     * @param schoolInfoId 资讯组id
     * @param groupIds 组id  平台id\园校id\资讯组id
     * @param updateMan 修改人
     * @param gongGaoImg 公告图片
     * @return
     */
	public JsonResult editAnnouncement(String title,String content,String schoolInfoId,String groupIds,String updateMan,Integer memberType,String gongGaoImg){
		
		JsonResult jsonResult = new JsonResult();
		Integer result = 0;
		
		if (StringUtils.isEmpty(schoolInfoId) || StringUtils.isEmpty(title) ||  StringUtils.isEmpty(groupIds) || StringUtils.isEmpty(content) || StringUtils.isEmpty(updateMan)||null==memberType) {
		    jsonResult.setSuccess(false);
			jsonResult.setMsg("修改失败：空值");
			return jsonResult;
		}
		String[] strIds = groupIds.split(",");
		int strIdsLen = strIds.length;
		PlatformDTO platformDTO = new PlatformDTO();
		BaseSchoolInfo baseSchoolInfo = new BaseSchoolInfo();
		
		if (StringUtils.isEmpty(platformDTO.getId())) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("修改失败:platformDTO.getId()为空");
			return jsonResult;
		}
		
		//在数据库查找这条公告
		EntityWrapper<BaseSchoolInfo> ew = new EntityWrapper<BaseSchoolInfo>();
		ew.where("id = {0}", schoolInfoId);
		ew.where("info_type = {0}", EnumInfoType.GG.getValue());
		ew.where("delete_flag = {0}", EnumDeleteFlag.WSC.getValue());
        List<BaseSchoolInfo> oldGongGaolist = baseSchoolInfoMapper.selectList(ew);
        if (oldGongGaolist.size() == 0) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("该公告已被删除");
			return jsonResult;
		}
		
		if (memberType == EnumMemberType.PTGL.getValue()) {
			boolean ifQPT = false;
			for (int i = 0; i < strIds.length; i++) {
				if (strIds[i].trim().equals(platformDTO.getId().trim())) {
					ifQPT = true;//全平台推送
				}
			}
			//现在要全平台推送
			if (ifQPT) {
				//现在要全平台推送   原来是全平台推送的  则修改
                if (oldGongGaolist.get(0).getRangeType() == EnumRangeType.QPT.getValue() && oldGongGaolist.get(0).getPlatformFlag() == EnumPlatform.PT.getValue()) {
                	baseSchoolInfo.setId(schoolInfoId);
    				baseSchoolInfo.setTitle(title);
    				baseSchoolInfo.setContent(content);
    				baseSchoolInfo.setUpdateMan(updateMan);
    				baseSchoolInfo.setUpdateTime(new Date());
    				if (!StringUtils.isEmpty(gongGaoImg.trim())) {
    					baseSchoolInfo.setCoverImages(gongGaoImg);
    				} else {
						baseSchoolInfo.setCoverImages(oldGongGaolist.get(0).getCoverImages());
					}
    				result += baseSchoolInfoMapper.updateById(baseSchoolInfo);
				} else if (oldGongGaolist.get(0).getRangeType() == EnumRangeType.QYX.getValue() && oldGongGaolist.get(0).getPlatformFlag() == EnumPlatform.PT.getValue()){
				 //现在要全平台推送     原来是按学校推送的 则删除
					EntityWrapper<BaseSchoolInfo> ew1 = new EntityWrapper<BaseSchoolInfo>();
			  		ew1.where("title = {0}",oldGongGaolist.get(0).getTitle());
			  		ew1.where("range_type = {0}",EnumRangeType.QYX.getValue());
			  		ew1.where("platform_flag = {0}",EnumPlatform.PT.getValue());
			  		ew1.where("create_mam = {0}", oldGongGaolist.get(0).getCreateMam());
			  		ew1.where("info_type = {0}", oldGongGaolist.get(0).getInfoType());
			  		ew1.where("delete_flag = {0}", oldGongGaolist.get(0).getDeleteFlag());
					ew1.setSqlSelect("id,school_id AS schoolId");
					ew1.groupBy("school_id");
					List<BaseSchoolInfo> schoolIdList = baseSchoolInfoMapper.selectList(ew1);
					if (schoolIdList.size()>0) {
						for (int i = 0; i < schoolIdList.size(); i++) {
							baseSchoolInfo = new BaseSchoolInfo();
							baseSchoolInfo.setId(schoolIdList.get(i).getId());
							baseSchoolInfo.setUpdateMan(updateMan);
							baseSchoolInfo.setUpdateTime(new Date());
							baseSchoolInfo.setDeleteFlag(EnumDeleteFlag.YSC.getValue()); //标记为删除
							result += baseSchoolInfoMapper.updateById(baseSchoolInfo);
						}
						
					}
					//删除后新增一条全平台的公告
					baseSchoolInfo = new BaseSchoolInfo();
					baseSchoolInfo.setTitle(title);
					baseSchoolInfo.setContent(content);
					baseSchoolInfo.setBrowseCount(0);
					if (!StringUtils.isEmpty(gongGaoImg.trim())) {
						baseSchoolInfo.setCoverImages(gongGaoImg);
					} else {
						baseSchoolInfo.setCoverImages(oldGongGaolist.get(0).getCoverImages());
					}
					baseSchoolInfo.setCreateMam(updateMan);
					baseSchoolInfo.setCreateTime(new Date());
					baseSchoolInfo.setPlatformFlag(EnumPlatform.PT.getValue());
					baseSchoolInfo.setCheckFlag(EnumCheckFlag.WSH.getValue());
					baseSchoolInfo.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
					baseSchoolInfo.setInfoType(EnumInfoType.GG.getValue());
					baseSchoolInfo.setRangeType(EnumRangeType.QPT.getValue());
					result += baseSchoolInfoMapper.insert(baseSchoolInfo);
				 } else {
					jsonResult.setMsg("无法确定推送范围");
					jsonResult.setSuccess(false);
					return jsonResult;
				}
          }else { 
        	//现在分园校推送       原来是分园校推送的
              if (oldGongGaolist.get(0).getRangeType() == EnumRangeType.QYX.getValue() && oldGongGaolist.get(0).getPlatformFlag() == EnumPlatform.PT.getValue()) {
            	
            	  EntityWrapper<BaseSchoolInfo> ew1 = new EntityWrapper<BaseSchoolInfo>();
			  		ew1.where("title = {0}",oldGongGaolist.get(0).getTitle());
			  		ew1.where("range_type = {0}",EnumRangeType.QYX.getValue());
			  		ew1.where("platform_flag = {0}",EnumPlatform.PT.getValue());
			  		ew1.where("create_mam = {0}", oldGongGaolist.get(0).getCreateMam());
			  		ew1.where("info_type = {0}", oldGongGaolist.get(0).getInfoType());
			  		ew1.where("delete_flag = {0}", oldGongGaolist.get(0).getDeleteFlag());
					ew1.setSqlSelect("id,school_id AS schoolId");
					ew1.groupBy("school_id");
					// 查询编辑前推送的学校
					List<BaseSchoolInfo> schoolIdList = baseSchoolInfoMapper.selectList(ew1);
            	    if (schoolIdList.size()>0) {
            	    	//循环判断是否需要修改或新增
            	    	for (int i = 0; i < strIdsLen; i++) { // [1,3]
            	    		boolean add = true;
            	    		for (int j = 0; j < schoolIdList.size(); j++) { // [1,2]
    							
            	    			//判断新的推送的园校id是否与旧的的一样    一样就修改
            	    			if (strIds[i].trim().equals(schoolIdList.get(j).getSchoolId().trim())) {
    								add = false;
    								schoolIdList.get(j).setTitle(title);
									schoolIdList.get(j).setContent(content);
									schoolIdList.get(j).setUpdateMan(updateMan);
									schoolIdList.get(j).setUpdateTime(new Date());
									if (!StringUtils.isEmpty(gongGaoImg.trim())) {
										schoolIdList.get(j).setContentImgs(gongGaoImg);
									} 
									result += baseSchoolInfoMapper.updateById(schoolIdList.get(j));
								}
    						}
            	    		if (add) {
            	    		    //add 为true 时说明是新推送的园校
            	    			baseSchoolInfo = new BaseSchoolInfo();
            					baseSchoolInfo.setSchoolId(strIds[i]);
            					baseSchoolInfo.setTitle(title);
            					baseSchoolInfo.setContent(content);
            					baseSchoolInfo.setBrowseCount(0);
            					if (!StringUtils.isEmpty(gongGaoImg.trim())) {
            						baseSchoolInfo.setCoverImages(gongGaoImg);
            					} else {
        							baseSchoolInfo.setCoverImages(oldGongGaolist.get(0).getCoverImages());
        						}
            					baseSchoolInfo.setCreateMam(updateMan);
            					baseSchoolInfo.setCreateTime(new Date());
            					baseSchoolInfo.setPlatformFlag(EnumPlatform.PT.getValue());
            					baseSchoolInfo.setCheckFlag(EnumCheckFlag.WSH.getValue());
            					baseSchoolInfo.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
            					baseSchoolInfo.setInfoType(EnumInfoType.GG.getValue());
            					baseSchoolInfo.setRangeType(EnumRangeType.QYX.getValue());
            					result += baseSchoolInfoMapper.insert(baseSchoolInfo);
							}
						}
            	    	for (int i = 0; i <schoolIdList.size() ; i++) { // [1,3]
            	    		boolean del = true;
            	    		for (int j = 0; j < strIdsLen; j++) { // [1,2]
            	    			//判断编辑前推送的园校id是否与新推送的一样    不一样就删除
            	    			if (schoolIdList.get(i).getSchoolId().trim().equals(strIds[j].trim())) {
    								del = false;
    							}
    						}
            	    		if (del) {
								schoolIdList.get(i).setUpdateMan(updateMan);
								schoolIdList.get(i).setUpdateTime(new Date());
								schoolIdList.get(i).setDeleteFlag(EnumDeleteFlag.YSC.getValue());
								result += baseSchoolInfoMapper.updateById(schoolIdList.get(i));
							}
            	    	}
					}else {
						for (int i = 0; i < strIdsLen; i++) {
							baseSchoolInfo = new BaseSchoolInfo();
							baseSchoolInfo.setSchoolId(strIds[i]);
							baseSchoolInfo.setTitle(title);
							baseSchoolInfo.setContent(content);
							baseSchoolInfo.setBrowseCount(0);
							if (!StringUtils.isEmpty(gongGaoImg.trim())) {
								baseSchoolInfo.setCoverImages(gongGaoImg);
							} else {
								baseSchoolInfo.setCoverImages(oldGongGaolist.get(0).getCoverImages());
							}
							baseSchoolInfo.setCreateMam(updateMan);
							baseSchoolInfo.setCreateTime(new Date());
							baseSchoolInfo.setPlatformFlag(EnumPlatform.PT.getValue());
							baseSchoolInfo.setCheckFlag(EnumCheckFlag.WSH.getValue());
							baseSchoolInfo.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
							baseSchoolInfo.setInfoType(EnumInfoType.GG.getValue());
							baseSchoolInfo.setRangeType(EnumRangeType.QYX.getValue());
							result += baseSchoolInfoMapper.insert(baseSchoolInfo);
						}
					}
            	    //现在分园校推送    原来是全平台推送
			    } else if (oldGongGaolist.get(0).getRangeType() == EnumRangeType.QPT.getValue() && oldGongGaolist.get(0).getPlatformFlag() == EnumPlatform.PT.getValue()){
					// 先把原来平台推送的一条数据删除  再为每个学校新增一条公告
			    	baseSchoolInfo = new BaseSchoolInfo();
		    	    baseSchoolInfo.setId(schoolInfoId);
					baseSchoolInfo.setUpdateMan(updateMan);
					baseSchoolInfo.setUpdateTime(new Date());
					baseSchoolInfo.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
					result += baseSchoolInfoMapper.updateById(baseSchoolInfo);
					
					for (int j = 0; j < strIds.length; j++) {
					
						baseSchoolInfo = new BaseSchoolInfo();
						baseSchoolInfo.setSchoolId(strIds[j]);
						baseSchoolInfo.setTitle(title);
						baseSchoolInfo.setContent(content);
						baseSchoolInfo.setBrowseCount(0);
						if (!StringUtils.isEmpty(gongGaoImg.trim())) {
							baseSchoolInfo.setCoverImages(gongGaoImg);
						} else {
							baseSchoolInfo.setCoverImages(oldGongGaolist.get(0).getCoverImages());
						}
						baseSchoolInfo.setCreateMam(updateMan);
						baseSchoolInfo.setCreateTime(new Date());
						baseSchoolInfo.setPlatformFlag(EnumPlatform.PT.getValue());
						baseSchoolInfo.setCheckFlag(EnumCheckFlag.WSH.getValue());
						baseSchoolInfo.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
						baseSchoolInfo.setInfoType(EnumInfoType.GG.getValue());
						baseSchoolInfo.setRangeType(EnumRangeType.QYX.getValue());
						result += baseSchoolInfoMapper.insert(baseSchoolInfo);
					}
			    } else {
					jsonResult.setMsg("无法确定推送范围");
					jsonResult.setSuccess(false);
					return jsonResult;
				}
            }
			//教师、园长登录
		} else if (memberType == EnumMemberType.YZ.getValue() || memberType == EnumMemberType.LS.getValue()) {
			
			boolean ifQYX = false;
			for (int i = 0; i < strIdsLen; i++) {
				if (strIds[i].trim().equals(oldGongGaolist.get(0).getSchoolId())) {
					ifQYX = true;//全园校推送
				}
			}
			//现在是否要全园校推送
			if (ifQYX) {
				//现在要全园推送   原来是全园推送的  则修改
                if (oldGongGaolist.get(0).getRangeType() == EnumRangeType.QYX.getValue() && oldGongGaolist.get(0).getPlatformFlag() == EnumPlatform.YX.getValue()) {
                	oldGongGaolist.get(0).setTitle(title);
                	oldGongGaolist.get(0).setContent(content);
                	oldGongGaolist.get(0).setUpdateMan(updateMan);
                	oldGongGaolist.get(0).setUpdateTime(new Date());
    				if (!StringUtils.isEmpty(gongGaoImg.trim())) {
    					oldGongGaolist.get(0).setCoverImages(gongGaoImg);
    				}else {
						baseSchoolInfo.setCoverImages(oldGongGaolist.get(0).getCoverImages());
					}
    				result += baseSchoolInfoMapper.updateById(oldGongGaolist.get(0));
				} else if(oldGongGaolist.get(0).getRangeType() == EnumRangeType.FZTS.getValue() && oldGongGaolist.get(0).getPlatformFlag() == EnumPlatform.YX.getValue()){
				    	//现在要全园推送   原来是否是按会员组推送的  则删除资讯组里面的
					    MemInfoGroup memInfoGroup = new MemInfoGroup();
						EntityWrapper<MemInfoGroup> ew1 = new EntityWrapper<MemInfoGroup>();
						memInfoGroup.setUpdateMan(updateMan);
						memInfoGroup.setUpdateTime(new Date());
						memInfoGroup.setDeleteFlag(EnumDeleteFlag.YSC.getValue());
				  		ew.where("school_info_id = {0}",schoolInfoId);
				  		ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
				  		result += memInfoGroupMapper.update(memInfoGroup, ew1);
                       
				  		//删除后改变该条公告的推送范围  改为 全园校
				  		oldGongGaolist.get(0).setRangeType(EnumRangeType.QYX.getValue());
	                	oldGongGaolist.get(0).setTitle(title);
	                	oldGongGaolist.get(0).setContent(content);
	                	oldGongGaolist.get(0).setUpdateMan(updateMan);
	                	oldGongGaolist.get(0).setUpdateTime(new Date());
	    				if (!StringUtils.isEmpty(gongGaoImg.trim())) {
	    					oldGongGaolist.get(0).setCoverImages(gongGaoImg);
	    				} else {
							baseSchoolInfo.setCoverImages(oldGongGaolist.get(0).getCoverImages());
						}
	    				result += baseSchoolInfoMapper.updateById(oldGongGaolist.get(0));
				 }
          }else { //现在要进行分会员组推送
        	  
        	//判断原来是否是分会员组推送的
              if (oldGongGaolist.get(0).getRangeType() == EnumRangeType.FZTS.getValue() && oldGongGaolist.get(0).getPlatformFlag() == EnumPlatform.YX.getValue()) {
            	    EntityWrapper<MemInfoGroup> ew1 = new EntityWrapper<MemInfoGroup>();
            	    ew1.setSqlSelect("base_group_id AS baseGroupId");
			  		ew1.where("school_info_id = {0}",schoolInfoId);
			  		ew1.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
					// 查询编辑前推送的会员组
					List<MemInfoGroup> OldGroupList = memInfoGroupMapper.selectList(ew1);
            	    if (OldGroupList.size()>0) {
            	    	//循环判断是否需要修改或新增
            	    	for (int i = 0; i < strIdsLen; i++) { // [1,3]
            	    		boolean add = true;
            	    		for (int j = 0; j < OldGroupList.size(); j++) { // [1,2]
            	    			//判断新的推送的会员组id是否与旧的的一样    一样就修改
            	    			if (strIds[i].trim().equals(OldGroupList.get(j).getBaseGroupId().trim())) {
    								add = false;
    								
    								EntityWrapper<MemInfoGroup> ew2 = new EntityWrapper<MemInfoGroup>();
    								OldGroupList.get(j).setUpdateMan(updateMan);
    								OldGroupList.get(j).setUpdateTime(new Date());
    								ew.where("school_info_id = {0}",schoolInfoId);
    						  		ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
    						  		result += memInfoGroupMapper.update(OldGroupList.get(j), ew2);
								}
    						}
            	    		if (add) {
            	    		    //add 为true 时说明是新推送的会员组
            	    			MemInfoGroup memInfoGroup = new MemInfoGroup();
    							memInfoGroup.setSchoolInfoId(schoolInfoId);
    							memInfoGroup.setBaseGroupId(strIds[i]);
    							memInfoGroup.setCreateMam(updateMan);
    							memInfoGroup.setCreateTime(new Date());
    							memInfoGroup.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
    							result += memInfoGroupMapper.insert(memInfoGroup);
							}
						}
            	    	for (int i = 0; i <OldGroupList.size() ; i++) { // [1,3]
            	    		boolean del = true;
            	    		for (int j = 0; j < strIdsLen; j++) { // [1,2]
            	    			//判断编辑前推送的园校id是否与新推送的一样    不一样就删除
            	    			if (OldGroupList.get(i).getBaseGroupId().trim().equals(strIds[j].trim())) {
    								del = false;
    							}
    						}
            	    		if (del) {
            	    			EntityWrapper<MemInfoGroup> ew3 = new EntityWrapper<MemInfoGroup>();
								OldGroupList.get(i).setUpdateMan(updateMan);
								OldGroupList.get(i).setUpdateTime(new Date());
								OldGroupList.get(i).setDeleteFlag(EnumDeleteFlag.YSC.getValue());
								ew.where("school_info_id = {0}",schoolInfoId);
								ew.where("delete_flag = {0}",EnumDeleteFlag.WSC.getValue());
								result += memInfoGroupMapper.update(OldGroupList.get(i),ew3);
							}
            	    	}
					}else {
						//为0则新增
						for (int i = 0; i < strIdsLen; i++) {
							MemInfoGroup memInfoGroup = new MemInfoGroup();
							memInfoGroup.setSchoolInfoId(schoolInfoId);
							memInfoGroup.setBaseGroupId(strIds[i]);
							memInfoGroup.setCreateMam(updateMan);
							memInfoGroup.setCreateTime(new Date());
							memInfoGroup.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
							result += memInfoGroupMapper.insert(memInfoGroup);
						}
					}
	            	  //把公告推送范围改成分组推送
	              	  oldGongGaolist.get(0).setRangeType(EnumRangeType.FZTS.getValue());
	              	  oldGongGaolist.get(0).setTitle(title);
	              	  oldGongGaolist.get(0).setContent(content);
	              	  if (!StringUtils.isEmpty(gongGaoImg.trim())) {
	              		  oldGongGaolist.get(0).setCoverImages(gongGaoImg);
	      				} else {
							baseSchoolInfo.setCoverImages(oldGongGaolist.get(0).getCoverImages());
						}
	              	  oldGongGaolist.get(0).setUpdateMan(updateMan);
	              	  oldGongGaolist.get(0).setUpdateTime(new Date());
	              	  result += baseSchoolInfoMapper.updateById(oldGongGaolist.get(0));
            	    
			    } else if(oldGongGaolist.get(0).getRangeType() == EnumRangeType.QYX.getValue() && oldGongGaolist.get(0).getPlatformFlag() == EnumPlatform.YX.getValue()){
			    	 //现在分会员组校推送    原来是全校推送
			    	
					// 先把原来全校推送的一条数据修改推送范围为分组推送  再为每个会员组新增一条数据
			    	oldGongGaolist.get(0).setRangeType(EnumRangeType.FZTS.getValue());
                	oldGongGaolist.get(0).setTitle(title);
                	oldGongGaolist.get(0).setContent(content);
                	oldGongGaolist.get(0).setUpdateMan(updateMan);
                	oldGongGaolist.get(0).setUpdateTime(new Date());
    				if (!StringUtils.isEmpty(gongGaoImg.trim())) {
    					oldGongGaolist.get(0).setCoverImages(gongGaoImg);
    				} else {
						baseSchoolInfo.setCoverImages(oldGongGaolist.get(0).getCoverImages());
					}
    				result += baseSchoolInfoMapper.updateById(oldGongGaolist.get(0));
					for (int j = 0; j < strIdsLen; j++) {
						MemInfoGroup memInfoGroup= new MemInfoGroup();
						memInfoGroup.setSchoolInfoId(schoolInfoId);
						memInfoGroup.setBaseGroupId(strIds[j]);
						memInfoGroup.setCreateMam(updateMan);
						memInfoGroup.setCreateTime(new Date());
						memInfoGroup.setDeleteFlag(EnumDeleteFlag.WSC.getValue());
						result += result += memInfoGroupMapper.insert(memInfoGroup);
					}
			    }else {
					jsonResult.setMsg("无法确定推送范围");
					jsonResult.setSuccess(false);
					return jsonResult;
				}
            }
		} else {
			jsonResult.setMsg("无法确认用户身份,请换用户登录");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		if (result > 0) {
			jsonResult.setSuccess(true);
		} else {
			jsonResult.setSuccess(false);
		}
		return jsonResult;
	}
}
