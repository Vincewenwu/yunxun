package com.vision.edu.framework.exception;

import com.vision.edu.framework.support.HttpCode;

/**
 * 
 * @title 
 * @filename BusinessException.java
 * @author XieFan
 * @date 2017年4月4日 下午3:53:33
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BusinessException extends BaseException {
	public BusinessException() {
	}

	/**
	 * 抛出原异常
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * @param ex
	 */
	public BusinessException(Throwable ex) {
		super(ex);
	}

	/**
	 * 设置自定义异常
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
	}

	/**
	 * 设置自定义异常，并抛出原本异常
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * @param message
	 * @param ex
	 */
	public BusinessException(String message, Throwable ex) {
		super(message, ex);
	}

	protected HttpCode getHttpCode() {
		return HttpCode.CONFLICT;
	}
}