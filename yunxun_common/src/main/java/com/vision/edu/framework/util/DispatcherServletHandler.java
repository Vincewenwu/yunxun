package com.vision.edu.framework.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;


/**
 * 打印日志
 * @author XieFan
 * @date 2017年7月14日 上午10:51:48
 * @version 1.0
 */
public class DispatcherServletHandler extends DispatcherServlet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	// log4j2方式
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServletHandler.class);

	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			super.doService(request, response);
		}catch(Exception ex){
			logger.error(ex.getMessage());
		}
	}
}

