package com.vision.edu.dto;

import java.util.ArrayList;


/**
 * 平台
 * @author jiangwangying
 * @date 2017年7月27日 下午10:50:35
 * @version 1.0
 */
public class PlatformDTO {

	/**
	 * 平台
	 */
	final private String id = "xuechenjiaoyu";
	/**
	 * 平台名称
	 */
    private String name = "全平台";
	/**
	 * 园校集合
	 */
	private ArrayList<GroupSchoolDTO> children;

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<GroupSchoolDTO> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<GroupSchoolDTO> children) {
		this.children = children;
	}

}
