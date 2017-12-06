package com.vision.edu.framework.exception;

import com.vision.edu.framework.support.HttpCode;

/**
 * 
 * @title 
 * @filename LoginException.java
 * @author XieFan
 * @date 2017年4月4日 下午3:53:46
 * @version 1.0
 */
@SuppressWarnings("serial")
public class LoginException extends BaseException {
	public LoginException() {
	}

	public LoginException(String message) {
		super(message);
	}

	public LoginException(String message, Exception e) {
		super(message, e);
	}

	protected HttpCode getHttpCode() {
		return HttpCode.LOGIN_FAIL;
	}
}
