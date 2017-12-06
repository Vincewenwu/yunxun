/**
 * 
 */
package com.vision.edu.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vision.edu.common.base.BaseEntity;
import com.vision.edu.dto.PrincipalMsgDTO;
import com.vision.edu.dto.WebUserVo;
import com.vision.edu.entity.member.MemPraise;
import com.vision.edu.entity.system.SysPrincipalMailbox;
import com.vision.edu.enums.EnumMemberType;
import com.vision.edu.enums.EnumResourceType;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseMemberService;
import com.vision.edu.service.member.IMemPraiseService;
import com.vision.edu.service.system.ISysPrincipalMailboxService;

/**
 *这是园长风采的控制器
*@author:zyml
*@date:2017年7月6日下午5:16:59
*/
@Controller
@RequestMapping("/principalstyle")
public class PrincipalStyleController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(PrincipalStyleController.class);
	
	@Autowired
	private IBaseMemberService baseMemberService;     //注入IBaseMemberService
	
	@Autowired
	private ISysPrincipalMailboxService sysPrincipalMailboxService;   //注入ISysPrincipalMailboxService
	
	@Autowired
	private IMemPraiseService memPraiseService;		//注入IMemPraiseService
	
	/**
	*根据学校的id查找园长的基本信息
	*@author:zyml
	*@date:2017年7月9日下午7:53:13
	*@param strSchoolId 学校id
	 */
	@ResponseBody
	@RequestMapping("/findPrincipalById")
	public JsonResult findPrincipalById(String schoolId) {
		JsonResult rs=null;
		try {
			rs=new JsonResult();
			schoolId="2ad1c4b063f14fa3b0fe7a3c0e6b4757";
			BaseEntity  principalMsgPo=baseMemberService.findPrincipalById(schoolId,EnumMemberType.YZ.getValue());
			rs.setObj(principalMsgPo);
			rs.setStatus("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/**
	*根据id查询园长信息详情
	*@author:zyml
	*@date:2017年7月9日下午7:56:29
	*@param userId 用户id
	*/
	@ResponseBody
	@RequestMapping("/findPrincipalDetailByUserId")
	public JsonResult findPrincipalDetailByUserId(HttpServletRequest request) {
		WebUserVo<Object> userVo=super.getMember();
		JsonResult rs=new JsonResult();
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
			System.out.println("==============="+"开始查询园长的详细信息"+"============");
			PrincipalMsgDTO principalMsgPo=baseMemberService.findPrincipalDetailByUserId(userId,memberId);
			rs.setObj(principalMsgPo);
			System.out.println("==============="+"开始查询园长的详细信息"+"============");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/**
	 * 园长的点赞与取消点赞
	 * @author:zyml
	 * @date:2017年7月23日上午8:33:16
	 * @param BaseSchoolInfo 校园资讯
	 */
	@ResponseBody
	@RequestMapping("/insertPricalCount")
	public JsonResult insertPricalCount(MemPraise memPraise) {
		LOG.info("点赞情况：{}", memPraise.getCancelNo());
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isAnyBlank(memPraise.getMemberId(), memPraise.getSourceId())) {
			LOG.error("园长点赞失败：memberId={},sourceId={}", memPraise.getMemberId(), memPraise.getSourceId());
			jsonResult.setSuccess(false);
			jsonResult.setMsg("点赞失败");
			return jsonResult;
		}
		memPraise.setPraiseType(EnumResourceType.YZ.getValue());
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
	*根据id进行园长点赞数是否唯一显示相应的状态
	*@author:zyml
	*@date:2017年7月22日下午5:46:45
	*@param userId 用户id
	*/
	@ResponseBody
	@RequestMapping("/findByUserId")
	public JsonResult findByUserId(HttpServletRequest request) {
		JsonResult rs=null;
		/*try {*/
			rs=new JsonResult();
			String userId=request.getParameter("id");
			/*System.out.println("==================================");
			MemPraise memPraise=memPraiseService.findByUserId(userId);
			if (memPraise!=null) {
				rs.setObj(memPraise);
				System.out.println("==================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return rs;
	}
	
	/**
	 *园长赞数的修改
	 *@author:zyml
	 *@date:2017年7月12日上午8:20:24
	 *@param BaseSchoolInfo 校园资讯
	 */
	@ResponseBody
	@RequestMapping("/UpdateYuanZhangDianZanNum")
	public JsonResult UpdateYuanZhangDianZanNum(MemPraise memPraise) {
		return memPraiseService.UpdateYuanZhangDianZanNum(memPraise);
	}
	
	/**
	 *根据点赞记录id进行查询
	*@author:zyml
	*@date:2017年7月23日下午10:06:42
	*@param priaseId 点赞记录id
	*/
	@ResponseBody
	@RequestMapping("/findByPriaseId")
	public JsonResult findByPriaseId(String priaseId) {
		JsonResult rs=null;
		try {
			rs =new JsonResult();
			MemPraise memPraise=memPraiseService.findByPriaseId(priaseId);
			rs.setObj(memPraise);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
		

	}
	

	/**
	*园长点赞数的增加
	*@author:zyml
	*@date:2017年7月23日上午8:33:16
	*@param BaseSchoolInfo 校园资讯
	*/
	@ResponseBody
	@RequestMapping("/insertYuanZhangPraseCount")
	public JsonResult insertYuanZhangPraseCount(MemPraise memPraise) {
	  return memPraiseService.insertYuanZhangPraseCount(memPraise);
	}
	
	/**
	*新增园长信箱的信息
	*@author:zyml
	*@date:2017年7月10日上午11:57:49
	*@param sysPrincipalMailbox 园长信箱对象
	*/
	@ResponseBody
	@RequestMapping("/addPrincipal")
	public String addPrincipal(SysPrincipalMailbox sysPrincipalMailbox) {
		this.sysPrincipalMailboxService.addPrincipal(sysPrincipalMailbox);
		return "";	
	}
	
	/**
	*新增园长的点赞数
	*@author:zyml
	*@date:2017年7月11日下午7:42:33
	*@param MemPraise 表扬实体
	*/
	@ResponseBody
	@RequestMapping("/addPrincipalParise")
	public void addPrincipalParise(MemPraise memPraise) {
		this.memPraiseService.addPrincipalParise(memPraise);
	}
	
}
