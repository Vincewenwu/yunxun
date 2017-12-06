package com.vision.edu.core.listenter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.vision.edu.framework.util.SystemConfig;
 

/**
 * 获取ctx
 * @title 
 * @filename PlatformServletContextListener.java
 * @author XieFan
 * @date 2017年4月7日 下午3:41:55
 * @version 1.0
 */
public class PlatformServletContextListener implements ServletContextListener{

	/**
	 * 项目启动时执行
	 * <p>Title: contextInitialized</p>
	 * <p>Description: </p>
	 * @param event=
	 */
	public void contextInitialized(ServletContextEvent event) {
		//在web应用启动的时候，通过servletContext获取web应用工程名
		String contextPath = event.getServletContext().getContextPath();
		//获取配置文件中的图片服务器路径
		String imgService = SystemConfig.getImageService();
		//由于web应用在启动和销毁过程中，web应用的工程名一直不变，
		//所以我们就将这个工程名存放到servletContext属性，
		//需要用到的时候，直接通过servletContext会话级别获取属性
		event.getServletContext().setAttribute("ctx", contextPath);
		event.getServletContext().setAttribute("imgService", imgService);
		System.out.println("ctx==============>" + contextPath);
		System.out.println("imgService============>" + imgService);
	}

	public void contextDestroyed(ServletContextEvent event) {
				
	}
	
}
