package com.vision.edu.dto;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 班级DTO
 * @author jiangwangying
 * @date 2017年7月9日 下午9:43:56
 * @version 1.0
 */
public class ClassDTO {
	
	/**
     * 主键
     */
	private String id;
   
    /**
     * 班主任
     */
	private String teacherName;
	
	/**
	 * 宝贝数
	 */
	private Integer peopleNum;
  
	/**
	 * 园校名称
	 */
	private String schoolName;

	/**
     * 和班名称
     */
	private String className;
  
	/**
     * 班级描述
     */
	private String description;
  
	/**
     * 创建时间
     */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
    
    /**
     * 0-未删除，1-已删除
     */
	private Integer deleteFlag;
	
	/**
	 * 班级
	 */
	private String gradeName;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

}
