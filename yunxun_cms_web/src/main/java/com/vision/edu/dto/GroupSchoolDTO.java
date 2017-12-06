package com.vision.edu.dto;

import java.util.ArrayList;
import java.util.List;

import com.vision.edu.entity.base.BaseGroup;
import com.vision.edu.entity.base.BaseSchool;

/**
 * 学校组DTO
 * @author jiangwangying
 * @date 2017年7月23日 上午11:42:48
 * @version 1.0
 */
public class GroupSchoolDTO {

	/**
	 * 园校id
	 */
	private String id;
	/**
	 * 园校id
	 */
	private String name;
	/**
	 * 分组list集合 根据园校id查询
	 */
	private ArrayList<BaseGroup> children;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<BaseGroup> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<BaseGroup> children) {
		this.children = children;
	}
	
	
}
