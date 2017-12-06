package com.vision.edu.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.vision.edu.dto.BaseSignRecordDto;
import com.vision.edu.dto.CommentinfoDto;
import com.vision.edu.dto.CookbookPublishersSetDto;
import com.vision.edu.dto.MemClassCircleDto;
import com.vision.edu.dto.MemDynamicDto;
import com.vision.edu.dto.MemGrowthDto;
import com.vision.edu.dto.MemSchoolRecipeDetailDto;
import com.vision.edu.dto.ResourceCollectionDto;
import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.enums.EnumDeleteFlag;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseBabyService;
import com.vision.edu.service.base.IBaseSignRecordService;
import com.vision.edu.service.member.IMemClassCircleService;
import com.vision.edu.service.member.IMemCommentService;
import com.vision.edu.service.member.IMemDynamicService;
import com.vision.edu.service.member.IMemGrowthService;
import com.vision.edu.service.member.IMemSchoolRecipeDetailService;
import com.vision.edu.service.system.ISysUserService;

/**
 * 和班【家长端】
 * @author lichenglong
 * @date 2017年7月16日 上午10:15:18
 * @version 1.0
 */
@Controller
@RequestMapping("/parentsSideAndClass")
public class ParentsSideAndClassController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(ParentsSideAndClassController.class);
	@Autowired
	private IMemSchoolRecipeDetailService memSchoolRecipeDetailService;//注入园校食谱明细IMemSchoolRecipeDetailService
	@Autowired
	private IBaseBabyService baseBabyService;//注入宝贝IBaseBabyService
	@Autowired
	private IBaseSignRecordService baseSignRecordService;//注入签到记录IBaseSignRecordService
	@Autowired
	private IMemGrowthService memGrowthService;//注入成长轨迹IMemGrowthService
	@Autowired
	private IMemClassCircleService memClassCircleService;//注入班级圈IMemClassCircleService
	@Autowired
	private IMemDynamicService memDynamicService;//注入动态表IMemDynamicService
	@Autowired
	private ISysUserService sysUserService;//注入后台用户ISysUserService
	@Autowired
	private IMemCommentService memCommentService;//注入评论记录IMemCommentService
	
	/**
	 * 和班-全部
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月16日 上午10:22:47
	 */
	@ResponseBody
	@RequestMapping("/wholeInformation")
	public JsonResult wholeInformation(HttpServletRequest request){
		String babyId = request.getParameter("babyId");//宝贝id
		Integer row = 0;
		if(Integer.parseInt(request.getParameter("row")) > 0){
			row = Integer.parseInt(request.getParameter("row"));
		}
		System.out.println("页码:"+row);
		BaseBaby baseBaby = baseBabyService.selectById(babyId);
		List<MemDynamicDto> listAndClass = new ArrayList<MemDynamicDto>();
		Page<MemDynamicDto> page = new Page<MemDynamicDto>(1,6+row);
		List<MemDynamicDto> listMemDynamicDto = memDynamicService.findWholeInformation(page,baseBaby.getClassId(), EnumDeleteFlag.WSC.getValue());
		int runs = 0;
		for (MemDynamicDto Data : listMemDynamicDto) {
			//菜谱
			List<CookbookPublishersSetDto> listCookbookPublishersSetDto = new ArrayList<CookbookPublishersSetDto>();
			if(runs == 0){
				Page<MemDynamicDto> pageMemDynamic = new Page<MemDynamicDto>(1,1);
				List<MemDynamicDto> listMemDynamicDtos = memDynamicService.findAKindOfDynamic(pageMemDynamic,baseBaby.getClassId(),EnumResourceType.SP.getValue(),EnumDeleteFlag.WSC.getValue());
				for (MemDynamicDto Datas : listMemDynamicDtos) {
					CookbookPublishersSetDto cookbookPublishersSetDto = sysUserService.findDailyRecipes(Datas.getResourcesId(),EnumResourceType.SP.getValue());
					List<MemSchoolRecipeDetailDto>  listMSRDDto = memSchoolRecipeDetailService.findRecipeCollectionField(Datas.getResourcesType(),Datas.getResourcesId(), EnumDeleteFlag.WSC.getValue());
					cookbookPublishersSetDto.setListMemSchoolRecipeDetailDto(listMSRDDto);
					listCookbookPublishersSetDto.add(cookbookPublishersSetDto);
				}
				runs = runs + 1;
			}
			//签到
			List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordService.findSignInCollectionField(Data.getResourcesType(), Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
			//成长轨迹
			List<MemGrowthDto> list = new ArrayList<MemGrowthDto>();
			if(Data.getResourcesType() == EnumResourceType.CZGJ.getValue()){
				List<MemGrowthDto> listMemGrowthDto = memGrowthService.findGrowthTrajectoryCollectionField(Data.getResourcesType(), Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
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
					String[] strs=str.split(",");//分割符
					for (int i = 0; i < strs.length; i++) {
						resourceCollection = new ResourceCollectionDto();
						resourceCollection.setUniformResourceLocator(strs[i].toString());
						listTwo.add(resourceCollection);
					}
					data.setListResourceCollectionDto(listTwo);
					list.add(data);
				}
			}
			//班级圈动态
			List<MemClassCircleDto> listClass = new ArrayList<MemClassCircleDto>();
			List<MemClassCircleDto>  listMemClassCircleDto = memClassCircleService.findDynamicCollectionClassRing(Data.getResourcesType(), Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
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
				listClass.add(data);
			}
			
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
			memDynamicDto.setRow(listMemDynamicDto.size());
			memDynamicDto.setListCookbookPublishersSetDto(listCookbookPublishersSetDto);
			memDynamicDto.setListBaseSignRecordDto(listBaseSignRecordDto);
			memDynamicDto.setListMemGrowthDto(list);
			memDynamicDto.setListMemClassCircleDto(listClass);
			listAndClass.add(memDynamicDto);
		}
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listAndClass);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 每日餐谱
	 * @author lichenglong
	 * @date 2017年7月16日 下午2:54:04
	 */
	@ResponseBody
	@RequestMapping("/andClassDailyDiet")
	public JsonResult andClassDailyDiet(HttpServletRequest request){
		String babyId = request.getParameter("babyId");//宝贝id
		BaseBaby baseBaby = baseBabyService.selectById(babyId);
		List<CookbookPublishersSetDto> list = new ArrayList<CookbookPublishersSetDto>();
		Page<MemDynamicDto> page = new Page<MemDynamicDto>(1,1);
		List<MemDynamicDto> listMemDynamicDto = memDynamicService.findAKindOfDynamic(page,baseBaby.getClassId(),EnumResourceType.SP.getValue(),EnumDeleteFlag.WSC.getValue());
		for (MemDynamicDto Data : listMemDynamicDto) {
			CookbookPublishersSetDto cookbookPublishersSetDto = sysUserService.findDailyRecipes(Data.getResourcesId(),EnumResourceType.SP.getValue());
			List<MemSchoolRecipeDetailDto>  listMSRDDto = memSchoolRecipeDetailService.findRecipeCollectionField(Data.getResourcesType(),Data.getResourcesId(), EnumDeleteFlag.WSC.getValue());
			cookbookPublishersSetDto.setListMemSchoolRecipeDetailDto(listMSRDDto);
			list.add(cookbookPublishersSetDto);
		}
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(list);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 每日餐谱详情
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月16日 下午4:38:01
	 */
	@ResponseBody
	@RequestMapping("/theDailyDietForDetails")
	public JsonResult theDailyDietForDetails(HttpServletRequest request){
		String schoolRecipeId = request.getParameter("schoolRecipeId");//园校食谱id
		List<CookbookPublishersSetDto> listAndClass = new ArrayList<CookbookPublishersSetDto>();
		CookbookPublishersSetDto cookbookPublishersSetDto = sysUserService.findDailyRecipes(schoolRecipeId,EnumResourceType.SP.getValue());
		List<MemSchoolRecipeDetailDto>  listMSRDDto = memSchoolRecipeDetailService.findRecipeCollectionField(EnumResourceType.SP.getValue(),schoolRecipeId, EnumDeleteFlag.WSC.getValue());
		cookbookPublishersSetDto.setListMemSchoolRecipeDetailDto(listMSRDDto);
		listAndClass.add(cookbookPublishersSetDto);
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listAndClass);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 每日餐谱更多
	 * @author lichenglong
	 * @date 2017年7月17日 下午4:31:45
	 */
	@ResponseBody
	@RequestMapping
	public void dailyDietMore(){
		
	}
	
	/**
	 * 考勤签到
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月16日 下午3:15:12
	 */
	@ResponseBody
	@RequestMapping("/andClassAttendanceSignIn")
	public JsonResult andClassAttendanceSignIn(HttpServletRequest request){
		String babyId = request.getParameter("babyId");//宝贝id
		BaseBaby baseBaby = baseBabyService.selectById(babyId);
		List<BaseSignRecordDto> listBaseSignRecordDto = baseSignRecordService.findAttendanceSignIn(baseBaby.getClassId(),EnumResourceType.QD.getValue() ,EnumDeleteFlag.WSC.getValue());
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(listBaseSignRecordDto);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 成长轨迹
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月16日 下午5:04:30
	 */
	@ResponseBody
	@RequestMapping("/growthTrack")
	public JsonResult growthTrack(HttpServletRequest request){
		String babyId = request.getParameter("babyId");//宝贝id
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
			String[] strs=str.split(",");//分割符
			for (int i = 0; i < strs.length; i++) {
				resourceCollection = new ResourceCollectionDto();
				resourceCollection.setUniformResourceLocator(strs[i].toString());
				listTwo.add(resourceCollection);
			}
			data.setListResourceCollectionDto(listTwo);
			list.add(data);
		}
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(list);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 班级圈动态
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月17日 上午8:05:22
	 */
	@ResponseBody
	@RequestMapping("/classRingDynamic")
	public JsonResult classRingDynamic(HttpServletRequest request){
		String babyId = request.getParameter("babyId");//宝贝id
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
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(list);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 根据资源id查询班级圈详情
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月22日 上午8:43:52
	 */
	@ResponseBody
	@RequestMapping("/classRingDetails")
	public JsonResult classRingDetails(HttpServletRequest request){
		String resourcesId = request.getParameter("resourcesId");//资源id
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
		JsonResult jsonResult = new JsonResult();
		jsonResult.setObj(list);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
	
	/**
	 * 班级圈评论
	 * @author lichenglong
	 * @return 
	 * @date 2017年7月26日 上午8:30:02
	 */
	@ResponseBody
	@RequestMapping("/classCircles")
	public JsonResult classCircles(HttpServletRequest request){
		JsonResult jsonResult = new JsonResult();
		if(StringUtils.isAnyBlank(request.getParameter("sourceId"))){
			LOG.error("班级圈评论：资源id为空",request.getParameter("sourceId"));
			jsonResult.setObj(false);
			jsonResult.setMsg("查看评论失败");
			return jsonResult;
		}
		//根据资源id查询出评论记录
		String sourceId = request.getParameter("sourceId");//资源id
		List<CommentinfoDto> listMemComment = memCommentService.findCommentinfo(sourceId, EnumDeleteFlag.WSC.getValue());
		jsonResult.setObj(listMemComment);
		jsonResult.setMsg("ok");
		return jsonResult;
	}
}
