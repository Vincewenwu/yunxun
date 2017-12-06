package com.vision.edu.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vision.edu.dto.WebUserVo;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.member.IMemParentBabyService;

/**
 * @author zhangfeihong
 * @date 2017年7月25日 上午12:43:33
 * @version 1.0
 */

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private IMemParentBabyService memParentBabyService;

	@ResponseBody
	@RequestMapping("/doBinDingChild")
	public JsonResult doBinDingChild(HttpServletRequest request) {
		JsonResult jsonResult = new JsonResult();
		WebUserVo userVo = super.getMember();
		if (userVo == null || StringUtils.isBlank(userVo.getBaseWechat().getUnionId())) {
			LOG.error("登陆信息过期");
			jsonResult.setMsg("登陆信息过期");
			jsonResult.setSuccess(false);
			return jsonResult;
		}

		//获取参数，判断参数
		String mobile = request.getParameter("mobile");
		String kidName = request.getParameter("kidName");
		String bingDingCode = request.getParameter("bingDingCode");
		String parentName = request.getParameter("parentName");
		String kinship = request.getParameter("kinship");
		if (StringUtils.isAnyBlank(mobile, kidName, bingDingCode, parentName, kinship)) {
			LOG.error("绑定宝贝参数错误！mobile={}, kidName={}, bingDingCode={}, parentName={}, kinship={}", mobile, kidName, bingDingCode, parentName, kinship);
			jsonResult.setMsg("信息不全");
			jsonResult.setSuccess(false);
			return jsonResult;
		}

		//绑定孩子
		Map<String, Object> map = new HashMap<>();
		map.put("mobile", mobile);
		map.put("kidName", kidName);
		map.put("bingDingCode", bingDingCode);
		map.put("parentName", parentName);
		map.put("kinship", kinship);
		userVo = memParentBabyService.doBinDingChild(userVo, map);
		if (userVo.getBaseBaby() == null) {
			jsonResult.setSuccess(false);
			jsonResult.setMsg("绑定失败");
			jsonResult.setObj(userVo);
		} else {
			super.setMember(userVo);
			jsonResult.setSuccess(true);
			jsonResult.setMsg("绑定成功");
			jsonResult.setObj(userVo);
		}
		return jsonResult;
	}
}
