package com.vision.edu.dto;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 宝贝请假记录DTO
 * 
 * @title
 * @filename LeaveRecordDTO.java
 * @author jiangwangying
 * @date 2017年7月9日 上午11:34:51
 * @version 1.0
 */
public class LeaveRecordDTO {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 园校名称
	 */
	private String schoolName;

	/**
	 * 班级名称
	 */
	private String className;
	/**
	 * 开始时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	/**
	 * 结束时间
	 */
	@TableField("end_time")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	/**
	 * 申请时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	/**
	 * 请假时长
	 */
	private Integer whenLong;

	/**
	 * 请假人姓名
	 */
	private String name;
	/**
	 * 请假事由
	 */
	private String reason;
	/**
	 * 审核状态
	 */
	private Integer checkFlag;

	/**
	 * 状态名称
	 */
	private String stateNeme;

	/**
	 * 0-未删除，1-已删除
	 */
	private Integer deleteFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getWhenLong() {
		return whenLong;
	}

	public void setWhenLong(Integer whenLong) {
		this.whenLong = whenLong;
	}
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getStateNeme() {
		return stateNeme;
	}

	public void setStateNeme(String stateNeme) {
		this.stateNeme = stateNeme;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(Integer checkFlag) {
		this.checkFlag = checkFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
