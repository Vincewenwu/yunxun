/**
 *
 */
package com.vision.edu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.WebUserVo;
import com.vision.edu.entity.base.BaseSchoolInfo;
import com.vision.edu.entity.member.MemApplyRecord;
import com.vision.edu.entity.member.MemComment;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.enums.EnumInfoType;
import com.vision.edu.enums.EnumRangeType;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseSchoolInfoService;
import com.vision.edu.service.member.IMemApplyRecordService;
import com.vision.edu.service.member.IMemCommentService;
import com.vision.edu.service.member.IMemPraiseService;

/**
 *校园资讯
 *@author:zyml
 *@date:2017年7月9日下午4:37:04
 */
@Controller
@RequestMapping("/schoolInfo")
public class SchoolInfoController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(SchoolInfoController.class);
	@Autowired
	private IBaseSchoolInfoService baseSchoolInfoService;	//注入IBaseSchoolInfoService

	@Autowired
	private IMemApplyRecordService memApplyRecordService;	//注入IMemApplyRecordService

	@Autowired
	private IMemCommentService memCommentService;		//注入IMemCommentService

	@Autowired
	private IMemPraiseService memPraiseService;		//注入IMemPraiseService

	/**
	 *查询公告标题的最新信息
	 *@author:zyml
	 *@date:2017年7月6日下午3:40:56
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	@ResponseBody
	@RequestMapping("/findAdvertisTitle")
	public JsonResult findAdvertisTitle(String schoolId,String babyId) {
		Map<String, Object> map =new HashMap<>();       //定义一个map用来接收
		map.put("qpt", EnumRangeType.QPT.getValue());	//全平台
		map.put("qyx", EnumRangeType.QYX.getValue());   //全院校
		map.put("fzts",EnumRangeType.FZTS.getValue());  //分组推送
		map.put("gg", EnumInfoType.GG.getValue());      //资讯
		map.put("schid", schoolId);                  //学校id
		map.put("babyId", babyId);                      //孩子id
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("================"+"开始查询资讯活动的最新信息"+"============");
			List<BaseEntity> listInforMation = baseSchoolInfoService.findAdvertisTitle(map);
			rs.setObj(listInforMation);
			System.out.println("================"+"查询资讯活动的最新信息结束"+"============");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}


	/**
	 *根据公告标题查询公告详情信息
	 *@author:zyml
	 *@date:2017年7月9日下午7:57:22
	 *@param strCode 公告id
	 */
	@ResponseBody
	@RequestMapping("/findAdvertisDetail")
	public JsonResult findAdvertisDetail(HttpServletRequest request) {
		JsonResult rs=null;
		try {
			String strCode=request.getParameter("strCode");
			rs=new JsonResult();
			System.out.println("==========="+"开始查询公告的详细信息"+"=============");
			BaseEntity baseSchoolInfo=baseSchoolInfoService.findAdvertisDetail(strCode);
			rs.setObj(baseSchoolInfo);
			System.out.println("==========="+"查询公告的详细信息结束"+"=============");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 *查看资讯活动基本最新信息
	 *@author:zyml
	 *@date:2017年7月7日上午10:12:13
	 *@param
	 */
	@ResponseBody
	@RequestMapping("/findInforMation")
	public JsonResult findInforMation(String schoolId,String babyId) {
		Map<String, Object> map =new HashMap<>();       //定义一个map用来接收
		map.put("qpt", EnumRangeType.QPT.getValue());	//全平台
		map.put("qyx", EnumRangeType.QYX.getValue());   //全院校
		map.put("fzts",EnumRangeType.FZTS.getValue());  //分组推送
		map.put("zx", EnumInfoType.ZX.getValue());      //资讯
		map.put("hd", EnumInfoType.HD.getValue());      //活动
		map.put("schoolId", schoolId);                  //学校id
		map.put("babyId", babyId);                      //孩子id
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("================"+"开始查询资讯活动的最新信息"+"============");
			List<BaseEntity> listInforMation = baseSchoolInfoService.findInforMation(map);
			rs.setObj(listInforMation);
			System.out.println("================"+"查询资讯活动的最新信息结束"+"============");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 *查看资讯活动更多信息
	 *@author:zyml
	 *@date:2017年7月7日上午10:12:13findInforMationMore
	 *@param rangeType:范围，infoType：资讯类型 ，schoolId：学校id,babyId:宝贝id
	 */
	@ResponseBody
	@RequestMapping("/findInforMationMore")
	public JsonResult findInforMationMore(String schoolId,String babyId) {
		Map<String, Object> map =new HashMap<>();       //定义一个map用来接收
		map.put("qpt", EnumRangeType.QPT.getValue());	//全平台
		map.put("qyx", EnumRangeType.QYX.getValue());   //全院校
		map.put("fzts",EnumRangeType.FZTS.getValue());  //分组推送
		map.put("zx", EnumInfoType.ZX.getValue());      //资讯
		map.put("hd", EnumInfoType.HD.getValue());      //活动
		map.put("schoolId", schoolId);                  //学校id
		map.put("babyId", babyId);                      //孩子id
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("================"+"开始查询资讯活动的最新信息"+"============");
			List<BaseEntity> listInforMation = baseSchoolInfoService.findInforMationMore(map);
			rs.setObj(listInforMation);
			System.out.println("================"+"查询资讯活动的最新信息结束"+"============");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}


	/**
	 *根据ID查看资讯详细信息
	 *@author:zyml
	 *@date:2017年7月7日下午5:16:34
	 *@param strCode 资讯id
	 */
	@ResponseBody
	@RequestMapping("/findInforMationDetail")
	public JsonResult findInforMationDetail(HttpServletRequest request) {
		WebUserVo userVo = super.getMember();
		JsonResult jsonResult = new JsonResult();
		String strCode = request.getParameter("schoolInfoId");
		String memberId =request.getParameter("memberId");
		if (userVo!=null && userVo.getBaseMember()!=null && userVo.getBaseMember().getId()!=null) {
			memberId = userVo.getBaseMember().getId();
		}

		if (StringUtils.isBlank(strCode)) {
			LOG.error("参数错误：strCode={}", strCode);
			jsonResult.setMsg("系统错误");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		try {
			LOG.info("================开始根据ID查看资讯详细信息==============");
			BaseSchoolInfo inforMationDetail = baseSchoolInfoService.findInforMationDetail(strCode, memberId);
			jsonResult.setObj(inforMationDetail);
			LOG.info("================开始根据ID查看资讯详细信息结束==============");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonResult;
	}
	/**
	 *开始查询咨询的评论信息
	 *@author:zyml
	 *@date:2017年7月8日下午8:47:01
	 *@param strCode 资讯id
	 */
	@ResponseBody
	@RequestMapping("/findInforMationDetailNext")
	public JsonResult findInforMationDetailNext(String strCode) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			strCode="2214aff4e25843eeb1eb9551e1ef075b";
			System.out.println("===================="+"开始查询咨询的评论信息"+"==================");
			List<BaseEntity> listinforMationDetailNext=baseSchoolInfoService.findInforMationDetailNext(strCode);
			System.out.println("===================="+"查询咨询的评论信息结束"+"==================");
			rs.setObj(listinforMationDetailNext);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 *根据id查看主题活动的详情信息
	 *@author:zyml
	 *@date:2017年7月9日上午9:05:45
	 *@param strCode 主题id
	 */
	@ResponseBody
	@RequestMapping("/findAllThemeActDetailById")
	public JsonResult findAllThemeActDetailById(HttpServletRequest request) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			String strCode=request.getParameter("id");
			BaseSchoolInfo themeActDetail=baseSchoolInfoService.findAllThemeActDetailById(strCode);
//
//			/*strCode="6340212887b3412d819d338faa269e78";*/
//			System.out.println("========"+"开始查询主题活动的详细信息"+"======");
//			BaseSchoolInfo themeActDetail = baseSchoolInfoService.findAllThemeActDetailById(strCode);

			rs.setObj(themeActDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;

	}



	/**
	 *活动报名的新增
	 *@author:zyml
	 *@date:2017年7月11日下午8:26:39
	 *@param MemApplyRecord 活动报名实体
	 */
	@ResponseBody
	@RequestMapping("/addActBaoMing")
	public JsonResult addActBaoMing(MemApplyRecord r) {
		return memApplyRecordService.addActBaoMing(r);
	}


	/**
	 *增加资讯详情的评论
	 *@author:zyml
	 *@date:2017年7月11日下午9:49:00
	 *@param MemComment 评论实体
	 */
//	@ResponseBody
//	@RequestMapping("/addZiXunComment")
//	public JsonResult addZiXunComment(MemComment memComment) {
//		return memCommentService.addZiXunComment(memComment);
//	}


	/**
	 *根据id进行查询点赞数是否唯一显示相应的状态
	 *@author:zyml
	 *@date:2017年7月22日下午5:46:45
	 *@param userId 用户id
	 */
	@ResponseBody
	@RequestMapping("/findByUserId")
	public JsonResult findByUserId(HttpServletRequest request) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			String userId=request.getParameter("id");
			String sourceId=request.getParameter("sourceId");
			System.out.println("==================================");
			MemPraise memPraise=memPraiseService.findByUserId(userId,sourceId);
			if (memPraise!=null) {
				rs.setObj(memPraise);
				System.out.println("==================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 *资讯点赞数的修改
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param BaseSchoolInfo 校园资讯
	 */
	@ResponseBody
	@RequestMapping("/UpdateZiXunDianZanNum")
	public JsonResult UpdateZiXunDianZanNum(MemPraise memPraise) {
		return baseSchoolInfoService.UpdateZiXunDianZanNum(memPraise);
	}

	/**
	 * 资讯的点赞与取消点赞
	 * @author:zyml
	 * @date:2017年7月23日上午8:33:16
	 * @param BaseSchoolInfo 校园资讯
	 */
	@ResponseBody
	@RequestMapping("/insertZiXunPraseCount")
	public JsonResult insertZiXunPraseCount(MemPraise memPraise) {
		LOG.info("点赞情况：{}", memPraise.getCancelNo());
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isAnyBlank(memPraise.getMemberId(), memPraise.getSourceId())) {
			LOG.error("资讯点赞失败：memberId={},sourceId={}", memPraise.getMemberId(), memPraise.getSourceId());
			jsonResult.setSuccess(false);
			jsonResult.setMsg("点赞失败");
			return jsonResult;
		}
		memPraise.setPraiseType(EnumResourceType.ZX.getValue());
		MemPraise praise = memPraiseService.changePraise(memPraise);
		if (praise == null) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("点赞失败");
			return jsonResult;
		}
		jsonResult.setMsg("点赞成功");
		jsonResult.setSuccess(true);
		jsonResult.setObj(praise);
		return jsonResult;
	}

	/**
	 * 增加评论/回复
	 * @author zhangfeihong
	 * @date 2017年7月26日 上午1:44:40
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addCommentOrReply")
	public JsonResult addCommentOrReply(MemComment comment) {
		JsonResult jsonResult = new JsonResult();
		comment.setCommentType(EnumResourceType.ZX.getValue());
		MemComment memComment = memCommentService.addCommentOrReply(comment);
		// TODO 评论未完成
		return jsonResult;
	}




	/**
	 *资讯浏览量的增加
	 *@author:zyml
	 *@date:2017年7月12日上午9:09:24
	 *@param BaseSchoolInfo 校园资讯实体
	 */
	@ResponseBody
	@RequestMapping("/addZiXunLiuLanCount")
	public JsonResult addZiXunLiuLanCount(BaseSchoolInfo baseSchoolInfo) {
		return baseSchoolInfoService.addZiXunLiuLanCount(baseSchoolInfo);
	}

	/**
	 *活动浏览量的增加
	 *@author:zyml
	 *@date:2017年7月12日上午9:09:24
	 *@param BaseSchoolInfo 校园资讯实体
	 */
	@ResponseBody
	@RequestMapping("/addActLiuLanCount")
	public JsonResult addActLiuLanCount(BaseSchoolInfo baseSchoolInfo) {
		return baseSchoolInfoService.addActLiuLanCount(baseSchoolInfo);
	}


}
