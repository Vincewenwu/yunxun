package com.vision.edu.framework.exception;

import com.vision.edu.framework.support.HttpCode;

/**
 * 
 * @title 
 * @filename DataParseException.java
 * @author XieFan
 * @date 2017年4月4日 下午3:53:29
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DataParseException extends BaseException {

	public DataParseException() {
	}

	public DataParseException(Throwable ex) {
		super(ex);
	}

	public DataParseException(String message) {
		super(message);
	}

	public DataParseException(String message, Throwable ex) {
		super(message, ex);
	}

	protected HttpCode getHttpCode() {
		return HttpCode.INTERNAL_SERVER_ERROR;
	}

}
