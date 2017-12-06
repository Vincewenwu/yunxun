package com.vision.edu.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.google.gson.Gson;
import com.vision.edu.core.base.Constants;
import com.vision.edu.dto.WebUserVo;

/**
 * @author zhangfeihong
 * @date 2017年7月5日 下午4:21:17
 * @version 1.0
 */
public class BaseController {

	private HttpServletRequest request;

	private HttpServletResponse response;

	@ModelAttribute
	public void init(HttpServletRequest req, HttpServletResponse resp) {
		request = req;
		response = resp;
	}

	/**
	 * 获取当前会话用户信息
	 * @author zhangfeihong
	 * @date 2017年7月21日 上午8:16:43
	 * @return
	 */
	protected WebUserVo getMember() {
		Object object = request.getSession().getAttribute(Constants.SESSION_USER);
		if (object == null) {
			return null;
		}
		return (WebUserVo) object;
	}

	/**
	 * 设置用户信息到session
	 * @author zhangfeihong
	 * @date 2017年7月26日 下午3:42:49
	 * @param webUserVo
	 */
	protected void setMember(WebUserVo webUserVo) {
		request.getSession(true).setAttribute(Constants.SESSION_USER, webUserVo);
	}
	/**
	 * 客户端返回JSON字符串
	 * @param response
	 * @param object
	 * @return
	 */
	protected String renderString(HttpServletResponse response, Object object) {
		return renderString(response, new Gson().toJson(object), "application/json");
	}

	/**
	 * 客户端返回字符串
	 * @param response
	 * @param string
	 * @return
	 */
	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
			response.setContentType(type);
			response.setCharacterEncoding("utf-8");
			//解决跨域问题
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}
