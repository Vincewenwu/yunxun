package com.vision.edu.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.vision.edu.core.base.Constants;
import com.vision.edu.dto.WebUserVo;
import com.vision.edu.entity.base.BaseWechat;
import com.vision.edu.platform.common.result.JsonResult;
import com.vision.edu.service.base.IBaseMemberService;
import com.vision.edu.service.base.IBaseWechatService;
import com.vision.edu.wechat.service.WeixinService;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpUserServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * @author zhangfeihong
 * @date 2017年7月21日 下午2:28:59
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class IndexController extends WxMpUserServiceImpl {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private WeixinService weixinService;

	@Autowired
	private IBaseWechatService baseWechatService;

	@Autowired
	private IBaseMemberService baseMemberService;

	public IndexController(WxMpService wxMpService) {
		super(wxMpService);
	}

	/**
	 * 用户静默授权-用户进入静默获取unionid，判断系统是否已存在，
	 * 如果已存在则自动调用数据微信用户信息，
	 * 否则重定向到确认授权进行授权确认，
	 * 并获取用户微信基本信息进行保存，用户下次进入不在需要确认授权
	 * @author zhangfeihong
	 * @date 2017年7月22日 上午8:44:44
	 * @param response
	 * @param flag 静默授权后重定向路径，默认不用传参，内部重定向使用
	 * @param
	 */
	@RequestMapping("/doAccredit")
	public void doAccredit(HttpServletResponse response, Boolean flag) {
		LOG.info("准备进入授权方法");
		String redictUrl = (flag == null || !flag) ? "/getBaseInfo" : "/getUserInfo";
		String scope = (flag == null || !flag) ? WxConsts.OAUTH2_SCOPE_BASE : WxConsts.OAUTH2_SCOPE_USER_INFO;
		String state = null;
		weixinService.doAccredit(response, scope, state, redictUrl);
	}

	/**
	 * 用户静默授权获取用户基本信息，判断是否已授权
	 * @author zhangfeihong
	 * @date 2017年7月22日 下午5:07:06
	 * @param code 静默授权获取的code
	 * @param state
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getBaseInfo")
	public String getBaseInfo(String code, String state, HttpServletRequest request, HttpServletResponse response) {
		LOG.info("静默授权code={}", code);
		WxMpOAuth2AccessToken oAuth2AccessToken = null;
		try {
			oAuth2AccessToken = weixinService.getWxMpOAuth2AccessToken(code);
			LOG.info("授权获取的AccessToken：{}", oAuth2AccessToken);
		} catch (WxErrorException e1) {
			LOG.error("core换取AccessToken失败");
			e1.printStackTrace();
		}

		//通过unionId获取本地微信信息，如果本地没有则重定向到确实授权方法
		BaseWechat baseWechat = baseWechatService.doCheckWechat(oAuth2AccessToken);
		if (baseWechat == null) {
			try {
				String redirectURI = weixinService.getWxMpConfigStorage().getOauth2redirectUri() + "/doAccredit?flag=true";
				response.sendRedirect(redirectURI);
				return null;
			} catch (IOException e) {
				LOG.error("重定向到确认授权失败");
				e.printStackTrace();
			}
		} else {
			WebUserVo webUserVo = baseMemberService.checkMember(baseWechat);
			request.getSession(true).setAttribute(Constants.SESSION_USER, webUserVo);
			LOG.info("获取微信基本信息成功base{}", baseWechat.toString());
			//获取用户基本信息后重定向回页面
			try {
				String object = JSONObject.toJSONString(webUserVo);
				String url = URLEncoder.encode(object, "utf-8");
				response.sendRedirect("http://frp3.xuechenedu.com/#/author?userVo=" + url);
				return null;
			} catch (IOException e) {
				LOG.error("{}", "重定向到新页面失败");
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 微信授权后获取用户微信基本信息
	 * @author zhangfeihong
	 * @date 2017年7月22日 上午11:56:31
	 * @param code 换取临时AccessToken参数
	 * @param state 自定义参数，此处用于判断
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getUserInfo")
	public String getUserInfo(String code, String state, HttpServletRequest request, HttpServletResponse response) {
		LOG.info("确认授权code={}", code);
		//code换取accessToken
		WxMpOAuth2AccessToken oAuth2AccessToken = null;
		try {
			oAuth2AccessToken = weixinService.getWxMpOAuth2AccessToken(code);
			LOG.debug("授权获取的AccessToken：{}", oAuth2AccessToken);
		} catch (WxErrorException e1) {
			LOG.error("core换取AccessToken失败");
			e1.printStackTrace();
		}

		//accessToke换取用户基本信息
		WxMpUser wxMpUser = null;
		try {
			wxMpUser = weixinService.getUserInfo(oAuth2AccessToken);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}

		//保存用户基本信息
		BaseWechat baseWechat = baseWechatService.addWechat(wxMpUser);
		LOG.info("获取微信基本信息成功{}", baseWechat.toString());
		WebUserVo webUserVo = baseMemberService.checkMember(baseWechat);
		request.getSession(true).setAttribute(Constants.SESSION_USER, webUserVo);
		//获取用户基本信息后重定向回页面
		try {
			String object = JSONObject.toJSONString(webUserVo);
			String url = URLEncoder.encode(object, "utf-8");
			response.sendRedirect("http://frp3.xuechenedu.com/#/author?userVo=" + url);
			return null;
		} catch (IOException e) {
			LOG.error("{}", "重定向到新页面失败");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据UnionId查询用户微信信息
	 * @author zhangfeihong
	 * @date 2017年7月23日 下午11:32:53
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getByUnionId")
	public JsonResult getByUnionId(String unionId, HttpServletRequest request) {
		JsonResult jsonResult = new JsonResult();
		if (StringUtils.isBlank(unionId)) {
			jsonResult.setMsg("参数错误");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		Wrapper<BaseWechat> wrapper =new EntityWrapper<>();
		wrapper.where("unionId={0}", unionId);
		BaseWechat baseWechat = baseWechatService.selectOne(wrapper);
		if (baseWechat == null) {
			jsonResult.setMsg("用户未授权");
			jsonResult.setSuccess(false);
			return jsonResult;
		}
		WebUserVo webUserVo = baseMemberService.checkMember(baseWechat);
		request.getSession(true).setAttribute(Constants.SESSION_USER, webUserVo);
		jsonResult.setMsg("获取用户信息成功");
		jsonResult.setSuccess(true);
		jsonResult.setObj(webUserVo);
		return jsonResult;
	}

	/**
	 * 微信签名
	 * @author zhangfeihong
	 * @date 2017年7月21日 上午10:38:14
	 * @param url
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/jssdkSign")
	public Object sign(String url) {
		try {
			WxJsapiSignature signature = weixinService.createJsapiSignature(url);
			return signature;
		} catch (WxErrorException e) {
			LOG.error("签名失败");
			e.printStackTrace();
		}
		return null;
	}
}
