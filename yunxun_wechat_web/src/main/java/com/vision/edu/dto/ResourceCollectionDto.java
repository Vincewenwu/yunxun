package com.vision.edu.dto;

/**
 * 资源集合（图片url、视频url）
 * @author lichenglong
 * @date 2017年7月21日 上午9:33:06
 * @version 1.0
 */
public class ResourceCollectionDto {

	private String uniformResourceLocator;//资源地址

	public String getUniformResourceLocator() {
		return uniformResourceLocator;
	}

	public void setUniformResourceLocator(String uniformResourceLocator) {
		this.uniformResourceLocator = uniformResourceLocator;
	}

	@Override
	public String toString() {
		return "ResourceCollectionDto [uniformResourceLocator=" + uniformResourceLocator + "]";
	}
	
	
}
