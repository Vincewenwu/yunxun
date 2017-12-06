package com.vision.edu.core.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 
 * @author Administrator
 *
 */
public class RememberAuthenticationFilter extends FormAuthenticationFilter {

	/**
	 * 验证用户权限
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String url = httpRequest.getRequestURI();
		System.out.println("===================>" + url);
		Subject subject = getSubject(request, response);
		return subject.isAuthenticated();
	}

}
