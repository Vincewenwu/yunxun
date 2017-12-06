/**
 * 
 */
package com.vision.edu.framework.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;

import com.vision.edu.framework.support.HttpCode;

/**
 * 
 * @title 
 * @filename BaseException.java
 * @author XieFan
 * @date 2017年4月4日 下午3:53:38
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class BaseException extends RuntimeException {
	public BaseException() {
	}

	public BaseException(Throwable ex) {
		super(ex);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(String message, Throwable ex) {
		super(message, ex);
	}

	public void handler(ModelMap modelMap) {
		modelMap.put("httpCode", getHttpCode().value());
		if (StringUtils.isNotBlank(getMessage())) {
			modelMap.put("msg", getMessage());
		} else {
			modelMap.put("msg", getHttpCode().msg());
		}
		modelMap.put("timestamp", System.currentTimeMillis());
	}

	protected abstract HttpCode getHttpCode();
}
