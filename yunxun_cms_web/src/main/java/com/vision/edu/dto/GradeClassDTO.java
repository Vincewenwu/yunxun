package com.vision.edu.dto;

import java.util.ArrayList;

import com.vision.edu.entity.base.BaseClass;

/**
 * 年级班级 DTO
 * @author jiangwangying
 * @date 2017年8月2日 下午2:33:24
 * @version 1.0
 */
public class GradeClassDTO {

	/**
	 * 年级id
	 */
	String id;
	
	/**
	 * 年级名称
	 */
	String gradeName;
	
	/**
	 * 年级包含的班级
	 */
	private ArrayList<BaseClass> children;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public ArrayList<BaseClass> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<BaseClass> children) {
		this.children = children;
	}

}
