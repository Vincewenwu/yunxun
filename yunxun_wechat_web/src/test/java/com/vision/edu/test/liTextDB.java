package com.vision.edu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.dto.BaseSignRecordDto;
import com.vision.edu.dto.CookbookPublishersSetDto;
import com.vision.edu.dto.MemClassCircleDto;
import com.vision.edu.dto.MemDynamicDto;
import com.vision.edu.dto.MemGrowthDto;
import com.vision.edu.dto.MemMemberDto;
import com.vision.edu.dto.MemSchoolRecipeDetailDto;
import com.vision.edu.dto.MyMessageDto;
import com.vision.edu.dto.ResourceCollectionDto;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.member.MemComboRecord;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.service.base.IBaseBabyService;
import com.vision.edu.service.base.IBaseClassService;
import com.vision.edu.service.base.IBaseSignRecordService;
import com.vision.edu.service.member.IMemClassCircleService;
import com.vision.edu.service.member.IMemComboRecordService;
import com.vision.edu.service.member.IMemDynamicService;
import com.vision.edu.service.member.IMemGrowthService;
import com.vision.edu.service.member.IMemMemberService;
import com.vision.edu.service.member.IMemSchoolRecipeDetailService;
import com.vision.edu.service.system.ISysMessageService;
import com.vision.edu.service.system.ISysUserService;

/**
 * 测试
 * @author lichenglong
 * @date 2017年7月14日 上午11:48:43
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试 
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) 
public class liTextDB {

	@Autowired
	private IMemMemberService memMemberService;//注入会员IMemMemberService
	@Autowired
	private IMemComboRecordService memComboRecordService;//注入套餐记录IMemComboRecordService
	@Autowired
	private IMemSchoolRecipeDetailService memSchoolRecipeDetailService;//注入园校食谱明细IMemSchoolRecipeDetailService
	@Autowired
	private IBaseBabyService baseBabyService;//注入宝贝IBaseBabyService
	@Autowired
	private IBaseClassService baseClassService;//注入班级IBaseClassService
	@Autowired
	private IBaseSignRecordService baseSignRecordService;//注入签到记录IBaseSignRecordService
	@Autowired
	private IMemGrowthService memGrowthService;//注入成长轨迹IMemGrowthService
	@Autowired
	private IMemClassCircleService memClassCircleService;//注入班级圈IMemClassCircleService
	@Autowired
	private IMemDynamicService memDynamicService;//注入动态表IMemDynamicService
	@Autowired
	private ISysMessageService sysMessageService;//注入消息通知ISysMessageService
	@Autowired
	private ISysUserService sysUserService;//注入后台用户ISysUserService
	
	/**
	 * 我的
	 * @author lichenglong
	 * @date 2017年7月14日 上午11:47:53
	 */
	
	public void mine(){
		String memberId = "12bb6cc0612b430aaf727a5ce603b5a";//会员id
		List<MemMemberDto> listMemMemberInfo = memMemberService.findAccountManagement(memberId, EnumDeleteFlag.WSC.getValue());
		System.out.println(listMemMemberInfo);
		List<MemComboRecord> listMemComboRecord = memComboRecordService.findSetRecords(memberId,EnumDeleteFlag.WSC.getValue());
		System.out.println(listMemComboRecord);
		Integer intDate = 0;
		for (MemComboRecord memComboRecord : listMemComboRecord) {
			memComboRecord.getExpireTime();
			intDate += (int) ((memComboRecord.getExpireTime().getTime()-(new Date()).getTime())/1000/(24*3600));
		}
		System.out.println("天数："+intDate);
	}
	
	/**
	 * 每日餐谱
	 * @author lichenglong
	 * @date 2017年7月16日 下午3:06:26
	 */
	@Test
	public void andClassDailyDiet(){
		String babyId = "1";
		BaseBaby baseBaby = baseBabyService.selectById(babyId);
		List<CookbookPublishersSetDto> listCookbookPublishersSetDto = new ArrayList<CookbookPublishersSetDto>();
		Page<MemDynamicDto> page = new Page<MemDynamicDto>(1,6);
		List<MemDynamicDto> listMemDynamicDto = memDynamicService.findWholeInformation(page,baseBaby.getClassId(), EnumDeleteFlag.WSC.getValue());
		for (MemDynamicDto Data : listMemDynamicDto) {
			if(Data.getResourcesType()==EnumResourceType.SP.getValue()){
				CookbookPublishersSetDto cookbookPublishersSetDto = sysUserService.findDailyRecipes(Data.getResourcesId(),EnumResourceType.SP.getValue());
				List<MemSchoolRecipeDetailDto>  listMSRDDto = memSchoolRecipeDetailService.findRecipeCollectionField(Data.getResourcesType(),Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
				cookbookPublishersSetDto.setListMemSchoolRecipeDetailDto(listMSRDDto);
				listCookbookPublishersSetDto.add(cookbookPublishersSetDto);	
			}
		}
		System.out.println(listCookbookPublishersSetDto);
	}
	
	
	public void cp(){
		String babyId = "1";
		BaseBaby baseBaby = baseBabyService.selectById(babyId);
		Page<MemDynamicDto> page = new Page<MemDynamicDto>(1,6);
		List<MemDynamicDto> listMemDynamicDto = memDynamicService.findWholeInformation(page,baseBaby.getClassId(), EnumDeleteFlag.WSC.getValue());
		for (MemDynamicDto Data : listMemDynamicDto) {
		    List<MemSchoolRecipeDetailDto>  listMSRDDto = memSchoolRecipeDetailService.findRecipeCollectionField(Data.getResourcesType(),Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
		    System.out.println(listMSRDDto);
		}
	}
	
	/**
	 * 考勤签到
	 * @author lichenglong
	 * @date 2017年7月16日 下午3:15:12
	 */
	
	public void andClassAttendanceSignIn(){
		String babyId = "1";//宝贝id
		BaseBaby baseBaby = baseBabyService.selectById(babyId);
		List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordService.findAttendanceSignIn(baseBaby.getClassId(),EnumResourceType.QD.getValue(), EnumDeleteFlag.WSC.getValue());
		System.out.println(listBaseSignRecordDto);
	}
	
	/**
	 * 成长轨迹
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月16日 下午5:04:30
	 */
	
	public void growthTrack(){
		String babyId = "1";
		BaseBaby baseBaby = baseBabyService.selectById(babyId);
		List<MemGrowthDto> list = new ArrayList<MemGrowthDto>();
		List<MemGrowthDto> listMemGrowthDto = memGrowthService.findGrowthTrack(baseBaby.getClassId(),EnumResourceType.CZGJ.getValue(),EnumDeleteFlag.WSC.getValue());
		for (MemGrowthDto memGrowthDto : listMemGrowthDto) {
			MemGrowthDto data = new MemGrowthDto();
			data.setHeadPortrait(memGrowthDto.getHeadPortrait());
			data.setMemberName(memGrowthDto.getMemberName());
			data.setPublisherId(memGrowthDto.getPublisherId());
			data.setCreateTime(memGrowthDto.getCreateTime());
			data.setSummary(memGrowthDto.getSummary());
			data.setResourceSet(memGrowthDto.getResourceSet());
			data.setDynamicContent(memGrowthDto.getDynamicContent());
			data.setContentType(memGrowthDto.getContentType());
			data.setDynamicType(memGrowthDto.getDynamicType());
			data.setRelationBabyIds(memGrowthDto.getRelationBabyIds());
			data.setUserHeadPortrait(memGrowthDto.getUserHeadPortrait());
			data.setUserName(memGrowthDto.getUserName());
			data.setDutiesName(memGrowthDto.getDutiesName());
			
			ArrayList<ResourceCollectionDto> listTwo = new ArrayList<ResourceCollectionDto>();
			ResourceCollectionDto resourceCollection = null;
			String str = memGrowthDto.getResourceSet();
			String[] strs=str.split("-");
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
		System.out.println(list);
	}
	
	/**
	 * 班级圈动态
	 * @author lichenglong
	 * @date 2017年7月17日 上午8:05:22
	 */
	
	public void classRingDynamic(){
		String babyId = "1";
		BaseBaby baseBaby = baseBabyService.selectById(babyId);
		List<MemClassCircleDto> list = new ArrayList<MemClassCircleDto>();
		List<MemClassCircleDto> listMemClassCircleDto = memClassCircleService.findClassRingDynamic(baseBaby.getClassId(), EnumResourceType.DT.getValue(), EnumDeleteFlag.WSC.getValue());
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
			String[] strs=str.split("-");
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
		System.out.println(list);
	}
	
	
	public void classRingDynamicTwo(){
		String babyId = "1";
		BaseBaby baseBaby = baseBabyService.selectById(babyId);
		Page<MemDynamicDto> page = new Page<MemDynamicDto>(1,6);
		List<MemDynamicDto> listMemDynamicDto = memDynamicService.findWholeInformation(page,baseBaby.getClassId(), EnumDeleteFlag.WSC.getValue());
		for (MemDynamicDto Data : listMemDynamicDto) {
			if(Data.getResourcesType() == 3){
				 List<MemClassCircleDto>  listMemClassCircleDto = memClassCircleService.findDynamicCollectionClassRing(Data.getResourcesType(), Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
				  System.out.println(listMemClassCircleDto);
			}
		}
	}
	
	/**
	 * 和班-全部
	 * @author lichenglong
	 * @date 2017年7月16日 上午10:22:47
	 */
	
	public void wholeInformation(){
		String babyId = "1";
		BaseBaby baseBaby = baseBabyService.selectById(babyId);
		List<MemDynamicDto> listAndClass = new ArrayList<MemDynamicDto>();
		Page<MemDynamicDto> page = new Page<MemDynamicDto>(1,6);
		List<MemDynamicDto> listMemDynamicDto = memDynamicService.findWholeInformation(page,baseBaby.getClassId(), EnumDeleteFlag.WSC.getValue());
		for (MemDynamicDto Data : listMemDynamicDto) {
			//菜谱
			List<CookbookPublishersSetDto> listCookbookPublishersSetDto = new ArrayList<CookbookPublishersSetDto>();
			if(Data.getResourcesType()==EnumResourceType.SP.getValue()){
				CookbookPublishersSetDto cookbookPublishersSetDto = sysUserService.findDailyRecipes(Data.getResourcesId(),EnumResourceType.SP.getValue());
				List<MemSchoolRecipeDetailDto>  listMSRDDto = memSchoolRecipeDetailService.findRecipeCollectionField(Data.getResourcesType(),Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
				cookbookPublishersSetDto.setListMemSchoolRecipeDetailDto(listMSRDDto);
				listCookbookPublishersSetDto.add(cookbookPublishersSetDto);	
			}
			//签到
			List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordService.findSignInCollectionField(Data.getResourcesType(), Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
			//成长轨迹
			List<MemGrowthDto> listMemGrowthDto = memGrowthService.findGrowthTrajectoryCollectionField(Data.getResourcesType(), Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
			//班级圈动态
			List<MemClassCircleDto>  listMemClassCircleDto = memClassCircleService.findDynamicCollectionClassRing(Data.getResourcesType(), Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
			//
			MemDynamicDto memDynamicDto = new MemDynamicDto();
			memDynamicDto.setId(Data.getId());
			memDynamicDto.setResourcesId(Data.getResourcesId());
			memDynamicDto.setResourcesType(Data.getResourcesType());
			memDynamicDto.setSchoolId(Data.getSchoolId());
			memDynamicDto.setClassId(Data.getClassId());
			memDynamicDto.setBrowseCount(Data.getBrowseCount());
			memDynamicDto.setPointCount(Data.getPointCount());
			memDynamicDto.setCreateTime(Data.getCreateTime());
			memDynamicDto.setCreateMamId(Data.getCreateMamId());
			memDynamicDto.setListCookbookPublishersSetDto(listCookbookPublishersSetDto);
			memDynamicDto.setListBaseSignRecordDto(listBaseSignRecordDto);
			memDynamicDto.setListMemGrowthDto(listMemGrowthDto);
			memDynamicDto.setListMemClassCircleDto(listMemClassCircleDto);
			listAndClass.add(memDynamicDto);
		}
		System.out.println(listAndClass);
	}
	
	/**
	 * 每日餐谱详情
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月16日 下午4:38:01
	 */
	
	public void theDailyDietForDetails(){
		String schoolRecipeDetailId = "7af87f0001e342ca8129f34827593717";
		CookbookPublishersSetDto cookbookPublishersSetDto = sysUserService.findDailyRecipes(schoolRecipeDetailId,EnumResourceType.SP.getValue());
		List<MemSchoolRecipeDetailDto>  listMSRDDto = memSchoolRecipeDetailService.findRecipeCollectionField(EnumResourceType.SP.getValue(),schoolRecipeDetailId, EnumDeleteFlag.WSC.getValue());
		cookbookPublishersSetDto.setListMemSchoolRecipeDetailDto(listMSRDDto);
		System.out.println(cookbookPublishersSetDto);
	}
	
	/**
	 * 消息 --我的消息
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月19日 下午9:17:56
	 */
	
	public void myMessage(){
		String sendeeId = "12bb6cc0612b430aaf727a5ce603b5a";
		List<MyMessageDto> listMyMessageDto = sysMessageService.findPersonalDetails(sendeeId, EnumDeleteFlag.WSC.getValue());
		System.out.println(listMyMessageDto);
	}
	
	/**
	 * 根据资源id查询班级圈详情
	 * @author lichenglong
	 * @date 2017年7月22日 上午8:43:52
	 */
	
	public void classRingDetails(){
		String resourcesId = "dtf87f0001e342ca8129f34827593714";
		List<MemClassCircleDto> list = new ArrayList<MemClassCircleDto>();
		List<MemClassCircleDto> listMemClassCircleDto = memClassCircleService.findClassRingDetails(resourcesId,EnumDeleteFlag.WSC.getValue());
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
			String[] strs=str.split("-");
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
		System.out.println(list);
	}
}
