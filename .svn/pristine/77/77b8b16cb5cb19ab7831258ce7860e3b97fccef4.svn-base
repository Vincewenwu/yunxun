package com.vision.edu.core.base;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.vision.edu.dto.SysUserDTO;
import com.vision.edu.framework.cons.Constants;
import com.vision.edu.framework.util.DateEditor;

/**
 * BaseController 
 * @author XieFan
 * @date 2017年7月6日 上午9:39:31
 * @version 1.0
 */
public class BaseController {
	
	//保证高并发共享request
	private static ThreadLocal<HttpServletRequest> requestThread =  new ThreadLocal<HttpServletRequest>();
	
	//保证高并发共享response
	private static ThreadLocal<HttpServletResponse>  responseThread =  new ThreadLocal<HttpServletResponse>();
	
	//保证高并发共享ModelMap
	private static ThreadLocal<ModelMap>  modelThread =  new ThreadLocal<ModelMap>();
	
	/**
	 * 初始化controller
	 * <p>Title: init</p>
	 * <p>Description: </p>
	 * @param request
	 * @param response
	 */
	@ModelAttribute
	public void init(HttpServletRequest request, HttpServletResponse response,ModelMap model){
		requestThread.set(request);  
		responseThread.set(response);
		modelThread.set(model);
	}
	
	/**
	 * 获取用户请求
	 * <p>Title: getRequest</p>
	 * <p>Description: </p>
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return requestThread.get();
	}
	
	/**
	 * 获取响应请求
	 * <p>Title: getResponse</p>
	 * <p>Description: </p>
	 * @return
	 */
	public HttpServletResponse getResponse(){
		return responseThread.get();
	}
	
	/**
	 * 获取用户信息
	 * @author XieFan
	 * @date 2017年7月28日 上午8:27:23
	 * @return
	 */
	public SysUserDTO getUserInfo(){
		Subject subject = SecurityUtils.getSubject();
		SysUserDTO sysUserDTO = (SysUserDTO) subject.getSession().getAttribute(Constants.CURRENT_USER);
		if(sysUserDTO != null){
			return sysUserDTO;
		}
		return null;
	}
	
	/**
	 * 获取modelmap
	 * <p>Title: getModelMap</p>
	 * <p>Description: </p>
	 * @return
	 */
	public ModelMap getModelMap(){
		return modelThread.get();
	}
	
	/**
	 * 获取当前页
	 * @param request
	 * @return
	 */
	public static Integer getCurrentPage(){
		String currentPage = requestThread.get().getParameter("currentPage");
		if(StringUtils.isNotBlank(currentPage) && StringUtils.isNumeric(currentPage)){
			return Integer.parseInt(currentPage);
		}
		return 1;
	}
	
	/**
	 * 获取页大小
	 * @param request
	 * @return
	 */
	public static Integer getPageSize(){
		String pageSize = requestThread.get().getParameter("pageSize");
		if(StringUtils.isNotBlank(pageSize) && StringUtils.isNumeric(pageSize)){
			return Integer.parseInt(pageSize);
		}
		return 10;
	}
	
	/**
	 * 自动装配日期
	 * <p>Title: initBinder</p>
	 * <p>Description: </p>
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
}
