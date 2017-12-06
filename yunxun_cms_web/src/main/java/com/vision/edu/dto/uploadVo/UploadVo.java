package com.vision.edu.dto.uploadVo;

import java.io.Serializable;

public class UploadVo implements Serializable{
	
	/**
	 * 状态
	 */
	private Integer errno;
	
	/**
	 * url集合
	 */
	private String[] data;

	public Integer getErrno() {
		return errno;
	}

	public void setErrno(Integer errno) {
		this.errno = errno;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}
	
}
