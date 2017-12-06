/**
 * 
 */
package com.vision.edu.framework.exception;

import com.vision.edu.framework.support.HttpCode;

/**
 * 
 * @title 
 * @filename IllegalParameterException.java
 * @author XieFan
 * @date 2017年4月4日 下午3:53:17
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IllegalParameterException extends BaseException {
	public IllegalParameterException() {
	}

	public IllegalParameterException(Throwable ex) {
		super(ex);
	}

	public IllegalParameterException(String message) {
		super(message);
	}

	public IllegalParameterException(String message, Throwable ex) {
		super(message, ex);
	}

	protected HttpCode getHttpCode() {
		return HttpCode.BAD_REQUEST;
	}
}
