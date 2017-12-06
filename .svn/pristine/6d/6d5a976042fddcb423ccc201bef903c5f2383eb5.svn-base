/**
 * 
 */
package com.vision.edu.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.GardenerDTO;
import com.vision.edu.dto.WebUserVo;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseMemberService;
import com.vision.edu.service.member.IMemPraiseService;

/**
*这是园丁风采的控制器
*@author:zyml
*@date:2017年7月9日下午2:58:25
*/
@Controller
@RequestMapping("/gardenerStyle")
public class GardenerStyleController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(GardenerStyleController.class);

	@Autowired
	private IBaseMemberService baseMemberService;
	
	@Autowired
	private IMemPraiseService memPraiseService;
	
	/**
	 *查询一个园校所有老师的基本信息
	*@author:zyml
	*@date:2017年7月9日下午7:29:14
	*@param strCode 学校id
	 */
	@ResponseBody
	@RequestMapping("/findListTeacher")
	public JsonResult findListTeacher(String schoolId) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("==============="+"开始查询园丁的基本信息"+"============");
			 schoolId="1";
			List<BaseEntity> listGardenerPo=baseMemberService.findListTeacher(schoolId,EnumMemberType.LS.getValue());
			System.out.println("==============="+"查询园丁的基本信息结束"+"============");
			rs.setObj(listGardenerPo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	*根据园丁id查询所有的详细信息
	*@author:zyml
	*@date:2017年7月9日下午5:47:13
	*@param strCode 园丁的id
	 */
	@ResponseBody
	@RequestMapping("/findListTeacherDetailById")
	public JsonResult findListTeacherDetailById(HttpServletRequest request) {
		JsonResult rs=new JsonResult();
		WebUserVo<Object> userVo=super.getMember();
		String userId=request.getParameter("id");
		String memberId = request.getParameter("memberId");
		if (userVo!=null && userVo.getBaseMember()!=null && userVo.getBaseMember().getId() !=null) {
			memberId=userVo.getBaseMember().getId();
		}
		if (StringUtils.isBlank(userId)) {
			LOG.error("参数错误：userId={}",userId);
			rs.setMsg("系统参数错误!");
			rs.setSuccess(false);
			return rs;
		}
		try {
			rs=new JsonResult();
			BaseEntity gardenerPo=baseMemberService.findListTeacherDetailById(userId,memberId);
			rs.setObj(gardenerPo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/**
	 *查询一个园校的更多老师
	*@author:zyml
	*@date:2017年7月9日下午7:29:14
	*@param strCode 学校id
	 */
	@ResponseBody
	@RequestMapping("/findListTeacherMore")
	public JsonResult findListTeacherMore(String schoolId) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			System.out.println("==============="+"开始查询园丁的基本信息"+"============");
			 schoolId="1";
			List<BaseEntity> listGardenerPo=baseMemberService.findListTeacherMore(schoolId,EnumMemberType.LS.getValue());
			System.out.println("==============="+"查询园丁的基本信息结束"+"============");
			rs.setObj(listGardenerPo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	*根据id进行园丁点赞数是否唯一显示相应的状态
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
			/*sourceId*/
			System.out.println("==================================");
			/*MemPraise memPraise=memPraiseService.findByUserId(userId);
			if (memPraise!=null) {
				rs.setObj(memPraise);
				System.out.println("==================================");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/**
	 *园丁点赞数的修改
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param BaseSchoolInfo 校园资讯
	 */
	@ResponseBody
	@RequestMapping("/UpdateYuanDingDianZanNum")
	public JsonResult UpdateYuanDingDianZanNum(MemPraise memPraise) {
		return memPraiseService.UpdateYuanDingDianZanNum(memPraise);
	}
	
	/**
	*园丁点赞数的新增
	*@author:zyml
	*@date:2017年7月11日上午11:04:12
	*@param MemPraise 表扬实体
	*/
	@ResponseBody
	@RequestMapping("/addTeacherParise")
	public JsonResult addTeacherParise(MemPraise memPraise) {
		return memPraiseService.addTeacherParise(memPraise);
	}
	
	/**
	 *园丁点赞数取消点赞
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param BaseSchoolInfo 校园资讯
	 */
	@ResponseBody
	@RequestMapping("/UpdateDianZanNum")
	public JsonResult UpdateDianZanNum(MemPraise memPraise) {
		return memPraiseService.UpdateDianZanNum(memPraise);
	}
	
	
	/**
	 * 园丁的点赞与取消点赞
	 * @author:zyml
	 * @date:2017年7月23日上午8:33:16
	 * @param BaseSchoolInfo 校园资讯
	 */
	@ResponseBody
	@RequestMapping("/insertGardenCount")
	public JsonResult insertGardenCount(MemPraise memPraise) {
		LOG.info("点赞情况：{}", memPraise.getCancelNo());
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isAnyBlank(memPraise.getMemberId(), memPraise.getSourceId())) {
			LOG.error("园长点赞失败：memberId={},sourceId={}", memPraise.getMemberId(), memPraise.getSourceId());
			jsonResult.setSuccess(false);
			jsonResult.setMsg("点赞失败");
			return jsonResult;
		}
		memPraise.setPraiseType(EnumResourceType.LS.getValue());
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


	
	
}
