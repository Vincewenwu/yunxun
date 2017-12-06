package com.vision.edu.dto;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 签到记录DTO
 * 
 * @title
 * @filename SignRecordDTO.java
 * @author jiangwangying
 * @date 2017年7月8日 下午9:05:41
 * @version 1.0
 */
public class SignDTO {

	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 宝贝id
	 */
	private String babyId;

	/**
	 * 签到时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date signTime;

	/**
	 * 0-未删除，1-已删除
	 */
	private Integer deleteFlag;

	/**
	 * 学校姓名
	 */
	private String schoolName;

	/**
	 * 学员姓名
	 */
	private String babyName;
	
	/**
	 * 头像
	 */
	private String headPortrait;

	/**
	 * 班级名称
	 */
	private String className;
	
	/**
	 * 年级名称
	 */
	private String gradeName;
	
	/**
	 * 签到记录类型
	 */
	private Integer recordType;
	
	/**
	 * 签到状态
	 */
	private Integer signStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getBabyName() {
		return babyName;
	}

	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getRecordType() {
		return recordType;
	}

	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}

	public Integer getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(Integer signStatus) {
		this.signStatus = signStatus;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getBabyId() {
		return babyId;
	}

	public void setBabyId(String babyId) {
		this.babyId = babyId;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

}
