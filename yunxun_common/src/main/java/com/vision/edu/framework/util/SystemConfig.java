package com.vision.edu.framework.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import redis.clients.jedis.Client;

/**
 * 获取配置文件信息
 * @title 
 * @filename SystemConfig.java
 * @author XieFan
 * @date 2017年4月4日 下午4:05:01
 * @version 1.0
 */
public class SystemConfig {

	private static Properties properties = null;
	
	static{
		try {
			properties = new Properties();
			properties.load(new InputStreamReader(Client.class.getClassLoader().getResourceAsStream("config/system.properties"), "UTF-8")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取短信发送接口
	 * <p>Title: getMobileUrl</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static String getMobileUrl(){
		return properties.getProperty("mobile_url");
	}

	/**
	 * 获取短信平台账号
	 * <p>Title: getMobileAccount</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static String getMobileAccount() {
		return properties.getProperty("mobile_account");
	}
	
	/**
	 * 获取短信平台密码
	 * <p>Title: getMobilePswd</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static String getMobilePswd() {
		return properties.getProperty("mobile_pswd");
	}
	
	/**
	 * 获取短信标识
	 * <p>Title: getMobileSign</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static String getMobileSign() {
		return properties.getProperty("mobile_sign");
	}
	
	/**
	 * 获取短信模板
	 * <p>Title: getMobileTemplate</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static String getMobileTemplate() {
		return properties.getProperty("mobile_template");
	}
	
	/**
	 * 获取保利威视密钥
	 * <p>Title: getPlvSecretKey</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static String getPlvSecretKey() {
		return properties.getProperty("PLV_SECRETKEY");
	}
	
	/**
	 * 获取保利威视读取密钥
	 * <p>Title: getPlvSecretKey</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static String getReadToken() {
		return properties.getProperty("READ_TOKEN");
	}
	
	/**
	 * 获取服务器标识
	 * <p>Title: getPlvSecretKey</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static String getMachineId() {
		return properties.getProperty("machineId");
	}
	
	/**
	 * 获取服务器标识
	 * <p>Title: getPlvSecretKey</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static String getImageService() {
		return properties.getProperty("image_service");
	}
	
	/**
	 * 队列
	 * <p>Title: getPlvSecretKey</p>
	 * <p>Description: </p>
	 * @return
	 */
	public static String getActiveMQQueue() {
		return properties.getProperty("activemq.ActiveMQQueue");
	}
	
}
