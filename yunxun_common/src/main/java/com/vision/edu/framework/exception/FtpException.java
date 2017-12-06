package com.vision.edu.framework.exception;

/**
 * FTP异常
 * @title 
 * @filename FtpException.java
 * @author XieFan
 * @date 2017年4月4日 下午3:53:23
 * @version 1.0
 */
@SuppressWarnings("serial")
public class FtpException extends RuntimeException {
	public FtpException() {
	}

	public FtpException(String message) {
		super(message);
	}

	public FtpException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
