package com.vision.edu.framework.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vision.edu.framework.cons.Constants;
import com.vision.edu.framework.support.cache.CacheManager;

/**
 * 缓存辅助类
 * @title 
 * @filename CacheUtil.java
 * @author XieFan
 * @date 2017年4月4日 下午3:57:40
 * @version 1.0
 */
public final class CacheUtil {
	private static Logger logger = LogManager.getLogger(CacheUtil.class);

	private CacheUtil() {
	}

	public static CacheManager getCache() {
		//return new RedissonHelper();
		return null;
	}

	/** 获取锁 */
	public static boolean getLock(String key) {
		if (!getCache().exists(key)) {
			synchronized (CacheUtil.class) {
				if (!getCache().exists(key)) {
					if (getCache().setnx(key, String.valueOf(System.currentTimeMillis()))) {
						return true;
					}
				}
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			logger.error(Constants.Exception_Head, e);
		}
		return getLock(key);
	}

	public static void unlock(String key) {
		getCache().unlock(key);
	}
}