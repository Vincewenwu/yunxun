//package com.vision.edu.web.controller.api;
//
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.ContextLoader;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.alibaba.fastjson.JSON;
//import com.vision.edu.core.queue.RedisQueue;
//import com.vision.edu.dto.apiVo.BabyPo;
//import com.vision.edu.entity.base.BaseBaby;
//import com.vision.edu.entity.base.BaseClass;
//import com.vision.edu.entity.base.BaseGrade;
//import com.vision.edu.entity.base.BaseSchool;
//import com.vision.edu.entity.base.BaseSign;
//import com.vision.edu.entity.base.BaseSignRecord;
//import com.vision.edu.entity.member.MemBabyCards;
//import com.vision.edu.entity.member.MemBabySurrogate;
//import com.vision.edu.enums.EnumRecordState;
//import com.vision.edu.framework.exception.BusinessException;
//import com.vision.edu.platform.common.result.JsonResult;
//import com.vision.edu.service.base.IBaseBabyService;
//import com.vision.edu.service.base.IBaseClassService;
//import com.vision.edu.service.base.IBaseGradeService;
//import com.vision.edu.service.base.IBaseSchoolService;
//import com.vision.edu.service.base.IBaseSignRecordService;
//import com.vision.edu.service.member.IMemBabyCardsService;
//import com.vision.edu.service.member.IMemBabySurrogateService;
//
///**
// * 考勤卡服务接口
// * @author zhangfeihong
// * @date 2017年7月30日 下午3:25:12
// * @version 1.0
// */
//@Controller
//@RequestMapping("/cardServer")
////@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
////@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
//public class CardServerController {
//
//	private static final Logger LOG = LoggerFactory.getLogger(CardServerController.class);
//
//	@Autowired
//	private IBaseBabyService baseBabyService;
//
//	@Autowired
//	private IBaseClassService baseClassService;
//
//	@Autowired
//	private IBaseGradeService baseGradeService;
//
//	@Autowired
//	private IMemBabyCardsService memBabyCardsService;
//	@Autowired
//	private IMemBabySurrogateService memBabySurrogateService;
//	@Autowired
//	private IBaseSchoolService baseSchoolService;
//	@Autowired
//	private IBaseSignRecordService baseSignRecordService;
//	@Bean("jedisQueue")
//	private RedisQueue<BaseSign> getJedisQueue() {
//		return new RedisQueue<BaseSign>();
//	}
//	/**
//	 * 获取所有宝贝信息
//	 * @author zhangfeihong
//	 * @date 2017年7月30日 下午3:28:01
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/findBabyAll")
////	@Test
//	public JsonResult findBabyAll() {
//		JsonResult jsonResult = new JsonResult();
//		List<BaseBaby> babies = baseBabyService.findBabyAll();
//		if (babies == null || babies.isEmpty()) {
//			jsonResult.setSuccess(false);
//			jsonResult.setMsg("宝贝信息不存在");
//			LOG.info(JSON.toJSONString(jsonResult));
//			return jsonResult;
//		}
//		jsonResult.setSuccess(true);
//		jsonResult.setObj(babies);
//		LOG.info(JSON.toJSONString(jsonResult));
//		return jsonResult;
//	}
//
//	@ResponseBody
//	@RequestMapping("/findBabyBySchoolId")
//	public JsonResult findBabyBySchoolId(String schoolId) {
//		if (StringUtils.isBlank(schoolId) || schoolId.length() < 32) {
//			throw new BusinessException("参数错误");
//		}
//		JsonResult jsonResult = new JsonResult();
//		BaseSchool baseSchool = new BaseSchool();
//		baseSchool.setId(schoolId);
//		List<BabyPo> babies = baseBabyService.findBabyBySchoolId(baseSchool);
//		if (babies == null || babies.isEmpty()) {
//			jsonResult.setMsg("没有数据");
//			jsonResult.setSuccess(false);
//			return jsonResult;
//		}
//		jsonResult.setMsg("查询成功");
//		jsonResult.setObj(babies);
//		jsonResult.setSuccess(true);
//		return jsonResult;
//	}
//
//	/**
//	 * 根据园校id查询所有年级
//	 * @author zhangfeihong
//	 * @date 2017年7月30日 下午8:55:40
//	 */
//	@ResponseBody
//	@RequestMapping("/findGradeBySchoolId")
////	@Test
//	public JsonResult findGradeBySchoolId(String schoolId) {
//		JsonResult jsonResult = new JsonResult();
//		BaseSchool baseSchool = new BaseSchool();
//		baseSchool.setId(schoolId);
//		List<BaseGrade> grades = baseGradeService.findGradeBySchoolId(baseSchool);
//		if (grades == null || grades.isEmpty()) {
//			jsonResult.setMsg("查询年级失败");
//			jsonResult.setSuccess(false);
//			return jsonResult;
//		}
//		jsonResult.setObj(grades);
//		jsonResult.setMsg("查询成功");
//		jsonResult.setSuccess(true);
//		return jsonResult;
//	}
//
//	/**
//	 * 根据年级id查询但前园校当前年级的所有班
//	 * @author zhangfeihong
//	 * @date 2017年7月30日 下午8:56:15
//	 */
//	@ResponseBody
//	@RequestMapping("/findClassByGradeId")
////	@Test
//	public JsonResult findClassByGradeId(String gradeId) {
//		JsonResult jsonResult = new JsonResult();
//		BaseGrade baseGrade = new BaseGrade();
//		baseGrade.setId(gradeId);
//		List<BaseClass> classes = baseClassService.selectClassByGradeId(baseGrade);
//		if (classes == null || classes.isEmpty()) {
//			jsonResult.setSuccess(false);
//			jsonResult.setMsg("查询班级失败");
//			return jsonResult;
//		}
//		jsonResult.setSuccess(true);
//		jsonResult.setMsg("查询成功");
//		jsonResult.setObj(classes);
//		return jsonResult;
//	}
//
//	/**
//	 * 根据班级id查询孩子
//	 * @author zhangfeihong
//	 * @date 2017年7月30日 下午11:02:01
//	 */
//	@ResponseBody
//	@RequestMapping("/findBabyByClassId")
//	public JsonResult findBabyByClassId(String baseClassId) {
//		JsonResult jsonResult = new JsonResult();
//		BaseClass baseClass = new BaseClass();
//		baseClass.setId(baseClassId);
//		List<BaseBaby> babies = baseBabyService.findBabyByClassId(baseClass);
//		if (babies == null || babies.isEmpty()) {
//			jsonResult.setMsg("查询孩子信息失败");
//			jsonResult.setSuccess(false);
//		}
//		jsonResult.setMsg("查询孩子信息成功");
//		jsonResult.setSuccess(true);
//		jsonResult.setObj(babies);
//		return jsonResult;
//	}
//
//	/**
//	 * 根据宝贝id查询宝贝所拥有卡号
//	 * @author zhangfeihong
//	 * @date 2017年7月30日 下午11:04:53
//	 */
//	@ResponseBody
//	@RequestMapping("/findCardByBabyId")
////	@Test
//	public JsonResult findCardByBabyId(String babyId) {
//		JsonResult jsonResult = new JsonResult();
//		BaseBaby baseBaby=new BaseBaby();
//		baseBaby.setId("e5a87cbfbb7a4b869c346f312ae6f451");
//		List<MemBabyCards> babyCards = memBabyCardsService.findCardByBabyId(baseBaby);
//		if (babyCards == null || babyCards.isEmpty()) {
//			jsonResult.setMsg("没有卡号信息");
//			jsonResult.setSuccess(false);
//			return jsonResult;
//		}
//		jsonResult.setMsg("查询成功");
//		jsonResult.setObj(babyCards);
//		jsonResult.setSuccess(true);
//		return jsonResult;
//	}
//
//	/**
//	 * 根据卡号查询宝贝信息
//	 * @author zhangfeihong
//	 * @date 2017年7月31日 上午8:44:27
//	 */
//	@ResponseBody
//	@RequestMapping("/findBybyByCardNum")
////	@Test
//	public JsonResult findBybyByCardNum() {
//		JsonResult jsonResult = new JsonResult();
//		MemBabyCards memBabyCards = new MemBabyCards();
//		memBabyCards.setCardNum("234234344");
//		BaseBaby baseBaby = baseBabyService.findBybyByCardNum(memBabyCards);
//		if (baseBaby == null) {
//			jsonResult.setMsg("宝贝不存在，或卡号不正确");
//			jsonResult.setSuccess(false);
//			return jsonResult;
//		}
//		jsonResult.setMsg("查询成功");
//		jsonResult.setObj(baseBaby);
//		jsonResult.setSuccess(true);
//		return jsonResult;
//	}
//
//	/**
//	 * 根据宝贝id查询宝贝接送人信息
//	 * @author zhangfeihong
//	 * @date 2017年7月31日 上午9:25:30
//	 */
//	@ResponseBody
//	@RequestMapping("/findBabySurrogateByBabyId")
//	public JsonResult findBabySurrogateByBabyId() {
//		JsonResult jsonResult = new JsonResult();
//		BaseBaby baseBaby=new BaseBaby();
//		baseBaby.setId("");
//		List<MemBabySurrogate> babySurrogates = memBabySurrogateService.findBabySurrogateByBabyId(baseBaby);
//		if (babySurrogates == null || babySurrogates.isEmpty()) {
//			jsonResult.setMsg("没有信息");
//			jsonResult.setSuccess(false);
//			return jsonResult;
//		}
//		jsonResult.setMsg("查询成功");
//		jsonResult.setObj(babySurrogates);
//		jsonResult.setSuccess(true);
//		return jsonResult;
//	}
//
//	/**
//	 * 新增打卡记录
//	 * @author zhangfeihong
//	 * @date 2017年7月31日 上午11:48:05
//	 */
//	@ResponseBody
//	@RequestMapping("/addBabySurrogate")
//	public JsonResult addBabySurrogate(HttpServletRequest request, String signTime) {
////		我这边就给你上传刷卡数据(刷卡卡号，学生ID，刷卡时间，照片链接)
//		//获取参数，判断参数
//		JsonResult jsonResult = new JsonResult();
//		String cardNum = request.getParameter("cardNum");
//		String babyId = request.getParameter("babyId");
//		String headImg = request.getParameter("headImg");
//		Integer signType = Integer.valueOf(request.getParameter("signType"));
//		System.out.println("打卡开始");
//		System.out.println("cardNum=" + cardNum);
//		System.out.println("babyId=" + babyId);
//		System.out.println("headImg=" + headImg);
//		System.out.println("signTime=" + signTime);
//		System.out.println("signType=" + signType);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date signDate = null;
//		try {
//			signDate = sdf.parse(signTime);
//		} catch (ParseException e) {
//			signDate = new Date();
//			e.printStackTrace();
//		}
//		if (StringUtils.isAnyBlank(cardNum, babyId, headImg, signTime) && signType != null) {
//			jsonResult.setMsg("参数错误：cardNum=" + cardNum + ",babyId=" + babyId + ",headImg=" + headImg + ",signType=" + signType);
//			LOG.error("参数不全:cardNum={},babyId={},headImg={},signTime={},signType={}", cardNum, babyId, headImg, signTime, signType);
//			jsonResult.setSuccess(false);
//			return jsonResult;
//		}
//
//		//新增签到记录
//		BaseSignRecord baseSignRecord = new BaseSignRecord();
//		baseSignRecord.setBabyId(babyId);
//		baseSignRecord.setPunchManImg(headImg);
//		baseSignRecord.setSignNum(cardNum);
//		baseSignRecord.setSignTime(signDate);
//		baseSignRecord.setRecordType(signType);
//		baseSignRecord.setSignStatus(EnumRecordState.YQ.getValue());
//		BaseSign baseSign = baseSignRecordService.addBabySurrogate(baseSignRecord);
//		if (baseSign == null) {
//			jsonResult.setMsg("该宝贝不在签到名单内");
//			jsonResult.setSuccess(false);
//			return jsonResult;
//		}
//		getJedisQueue().pushFromHead(baseSign);
//		jsonResult.setMsg("签到成功");
//		jsonResult.setSuccess(true);
//		return jsonResult;
//	}
//}
